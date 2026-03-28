package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.level.block.entity.ToasterBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ToasterBlockEntityRenderer implements BlockEntityRenderer<ToasterBlockEntity> {

    private final ItemRenderer itemRenderer;

    public ToasterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ToasterBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        NonNullList<ItemStack> toaster = blockEntity.getToaster();
        Direction direction = blockEntity.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);

        for (int j = 0; j < toaster.size(); j++) {
            ItemStack stack = toaster.get(j);
            if (!stack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5, 0.3, 0.5);
                poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
                poseStack.scale(0.5F, 0.5F, 0.5F);
                float zOffset = (j == 0) ? -0.125F : 0.125F;
                poseStack.translate(0.0, 0.0, zOffset);
                this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, source, blockEntity.getLevel(), 0);
                poseStack.popPose();
            }
        }
    }
}