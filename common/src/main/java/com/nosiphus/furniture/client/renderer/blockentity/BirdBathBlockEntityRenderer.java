package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.nosiphus.furniture.world.level.block.entity.BirdBathBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class BirdBathBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<BirdBathBlockEntity> {

    public BirdBathBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(BirdBathBlockEntity birdBath, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (birdBath.getFluidAmount() <= 0) return;

        float fillRatio = (float) birdBath.getFluidAmount() / (float) birdBath.getCapacity();
        float minY = 12.81F / 16.0F;
        float maxY = minY + ((1.09F * fillRatio) / 16.0F);

        this.renderFluidBox(birdBath, poseStack, buffer,
                1.61F / 16.0F, minY, 1.61F / 16.0F,
                14.39F / 16.0F, maxY, 14.39F / 16.0F,
                light, overlay);
    }
}