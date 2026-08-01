package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.nosiphus.furniture.world.level.block.LiquidCrystalDisplayTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

public class LiquidCrystalDisplayTelevisionBlockEntityRenderer implements BlockEntityRenderer<LiquidCrystalDisplayTelevisionBlockEntity> {

    public LiquidCrystalDisplayTelevisionBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(LiquidCrystalDisplayTelevisionBlockEntity tv, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (tv.getLevel() == null) return;
        BlockState state = tv.getBlockState();
        if (!state.getValue(LiquidCrystalDisplayTelevisionBlock.POWERED)) {
            return;
        }
        int activeChannel = state.hasProperty(LiquidCrystalDisplayTelevisionBlock.CHANNEL)
                ? state.getValue(LiquidCrystalDisplayTelevisionBlock.CHANNEL)
                : 0;
        String customUrl = tv.getChannelUrl(activeChannel);
        if (customUrl == null || customUrl.isBlank()) return;
        long gameTime = tv.getLevel().getGameTime();
        ResourceLocation renderTexture = GifFrameCache.getInstance().getTexture(customUrl, gameTime);
        if (renderTexture == null) return;
        Direction facing = state.hasProperty(LiquidCrystalDisplayTelevisionBlock.DIRECTION)
                ? state.getValue(LiquidCrystalDisplayTelevisionBlock.DIRECTION)
                : Direction.NORTH;
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);
        float rotation = switch (facing) {
            case SOUTH -> 180.0F;
            case WEST  -> 270.0F;
            case EAST  -> 90.0F;
            case NORTH -> 0.0F;
            default    -> 0.0F;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        boolean mounted = state.getValue(LiquidCrystalDisplayTelevisionBlock.MOUNTED);
        double zOffset = mounted ? 0.34475D : -0.03225D;
        poseStack.translate(0.0D, 0.125D, zOffset);
        int fullbrightLight = LightTexture.FULL_BRIGHT;
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(renderTexture));
        Matrix4f matrix = poseStack.last().pose();
        float width = 1.375F;
        float height = 0.75F;
        float minX = -width / 2.0F;
        float maxX = width / 2.0F;
        float minY = -height / 2.0F;
        float maxY = height / 2.0F;
        renderQuad(builder, matrix, minX, maxX, minY, maxY, fullbrightLight, OverlayTexture.NO_OVERLAY, false);
        renderQuad(builder, matrix, minX, maxX, minY, maxY, fullbrightLight, OverlayTexture.NO_OVERLAY, true);
        poseStack.popPose();
    }

    private static void renderQuad(VertexConsumer builder, Matrix4f matrix, float minX, float maxX, float minY, float maxY, int combinedLight, int combinedOverlay, boolean reverseWinding) {
        if (!reverseWinding) {
            builder.addVertex(matrix, minX, maxY, 0.0F).setColor(255, 255, 255, 255).setUv(1.0F, 0.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, 1.0F);
            builder.addVertex(matrix, minX, minY, 0.0F).setColor(255, 255, 255, 255).setUv(1.0F, 1.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, 1.0F);
            builder.addVertex(matrix, maxX, minY, 0.0F).setColor(255, 255, 255, 255).setUv(0.0F, 1.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, 1.0F);
            builder.addVertex(matrix, maxX, maxY, 0.0F).setColor(255, 255, 255, 255).setUv(0.0F, 0.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, 1.0F);
        } else {
            builder.addVertex(matrix, maxX, maxY, 0.0F).setColor(255, 255, 255, 255).setUv(0.0F, 0.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, -1.0F);
            builder.addVertex(matrix, maxX, minY, 0.0F).setColor(255, 255, 255, 255).setUv(0.0F, 1.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, -1.0F);
            builder.addVertex(matrix, minX, minY, 0.0F).setColor(255, 255, 255, 255).setUv(1.0F, 1.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, -1.0F);
            builder.addVertex(matrix, minX, maxY, 0.0F).setColor(255, 255, 255, 255).setUv(1.0F, 0.0F).setOverlay(combinedOverlay).setLight(combinedLight).setNormal(0.0F, 0.0F, -1.0F);
        }
    }
}