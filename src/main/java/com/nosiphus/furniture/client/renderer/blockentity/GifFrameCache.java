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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
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

    private final Map<String, GifData> gifCache = new ConcurrentHashMap<>();
    private final Set<String> loadingUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private final Set<String> failedUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public record GifFrame(ResourceLocation textureLocation, int delayTicks) {}

    public static class GifData {
        private final List<GifFrame> frames;
        private int refCount = 0;
        private long lastAccessTime = System.currentTimeMillis();

        public GifData(List<GifFrame> frames) {
            this.frames = frames;
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

    private void evictOldestIfNecessary() {
        if (gifCache.size() < MAX_CACHE_ENTRIES) return;

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
        }
    }

    private void loadGifAsync(String urlString) {
        try {
            URI uri = URI.create(urlString);

            if (!"https".equalsIgnoreCase(uri.getScheme())) {
                failUrl(urlString, "Rejected: Must use HTTPS protocol.");
                return;
            }

            InetAddress hostAddress = InetAddress.getByName(uri.getHost());
            if (hostAddress.isLoopbackAddress() || hostAddress.isSiteLocalAddress()
                    || hostAddress.isLinkLocalAddress() || hostAddress.isAnyLocalAddress()) {
                failUrl(urlString, "Rejected: Resolves to private/loopback IP address.");
                return;
            }

            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false); // Security: Prevent SSRF redirect loops
            conn.setConnectTimeout(TIMEOUT_MS);
            conn.setReadTimeout(TIMEOUT_MS);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
            conn.setRequestProperty("Accept", "image/gif,image/webp,image/apng,image/*,*/*;q=0.8");

            String contentType = conn.getContentType();
            if (contentType != null && !contentType.toLowerCase().contains("image")) {
                failUrl(urlString, "Rejected: Invalid Content-Type (" + contentType + ")");
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

            Minecraft.getInstance().execute(() -> {
                List<GifFrame> registeredFrames = new ArrayList<>();
                for (int i = 0; i < rawFrames.size(); i++) {
                    RawFrameData raw = rawFrames.get(i);
                    ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                            "nfm", "textures/dynamic/gif_" + Math.abs(urlString.hashCode()) + "_" + i);

                    DynamicTexture texture = new DynamicTexture(raw.nativeImage());
                    texture.upload();
                    Minecraft.getInstance().getTextureManager().register(loc, texture);
                    registeredFrames.add(new GifFrame(loc, raw.delayTicks()));
                }

                evictOldestIfNecessary();
                gifCache.put(urlString, new GifData(registeredFrames));
                loadingUrls.remove(urlString);
            });

        } catch (Exception e) {
            failUrl(urlString, "Exception: " + e.getMessage());
        }
    }

    private record RawFrameData(NativeImage nativeImage, int delayTicks) {}

    private List<RawFrameData> decodeRawFrames(byte[] imageBytes) {
        List<RawFrameData> frames = new ArrayList<>();
        try (ImageInputStream in = ImageIO.createImageInputStream(new ByteArrayInputStream(imageBytes))) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
            if (!readers.hasNext()) return frames;

            ImageReader reader = readers.next();
            reader.setInput(in);

            int count = Math.min(reader.getNumImages(true), MAX_FRAMES);

            int masterWidth = reader.getWidth(0);
            int masterHeight = reader.getHeight(0);

            if (masterWidth > MAX_DIMENSION || masterHeight > MAX_DIMENSION || masterWidth <= 0 || masterHeight <= 0) {
                System.err.println("[NFM] Rejected GIF: Resolution exceeds safety cap (" + masterWidth + "x" + masterHeight + ")");
                reader.dispose();
                return frames;
            }

            BufferedImage masterCanvas = new BufferedImage(masterWidth, masterHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = masterCanvas.createGraphics();

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
                            int ms = Integer.parseInt(delayTime) * 10;
                            delayTicks = Math.max(1, ms / 50);
                        }
                    }

                    IIOMetadataNode descriptor = getChildNode(root, "ImageDescriptor");
                    if (descriptor != null) {
                        String left = descriptor.getAttribute("imageLeftPosition");
                        String top = descriptor.getAttribute("imageTopPosition");
                        xOffset = (left != null && !left.isEmpty()) ? Integer.parseInt(left) : 0;
                        yOffset = (top != null && !top.isEmpty()) ? Integer.parseInt(top) : 0;
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

            g2d.dispose();
            reader.dispose();
        } catch (Exception e) {
            for (RawFrameData f : frames) {
                f.nativeImage().close();
            }
            frames.clear();
            System.err.println("[NFM] Error decoding GIF frames: " + e.getMessage());
        }
        return frames;
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
        System.err.println("[NFM] " + reason + " -> " + url);
        failedUrls.add(url);
        loadingUrls.remove(url);
    }
}