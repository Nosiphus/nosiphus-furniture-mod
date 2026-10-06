package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.BlenderBlock;
import com.nosiphus.furniture.world.level.block.entity.BlenderBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluids;
import org.joml.Matrix4f;

public class BlenderBlockEntityRenderer implements BlockEntityRenderer<BlenderBlockEntity> {

    public BlenderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BlenderBlockEntity blender, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if (blender.getFluid() == Fluids.EMPTY || blender.getFluidAmount() <= 0) {
            return;
        }

        float fillRatio = Math.min(1.0F, (float) blender.getFluidAmount() / (float) blender.getCapacity());

        float minX = 5.01F / 16.0F;
        float maxX = 10.99F / 16.0F;
        float minZ = 5.01F / 16.0F;
        float maxZ = 10.99F / 16.0F;

        float minY = 5.1F / 16.0F;
        float maxY = minY + ((8.7F * fillRatio) / 16.0F);

        TextureAtlasSprite sprite = Services.PLATFORM.getStillFluidSprite(blender.getFluid());
        int color = Services.PLATFORM.getFluidColor(blender.getFluid(), blender.getLevel(), blender.getBlockPos());

        float r = ((color >> 16) & 0xFF) / 255.0F;
        float g = ((color >> 8) & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        float a = ((color >> 24) & 0xFF) / 255.0F;
        if (a == 0.0F) a = 1.0F;

        poseStack.pushPose();

        Direction direction = blender.getBlockState().getValue(BlenderBlock.DIRECTION);
        poseStack.translate(0.5D, 0.5D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5D, -0.5D, -0.5D);

        VertexConsumer builder = buffer.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();

        drawQuad(builder, matrix, minX, maxX, maxY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.UP);
        drawQuad(builder, matrix, minX, maxX, minY, minY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.DOWN);

        drawQuad(builder, matrix, minX, maxX, minY, maxY, minZ, minZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.NORTH);
        drawQuad(builder, matrix, minX, maxX, minY, maxY, maxZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.SOUTH);
        drawQuad(builder, matrix, minX, minX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.WEST);
        drawQuad(builder, matrix, maxX, maxX, minY, maxY, minZ, maxZ, sprite, r, g, b, a, packedLight, packedOverlay, Direction.EAST);

        poseStack.popPose();
    }

    private void drawQuad(VertexConsumer builder, Matrix4f matrix, float x1, float x2, float y1, float y2, float z1, float z2,
                          TextureAtlasSprite sprite, float r, float g, float b, float a,
                          int light, int overlay, Direction face) {

        float u1, u2, v1, v2;

        if (face == Direction.UP || face == Direction.DOWN) {
            u1 = sprite.getU(x1 * 16.0F);
            u2 = sprite.getU(x2 * 16.0F);
            v1 = sprite.getV(z1 * 16.0F);
            v2 = sprite.getV(z2 * 16.0F);
        } else if (face == Direction.NORTH || face == Direction.SOUTH) {
            u1 = sprite.getU(x1 * 16.0F);
            u2 = sprite.getU(x2 * 16.0F);
            v1 = sprite.getV((1.0F - y2) * 16.0F);
            v2 = sprite.getV((1.0F - y1) * 16.0F);
        } else {
            u1 = sprite.getU(z1 * 16.0F);
            u2 = sprite.getU(z2 * 16.0F);
            v1 = sprite.getV((1.0F - y2) * 16.0F);
            v2 = sprite.getV((1.0F - y1) * 16.0F);
        }

        switch (face) {
            case UP -> {
                builder.vertex(matrix, x1, y2, z2).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x2, y2, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
                builder.vertex(matrix, x1, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 1, 0).endVertex();
            }
            case DOWN -> {
                builder.vertex(matrix, x1, y1, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                builder.vertex(matrix, x2, y1, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                builder.vertex(matrix, x2, y1, z2).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
                builder.vertex(matrix, x1, y1, z2).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, -1, 0).endVertex();
            }
            case NORTH -> {
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x2, y1, z1).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x1, y1, z1).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
                builder.vertex(matrix, x1, y2, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(0, 0, -1).endVertex();
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
                builder.vertex(matrix, x2, y2, z2).color(r, g, b, a).uv(u1, v1).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y1, z2).color(r, g, b, a).uv(u1, v2).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y1, z1).color(r, g, b, a).uv(u2, v2).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
                builder.vertex(matrix, x2, y2, z1).color(r, g, b, a).uv(u2, v1).overlayCoords(overlay).uv2(light).normal(1, 0, 0).endVertex();
            }
        }
    }
}