package com.nosiphus.furniture.client.renderer.blockentity;

import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

import java.util.HashMap;
import java.util.Map;

public class CathodeRayTubeTelevisionRenderer implements BlockEntityRenderer<CathodeRayTubeTelevisionBlockEntity> {

    // Static GIF frame cache shared across all renderer instances
    private static final Map<String, GifFrameCache> GIF_CACHE = new HashMap<>();

    public CathodeRayTubeTelevisionRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CathodeRayTubeTelevisionBlockEntity blockEntity, float partialTicks,
                       PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {

        BlockState state = blockEntity.getBlockState();
        if (!(state.getBlock() instanceof CathodeRayTubeTelevisionBlock)) {
            return;
        }

        // Only render screen content when powered
        if (!state.getValue(CathodeRayTubeTelevisionBlock.POWER)) {
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

        Direction facing = state.getValue(CathodeRayTubeTelevisionBlock.DIRECTION);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        // The block voxel shape uses Direction.EAST as the base orientation.
        // SCREEN = Block.box(2.0, 1.6, 3.0, 6.8, 11.6, 13.0) facing EAST
        // The screen face is the low-x face (front of the CRT tube), at x=2/16.
        // After centering at 0.5:
        //   x_face = 2/16 - 0.5 = -0.375  (front face, render quad just in front at x ~ -0.38)
        //   y: 1.6/16 - 0.5 = -0.4  to  11.6/16 - 0.5 = 0.225
        //   z: 3/16 - 0.5 = -0.3125  to  13/16 - 0.5 = 0.3125
        //
        // The block's base direction is EAST (the VoxelShapeHelper.rotate call uses Direction.EAST).
        // FurnitureHorizontalBlock defaults to DIRECTION=NORTH or EAST — CRT defaults to NORTH.
        // VoxelShapeHelper.getRotatedShapes index = direction.get2DDataValue()
        // Direction.EAST.get2DDataValue() = 1  — but shapes[direction] means we need to rotate
        // to cancel the model rotation.
        //
        // The model is authored facing EAST (right side of screen faces +x).
        // When the block faces EAST in-world, no rotation needed.
        // Rotation offset to align local space: rotate by -90*(facing.get2DDataValue()) + 90 degrees
        // (matching the LCD TV renderer convention but adapted for EAST base)

        int rotation = facing.get2DDataValue(); // S=0, W=1, N=2, E=3
        // EAST base: when facing==EAST, rotation=3, we want 0° net. Formula: -90*rotation + 90*(3) = -90*rotation+270
        // Simpler: same formula as LCD TV but offset for EAST base vs SOUTH base.
        // LCD TV uses SOUTH base with: -90*rotation + 180
        // CRT uses EAST base: EAST base is 90° CCW from SOUTH, so subtract 90 more: -90*rotation + 90
        poseStack.mulPose(Axis.YP.rotationDegrees(-90F * rotation + 90F));

        // Screen quad in EAST-facing local space (centered at block origin)
        float xFace = -0.38f; // just in front of screen surface at x=2/16-0.5=-0.375
        float yMin = -0.4f;   // 1.6/16 - 0.5
        float yMax =  0.225f; // 11.6/16 - 0.5
        float zMin = -0.3125f; // 3/16 - 0.5
        float zMax =  0.3125f; // 13/16 - 0.5

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.text(frameTexture));
        Matrix4f pose = poseStack.last().pose();

        // Quad on the YZ plane (screen face normal pointing -X in local space)
        // Winding: looking from -X direction (from in front of screen)
        consumer.addVertex(pose, xFace, yMax, zMin).setColor(255, 255, 255, 255).setUv(0.0f, 0.0f).setLight(light);
        consumer.addVertex(pose, xFace, yMin, zMin).setColor(255, 255, 255, 255).setUv(0.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xFace, yMin, zMax).setColor(255, 255, 255, 255).setUv(1.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xFace, yMax, zMax).setColor(255, 255, 255, 255).setUv(1.0f, 0.0f).setLight(light);

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
