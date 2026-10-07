package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.ToiletBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class ToiletBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<ToiletBlockEntity> {

    public ToiletBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(ToiletBlockEntity toilet, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (toilet.getFluidAmount() <= 0) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = toilet.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        float fillRatio = (float) toilet.getFluidAmount() / (float) toilet.getCapacity();
        float minY = 6.41F / 16.0F;
        float maxY = minY + ((2.69F * fillRatio) / 16.0F);

        this.renderFluidBox(toilet, poseStack, buffer,
                4.01F / 16.0F, minY, 3.21F / 16.0F,
                11.99F / 16.0F, maxY, 10.39F / 16.0F,
                light, overlay);

        poseStack.popPose();
    }
}