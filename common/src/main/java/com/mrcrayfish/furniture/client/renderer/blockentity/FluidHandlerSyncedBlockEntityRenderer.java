package com.mrcrayfish.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.joml.Matrix4f;

public abstract class FluidHandlerSyncedBlockEntityRenderer<T extends FluidHandlerSyncedBlockEntity> implements BlockEntityRenderer<T> {

    public FluidHandlerSyncedBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    protected void renderFluidBox(T blockEntity, PoseStack poseStack, MultiBufferSource buffer,
                                  float minX, float minY, float minZ,
                                  float maxX, float maxY, float maxZ,
                                  int packedLight, int packedOverlay) {

        Fluid fluid = blockEntity.getFluid();
        if (fluid == Fluids.EMPTY || blockEntity.getFluidAmount() <= 0 || minY >= maxY) {
            return;
        }

        TextureAtlasSprite sprite = Services.PLATFORM.getStillFluidSprite(fluid);
        if (sprite == null) {
            return;
        }

        int color = Services.PLATFORM.getFluidColor(fluid, blockEntity.getLevel(), blockEntity.getBlockPos());
        float r = ((color >> 16) & 0xFF) / 255.0F;
        float g = ((color >> 8) & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        float a = ((color >> 24) & 0xFF) / 255.0F;
        if (a == 0.0F) a = 1.0F;

        VertexConsumer builder = buffer.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();

        drawTiledHorizontalFace(builder, matrix, minX, maxX, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.UP);
        drawTiledHorizontalFace(builder, matrix, minX, maxX, minY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.DOWN);

        drawTiledSideFaceZ(builder, matrix, minX, maxX, minY, maxY, minZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.NORTH);
        drawTiledSideFaceZ(builder, matrix, minX, maxX, minY, maxY, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.SOUTH);

        drawTiledSideFaceX(builder, matrix, minX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.WEST);
        drawTiledSideFaceX(builder, matrix, maxX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.EAST);
    }

    private void drawTiledHorizontalFace(VertexConsumer builder, Matrix4f matrix,
                                         float minX, float maxX, float y, float minZ, float maxZ,
                                         TextureAtlasSprite sprite, float r, float g, float b, float a,
                                         int light, int overlay, Direction face) {
        for (float x = minX; x < maxX; x = Math.min(x + 1.0F - (x % 1.0F == 0 ? 0 : x % 1.0F), maxX)) {
            float nextX = Math.min(x + (1.0F - (x % 1.0F)), maxX);
            float u1 = sprite.getU((x % 1.0F) * 16.0F);
            float u2 = sprite.getU((x % 1.0F + (nextX - x)) * 16.0F);

            for (float z = minZ; z < maxZ; z = Math.min(z + 1.0F - (z % 1.0F == 0 ? 0 : z % 1.0F), maxZ)) {
                float nextZ = Math.min(z + (1.0F - (z % 1.0F)), maxZ);
                float v1 = sprite.getV((z % 1.0F) * 16.0F);
                float v2 = sprite.getV((z % 1.0F + (nextZ - z)) * 16.0F);

                if (face == Direction.UP) {
                    builder.vertex(matrix, x, y, nextZ).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                    builder.vertex(matrix, nextX, y, nextZ).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                    builder.vertex(matrix, nextX, y, z).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                } else {
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                    builder.vertex(matrix, nextX, y, z).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                    builder.vertex(matrix, nextX, y, nextZ).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                    builder.vertex(matrix, x, y, nextZ).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                }
            }
        }
    }

    private void drawTiledSideFaceZ(VertexConsumer builder, Matrix4f matrix,
                                    float minX, float maxX, float minY, float maxY, float z,
                                    TextureAtlasSprite sprite, float r, float g, float b, float a,
                                    int light, int overlay, Direction face) {
        float ny = (face == Direction.NORTH) ? -1.0F : 1.0F;

        for (float x = minX; x < maxX; x = Math.min(x + 1.0F - (x % 1.0F == 0 ? 0 : x % 1.0F), maxX)) {
            float nextX = Math.min(x + (1.0F - (x % 1.0F)), maxX);
            float u1 = sprite.getU((x % 1.0F) * 16.0F);
            float u2 = sprite.getU((x % 1.0F + (nextX - x)) * 16.0F);

            for (float y = minY; y < maxY; y = Math.min(y + 1.0F - (y % 1.0F == 0 ? 0 : y % 1.0F), maxY)) {
                float nextY = Math.min(y + (1.0F - (y % 1.0F)), maxY);
                float v1 = sprite.getV((1.0F - (nextY % 1.0F)) * 16.0F);
                float v2 = sprite.getV((1.0F - (y % 1.0F)) * 16.0F);

                if (face == Direction.NORTH) {
                    builder.vertex(matrix, nextX, nextY, z).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, nextX, y, z).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, x, nextY, z).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                } else {
                    builder.vertex(matrix, x, nextY, z).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, nextX, y, z).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                    builder.vertex(matrix, nextX, nextY, z).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 0, ny).endVertex();
                }
            }
        }
    }

    private void drawTiledSideFaceX(VertexConsumer builder, Matrix4f matrix,
                                    float x, float minY, float maxY, float minZ, float maxZ,
                                    TextureAtlasSprite sprite, float r, float g, float b, float a,
                                    int light, int overlay, Direction face) {
        float nx = (face == Direction.WEST) ? -1.0F : 1.0F;

        for (float z = minZ; z < maxZ; z = Math.min(z + 1.0F - (z % 1.0F == 0 ? 0 : z % 1.0F), maxZ)) {
            float nextZ = Math.min(z + (1.0F - (z % 1.0F)), maxZ);
            float u1 = sprite.getU((z % 1.0F) * 16.0F);
            float u2 = sprite.getU((z % 1.0F + (nextZ - z)) * 16.0F);

            for (float y = minY; y < maxY; y = Math.min(y + 1.0F - (y % 1.0F == 0 ? 0 : y % 1.0F), maxY)) {
                float nextY = Math.min(y + (1.0F - (y % 1.0F)), maxY);
                float v1 = sprite.getV((1.0F - (nextY % 1.0F)) * 16.0F);
                float v2 = sprite.getV((1.0F - (y % 1.0F)) * 16.0F);

                if (face == Direction.WEST) {
                    builder.vertex(matrix, x, nextY, z).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, y, nextZ).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, nextY, nextZ).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                } else {
                    builder.vertex(matrix, x, nextY, nextZ).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, y, nextZ).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, y, z).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                    builder.vertex(matrix, x, nextY, z).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(nx, 0, 0).endVertex();
                }
            }
        }
    }
}