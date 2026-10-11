package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.nosiphus.furniture.world.level.block.entity.WaterTankBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class WaterTankBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<WaterTankBlockEntity> {

    public WaterTankBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(WaterTankBlockEntity tank, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        if (tank.getFluidAmount() <= 0) return;

        float fillRatio = (float) tank.getFluidAmount() / (float) tank.getCapacity();
        float minY = 7.01F / 16.0F;
        float maxY = minY + ((9.99F * fillRatio) / 12.0F);

        this.renderFluidBox(tank, poseStack, buffer,
                1.81F / 16.0F, minY, 1.81F / 16.0F,
                14.19F / 16.0F, maxY, 14.19F / 16.0F,
                light, overlay);
    }
}