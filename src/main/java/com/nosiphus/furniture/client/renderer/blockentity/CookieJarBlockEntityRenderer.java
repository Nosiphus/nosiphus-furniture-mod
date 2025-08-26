package com.nosiphus.furniture.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.nosiphus.furniture.blockentity.CookieJarBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CookieJarBlockEntityRenderer implements BlockEntityRenderer<CookieJarBlockEntity> {

    public CookieJarBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(CookieJarBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {

        NonNullList<ItemStack> cookieJar = blockEntity.getCookieJar();
        for(int j = 0; j < cookieJar.size(); j++) {
            ItemStack stack = cookieJar.get(j);
            if(!stack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5, (j * 0.05) + 0.0625, 0.5);
                poseStack.mulPose(Axis.XP.rotationDegrees(90F));
                poseStack.scale(0.375F, 0.375F, 0.375F);
                Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, source, blockEntity.getLevel(), 0);
                poseStack.popPose();
            }
        }

    }

}
