package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.BathBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class BathBlockEntityRenderer implements BlockEntityRenderer<BathBlockEntity> {

    public BathBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BathBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        Fluid fluid = tileEntity.getFluid();
        if (fluid == Fluids.EMPTY || tileEntity.getFluidAmount() <= 0) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = tileEntity.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(direction.get2DDataValue() * -90F - 90F));
        poseStack.translate(-0.5, -0.5, -0.5);

        this.drawFluidBack(tileEntity, poseStack, source, 2.0F / 16.0F, 2.0F / 16.0F, 2.0F / 16.0F, 14.0F / 16.0F, 11.2F / 16.0F, 12.0F / 16.0F, light, overlay);
        this.drawFluidHead(tileEntity, poseStack, source, 16.0F / 16.0F, 2.0F / 16.0F, 2.0F / 16.0F, 14.0F / 16.0F, 11.2F / 16.0F, 12.0F / 16.0F, light, overlay);

        poseStack.popPose();
    }

    private void drawFluidHead(BathBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float height, float depth, int light, int overlay) {
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

        float minU = sprite.getU0();
        float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
        float minV = sprite.getV0();
        float maxV = Math.min(minV + (sprite.getV1() - minV) * width, sprite.getV1());

        float currentHeight = height * ((float) te.getFluidAmount() / (float) te.getCapacity());
        float renderY = y + currentHeight;

        VertexConsumer consumer = source.getBuffer(RenderType.translucent());
        PoseStack.Pose pose = poseStack.last();

        // Top Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, minV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);

        // Bottom Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
    }

    private void drawFluidBack(BathBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float height, float depth, int light, int overlay) {
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

        float minU = sprite.getU0();
        float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
        float vSpan = sprite.getV1() - sprite.getV0();
        float minV = sprite.getV0() + (2.0F / 16.0F * vSpan);
        float maxV = Math.min(minV + vSpan * width, sprite.getV1());

        float currentHeight = height * ((float) te.getFluidAmount() / (float) te.getCapacity());
        float renderY = y + currentHeight;

        VertexConsumer consumer = source.getBuffer(RenderType.translucent());
        PoseStack.Pose pose = poseStack.last();

        // Top Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, minV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, maxV, light, overlay, 0.0F, 1.0F, 0.0F);

        // Bottom Face
        this.addVertex(consumer, pose, x, renderY, z, r, g, b, a, maxU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z, r, g, b, a, maxU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x + width, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay, 0.0F, -1.0F, 0.0F);
        this.addVertex(consumer, pose, x, renderY, z + depth, r, g, b, a, minU, minV, light, overlay, 0.0F, -1.0F, 0.0F);
    }

    private void addVertex(VertexConsumer consumer, PoseStack.Pose pose, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light, int overlay, float nx, float ny, float nz) {
        consumer.vertex(pose.pose(), x, y, z)
                .color(r, g, b, a)
                .uv(u, v)
                .overlayCoords(overlay)
                .uv2(light)
                .normal(pose.normal(), nx, ny, nz)
                .endVertex();
    }
}