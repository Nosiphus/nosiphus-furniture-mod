package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.furniture.client.renderer.blockentity.FluidHandlerSyncedBlockEntityRenderer;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.nosiphus.furniture.world.item.crafting.BlendingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.level.block.entity.BlenderBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class BlenderBlockEntityRenderer extends FluidHandlerSyncedBlockEntityRenderer<BlenderBlockEntity> {

    public BlenderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(BlenderBlockEntity blender, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        float progress = blender.getBlendProgress(partialTick);

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.5D, 0.5D);
        Direction direction = blender.getBlockState().getValue(FurnitureHorizontalBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        poseStack.translate(-0.5D, -0.5D, -0.5D);

        BlenderBlockEntity fluidTarget = blender;
        float fillRatio = (float) blender.getFluidAmount() / (float) blender.getCapacity();

        if (blender.isBlending() && blender.getLevel() != null) {
            var recipeOpt = blender.getLevel().getRecipeManager().getRecipeFor(ModRecipeTypes.BLENDING.get(), blender, blender.getLevel());
            if (recipeOpt.isPresent()) {
                BlendingRecipe recipe = recipeOpt.get();
                Fluid targetFluid = recipe.getResultFluid();
                int animatedAmount = Math.max(1, (int) (recipe.getFluidAmount() * progress));

                fluidTarget = new BlenderBlockEntity(blender.getBlockPos(), blender.getBlockState()) {
                    @Override
                    public Fluid getFluid() {
                        return targetFluid;
                    }

                    @Override
                    public int getFluidAmount() {
                        return animatedAmount;
                    }
                };
                fluidTarget.setLevel(blender.getLevel());

                fillRatio = ((float) recipe.getFluidAmount() / (float) blender.getCapacity()) * progress;
            }
        }

        if (fluidTarget.getFluid() != Fluids.EMPTY && fillRatio > 0.0F) {
            float minY = 5.1F / 16.0F;
            float maxY = minY + ((8.7F * fillRatio) / 16.0F);

            this.renderFluidBox(fluidTarget, poseStack, buffer,
                    5.01F / 16.0F, minY, 5.01F / 16.0F,
                    10.99F / 16.0F, maxY, 10.99F / 16.0F,
                    light, overlay);
        }

        if (!blender.isEmpty()) {
            float itemScale = blender.isBlending() ? Math.max(0.0F, 1.0F - progress) * 0.35F : 0.35F;

            if (itemScale > 0.01F) {
                float rotationAngle = blender.isBlending() ? (progress * 360.0F * 12.0F) : 0.0F;

                for (int i = 0; i < blender.getContainerSize(); i++) {
                    ItemStack stack = blender.getItem(i);
                    if (stack.isEmpty()) continue;

                    poseStack.pushPose();
                    poseStack.translate(0.5D, 0.56D + (i * 0.08D), 0.5D);
                    poseStack.mulPose(Axis.YP.rotationDegrees(rotationAngle + (i * 90.0F)));
                    poseStack.scale(itemScale, itemScale, itemScale);

                    Minecraft.getInstance().getItemRenderer().renderStatic(
                            stack,
                            ItemDisplayContext.FIXED,
                            light,
                            overlay,
                            poseStack,
                            buffer,
                            blender.getLevel(),
                            0
                    );
                    poseStack.popPose();
                }
            }
        }

        poseStack.popPose();
    }
}