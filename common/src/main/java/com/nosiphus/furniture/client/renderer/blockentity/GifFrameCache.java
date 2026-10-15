package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.platform.NativeImage;
import com.nosiphus.furniture.network.UrlValidator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.net.ssl.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Manages downloading, decoding, caching, and releasing animated GIFs for TVs.
 *
 * This class ensures that GIFs loaded from the internet are safe to display, don't
 * overload the game's memory, and are properly cleaned up from OpenGL when worlds unload.
 */
public class GifFrameCache {

    private static final GifFrameCache INSTANCE = new GifFrameCache();
    public static GifFrameCache getInstance() { return INSTANCE; }

    // Safety limits for downloads, frames, and memory consumption
    private static final int MAX_FILE_SIZE = 10 * 1024 * 1024;             // 10 MB maximum download size
    private static final int TIMEOUT_MS = 5000;                           // 5-second connect and packet read timeout
    private static final long MAX_DOWNLOAD_TIME_MS = 10_000L;             // 10-second hard wall-clock ceiling per download (Slowloris protection)
    private static final int MAX_CONCURRENT_LOADS = 16;                   // Maximum in-flight/queued downloads at once
    private static final int MAX_FRAMES = 150;                            // Hard limit on total frame count per GIF
    private static final int MAX_DIMENSION = 1920;                        // Resolution limit in pixels (width or height)
    private static final long MAX_SINGLE_GIF_BYTES = 64L * 1024L * 1024L; // 64 MB native RAM ceiling for a single decoded GIF
    private static final int MAX_CACHE_ENTRIES = 25;                      // Maximum number of distinct GIFs kept in memory
    private static final long MAX_CACHE_BYTES = 256L * 1024L * 1024L;     // 256 MB overall cache budget
    private static final int MAX_FAILED_URLS = 1000;                      // Bounded history of broken/rejected links
    private static final long IN_USE_LEASE_MS = 15_000L;                  // 15-second grace period before an inactive GIF can be purged

    // Incremented whenever clearAll() is called so in-flight downloads from a previous world are safely discarded
    private final AtomicInteger cacheGeneration = new AtomicInteger(0);

    // A small dedicated thread pool for web downloads so we never block Minecraft's worker threads
    private final ExecutorService networkExecutor = Executors.newFixedThreadPool(3, r -> {
        Thread t = new Thread(r, "NFM-Gif-Loader");
        t.setDaemon(true);
        return t;
    });

    private final Map<String, GifData> gifCache = new ConcurrentHashMap<>();
    private final Set<String> loadingUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());

    // Tracks broken or invalid URLs so we don't spam network requests if a link fails
    private final Set<String> failedUrls = Collections.newSetFromMap(
            Collections.synchronizedMap(new LinkedHashMap<>(64, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                    return size() > MAX_FAILED_URLS;
                }
            }));

    // Holds a single texture frame and the number of ticks it should remain visible on screen
    public record GifFrame(ResourceLocation textureLocation, int delayTicks) {}

    // Holds the decoded sequence of frames along with active reference counts and memory tracking
    public static class GifData {
        private final GifFrame[] frames;
        private final int totalTicks;
        private final long estimatedSizeBytes;
        private int refCount = 0;
        private volatile long lastAccessTime = System.currentTimeMillis();
        private volatile boolean released = false;

        public GifData(List<GifFrame> frameList, long estimatedSizeBytes) {
            this.frames = frameList.toArray(new GifFrame[0]);
            this.estimatedSizeBytes = estimatedSizeBytes;

            int sum = 0;
            for (GifFrame frame : this.frames) {
                sum += frame.delayTicks();
            }
            this.totalTicks = sum <= 0 ? 20 : sum;
        }

        // Calculates which frame index to display based on the current world game time
        public ResourceLocation getFrame(long gameTime) {
            this.lastAccessTime = System.currentTimeMillis();
            if (released || frames.length == 0) return null;
            if (frames.length == 1) return frames[0].textureLocation();

            long currentTick = Math.floorMod(gameTime, totalTicks);
            int accumulated = 0;
            for (GifFrame frame : frames) {
                accumulated += frame.delayTicks();
                if (currentTick < accumulated) {
                    return frame.textureLocation();
                }
            }
            return frames[0].textureLocation();
        }

        public synchronized void incrementRef() { this.refCount++; }
        public synchronized void decrementRef() { this.refCount = Math.max(0, this.refCount - 1); }
        public synchronized int getRefCount() { return this.refCount; }
        public long getLastAccessTime() { return this.lastAccessTime; }
        public long getEstimatedSizeBytes() { return this.estimatedSizeBytes; }

        // Deletes the texture sheets from OpenGL memory on the client render thread
        public synchronized void release() {
            if (released) return;
            this.released = true;
            Minecraft mc = Minecraft.getInstance();
            mc.execute(() -> {
                for (GifFrame frame : frames) {
                    mc.getTextureManager().release(frame.textureLocation());
                }
            });
        }
    }

    // Called by the block entity renderer every frame to retrieve the active texture ID
    public ResourceLocation getTexture(String rawUrl, long gameTime) {
        if (rawUrl == null || rawUrl.isBlank()) {
            return null;
        }

        String url = UrlValidator.normalizeUrl(rawUrl);
        if (url.isEmpty() || failedUrls.contains(url)) {
            return null;
        }

        GifData cachedData = gifCache.get(url);
        if (cachedData != null) {
            ResourceLocation frameLoc = cachedData.getFrame(gameTime);
            if (frameLoc != null) {
                return frameLoc;
            }
        }

        ServerData serverData = Minecraft.getInstance().getCurrentServer();
        String currentServerIp = (serverData != null) ? serverData.ip : null;

        if (!UrlValidator.isClientTrustedUrl(url, currentServerIp)) {
            failUrl(url, "Blocked untrusted GIF domain (add server to allowed_servers or domain to allowed_urls)");
            return null;
        }

        // Cap concurrent queued downloads to prevent queue flooding DoS
        if (loadingUrls.size() >= MAX_CONCURRENT_LOADS) {
            return null;
        }

        if (loadingUrls.add(url)) {
            int expectedGen = cacheGeneration.get();
            networkExecutor.submit(() -> loadGifAsync(url, expectedGen));
        }

        return null;
    }

    // Increments the active reference counter when a TV block entity tunes into a channel
    public void bindUrl(String rawUrl) {
        String url = UrlValidator.normalizeUrl(rawUrl);
        if (url.isEmpty()) return;
        GifData data = gifCache.get(url);
        if (data != null) {
            data.incrementRef();
        }
    }

    // Decrements the reference counter when a TV block entity unloads, powers off, or changes channels
    public void releaseUrlIfUnused(String rawUrl) {
        String url = UrlValidator.normalizeUrl(rawUrl);
        if (url.isEmpty()) return;
        GifData data = gifCache.get(url);
        if (data != null) {
            data.decrementRef();
            long now = System.currentTimeMillis();
            if (data.getRefCount() <= 0 && (now - data.getLastAccessTime() > IN_USE_LEASE_MS)) {
                if (gifCache.remove(url, data)) {
                    data.release();
                }
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

    // Cleans out old GIFs from memory if we hit our cache or memory ceiling
    private boolean evictOldestIfNecessary(long incomingSizeBytes) {
        long now = System.currentTimeMillis();

        while ((gifCache.size() >= MAX_CACHE_ENTRIES || (getTotalCachedBytes() + incomingSizeBytes) > MAX_CACHE_BYTES) && !gifCache.isEmpty()) {
            String targetUrl = null;
            long oldestTime = Long.MAX_VALUE;

            // Pass 1: Look for the oldest unreferenced GIF outside the 15-second active viewing lease
            for (Map.Entry<String, GifData> entry : gifCache.entrySet()) {
                GifData data = entry.getValue();
                if (data.getRefCount() <= 0 && (now - data.getLastAccessTime() > IN_USE_LEASE_MS) && data.getLastAccessTime() < oldestTime) {
                    oldestTime = data.getLastAccessTime();
                    targetUrl = entry.getKey();
                }
            }

            // Pass 2 (Fallback): Any GIF not rendered in the last 15 seconds (guards against refCount desync locking the cache)
            if (targetUrl == null) {
                for (Map.Entry<String, GifData> entry : gifCache.entrySet()) {
                    GifData data = entry.getValue();
                    if ((now - data.getLastAccessTime() > IN_USE_LEASE_MS) && data.getLastAccessTime() < oldestTime) {
                        oldestTime = data.getLastAccessTime();
                        targetUrl = entry.getKey();
                    }
                }
            }

            if (targetUrl != null) {
                GifData evicted = gifCache.remove(targetUrl);
                if (evicted != null) {
                    evicted.release();
                }
            } else {
                return false; // All cached GIFs are actively being rendered on screen right now
            }
        }
        return true;
    }

    // Blocks requests to internal LANs, loopbacks, router gateways, and reserved IPv4/IPv6 subnets
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
            int o2 = b[2] & 0xFF;
            if (o0 == 0) return true;                                     // 0.0.0.0/8
            if (o0 == 100 && (o1 & 0xC0) == 64) return true;              // 100.64.0.0/10 (Carrier-grade NAT)
            if (o0 == 192 && o1 == 0 && (o2 == 0 || o2 == 2)) return true;// 192.0.0.0/24 & 192.0.2.0/24 (TEST-NET-1)
            if (o0 == 198 && (o1 == 18 || o1 == 19)) return true;         // 198.18.0.0/15 (Benchmarking)
            if (o0 == 198 && o1 == 51 && o2 == 100) return true;          // 198.51.100.0/24 (TEST-NET-2)
            if (o0 == 203 && o1 == 0 && o2 == 113) return true;           // 203.0.113.0/24 (TEST-NET-3)
            if (o0 >= 240) return true;                                   // 240.0.0.0/4 (Reserved / Class E)
        } else if (b.length == 16) {
            // 1. Unwrap IPv4-mapped (::ffff:0:0/96) and IPv4-compatible (::/96) IPv6 addresses
            boolean isZeroPrefix = true;
            for (int i = 0; i < 10; i++) {
                if (b[i] != 0) { isZeroPrefix = false; break; }
            }
            if (isZeroPrefix) {
                boolean isMapped = (b[10] & 0xFF) == 0xFF && (b[11] & 0xFF) == 0xFF;
                boolean isCompat = b[10] == 0 && b[11] == 0;
                if (isMapped || isCompat) {
                    try {
                        return isPrivateOrRestricted(InetAddress.getByAddress(Arrays.copyOfRange(b, 12, 16)));
                    } catch (Exception ignored) {
                        return true;
                    }
                }
            }

            int b0 = b[0] & 0xFF;
            int b1 = b[1] & 0xFF;
            int b2 = b[2] & 0xFF;
            int b3 = b[3] & 0xFF;

            // 2. fc00::/7 (Unique Local IPv6)
            if ((b0 & 0xFE) == 0xFC) return true;

            // 3. 2002::/16 (6to4 tunneling - embeds an IPv4 address in bytes 2..5)
            if (b0 == 0x20 && b1 == 0x02) {
                try {
                    return isPrivateOrRestricted(InetAddress.getByAddress(Arrays.copyOfRange(b, 2, 6)));
                } catch (Exception ignored) {
                    return true;
                }
            }

            // 4. 2001::/16 special ranges (Teredo 2001:0000::/32, Benchmarking 2001:2::/48, Documentation 2001:db8::/32)
            if (b0 == 0x20 && b1 == 0x01) {
                if (b2 == 0x00 && b3 == 0x00) return true; // Teredo
                if (b2 == 0x00 && b3 == 0x02) return true; // Benchmarking
                if (b2 == 0x0D && b3 == 0xB8) return true; // Documentation
            }

            // 5. 64:ff9b::/96 and 64:ff9b:1::/48 (NAT64 translation prefixes)
            if (b0 == 0x00 && b1 == 0x64 && b2 == 0xFF && b3 == 0x9B) {
                return true;
            }
        }
        return false;
    }

    // Creates a short SHA-256 hash string from the URL to use inside the ResourceLocation path
    private static String urlHashKey(String url) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(url.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(24);
            for (int i = 0; i < 12; i++) {
                sb.append(String.format("%02x", digest[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return Integer.toHexString(url.hashCode() & 0x7FFFFFFF);
        }
    }

    // Handles the background HTTP download, security validation, and frame registration
    private void loadGifAsync(String urlString, int expectedGen) {
        HttpURLConnection conn = null;
        boolean handedOffToRenderThread = false;
        try {
            URI uri = URI.create(urlString);

            if (!"https".equalsIgnoreCase(uri.getScheme())) {
                failUrl(urlString, "Rejected: Must use HTTPS protocol.");
                return;
            }

            int port = uri.getPort();
            if (port != -1 && port != 443) {
                failUrl(urlString, "Rejected: Non-standard HTTPS port (" + port + ")");
                return;
            }

            String hostName = uri.getHost();
            if (hostName == null || hostName.isEmpty()) {
                failUrl(urlString, "Rejected: Missing host.");
                return;
            }

            // Resolve host IP and ensure no returned record points to a local/restricted address
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

            InetAddress pinnedAddr = resolved[0];
            URL url = uri.toURL();
            // Prevent use of system proxies that could route requests internally
            conn = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            conn.setInstanceFollowRedirects(false);
            conn.setConnectTimeout(TIMEOUT_MS);
            conn.setReadTimeout(TIMEOUT_MS);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) NosiphusFurnitureMod/1.0");
            conn.setRequestProperty("Accept", "image/gif");

            if (conn instanceof HttpsURLConnection https) {
                SSLSocketFactory defaultFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                https.setSSLSocketFactory(new PinnedSSLSocketFactory(defaultFactory, pinnedAddr, hostName));
            } else {
                failUrl(urlString, "Rejected: Not an HTTPS connection.");
                return;
            }

            int status = conn.getResponseCode();
            if (status != 200) {
                failUrl(urlString, "Rejected: HTTP status " + status);
                return;
            }

            String contentType = conn.getContentType();
            if (contentType == null || !contentType.toLowerCase(Locale.ROOT).startsWith("image/gif")) {
                failUrl(urlString, "Rejected: Invalid Content-Type (" + contentType + "), expected image/gif");
                return;
            }

            long declaredLen = conn.getContentLengthLong();
            if (declaredLen > MAX_FILE_SIZE) {
                failUrl(urlString, "Rejected: Content-Length exceeds 10MB.");
                return;
            }

            // Read stream with both a 10 MB size ceiling and a 10-second wall-clock deadline (Slowloris protection)
            byte[] imageBytes = readStreamWithDeadline(conn.getInputStream(), MAX_FILE_SIZE, MAX_DOWNLOAD_TIME_MS);

            // Abort early if the world unloaded while we were downloading
            if (cacheGeneration.get() != expectedGen) {
                loadingUrls.remove(urlString);
                return;
            }

            List<RawFrameData> rawFrames = decodeRawFrames(imageBytes);
            if (rawFrames.isEmpty()) {
                failUrl(urlString, "Failed to decode GIF frames.");
                return;
            }

            long estimatedGifBytes = 0;
            for (RawFrameData f : rawFrames) {
                estimatedGifBytes += (long) f.nativeImage().getWidth() * f.nativeImage().getHeight() * 4L;
            }
            final long finalGifBytes = estimatedGifBytes;

            handedOffToRenderThread = true;
            Minecraft.getInstance().execute(() -> {
                try {
                    // Check if clearAll() was called while waiting for the render thread
                    if (cacheGeneration.get() != expectedGen) {
                        for (RawFrameData raw : rawFrames) raw.nativeImage().close();
                        return;
                    }

                    if (!evictOldestIfNecessary(finalGifBytes)) {
                        for (RawFrameData raw : rawFrames) raw.nativeImage().close();
                        return;
                    }

                    String key = urlHashKey(urlString);
                    List<GifFrame> registeredFrames = new ArrayList<>(rawFrames.size());

                    for (int i = 0; i < rawFrames.size(); i++) {
                        RawFrameData raw = rawFrames.get(i);
                        ResourceLocation loc = new ResourceLocation("nfm", "textures/dynamic/gif_" + key + "_" + i);
                        DynamicTexture texture = new DynamicTexture(raw.nativeImage());
                        texture.upload();
                        Minecraft.getInstance().getTextureManager().register(loc, texture);
                        registeredFrames.add(new GifFrame(loc, raw.delayTicks()));
                    }

                    GifData previous = gifCache.put(urlString, new GifData(registeredFrames, finalGifBytes));
                    if (previous != null) {
                        previous.release();
                    }
                } catch (Throwable t) {
                    for (RawFrameData raw : rawFrames) {
                        try { raw.nativeImage().close(); } catch (Exception ignored) {}
                    }
                    failUrl(urlString, "Render upload error: " + t.getMessage());
                } finally {
                    loadingUrls.remove(urlString);
                }
            });

        } catch (Throwable t) {
            failUrl(urlString, "Exception: " + t.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (!handedOffToRenderThread) {
                loadingUrls.remove(urlString);
            }
        }
    }

    private static byte[] readStreamWithDeadline(InputStream is, int maxBytes, long maxDurationMs) throws IOException {
        long deadline = System.currentTimeMillis() + maxDurationMs;
        try (InputStream in = is; ByteArrayOutputStream out = new ByteArrayOutputStream(Math.min(maxBytes, 65536))) {
            byte[] buffer = new byte[8192];
            int totalRead = 0;
            int n;
            while ((n = in.read(buffer)) != -1) {
                if (System.currentTimeMillis() > deadline) {
                    throw new SocketTimeoutException("Download exceeded total time limit of " + maxDurationMs + "ms");
                }
                totalRead += n;
                if (totalRead > maxBytes) {
                    throw new IOException("Download exceeds 10MB limit");
                }
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        }
    }

    private record RawFrameData(NativeImage nativeImage, int delayTicks) {}

    // Decodes individual frames and composites them onto a shared canvas
    private List<RawFrameData> decodeRawFrames(byte[] imageBytes) {
        List<RawFrameData> frames = new ArrayList<>();
        ImageReader reader = null;
        Graphics2D g2d = null;
        long totalAllocatedMemory = 0;

        try (ImageInputStream in = ImageIO.createImageInputStream(new ByteArrayInputStream(imageBytes))) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
            if (!readers.hasNext()) return frames;

            reader = readers.next();
            // Verify magic bytes actually resolved to a GIF reader (blocks spoofed TIFF/BMP payloads)
            if (!"gif".equalsIgnoreCase(reader.getFormatName())) {
                System.err.println("[NFM] Rejected image: Reader format is not GIF (" + reader.getFormatName() + ")");
                return frames;
            }

            reader.setInput(in, false, false);

            int masterWidth = reader.getWidth(0);
            int masterHeight = reader.getHeight(0);

            if (masterWidth > MAX_DIMENSION || masterHeight > MAX_DIMENSION || masterWidth <= 0 || masterHeight <= 0) {
                System.err.println("[NFM] Rejected GIF: Master dimensions exceed bounds (" + masterWidth + "x" + masterHeight + ")");
                return frames;
            }

            BufferedImage masterCanvas = new BufferedImage(masterWidth, masterHeight, BufferedImage.TYPE_INT_ARGB);
            g2d = masterCanvas.createGraphics();

            String disposalMethod = "none";
            int xOffset = 0, yOffset = 0;

            // Avoid reader.getNumImages(true) which scans the entire stream upfront; probe frame-by-frame up to MAX_FRAMES
            for (int i = 0; i < MAX_FRAMES; i++) {
                int frameW, frameH;
                try {
                    frameW = reader.getWidth(i);
                    frameH = reader.getHeight(i);
                } catch (IndexOutOfBoundsException e) {
                    break; // Reached the end of the GIF safely
                }

                // Validate EVERY individual frame's dimensions before reader.read(i) allocates heap memory
                if (frameW <= 0 || frameH <= 0 || frameW > MAX_DIMENSION || frameH > MAX_DIMENSION) {
                    throw new IOException("Frame " + i + " dimensions exceed bounds (" + frameW + "x" + frameH + ")");
                }

                long frameBytes = Math.max(
                        (long) masterWidth * masterHeight * 4L,
                        (long) frameW * frameH * 4L
                );
                totalAllocatedMemory += frameBytes;
                if (totalAllocatedMemory > MAX_SINGLE_GIF_BYTES) {
                    System.err.println("[NFM] Aborted GIF decoding: Total uncompressed size exceeded " + (MAX_SINGLE_GIF_BYTES / 1024 / 1024) + "MB limit.");
                    break;
                }

                BufferedImage rawFrame = reader.read(i);
                IIOMetadata metadata = reader.getImageMetadata(i);

                int delayTicks = 2; // Default fallback to 100ms per frame

                if (metadata != null) {
                    try {
                        IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree("javax_imageio_gif_image_1.0");
                        IIOMetadataNode gce = getChildNode(root, "GraphicControlExtension");
                        if (gce != null) {
                            disposalMethod = gce.getAttribute("disposalMethod");
                            String delayTime = gce.getAttribute("delayTime");
                            if (delayTime != null && !delayTime.isEmpty()) {
                                int ms = safeParseInt(delayTime, 2) * 10;
                                delayTicks = Math.max(1, ms / 50); // Convert milliseconds to 50ms game ticks
                            }
                        }

                        IIOMetadataNode descriptor = getChildNode(root, "ImageDescriptor");
                        if (descriptor != null) {
                            xOffset = Math.max(0, Math.min(safeParseInt(descriptor.getAttribute("imageLeftPosition"), 0), masterWidth));
                            yOffset = Math.max(0, Math.min(safeParseInt(descriptor.getAttribute("imageTopPosition"), 0), masterHeight));
                        }
                    } catch (Exception ignored) {}
                }

                g2d.drawImage(rawFrame, xOffset, yOffset, null);

                NativeImage nativeImage = convertToNativeImage(masterCanvas);
                frames.add(new RawFrameData(nativeImage, delayTicks));

                // Clear background if the frame specifies background disposal
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

    // Converts a standard AWT BufferedImage into a Blaze3D NativeImage
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
        cacheGeneration.incrementAndGet();
        for (GifData data : gifCache.values()) {
            data.release();
        }
        gifCache.clear();
        loadingUrls.clear();
        failedUrls.clear();
    }

    // Logs network failures while stripping path and query details to protect user privacy
    private void failUrl(String url, String reason) {
        String sanitizedUrl = "[invalid-url]";
        try {
            URI uri = URI.create(url);
            if (uri.getScheme() != null && uri.getHost() != null) {
                sanitizedUrl = uri.getScheme() + "://" + uri.getHost() + "/[redacted]";
            }
        } catch (Exception ignored) {}

        System.err.println("[NFM] " + reason + " -> " + sanitizedUrl);
        failedUrls.add(url);
        loadingUrls.remove(url);
    }

    // Enforces IP pinning against DNS rebinding while preserving the domain name for SNI and TLS cert validation
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
            // HttpsURLConnection connects a raw TCP socket first and passes it here.
            // Verify that HttpsURLConnection did not reconnect to a rebound/private IP!
            InetAddress remoteAddr = s.getInetAddress();
            if (remoteAddr == null || isPrivateOrRestricted(remoteAddr)) {
                try { s.close(); } catch (Exception ignored) {}
                throw new SecurityException("Blocked connection to restricted/private IP: " + remoteAddr);
            }
            if (!remoteAddr.equals(pinnedAddress)) {
                // If HttpsURLConnection resolved a different IP than our pinned one, close it and connect to pinnedAddress
                try { s.close(); } catch (Exception ignored) {}
                return connectPinnedSocket(port, null, 0);
            }
            return configureSocket((SSLSocket) delegate.createSocket(s, hostName, port, autoClose));
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException {
            return connectPinnedSocket(port, null, 0);
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
            return connectPinnedSocket(port, localHost, localPort);
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            return connectPinnedSocket(port, null, 0);
        }

        @Override
        public Socket createSocket(InetAddress host, int port, InetAddress localHost, int localPort) throws IOException {
            return connectPinnedSocket(port, localHost, localPort);
        }

        private Socket connectPinnedSocket(int port, InetAddress localHost, int localPort) throws IOException {
            Socket raw = new Socket(Proxy.NO_PROXY);
            try {
                if (localHost != null) {
                    raw.bind(new InetSocketAddress(localHost, localPort));
                }
                raw.connect(new InetSocketAddress(pinnedAddress, port), TIMEOUT_MS);
                raw.setSoTimeout(TIMEOUT_MS);
                return configureSocket((SSLSocket) delegate.createSocket(raw, hostName, port, true));
            } catch (Throwable t) {
                try { raw.close(); } catch (Exception ignored) {}
                throw t instanceof IOException io ? io : new IOException(t);
            }
        }

        private Socket configureSocket(SSLSocket socket) {
            SSLParameters params = socket.getSSLParameters();
            try {
                params.setServerNames(List.of(new SNIHostName(hostName)));
            } catch (IllegalArgumentException ignored) {
                // Hostname is an IP literal or non-SNI compatible; EndpointIdentificationAlgorithm still verifies the cert
            }
            params.setEndpointIdentificationAlgorithm("HTTPS");
            socket.setSSLParameters(params);
            return socket;
        }
    }
}
