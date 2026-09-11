package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
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

public class CathodeRayTubeTelevisionBlockEntityRenderer implements BlockEntityRenderer<CathodeRayTubeTelevisionBlockEntity> {

    public CathodeRayTubeTelevisionBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(CathodeRayTubeTelevisionBlockEntity tv, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (tv.getLevel() == null) return;
        BlockState state = tv.getBlockState();
        if (!state.getValue(CathodeRayTubeTelevisionBlock.POWERED)) return;

        int activeChannel = state.hasProperty(CathodeRayTubeTelevisionBlock.CHANNEL) ? state.getValue(CathodeRayTubeTelevisionBlock.CHANNEL) : 0;
        String customUrl = tv.getChannelUrl(activeChannel);
        if (customUrl == null || customUrl.isBlank()) return;

        long gameTime = tv.getLevel().getGameTime();
        ResourceLocation renderTexture = GifFrameCache.getInstance().getTexture(customUrl, gameTime);
        if (renderTexture == null) return;

        Direction facing = state.hasProperty(CathodeRayTubeTelevisionBlock.DIRECTION) ? state.getValue(CathodeRayTubeTelevisionBlock.DIRECTION) : Direction.NORTH;

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);

        float rotation = switch (facing) {
            case SOUTH -> 180.0F;
            case WEST -> 270.0F;
            case EAST -> 90.0F;
            case NORTH -> 0.0F;
            default -> 0.0F;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        double baseZOffset = 0.38D;
        boolean isEastOrWest = (facing == Direction.EAST || facing == Direction.WEST);
        double zOffset = isEastOrWest ? -baseZOffset : baseZOffset;
        poseStack.translate(0.0D, -0.0875D, zOffset);

        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(renderTexture));
        Matrix4f matrix = poseStack.last().pose();

        float width = 0.625F;
        float height = 0.625F;
        float minX = -width / 2.0F;
        float maxX = width / 2.0F;
        float minY = -height / 2.0F;
        float maxY = height / 2.0F;

        float minU = isEastOrWest ? 0.0F : 1.0F;
        float maxU = isEastOrWest ? 1.0F : 0.0F;

        builder.vertex(matrix, minX, maxY, 0.0F).color(255, 255, 255, 255).uv(maxU, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, 1.0F).endVertex();
        builder.vertex(matrix, minX, minY, 0.0F).color(255, 255, 255, 255).uv(maxU, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, 1.0F).endVertex();
        builder.vertex(matrix, maxX, minY, 0.0F).color(255, 255, 255, 255).uv(minU, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, 1.0F).endVertex();
        builder.vertex(matrix, maxX, maxY, 0.0F).color(255, 255, 255, 255).uv(minU, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, 1.0F).endVertex();

        builder.vertex(matrix, maxX, maxY, 0.0F).color(255, 255, 255, 255).uv(minU, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, -1.0F).endVertex();
        builder.vertex(matrix, maxX, minY, 0.0F).color(255, 255, 255, 255).uv(minU, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, -1.0F).endVertex();
        builder.vertex(matrix, minX, minY, 0.0F).color(255, 255, 255, 255).uv(maxU, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, -1.0F).endVertex();
        builder.vertex(matrix, minX, maxY, 0.0F).color(255, 255, 255, 255).uv(maxU, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(0.0F, 0.0F, -1.0F).endVertex();

        poseStack.popPose();
    }
}