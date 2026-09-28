package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.tags.ModFluidTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class CupBlockEntity extends FluidHandlerSyncedBlockEntity {

    public CupBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CUP.get(), pos, state, 1000);
    }

    public ItemStack getItemRepresentation() {
        ItemStack stack = new ItemStack(this.getBlockState().getBlock().asItem());
        if (this.fluid != Fluids.EMPTY && this.fluidAmount > 0) {
            CompoundTag beTag = new CompoundTag();
            this.saveAdditional(beTag);
            stack.getOrCreateTag().put("BlockEntityTag", beTag);
        }
        return stack;
    }

    public void drinkDirectly(Player player) {
        if (this.fluid != Fluids.EMPTY && this.fluidAmount > 0) {
            ModFluidTags.applyEffects(player, this.fluid);
            if (!player.getAbilities().instabuild) {
                this.drain(Math.min(this.fluidAmount, 250));
            }
            if (this.level != null) {
                this.level.playSound(null, this.worldPosition, SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 0.8F, 1.0F);
            }
        }
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

    private void applyFluidEffects(Player player, Fluid fluid) {
        if (fluid == Fluids.WATER) {
            if (player.isOnFire()) {
                player.clearFire();
            }
        }
    }

}
