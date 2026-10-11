package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.tags.ModFluidTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class CupBlockEntity extends FluidHandlerSyncedBlockEntity {

    public CupBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CUP.get(), pos, state, 1000);
    }

    public ItemStack getItemRepresentation() {
        ItemStack stack = new ItemStack(this.getBlockState().getBlock().asItem());
        if (this.fluid != Fluids.EMPTY && this.fluidAmount > 0 && this.level != null) {
            CompoundTag beTag = this.saveCustomOnly(this.level.registryAccess());
            CompoundTag root = new CompoundTag();
            root.put("BlockEntityTag", beTag);
            stack.set(DataComponents.CUSTOM_DATA, CustomData.of(root));
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
            ItemStack stack = new ItemStack(Items.POTION);
            stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
            return stack;
        }
        return ItemStack.EMPTY;
    }

    public Fluid getPotionFluidEquivalent(ItemStack potionStack) {
        if (potionStack.is(Items.POTION)) {
            PotionContents contents = potionStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
            if (contents.is(Potions.WATER)) {
                return Fluids.WATER;
            }
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