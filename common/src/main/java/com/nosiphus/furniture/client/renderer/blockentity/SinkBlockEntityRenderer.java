package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.SinkBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class SinkBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<SinkBlockEntity> {

    public SinkBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(SinkBlockEntity sink, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (sink.getFluidAmount() <= 0) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = sink.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        float fillRatio = (float) sink.getFluidAmount() / (float) sink.getCapacity();
        float minY = 12.01F / 16.0F;
        float maxY = minY + ((3.49F * fillRatio) / 16.0F);

        this.renderFluidBox(sink, poseStack, buffer,
                2.01F / 16.0F, minY, 2.01F / 16.0F,
                13.99F / 16.0F, maxY, 11.99F / 16.0F,
                light, overlay);

        poseStack.popPose();
    }
}