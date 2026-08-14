package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.PlateBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class PlateBlockEntityRenderer implements BlockEntityRenderer<PlateBlockEntity> {

    private final ItemRenderer itemRenderer;

    public PlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(PlateBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        ItemStack stack = blockEntity.getItem(0);
        if (stack.isEmpty()) return;
        BlockState state = blockEntity.getBlockState();
        if (!state.hasProperty(FurnitureHorizontalBlock.DIRECTION)) return;
        Direction direction = state.getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.pushPose();
        poseStack.translate(0.5, 0.0625, 0.5);
        poseStack.mulPose(Axis.XP.rotationDegrees(90F));
        poseStack.scale(0.375F, 0.375F, 0.375F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-direction.toYRot()));
        this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, source, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }

}