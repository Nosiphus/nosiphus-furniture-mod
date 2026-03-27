package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.WaterTankBlockEntity;
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

public class WaterTankBlockEntityRenderer implements BlockEntityRenderer<WaterTankBlockEntity> {

    public WaterTankBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(WaterTankBlockEntity tileEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = tileEntity.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(direction.get2DDataValue() * -90F - 90F));
        poseStack.translate(-0.5, -0.5, -0.5);

        float x = 1.8F / 16.0F;
        float y = 7.0F / 16.0F;
        float z = 1.8F / 16.0F;
        float width = 12.4F / 16.0F;
        float maxHeight = 10.0F / 16.0F;
        float depth = 12.4F / 16.0F;

        this.drawFluid(tileEntity, poseStack, source, x, y, z, width, maxHeight, depth, light, overlay);
        poseStack.popPose();
    }

    private void drawFluid(WaterTankBlockEntity te, PoseStack poseStack, MultiBufferSource source, float x, float y, float z, float width, float maxHeight, float depth, int light, int overlay) {
        FluidStack fluidStack = te.getTank().getFluidInTank(0);
        Fluid fluid = fluidStack.getFluid();

        if (fluid != Fluids.EMPTY) {
            IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(fluid);
            TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(fluidType.getStillTexture(fluidStack));

            float height = maxHeight * ((float) fluidStack.getAmount() / (float) te.getTank().getTankCapacity(0));

            int color = fluidType.getTintColor(fluidStack);
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            float a = (float) (color >> 24 & 255) / 255.0F;
            if (a <= 0.0F) a = 1.0F;

            float minU = sprite.getU0();
            float maxU = sprite.getU1();
            float minV = sprite.getV0();
            float maxV = sprite.getV1();

            VertexConsumer consumer = source.getBuffer(RenderType.translucent());
            Matrix4f matrix = poseStack.last().pose();

            consumer.addVertex(matrix, x, y + height, z).setColor(r, g, b, a).setUv(maxU, minV).setOverlay(overlay).setLight(light).setNormal(0.0F, 1.0F, 0.0F);
            consumer.addVertex(matrix, x, y + height, z + depth).setColor(r, g, b, a).setUv(minU, minV).setOverlay(overlay).setLight(light).setNormal(0.0F, 1.0F, 0.0F);
            consumer.addVertex(matrix, x + width, y + height, z + depth).setColor(r, g, b, a).setUv(minU, maxV).setOverlay(overlay).setLight(light).setNormal(0.0F, 1.0F, 0.0F);
            consumer.addVertex(matrix, x + width, y + height, z).setColor(r, g, b, a).setUv(maxU, maxV).setOverlay(overlay).setLight(light).setNormal(0.0F, 1.0F, 0.0F);
        }
    }
}