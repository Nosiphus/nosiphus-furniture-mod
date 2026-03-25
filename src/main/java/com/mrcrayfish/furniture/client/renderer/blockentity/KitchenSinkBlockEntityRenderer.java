package com.mrcrayfish.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.level.block.entity.KitchenSinkBlockEntity;
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

/**
 * Author: MrCrayfish
 */
public class KitchenSinkBlockEntityRenderer implements BlockEntityRenderer<KitchenSinkBlockEntity>
{
    public KitchenSinkBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(KitchenSinkBlockEntity kitchenSink, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay)
    {
        FluidStack fluidStack = kitchenSink.getTank().getFluid();
        if(fluidStack.isEmpty()) return;

        poseStack.pushPose();

        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = kitchenSink.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(direction.get2DDataValue() * -90F - 90F));
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

    private void drawFluid(KitchenSinkBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float depth, float maxHeight, int light, int overlay)
    {
        FluidStack fluidStack = te.getTank().getFluid();
        Fluid fluid = fluidStack.getFluid();
        if(fluid == Fluids.EMPTY || te.getTank().getFluidAmount() <= 0) return;

        IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(fluid);
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(fluidType.getStillTexture(fluidStack));

        int color = fluidType.getTintColor(fluidStack);
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        float a = (float) (color >> 24 & 255) / 255.0F;

        float fillHeight = maxHeight * ((float) te.getTank().getFluidAmount() / (float) te.getTank().getCapacity());
        float renderY = y + fillHeight;

        float minU = sprite.getU0();
        float maxU = Math.min(minU + (sprite.getU1() - minU) * depth, sprite.getU1());
        float minV = sprite.getV0();
        float maxV = Math.min(minV + (sprite.getV1() - minV) * width, sprite.getV1());

        VertexConsumer consumer = source.getBuffer(RenderType.translucent());
        Matrix4f matrix = poseStack.last().pose();
        this.addVertex(consumer, matrix, x, renderY, z, r, g, b, a, minU, minV, light, overlay);
        this.addVertex(consumer, matrix, x, renderY, z + depth, r, g, b, a, minU, maxV, light, overlay);
        this.addVertex(consumer, matrix, x + width, renderY, z + depth, r, g, b, a, maxU, maxV, light, overlay);
        this.addVertex(consumer, matrix, x + width, renderY, z, r, g, b, a, maxU, minV, light, overlay);
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, float x, float y, float z, float r, float g, float b, float a, float u, float v, int light, int overlay)
    {
        consumer.addVertex(matrix, x, y, z)
                .setColor(r, g, b, a)
                .setUv(u, v)
                .setLight(light)
                .setOverlay(overlay)
                .setNormal(0.0F, 1.0F, 0.0F);
    }
}