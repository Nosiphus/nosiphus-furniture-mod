package com.mrcrayfish.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.level.block.entity.KitchenSinkBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class KitchenSinkBlockEntityRenderer implements BlockEntityRenderer<KitchenSinkBlockEntity> {

    public KitchenSinkBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(KitchenSinkBlockEntity kitchenSink, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        Fluid fluid = kitchenSink.getFluid();
        if (fluid == Fluids.EMPTY || kitchenSink.getFluidAmount() <= 0) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = kitchenSink.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        float baseHeight = kitchenSink.isBigSink() ? 0.5625F : 0.8125F;
        float totalBasinDepth = kitchenSink.isBigSink() ? 0.375F : 0.125F;

        this.drawFluid(kitchenSink, poseStack, source,
                0.125F, baseHeight, 0.125F,
                0.75F, 0.75F,
                totalBasinDepth,
                light, overlay);

        poseStack.popPose();
    }

    private void drawFluid(KitchenSinkBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float depth, float maxHeight, int light, int overlay) {
        Fluid fluid = te.getFluid();
        if (fluid == Fluids.EMPTY || te.getFluidAmount() <= 0) {
            return;
        }

        TextureAtlasSprite sprite = Services.PLATFORM.getStillFluidSprite(fluid);
        if (sprite == null) {
            return;
        }

        int color = Services.PLATFORM.getFluidColor(fluid, te.getLevel(), te.getBlockPos());
        if ((color & 0xFF000000) == 0) {
            color |= 0xFF000000;
        }

        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        float a = (float) (color >> 24 & 255) / 255.0F;

        float fillRatio = (float) te.getFluidAmount() / (float) te.getCapacity();
        float fillHeight = maxHeight * fillRatio;
        float renderY = y + fillHeight;

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
        consumer.vertex(pose.pose(), x, y, z)
                .color(r, g, b, a)
                .uv(u, v)
                .overlayCoords(overlay)
                .uv2(light)
                .normal(pose.normal(), nx, ny, nz)
                .endVertex();
    }
}