package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import com.nosiphus.furniture.world.level.block.ComputerBlock;
import com.nosiphus.furniture.world.level.block.entity.ComputerBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

import java.util.HashMap;
import java.util.Map;

public class ComputerBlockEntityRenderer implements BlockEntityRenderer<ComputerBlockEntity> {

    // Static GIF frame cache shared across all renderer instances
    private static final Map<String, GifFrameCache> GIF_CACHE = new HashMap<>();

    public ComputerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ComputerBlockEntity blockEntity, float partialTicks,
                       PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {

        BlockState state = blockEntity.getBlockState();
        if (!(state.getBlock() instanceof ComputerBlock)) {
            return;
        }

        // Only render screen content when powered
        if (!state.getValue(ComputerBlock.POWER)) {
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

        Direction facing = state.getValue(ComputerBlock.DIRECTION);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        // The ComputerBlock default direction is EAST (see registerDefaultState).
        // VoxelShapeHelper.rotate with Direction.EAST means the model is authored facing EAST.
        // We need to rotate so that when DIRECTION=EAST the screen faces east, etc.
        // DIRECTION uses get2DDataValue: SOUTH=0, WEST=1, NORTH=2, EAST=3
        // We want no rotation when facing EAST (authored direction).
        // Rotation to apply = (facing.get2DDataValue() - Direction.EAST.get2DDataValue()) * -90 degrees around Y
        int rotation = facing.get2DDataValue(); // S=0, W=1, N=2, E=3
        // For EAST (rotation=3): 3*(-90)+180 = -90 => faces east correctly
        // For SOUTH (rotation=0): 0*(-90)+180 = 180 => faces south correctly
        poseStack.mulPose(Axis.YP.rotationDegrees(-90F * rotation + 180F));

        // MONITOR_SCREEN when facing EAST (authored direction):
        // Block.box(4.8, 7.4, 3.0, 6.4, 15.0, 13.0) with Direction.EAST rotation
        // After VoxelShapeHelper.rotate(shape, Direction.EAST): rotates model so it faces east
        // The screen face at x=4.8 (min x) is the front face of the screen, facing west (toward -x)
        // BUT the screen content should show on the outer face facing the viewer.
        // In the EAST-facing authored model, the monitor screen panel is at x=4.8..6.4, z=3..13, y=7.4..15
        // The front (visible) face is at x=4.8 (minimum x face, facing -X direction in east-authored space)
        // After our pose rotation (which aligns east-authored to match DIRECTION), 
        // the screen faces in the -Z direction in rotated space (which becomes the "south" face of the block
        // after all rotations cancel out to point toward the viewer).
        //
        // Let's work in the centered coordinate space after translate(0.5,0.5,0.5) and the Y rotation:
        // In the rotated frame, the screen panel front face is at:
        //   z offset from center: 4.8/16 - 0.5 = 0.3 - 0.5 = -0.2  (front face at x=4.8 in block space)
        //   BUT after the Y rotation that aligns east->south facing, x becomes -z
        //   So screen front in rotated space: z = -(4.8/16 - 0.5) = 0.2 ... 
        // 
        // Simpler approach: the screen quad should sit just in front of x=4.8/16 in block local space.
        // In the south-facing post-rotation space:
        //   The screen surface is at z = -(4.8/16 - 0.5) = 0.2 in centered rotated space
        //   Screen spans: y from 7.4/16-0.5 = -0.0375 to 15.0/16-0.5 = 0.4375
        //                 x from -(13.0/16-0.5) = -0.3125 to -(3.0/16-0.5) = 0.3125
        //   (z span 3..13 in block space maps to x in rotated space, centered)

        float zOffset = 0.21f;   // Just in front of the screen panel surface (x=4.8 in block space)

        float xMin = -0.3125f;   // -(13/16 - 0.5) = -(0.8125 - 0.5) = -0.3125
        float xMax =  0.3125f;   // -(3/16 - 0.5)  = -(0.1875 - 0.5) =  0.3125
        float yMin = -0.0375f;   // 7.4/16 - 0.5 = 0.4625 - 0.5 = -0.0375
        float yMax =  0.4375f;   // 15.0/16 - 0.5 = 0.9375 - 0.5 = 0.4375

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.text(frameTexture));
        Matrix4f pose = poseStack.last().pose();

        // Render as a quad on the screen face (facing -Z in rotated space)
        consumer.addVertex(pose, xMin, yMax, zOffset).setColor(255, 255, 255, 255).setUv(0.0f, 0.0f).setLight(light);
        consumer.addVertex(pose, xMin, yMin, zOffset).setColor(255, 255, 255, 255).setUv(0.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xMax, yMin, zOffset).setColor(255, 255, 255, 255).setUv(1.0f, 1.0f).setLight(light);
        consumer.addVertex(pose, xMax, yMax, zOffset).setColor(255, 255, 255, 255).setUv(1.0f, 0.0f).setLight(light);

        poseStack.popPose();
    }

    /**
     * Evict cached GIF data for a URL (called when a computer's URL changes, to free memory).
     */
    public static void evict(String url) {
        GifFrameCache removed = GIF_CACHE.remove(url);
        if (removed != null) {
            removed.release();
        }
    }
}
