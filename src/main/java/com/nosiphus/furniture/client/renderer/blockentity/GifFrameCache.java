package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.platform.NativeImage;
import com.nosiphus.furniture.network.protocol.UrlValidator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class GifFrameCache {

    private static final GifFrameCache INSTANCE = new GifFrameCache();
    public static GifFrameCache getInstance() { return INSTANCE; }

    private static final int MAX_FILE_SIZE = 10 * 1024 * 1024;
    private static final int TIMEOUT_MS = 5000;
    private static final int MAX_FRAMES = 150;
    private static final int MAX_DIMENSION = 1920;
    private static final int MAX_CACHE_ENTRIES = 25;
    private static final long MAX_CACHE_BYTES = 256L * 1024L * 1024L; // 256 MB native RAM cap
    private static final int MAX_FAILED_URLS = 1000;

    private final Map<String, GifData> gifCache = new ConcurrentHashMap<>();
    private final Set<String> loadingUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());
    // Bounded LRU. Set-of-strings from a LinkedHashMap with access-order and
    // an eviction hook so the failure list can't grow unbounded when a player
    // cycles random URLs on TVs.
    private final Set<String> failedUrls = Collections.newSetFromMap(
            Collections.synchronizedMap(new LinkedHashMap<String, Boolean>(64, 0.75f, true) {
                @Override protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                    return size() > MAX_FAILED_URLS;
                }
            }));

    public record GifFrame(ResourceLocation textureLocation, int delayTicks) {}

    public static class GifData {
        private final List<GifFrame> frames;
        private final long estimatedSizeBytes;
        private int refCount = 0;
        private volatile long lastAccessTime = System.currentTimeMillis();

        public GifData(List<GifFrame> frames, long estimatedSizeBytes) {
            this.frames = frames;
            this.estimatedSizeBytes = estimatedSizeBytes;
        }

        public ResourceLocation getFrame(long gameTime) {
            this.lastAccessTime = System.currentTimeMillis();
            if (frames.isEmpty()) return null;
            if (frames.size() == 1) return frames.get(0).textureLocation();

            int totalTicks = 0;
            for (GifFrame frame : frames) totalTicks += frame.delayTicks();
            if (totalTicks <= 0) totalTicks = 20;

            long currentTick = gameTime % totalTicks;
            int accumulated = 0;
            for (GifFrame frame : frames) {
                accumulated += frame.delayTicks();
                if (currentTick < accumulated) {
                    return frame.textureLocation();
                }
            }
            return frames.get(0).textureLocation();
        }

        public synchronized void incrementRef() { this.refCount++; }
        public synchronized void decrementRef() { this.refCount = Math.max(0, this.refCount - 1); }
        public synchronized int getRefCount() { return this.refCount; }
        public long getEstimatedSizeBytes() { return this.estimatedSizeBytes; }

        public void release() {
            Minecraft mc = Minecraft.getInstance();
            mc.execute(() -> {
                for (GifFrame frame : frames) {
                    mc.getTextureManager().release(frame.textureLocation());
                }
                frames.clear();
            });
        }
    }

    public ResourceLocation getTexture(String url, long gameTime) {
        if (url == null || url.isBlank() || failedUrls.contains(url)) {
            return null;
        }

        GifData cachedData = gifCache.get(url);
        if (cachedData != null) {
            return cachedData.getFrame(gameTime);
        }

        if (UrlValidator.isTrustedUrl(url) && loadingUrls.add(url)) {
            CompletableFuture.runAsync(() -> loadGifAsync(url));
        }

        return null;
    }

    public void releaseUrlIfUnused(String url) {
        if (url == null || url.isBlank()) return;
        GifData data = gifCache.get(url);
        if (data != null) {
            data.decrementRef();
            if (data.getRefCount() <= 0) {
                data.release();
                gifCache.remove(url);
            }
        }
    }

    private long getTotalCachedBytes() {
        long total = 0;
        for (GifData data : gifCache.values()) {
            total += data.getEstimatedSizeBytes();
        }
        return total;
    }

    // Returns true if we should try to insert, false if the cache is full
    // and could not be shrunk (all in-use). Previously the eviction was
    // best-effort and the map could grow past MAX_CACHE_ENTRIES.
    private boolean evictOldestIfNecessary(long incomingSizeBytes) {
        while ((gifCache.size() >= MAX_CACHE_ENTRIES || (getTotalCachedBytes() + incomingSizeBytes) > MAX_CACHE_BYTES) && !gifCache.isEmpty()) {
            String oldestUrl = null;
            long oldestTime = Long.MAX_VALUE;

            for (Map.Entry<String, GifData> entry : gifCache.entrySet()) {
                GifData data = entry.getValue();
                if (data.getRefCount() <= 0 && data.lastAccessTime < oldestTime) {
                    oldestTime = data.lastAccessTime;
                    oldestUrl = entry.getKey();
                }
            }

            if (oldestUrl != null) {
                GifData evicted = gifCache.remove(oldestUrl);
                if (evicted != null) {
                    evicted.release();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // Broader coverage than InetAddress's built-in checks. Adds carrier-grade
    // NAT (100.64.0.0/10), IPv6 unique-local (fc00::/7), multicast, and the
    // 0.0.0.0/8 "this network" block. The built-ins already cover loopback,
    // link-local (which includes 169.254/16 metadata endpoints), site-local
    // and IPv6 loopback/link-local.
    private static boolean isPrivateOrRestricted(InetAddress addr) {
        if (addr.isLoopbackAddress()
                || addr.isSiteLocalAddress()
                || addr.isLinkLocalAddress()
                || addr.isAnyLocalAddress()
                || addr.isMulticastAddress()) {
            return true;
        }
        byte[] b = addr.getAddress();
        if (b.length == 4) {
            int o0 = b[0] & 0xFF;
            int o1 = b[1] & 0xFF;
            if (o0 == 100 && (o1 & 0xC0) == 64) return true; // Carrier-grade NAT: 100.64.0.0/10
            if (o0 == 0) return true; // "This network": 0.0.0.0/8
            if (o0 >= 240) return true; // Reserved: 240.0.0.0/4
        } else if (b.length == 16) {
            // Unwrap IPv4-mapped IPv6 addresses (::ffff:x.x.x.x)
            boolean isMapped = true;
            for (int i = 0; i < 10; i++) {
                if (b[i] != 0) { isMapped = false; break; }
            }
            if (isMapped && (b[10] & 0xFF) == 0xFF && (b[11] & 0xFF) == 0xFF) {
                try {
                    return isPrivateOrRestricted(InetAddress.getByAddress(Arrays.copyOfRange(b, 12, 16)));
                } catch (Exception ignored) {}
            }
            int o0 = b[0] & 0xFF;
            if ((o0 & 0xFE) == 0xFC) return true; // IPv6 unique local: fc00::/7
        }
        return false;
    }

    // Stable, collision-resistant per-URL key for ResourceLocation paths.
    // Previously used Math.abs(urlString.hashCode()) which collides trivially
    // (well-known Java string-hash collisions), causing one TV's texture to
    // overwrite another's registration and render the wrong GIF.
    private static String urlHashKey(String url) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(url.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(24);
            for (int i = 0; i < 12; i++) {
                sb.append(String.format("%02x", digest[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return Integer.toHexString(url.hashCode() & 0x7fffffff);
        }
    }

    private void loadGifAsync(String urlString) {
        HttpURLConnection conn = null;
        try {
            URI uri = URI.create(urlString);

            if (!"https".equalsIgnoreCase(uri.getScheme())) {
                failUrl(urlString, "Rejected: Must use HTTPS protocol.");
                return;
            }

            String hostName = uri.getHost();
            if (hostName == null || hostName.isEmpty()) {
                failUrl(urlString, "Rejected: Missing host.");
                return;
            }

            // Resolve DNS and validate ALL returned IP addresses to block private/loopback SSRF
            InetAddress[] resolved = InetAddress.getAllByName(hostName);
            if (resolved.length == 0) {
                failUrl(urlString, "Rejected: DNS returned no addresses.");
                return;
            }
            for (InetAddress addr : resolved) {
                if (isPrivateOrRestricted(addr)) {
                    failUrl(urlString, "Rejected: Resolves to private/restricted IP (" + addr.getHostAddress() + ").");
                    return;
                }
            }

            // Open standard URL connection to preserve native SNI and TLS certificate verification
            URL url = uri.toURL();
            conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false); // Security: Prevent SSRF redirect loops
            conn.setConnectTimeout(TIMEOUT_MS);
            conn.setReadTimeout(TIMEOUT_MS);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
            conn.setRequestProperty("Accept", "image/gif,image/webp,image/apng,image/*,*/*;q=0.8");

            // Pin socket creation to the validated IP to defeat DNS-rebinding TOCTOU attacks
            if (conn instanceof HttpsURLConnection https) {
                SSLSocketFactory defaultFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                https.setSSLSocketFactory(new PinnedSSLSocketFactory(defaultFactory, resolved[0], hostName));
            }

            int status = conn.getResponseCode();
            if (status != 200) {
                failUrl(urlString, "Rejected: HTTP status " + status);
                return;
            }

            // Fail-closed on missing/mismatched Content-Type. Previously null
            // Content-Type passed and .contains("image") matched unrelated
            // types like text/x-image-descriptor.
            String contentType = conn.getContentType();
            if (contentType == null || !contentType.toLowerCase().startsWith("image/")) {
                failUrl(urlString, "Rejected: Invalid Content-Type (" + contentType + ")");
                return;
            }

            // Early-reject if the server declared an oversize body before we
            // spend bandwidth reading it.
            long declaredLen = conn.getContentLengthLong();
            if (declaredLen > MAX_FILE_SIZE) {
                failUrl(urlString, "Rejected: Content-Length exceeds 10MB.");
                return;
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead;
            int totalBytes = 0;

            try (InputStream is = conn.getInputStream()) {
                while ((bytesRead = is.read(buffer)) != -1) {
                    totalBytes += bytesRead;
                    if (totalBytes > MAX_FILE_SIZE) {
                        failUrl(urlString, "Rejected: Exceeds 10MB limit.");
                        return;
                    }
                    baos.write(buffer, 0, bytesRead);
                }
            }

            byte[] imageBytes = baos.toByteArray();
            List<RawFrameData> rawFrames = decodeRawFrames(imageBytes);

            if (rawFrames.isEmpty()) {
                failUrl(urlString, "Failed to decode frames.");
                return;
            }

            // Calculate estimated native RGBA memory usage for this GIF
            long estimatedGifBytes = 0;
            for (RawFrameData f : rawFrames) {
                estimatedGifBytes += (long) f.nativeImage().getWidth() * f.nativeImage().getHeight() * 4L;
            }

            final long finalGifBytes = estimatedGifBytes;

            Minecraft.getInstance().execute(() -> {
                // Refuse the insert if the cache is full and no in-use slot
                // could be freed, rather than silently exceeding the cap.
                if (!evictOldestIfNecessary(finalGifBytes)) {
                    for (RawFrameData raw : rawFrames) raw.nativeImage().close();
                    loadingUrls.remove(urlString);
                    return;
                }

                String key = urlHashKey(urlString);
                List<GifFrame> registeredFrames = new ArrayList<>();
                for (int i = 0; i < rawFrames.size(); i++) {
                    RawFrameData raw = rawFrames.get(i);
                    ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                            "nfm", "textures/dynamic/gif_" + key + "_" + i);

                    DynamicTexture texture = new DynamicTexture(raw.nativeImage());
                    texture.upload();
                    Minecraft.getInstance().getTextureManager().register(loc, texture);
                    registeredFrames.add(new GifFrame(loc, raw.delayTicks()));
                }

                gifCache.put(urlString, new GifData(registeredFrames, finalGifBytes));
                loadingUrls.remove(urlString);
            });

        } catch (Throwable t) {
            failUrl(urlString, "Exception: " + t.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            loadingUrls.remove(urlString);
        }
    }

    private record RawFrameData(NativeImage nativeImage, int delayTicks) {}

    private List<RawFrameData> decodeRawFrames(byte[] imageBytes) {
        List<RawFrameData> frames = new ArrayList<>();
        ImageReader reader = null;
        Graphics2D g2d = null;
        try (ImageInputStream in = ImageIO.createImageInputStream(new ByteArrayInputStream(imageBytes))) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
            if (!readers.hasNext()) return frames;

            reader = readers.next();
            reader.setInput(in);

            int count = Math.min(reader.getNumImages(true), MAX_FRAMES);

            int masterWidth = reader.getWidth(0);
            int masterHeight = reader.getHeight(0);

            if (masterWidth > MAX_DIMENSION || masterHeight > MAX_DIMENSION || masterWidth <= 0 || masterHeight <= 0) {
                System.err.println("[NFM] Rejected GIF: Resolution exceeds safety cap (" + masterWidth + "x" + masterHeight + ")");
                return frames;
            }

            BufferedImage masterCanvas = new BufferedImage(masterWidth, masterHeight, BufferedImage.TYPE_INT_ARGB);
            g2d = masterCanvas.createGraphics();

            String disposalMethod = "none";
            int xOffset = 0, yOffset = 0;

            for (int i = 0; i < count; i++) {
                BufferedImage rawFrame = reader.read(i);
                IIOMetadata metadata = reader.getImageMetadata(i);

                int delayTicks = 2;

                if (metadata != null) {
                    IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree("javax_imageio_gif_image_1.0");
                    IIOMetadataNode gce = getChildNode(root, "GraphicControlExtension");

                    if (gce != null) {
                        disposalMethod = gce.getAttribute("disposalMethod");
                        String delayTime = gce.getAttribute("delayTime");
                        if (delayTime != null && !delayTime.isEmpty()) {
                            int ms = safeParseInt(delayTime, 2) * 10;
                            delayTicks = Math.max(1, ms / 50);
                        }
                    }

                    IIOMetadataNode descriptor = getChildNode(root, "ImageDescriptor");
                    if (descriptor != null) {
                        String left = descriptor.getAttribute("imageLeftPosition");
                        String top = descriptor.getAttribute("imageTopPosition");
                        xOffset = safeParseInt(left, 0);
                        yOffset = safeParseInt(top, 0);

                        xOffset = Math.max(0, Math.min(xOffset, masterWidth));
                        yOffset = Math.max(0, Math.min(yOffset, masterHeight));
                    }
                }

                g2d.drawImage(rawFrame, xOffset, yOffset, null);

                NativeImage nativeImage = convertToNativeImage(masterCanvas);
                frames.add(new RawFrameData(nativeImage, delayTicks));

                if ("restoreToBackgroundColor".equalsIgnoreCase(disposalMethod)) {
                    g2d.setComposite(AlphaComposite.Clear);
                    g2d.fillRect(xOffset, yOffset, rawFrame.getWidth(), rawFrame.getHeight());
                    g2d.setComposite(AlphaComposite.SrcOver);
                }
            }
        } catch (Exception e) {
            for (RawFrameData f : frames) {
                f.nativeImage().close();
            }
            frames.clear();
            System.err.println("[NFM] Error decoding GIF frames: " + e.getMessage());
        } finally {
            if (g2d != null) g2d.dispose();
            if (reader != null) reader.dispose();
        }
        return frames;
    }

    private static int safeParseInt(String val, int fallback) {
        if (val == null || val.isBlank()) return fallback;
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    private static IIOMetadataNode getChildNode(IIOMetadataNode root, String nodeName) {
        if (root == null) return null;
        for (int i = 0; i < root.getLength(); i++) {
            if (root.item(i).getNodeName().equalsIgnoreCase(nodeName)) {
                return (IIOMetadataNode) root.item(i);
            }
        }
        return null;
    }

    private NativeImage convertToNativeImage(BufferedImage bImg) {
        NativeImage nativeImage = new NativeImage(bImg.getWidth(), bImg.getHeight(), false);
        for (int y = 0; y < bImg.getHeight(); y++) {
            for (int x = 0; x < bImg.getWidth(); x++) {
                int argb = bImg.getRGB(x, y);
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                nativeImage.setPixelRGBA(x, y, (255 << 24) | (b << 16) | (g << 8) | r);
            }
        }
        return nativeImage;
    }

    public void clearAll() {
        for (GifData data : gifCache.values()) {
            data.release();
        }
        gifCache.clear();
        loadingUrls.clear();
        failedUrls.clear();
    }

    private void failUrl(String url, String reason) {
        String redactedUrl = url;
        int queryIdx = url.indexOf('?');
        if (queryIdx != -1) {
            redactedUrl = url.substring(0, queryIdx) + "?[redacted]";
        }
        System.err.println("[NFM] " + reason + " -> " + redactedUrl);
        failedUrls.add(url);
        loadingUrls.remove(url);
    }

    /**
     * Custom SSLSocketFactory that connects directly to a pre-validated IP address
     * while retaining the original host name for SNI TLS negotiation and certificate validation.
     */
    private static class PinnedSSLSocketFactory extends SSLSocketFactory {
        private final SSLSocketFactory delegate;
        private final InetAddress pinnedAddress;
        private final String hostName;

        public PinnedSSLSocketFactory(SSLSocketFactory delegate, InetAddress pinnedAddress, String hostName) {
            this.delegate = delegate;
            this.pinnedAddress = pinnedAddress;
            this.hostName = hostName;
        }

        @Override public String[] getDefaultCipherSuites() { return delegate.getDefaultCipherSuites(); }
        @Override public String[] getSupportedCipherSuites() { return delegate.getSupportedCipherSuites(); }

        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            return configureSocket((SSLSocket) delegate.createSocket(s, host, port, autoClose));
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException {
            return configureSocket((SSLSocket) delegate.createSocket(pinnedAddress, port));
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
            return configureSocket((SSLSocket) delegate.createSocket(pinnedAddress, port, localHost, localPort));
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            return configureSocket((SSLSocket) delegate.createSocket(pinnedAddress, port));
        }

        @Override
        public Socket createSocket(InetAddress host, int port, InetAddress localHost, int localPort) throws IOException {
            return configureSocket((SSLSocket) delegate.createSocket(pinnedAddress, port, localHost, localPort));
        }

        private Socket configureSocket(SSLSocket socket) throws IOException {
            SSLParameters params = socket.getSSLParameters();
            params.setServerNames(List.of(new SNIHostName(hostName)));
            socket.setSSLParameters(params);
            return socket;
        }
    }
}
