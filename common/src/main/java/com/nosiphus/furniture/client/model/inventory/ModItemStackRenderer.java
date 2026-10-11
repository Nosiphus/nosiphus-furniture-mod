package com.nosiphus.furniture.client.model.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nosiphus.furniture.world.item.CupItem;
import com.nosiphus.furniture.world.level.block.CupBlock;
import com.nosiphus.furniture.world.level.block.entity.CupBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class ModItemStackRenderer extends BlockEntityWithoutLevelRenderer {

    public static final ModItemStackRenderer INSTANCE = new ModItemStackRenderer();

    private CupBlockEntity cupBlockEntity;

    public ModItemStackRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
        super(blockEntityRenderDispatcher, entityModelSet);
    }

    public ModItemStackRenderer() {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Item item = stack.getItem();

        if (item instanceof CupItem && item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof CupBlock) {
                BlockState state = block.defaultBlockState();

                if (this.cupBlockEntity == null) {
                    this.cupBlockEntity = new CupBlockEntity(BlockPos.ZERO, state);
                } else {
                    this.cupBlockEntity.setBlockState(state);
                }

                if (this.cupBlockEntity.getLevel() == null) {
                    this.cupBlockEntity.setLevel(Minecraft.getInstance().level);
                }

                if (CupItem.hasFluid(stack)) {
                    Fluid fluid = CupItem.getFluid(stack);
                    int amount = CupItem.getFluidAmount(stack);
                    this.cupBlockEntity.setFluid(fluid, amount);
                } else {
                    this.cupBlockEntity.setFluid(Fluids.EMPTY, 0);
                }

                poseStack.pushPose();

                BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
                blockDispatcher.renderSingleBlock(state, poseStack, buffer, packedLight, packedOverlay);

                BlockEntityRenderDispatcher dispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
                if (dispatcher != null && this.cupBlockEntity.getFluidAmount() > 0) {
                    dispatcher.renderItem(this.cupBlockEntity, poseStack, buffer, packedLight, packedOverlay);
                }

                poseStack.popPose();
                return;
            }
        }

        super.renderByItem(stack, displayContext, poseStack, buffer, packedLight, packedOverlay);
    }
}