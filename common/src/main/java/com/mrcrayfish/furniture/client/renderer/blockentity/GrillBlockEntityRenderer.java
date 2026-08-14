package com.mrcrayfish.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.world.level.block.entity.GrillBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/**
 * Author: MrCrayfish
 */
public class GrillBlockEntityRenderer implements BlockEntityRenderer<GrillBlockEntity>
{
    private final ItemRenderer itemRenderer;

    public GrillBlockEntityRenderer(BlockEntityRendererProvider.Context context)
    {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(GrillBlockEntity grill, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay)
    {
        NonNullList<ItemStack> grillItems = grill.getGrill();
        for(int i = 0; i < grillItems.size(); i++)
        {
            ItemStack stack = grillItems.get(i);
            if(stack.isEmpty()) continue;

            poseStack.pushPose();

            if(grill.isFlipping(i))
            {
                float progress = (grill.getFlippingCount(i) + partialTicks) / (float) GrillBlockEntity.MAX_FLIPPING_COUNTER;
                float jumpHeight = Mth.sin(progress * (float) Math.PI) * 0.5F;
                poseStack.translate(0.0, jumpHeight, 0.0);
            }

            poseStack.translate(0.5, 1.0, 0.5);
            poseStack.mulPose(Axis.XP.rotationDegrees(90F));
            poseStack.translate(-0.2 + 0.4 * (i % 2), -0.2 + 0.4 * (i / 2), 0.0);
            poseStack.scale(0.375F, 0.375F, 0.375F);

            poseStack.mulPose(Axis.ZP.rotationDegrees(90F * grill.getRotations()[i]));

            if(grill.isFlipping(i))
            {
                float progress = (grill.getFlippingCount(i) + partialTicks) / (float) GrillBlockEntity.MAX_FLIPPING_COUNTER;
                poseStack.mulPose(Axis.XP.rotationDegrees(-180F * progress));
            }
            else if(grill.isFlipped(i))
            {
                poseStack.mulPose(Axis.XP.rotationDegrees(180F));
            }

            this.itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, light, overlay, poseStack, source, grill.getLevel(), 0);

            poseStack.popPose();
        }

        NonNullList<ItemStack> fuelItems = grill.getFuel();
        for(int i = 0; i < fuelItems.size(); i++)
        {
            ItemStack stack = fuelItems.get(i);
            if(stack.isEmpty()) continue;

            poseStack.pushPose();
            poseStack.translate(0.5, 0.85, 0.5);
            poseStack.mulPose(Axis.XP.rotationDegrees(90F));
            poseStack.translate(-0.2 + 0.2 * (i % 3), -0.2 + 0.2 * (i / 3), 0.0);
            poseStack.scale(0.375F, 0.375F, 0.375F);

            poseStack.mulPose(Axis.YP.rotationDegrees(10F));

            this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, source, grill.getLevel(), 0);
            poseStack.popPose();
        }
    }
}