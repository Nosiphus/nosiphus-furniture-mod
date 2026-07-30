package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.platform.NativeImage;
import com.nosiphus.furniture.network.protocol.UrlValidator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class GifFrameCache {

    private static final GifFrameCache INSTANCE = new GifFrameCache();
    public static GifFrameCache getInstance() { return INSTANCE; }

    private static final int MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    private static final int TIMEOUT_MS = 5000;
    private static final int MAX_FRAMES = 150;

    private final Map<String, GifData> gifCache = new ConcurrentHashMap<>();
    private final Set<String> loadingUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private final Set<String> failedUrls = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public record GifFrame(ResourceLocation textureLocation, int delayTicks) {}

    public static class GifData {
        private final List<GifFrame> frames;

        public GifData(List<GifFrame> frames) {
            this.frames = frames;
        }

        public ResourceLocation getFrame(long gameTime) {
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

        public void release() {
            Minecraft mc = Minecraft.getInstance();
            for (GifFrame frame : frames) {
                mc.getTextureManager().release(frame.textureLocation());
            }
            frames.clear();
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
            URLConnection conn = url.openConnection();
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
                    Minecraft.getInstance().getTextureManager().register(loc, texture);
                    registeredFrames.add(new GifFrame(loc, raw.delayTicks()));
                }

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
            for (int i = 0; i < count; i++) {
                BufferedImage bImg = reader.read(i);
                NativeImage nativeImage = convertToNativeImage(bImg);
                frames.add(new RawFrameData(nativeImage, 2)); // Default 2 tick delay
            }
            reader.dispose();
        } catch (Exception ignored) {}
        return frames;
    }

    private NativeImage convertToNativeImage(BufferedImage bImg) {
        NativeImage nativeImage = new NativeImage(bImg.getWidth(), bImg.getHeight(), true);
        for (int y = 0; y < bImg.getHeight(); y++) {
            for (int x = 0; x < bImg.getWidth(); x++) {
                int argb = bImg.getRGB(x, y);
                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;
                nativeImage.setPixelRGBA(x, y, (a << 24) | (b << 16) | (g << 8) | r);
            }
        }
        return nativeImage;
    }

    private void failUrl(String url, String reason) {
        System.err.println("[NFM] " + reason + " -> " + url);
        failedUrls.add(url);
        loadingUrls.remove(url);
    }
}