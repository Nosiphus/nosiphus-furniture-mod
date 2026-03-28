package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.ToiletBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.joml.Matrix4f;

public class ToiletBlockEntityRenderer implements BlockEntityRenderer<ToiletBlockEntity> {

    public ToiletBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(ToiletBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        poseStack.pushPose();

        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = tileEntity.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        this.drawFluid(tileEntity, poseStack, source, 3.2f/16f, 6.4f/16f, 4f/16f, 10.4f/16f, 2.8f/16f, 8f/16f, light);

        poseStack.popPose();
    }

    private void drawFluid(ToiletBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float height, float depth, int light) {
        FluidStack fluidStack = te.getTank().getFluid();
        Fluid fluid = fluidStack.getFluid();

        if (fluid != Fluids.EMPTY && te.getLevel() != null) {
            IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(fluid);
            TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
                    .apply(fluidType.getStillTexture(fluidStack));

            float fillLevel = (float) fluidStack.getAmount() / te.getTank().getCapacity();
            float currentHeight = height * fillLevel;

            float minU = sprite.getU0();
            float maxU = sprite.getU1();
            float minV = sprite.getV0();
            float maxV = sprite.getV1();

            int color = fluidType.getTintColor(fluidStack);
            float r = (color >> 16 & 255) / 255.0F;
            float g = (color >> 8 & 255) / 255.0F;
            float b = (color & 255) / 255.0F;
            float a = (color >> 24 & 255) / 255.0F;
            if (a <= 0) a = 1.0f;

            VertexConsumer consumer = source.getBuffer(RenderType.translucent());
            Matrix4f matrix = poseStack.last().pose();

            addVertex(consumer, matrix, x, y + currentHeight, z, r, g, b, a, maxU, minV, light);
            addVertex(consumer, matrix, x, y + currentHeight, z + depth, r, g, b, a, minU, minV, light);
            addVertex(consumer, matrix, x + width, y + currentHeight, z + depth, r, g, b, a, minU, maxV, light);
            addVertex(consumer, matrix, x + width, y + currentHeight, z, r, g, b, a, maxU, maxV, light);
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light) {
        consumer.addVertex(matrix, x, y, z)
                .setColor(r, g, b, a)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0.0F, 1.0F, 0.0F);
    }
}