package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrcrayfish.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.entity.CupBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluids;
import org.joml.Matrix4f;

public class CupBlockEntityRenderer implements BlockEntityRenderer<CupBlockEntity> {

    public CupBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CupBlockEntity cup, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if (cup.getFluid() == Fluids.EMPTY || cup.getFluidAmount() <= 0) {
            return;
        }

        float fillRatio = (float) cup.getFluidAmount() / (float) cup.getCapacity();

        float minX = 6.0F / 16.0F;
        float maxX = 10.0F / 16.0F;
        float minZ = 6.0F / 16.0F;
        float maxZ = 10.0F / 16.0F;

        float minY = 0.5F / 16.0F;
        float maxY = (0.5F + (6.0F * fillRatio)) / 16.0F;

        TextureAtlasSprite sprite = Services.PLATFORM.getStillFluidSprite(cup.getFluid());
        int color = Services.PLATFORM.getFluidColor(cup.getFluid(), cup.getLevel(), cup.getBlockPos());

        float r = ((color >> 16) & 0xFF) / 255.0F;
        float g = ((color >> 8) & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        float a = ((color >> 24) & 0xFF) / 255.0F;
        if (a == 0.0F) a = 1.0F;

        VertexConsumer builder = buffer.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();

        drawQuad(builder, matrix, minX, maxX, maxY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.UP);

        drawQuad(builder, matrix, minX, minX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.WEST);
        drawQuad(builder, matrix, maxX, maxX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.EAST);
        drawQuad(builder, matrix, minX, maxX, minY, maxY, minZ, minZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.NORTH);
        drawQuad(builder, matrix, minX, maxX, minY, maxY, maxZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.SOUTH);
    }

    private void drawQuad(VertexConsumer builder, Matrix4f matrix, float x1, float x2, float y1, float y2, float z1, float z2,
                          TextureAtlasSprite sprite, float r, float g, float b, float a,
                          int light, int overlay, Direction face) {

        float u1 = sprite.getU(x1 * 16.0F);
        float u2 = sprite.getU(x2 * 16.0F);

        float v1, v2;
        if (face == Direction.UP || face == Direction.DOWN) {
            v1 = sprite.getV(z1 * 16.0F);
            v2 = sprite.getV(z2 * 16.0F);
        } else {
            v1 = sprite.getV(y1 * 16.0F);
            v2 = sprite.getV(y2 * 16.0F);
        }

        switch (face) {
            case UP -> {
                builder.vertex(matrix, x1, y2, z2).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x2, y2, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x1, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
            }
            case NORTH -> {
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x2, y1, z1).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x1, y1, z1).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x1, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
            }
            case SOUTH -> {
                builder.vertex(matrix, x1, y2, z2).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 0, 1).endVertex();
                builder.vertex(matrix, x1, y1, z2).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 0, 1).endVertex();
                builder.vertex(matrix, x2, y1, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 0, 1).endVertex();
                builder.vertex(matrix, x2, y2, z2).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 0, 1).endVertex();
            }
            case WEST -> {
                builder.vertex(matrix, x1, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(-1, 0, 0).endVertex();
                builder.vertex(matrix, x1, y1, z1).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(-1, 0, 0).endVertex();
                builder.vertex(matrix, x1, y1, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(-1, 0, 0).endVertex();
                builder.vertex(matrix, x1, y2, z2).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(-1, 0, 0).endVertex();
            }
            case EAST -> {
                builder.vertex(matrix, x2, y2, z2).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y1, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y1, z1).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
            }
        }
    }
}