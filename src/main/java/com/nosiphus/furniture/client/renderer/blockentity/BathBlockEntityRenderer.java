package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.blockentity.BathBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class BathBlockEntityRenderer implements BlockEntityRenderer<BathBlockEntity> {

    public BathBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(BathBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        Direction direction = blockEntity.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.popPose();
    }

}
