package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.BathBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.joml.Matrix4f;

public class BathBlockEntityRenderer implements BlockEntityRenderer<BathBlockEntity> {

    public BathBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BathBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
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
        FluidStack fluidStack = te.getTank().getFluidInTank(0);
        Fluid fluid = fluidStack.getFluid();
        if (fluid != Fluids.EMPTY) {
            IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(fluid);
            TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(fluidType.getStillTexture(fluidStack));

            int color = fluidType.getTintColor(fluidStack);
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            float a = (float) (color >> 24 & 255) / 255.0F;
            if (a <= 0.0F) a = 1.0F;

            float minU = sprite.getU0();
            float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
            float minV = sprite.getV0();
            float maxV = Math.min(minV + (sprite.getV1() - minV) * width, sprite.getV1());

            float currentHeight = height * ((float) fluidStack.getAmount() / (float) te.getTank().getTankCapacity(0));

            VertexConsumer consumer = source.getBuffer(RenderType.translucent());
            Matrix4f matrix = poseStack.last().pose();

            buildVertex(consumer, matrix, x, y + currentHeight, z, r, g, b, a, maxU, minV, light, overlay);
            buildVertex(consumer, matrix, x, y + currentHeight, z + depth, r, g, b, a, minU, minV, light, overlay);
            buildVertex(consumer, matrix, x + width, y + currentHeight, z + depth, r, g, b, a, minU, maxV, light, overlay);
            buildVertex(consumer, matrix, x + width, y + currentHeight, z, r, g, b, a, maxU, maxV, light, overlay);
        }
    }

    private void drawFluidBack(BathBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float height, float depth, int light, int overlay) {
        FluidStack fluidStack = te.getTank().getFluidInTank(0);
        Fluid fluid = fluidStack.getFluid();
        if (fluid != Fluids.EMPTY) {
            IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(fluid);
            TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(fluidType.getStillTexture(fluidStack));

            int color = fluidType.getTintColor(fluidStack);
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            float a = (float) (color >> 24 & 255) / 255.0F;
            if (a <= 0.0F) a = 1.0F;

            float minU = sprite.getU0();
            float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
            float vSpan = sprite.getV1() - sprite.getV0();
            float minV = sprite.getV0() + (2.0F / 16.0F * vSpan);
            float maxV = Math.min(minV + vSpan * width, sprite.getV1());

            float currentHeight = height * ((float) fluidStack.getAmount() / (float) te.getTank().getTankCapacity(0));

            VertexConsumer consumer = source.getBuffer(RenderType.translucent());
            Matrix4f matrix = poseStack.last().pose();

            buildVertex(consumer, matrix, x, y + currentHeight, z, r, g, b, a, maxU, minV, light, overlay);
            buildVertex(consumer, matrix, x, y + currentHeight, z + depth, r, g, b, a, minU, minV, light, overlay);
            buildVertex(consumer, matrix, x + width, y + currentHeight, z + depth, r, g, b, a, minU, maxV, light, overlay);
            buildVertex(consumer, matrix, x + width, y + currentHeight, z, r, g, b, a, maxU, maxV, light, overlay);
        }
    }

    private void buildVertex(VertexConsumer consumer, Matrix4f matrix, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light, int overlay) {
        consumer.addVertex(matrix, x, y, z)
                .setColor(r, g, b, a)
                .setUv(u, v)
                .setOverlay(overlay)
                .setLight(light)
                .setNormal(0.0F, 1.0F, 0.0F);
    }

}