package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrcrayfish.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.entity.BirdBathBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class BirdBathBlockEntityRenderer implements BlockEntityRenderer<BirdBathBlockEntity> {

    public BirdBathBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BirdBathBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        float minX = 1.6F / 16.0F;
        float minZ = 1.6F / 16.0F;
        float width = 12.8F / 16.0F;
        float depth = 12.8F / 16.0F;
        float yBase = 12.8F / 16.0F;
        float maxHeight = 1.5F / 16.0F;

        this.drawFluid(tileEntity, poseStack, source, minX, yBase, minZ, width, maxHeight, depth, light, overlay);
    }

    private void drawFluid(BirdBathBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float maxHeight, float depth, int light, int overlay) {
        Fluid fluid = te.getFluid();
        if (fluid == Fluids.EMPTY || te.getFluidAmount() <= 0) return;

        TextureAtlasSprite sprite = Services.PLATFORM.getStillFluidSprite(fluid);
        if (sprite == null) return;

        int color = Services.PLATFORM.getFluidColor(fluid, te.getLevel(), te.getBlockPos());
        if ((color & 0xFF000000) == 0) color |= 0xFF000000;

        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        float a = (float) (color >> 24 & 255) / 255.0F;

        float height = maxHeight * ((float) te.getFluidAmount() / (float) te.getCapacity());
        float renderY = y + height;

        float minU = sprite.getU0();
        float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
        float minV = sprite.getV0();
        float maxV = Math.min(minV + (sprite.getV1() - minV) * width, sprite.getV1());

        VertexConsumer consumer = source.getBuffer(RenderType.translucent());
        PoseStack.Pose pose = poseStack.last();

        // Top Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, minU, minV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, maxU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, 1.0F, 0.0F);

        // Bottom Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, minU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, maxU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
    }

    private void addVertex(VertexConsumer consumer, PoseStack.Pose pose, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light, int overlay, float nx, float ny, float nz) {
        consumer.addVertex(pose.pose(), x, y, z)
                .setColor(r, g, b, a)
                .setUv(u, v)
                .setOverlay(overlay)
                .setLight(light)
                .setNormal(pose, nx, ny, nz);
    }
}