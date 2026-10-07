package com.mrcrayfish.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.level.block.entity.KitchenSinkBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class KitchenSinkBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<KitchenSinkBlockEntity> {

    public KitchenSinkBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(KitchenSinkBlockEntity sink, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        if (sink.getFluidAmount() <= 0) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = sink.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5, -0.5, -0.5);

        float fillRatio = (float) sink.getFluidAmount() / (float) sink.getCapacity();
        float minY = 10.01F / 16.0F;
        float maxY = minY + ((5.49F * fillRatio) / 16.0F);

        this.renderFluidBox(sink, poseStack, source,
                2.01F / 16.0F, minY, 2.01F / 16.0F,
                14.0F / 16.0F, maxY, 12.0F / 16.0F,
                light, overlay);

        poseStack.popPose();
    }
}