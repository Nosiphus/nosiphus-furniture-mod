package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import com.nosiphus.furniture.world.level.block.LiquidCrystalDisplayTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

import java.util.HashMap;
import java.util.Map;

public class LiquidCrystalDisplayTelevisionRenderer implements BlockEntityRenderer<LiquidCrystalDisplayTelevisionBlockEntity> {

    // Static GIF frame cache shared across all renderer instances
    private static final Map<String, GifFrameCache> GIF_CACHE = new HashMap<>();

    public LiquidCrystalDisplayTelevisionRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(LiquidCrystalDisplayTelevisionBlockEntity blockEntity, float partialTicks,
                       PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {

        BlockState state = blockEntity.getBlockState();
        if (!(state.getBlock() instanceof LiquidCrystalDisplayTelevisionBlock)) {
            return;
        }

        // Only render screen content when powered
        if (!state.getValue(LiquidCrystalDisplayTelevisionBlock.POWER)) {
            return;
        }

        String gifUrl = blockEntity.getGifUrl();
        if (gifUrl == null || gifUrl.isBlank()) {
            return;
        }

        // Get or create cache entry
        GifFrameCache cache = GIF_CACHE.computeIfAbsent(gifUrl, url -> {
            GifFrameCache newCache = new GifFrameCache();
            newCache.startLoading(url);
            return newCache;
        });

        if (cache.isFailed() || cache.isLoading()) {
            return;
        }

        net.minecraft.resources.ResourceLocation frameTexture = cache.getCurrentFrame();
        if (frameTexture == null) {
            return;
        }

        Direction facing = state.getValue(LiquidCrystalDisplayTelevisionBlock.DIRECTION);
        boolean mounted = state.getValue(LiquidCrystalDisplayTelevisionBlock.MOUNTED);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        int rotation = facing.get2DDataValue();
        poseStack.mulPose(Axis.YP.rotationDegrees(-90F * rotation + 180F));

        // Translate to screen face position
        // The TV screen face in local (south-facing) space is around z = 8.0/16 - small offset
        // Screen spans approximately x: -3/16 to 13/16 relative to block origin, y: 4/16 to 16/16
        // After centering at 0.5, 0.5, 0.5:
        //   x: -3/16 - 0.5 = -0.6875  to  13/16 - 0.5 = 0.3125
        //   But block is 0..16 wide... let's use block-local coords for clarity:
        // In the south-facing model the screen is at z~0.532 (8.5/16), x: -3/16..13/16, y: 4/16..16/16
        // After translating by -0.5 each axis:
        //   x: -0.6875..0.3125, y: -0.25..0.5, z = 0.032 in this space (0.532 - 0.5)
        // Then extended 2x width since the actual TV spans -3 to +19 (22 units):
        //   left screen: x -3..13, right screen: 13..19
        //   Combined TV screen x: -3/16..19/16 shifted by -0.5: -0.6875..0.6875
        //   y: 4/16..16/16 shifted by -0.5: -0.25..0.5

        float zOffset = mounted ? -0.47f : 0.032f;  // front face offset in centered space

        float xMin = -0.6875f;
        float xMax =  0.6875f;
        float yMin = -0.25f;
        float yMax =  0.5f;

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.text(frameTexture));
        Matrix4f pose = poseStack.last().pose();

        // Render as a quad on the screen face
        consumer.addVertex(pose, xMin, yMax, zOffset).setColor(255, 255, 255, 255).setUv(0.0f, 0.0f).setLight(light);
        consumer.addVertex(pose, xMin, yMin, zOffset).setColor(255, 255, 255, 255).setUv(0.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xMax, yMin, zOffset).setColor(255, 255, 255, 255).setUv(1.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xMax, yMax, zOffset).setColor(255, 255, 255, 255).setUv(1.0f, 0.0f).setLight(light);

        poseStack.popPose();
    }

    /**
     * Evict cached GIF data for a URL (called when a TV's URL changes, to free memory).
     */
    public static void evict(String url) {
        GifFrameCache removed = GIF_CACHE.remove(url);
        if (removed != null) {
            removed.release();
        }
    }
}