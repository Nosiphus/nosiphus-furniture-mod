package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.BlenderBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class BlenderBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<BlenderBlockEntity> {

    public BlenderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(BlenderBlockEntity blender, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (blender.getFluidAmount() <= 0) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = blender.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        float fillRatio = (float) blender.getFluidAmount() / (float) blender.getCapacity();
        float minY = 5.11F / 16.0F;
        float maxY = minY + ((8.69F * fillRatio) / 16.0F);

        this.renderFluidBox(blender, poseStack, buffer,
                5.01F / 16.0F, minY, 5.01F / 16.0F,
                10.99F / 16.0F, maxY, 10.99F / 16.0F,
                light, overlay);

        poseStack.popPose();
    }
}