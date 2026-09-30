package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class BlenderBlockEntity extends FluidHandlerSyncedBlockEntity {

    public BlenderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BLENDER.get(), pos, state, 4000);
    }

    public ItemStack createBottleFromFluid(Fluid fluid) {
        if (fluid == Fluids.WATER) {
            return PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        }
        return ItemStack.EMPTY;
    }

    public Fluid getPotionFluidEquivalent(ItemStack potionStack) {
        if (potionStack.is(Items.POTION) && PotionUtils.getPotion(potionStack) == Potions.WATER) {
            return Fluids.WATER;
        }
        return Fluids.EMPTY;
    }

}
