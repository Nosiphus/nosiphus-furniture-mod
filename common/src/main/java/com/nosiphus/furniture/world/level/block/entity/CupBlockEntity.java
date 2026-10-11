package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.tags.ModFluidTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
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
            beTag.putString("id", BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(this.getType()).toString());
            stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(beTag));
        }
        return stack;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("FluidName", CompoundTag.TAG_STRING)) {
            this.fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(tag.getString("FluidName")));
            this.fluidAmount = tag.getInt("Amount");
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (this.fluid != Fluids.EMPTY && this.fluidAmount > 0) {
            tag.putString("FluidName", BuiltInRegistries.FLUID.getKey(this.fluid).toString());
            tag.putInt("Amount", this.fluidAmount);
        }
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