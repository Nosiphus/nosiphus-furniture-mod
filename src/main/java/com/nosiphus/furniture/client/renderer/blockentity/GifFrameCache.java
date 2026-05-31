package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Stores decoded GIF frames as registered DynamicTextures that can be drawn by the renderer.
 * Frame data is loaded asynchronously in a background thread.
 */
public class GifFrameCache {

    private final List<ResourceLocation> frames = new ArrayList<>();
    private final List<Integer> delays = new ArrayList<>();  // milliseconds per frame
    private long loadedAt = 0;
    private int totalDuration = 0;
    private final AtomicBoolean loading = new AtomicBoolean(false);
    private final AtomicBoolean failed = new AtomicBoolean(false);

    // Counter for unique texture name generation
    private static long textureCounter = 0;

    public boolean isLoading() {
        return loading.get();
    }

    public boolean isFailed() {
        return failed.get();
    }

    public boolean isLoaded() {
        return !loading.get() && !failed.get() && !frames.isEmpty();
    }

    /**
     * Returns the ResourceLocation for the frame that should be shown right now,
     * based on elapsed time since loading completed.
     */
    public ResourceLocation getCurrentFrame() {
        if (frames.isEmpty()) return null;
        if (frames.size() == 1) return frames.get(0);
        if (totalDuration <= 0) return frames.get(0);

        long elapsed = (System.currentTimeMillis() - loadedAt) % totalDuration;
        int cumulative = 0;
        for (int i = 0; i < delays.size(); i++) {
            cumulative += delays.get(i);
            if (elapsed < cumulative) {
                return frames.get(i);
            }
        }
        return frames.get(frames.size() - 1);
    }

    /**
     * Start downloading and decoding the GIF in a background thread.
     */
    public void startLoading(String url) {
        if (loading.getAndSet(true)) return; // already started

        CompletableFuture.runAsync(() -> {
            try {
                URL parsedUrl = URI.create(url).toURL();
                HttpURLConnection conn = (HttpURLConnection) parsedUrl.openConnection();
                conn.setRequestProperty("User-Agent", "NosiphusFurnitureMod/1.0");
                conn.setConnectTimeout(8000);
                conn.setReadTimeout(15000);
                conn.connect();

                if (conn.getResponseCode() != 200) {
                    failed.set(true);
                    loading.set(false);
                    return;
                }

                try (InputStream is = conn.getInputStream()) {
                    ImageInputStream imageStream = ImageIO.createImageInputStream(is);
                    Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("gif");
                    if (!readers.hasNext()) {
                        failed.set(true);
                        loading.set(false);
                        return;
                    }

                    ImageReader reader = readers.next();
                    reader.setInput(imageStream, false);

                    int frameCount = reader.getNumImages(true);
                    List<BufferedImage> bufferedFrames = new ArrayList<>();
                    List<Integer> frameDelays = new ArrayList<>();

                    for (int i = 0; i < frameCount; i++) {
                        BufferedImage img = reader.read(i);
                        bufferedFrames.add(img);

                        // Extract frame delay from metadata (in 1/100ths of a second)
                        IIOMetadata meta = reader.getImageMetadata(i);
                        int delayMs = extractFrameDelay(meta);
                        frameDelays.add(delayMs);
                    }

                    reader.dispose();

                    if (bufferedFrames.isEmpty()) {
                        failed.set(true);
                        loading.set(false);
                        return;
                    }

                    // Register textures on the main render thread
                    Minecraft.getInstance().execute(() -> {
                        try {
                            for (int i = 0; i < bufferedFrames.size(); i++) {
                                BufferedImage img = bufferedFrames.get(i);
                                NativeImage nativeImage = convertToNativeImage(img);

                                DynamicTexture dynTex = new DynamicTexture(nativeImage);
                                long id = ++textureCounter;
                                ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                                        "nfm", "gif_frame_" + id);
                                Minecraft.getInstance().getTextureManager().register(loc, dynTex);

                                frames.add(loc);
                                delays.add(frameDelays.get(i));
                                totalDuration += frameDelays.get(i);
                            }
                            loadedAt = System.currentTimeMillis();
                        } catch (Exception e) {
                            failed.set(true);
                        } finally {
                            loading.set(false);
                        }
                    });
                }
            } catch (Exception e) {
                failed.set(true);
                loading.set(false);
            }
        });
    }

    /**
     * Release all registered textures from the texture manager.
     */
    public void release() {
        Minecraft.getInstance().execute(() -> {
            for (ResourceLocation loc : frames) {
                Minecraft.getInstance().getTextureManager().release(loc);
            }
            frames.clear();
            delays.clear();
        });
    }

    /**
     * Convert a BufferedImage (any type) to a NativeImage in RGBA format.
     */
    private static NativeImage convertToNativeImage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        NativeImage nativeImage = new NativeImage(NativeImage.Format.RGBA, width, height, false);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = img.getRGB(x, y);
                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;
                // NativeImage stores as ABGR
                int abgr = (a << 24) | (b << 16) | (g << 8) | r;
                nativeImage.setPixelRGBA(x, y, abgr);
            }
        }
        return nativeImage;
    }

    /**
     * Parse the frame delay from GIF IIOMetadata. Returns delay in milliseconds.
     * Defaults to 100ms if not found.
     */
    private static int extractFrameDelay(IIOMetadata meta) {
        if (meta == null) return 100;
        try {
            org.w3c.dom.Node root = meta.getAsTree("javax_imageio_gif_image_1.0");
            org.w3c.dom.NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                org.w3c.dom.Node child = children.item(i);
                if ("GraphicControlExtension".equals(child.getNodeName())) {
                    org.w3c.dom.NamedNodeMap attrs = child.getAttributes();
                    org.w3c.dom.Node delayAttr = attrs.getNamedItem("delayTime");
                    if (delayAttr != null) {
                        int delayCs = Integer.parseInt(delayAttr.getNodeValue()); // centiseconds
                        int delayMs = delayCs * 10;
                        return delayMs < 20 ? 100 : delayMs; // clamp very short delays
                    }
                }
            }
        } catch (Exception ignored) {}
        return 100;
    }
}
