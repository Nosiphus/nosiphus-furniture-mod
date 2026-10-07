package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.nosiphus.furniture.world.level.block.entity.CupBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class CupBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<CupBlockEntity> {

    public CupBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(CupBlockEntity cup, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (cup.getFluidAmount() <= 0) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.translate(-0.5, -0.5, -0.5);

        float fillRatio = (float) cup.getFluidAmount() / (float) cup.getCapacity();
        float minY = 0.51F / 16.0F;
        float maxY = minY + ((5.99F * fillRatio) / 16.0F);

        this.renderFluidBox(cup, poseStack, buffer,
                6.01F / 16.0F, minY, 6.01F / 16.0F,
                9.99F / 16.0F, maxY, 9.99F / 16.0F,
                light, overlay);

        poseStack.popPose();
    }
}