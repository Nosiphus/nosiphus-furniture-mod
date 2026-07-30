package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;

public class CathodeRayTubeTelevisionBlockEntityRenderer implements BlockEntityRenderer<CathodeRayTubeTelevisionBlockEntity> {

    public CathodeRayTubeTelevisionBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CathodeRayTubeTelevisionBlockEntity tv, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (tv.getLevel() == null) return;

        String activeUrl = tv.getChannelUrl(0);
        if (activeUrl == null || activeUrl.isBlank()) return;

        long gameTime = tv.getLevel().getGameTime();
        ResourceLocation textureLoc = GifFrameCache.getInstance().getTexture(activeUrl, gameTime);
        if (textureLoc == null) return;

        BlockState state = tv.getBlockState();
        Direction facing = state.hasProperty(CathodeRayTubeTelevisionBlock.DIRECTION)
                ? state.getValue(CathodeRayTubeTelevisionBlock.DIRECTION)
                : Direction.NORTH;

        poseStack.pushPose();

        poseStack.translate(0.5D, 0.5D, 0.5D);

        float rotation = switch (facing) {
            case SOUTH -> 180.0F;
            case WEST  -> 270.0F;
            case EAST  -> 90.0F;
            default    -> 0.0F; // NORTH
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        poseStack.translate(0.0D, 0.05D, -0.26D);
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entitySolid(textureLoc));
        Matrix4f matrix = poseStack.last().pose();
        float width = 0.625F;
        float height = 0.45F;
        float minX = -width / 2.0F;
        float maxX = width / 2.0F;
        float minY = -height / 2.0F;
        float maxY = height / 2.0F;
        renderQuad(vertexConsumer, matrix, minX, maxX, minY, maxY, combinedLight, combinedOverlay);
        poseStack.popPose();
    }

    private static void renderQuad(VertexConsumer builder, Matrix4f matrix, float minX, float maxX, float minY, float maxY, int combinedLight, int combinedOverlay) {
        builder.addVertex(matrix, minX, maxY, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(0.0F, 0.0F)
                .setOverlay(combinedOverlay)
                .setLight(combinedLight)
                .setNormal(0.0F, 0.0F, 1.0F);
        builder.addVertex(matrix, minX, minY, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(0.0F, 1.0F)
                .setOverlay(combinedOverlay)
                .setLight(combinedLight)
                .setNormal(0.0F, 0.0F, 1.0F);
        builder.addVertex(matrix, maxX, minY, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(1.0F, 1.0F)
                .setOverlay(combinedOverlay)
                .setLight(combinedLight)
                .setNormal(0.0F, 0.0F, 1.0F);
        builder.addVertex(matrix, maxX, maxY, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(1.0F, 0.0F)
                .setOverlay(combinedOverlay)
                .setLight(combinedLight)
                .setNormal(0.0F, 0.0F, 1.0F);
    }
}