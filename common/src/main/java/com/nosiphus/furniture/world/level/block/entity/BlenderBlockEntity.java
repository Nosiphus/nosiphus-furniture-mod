package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.item.crafting.BlendingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlenderBlockEntity extends FluidHandlerSyncedBlockEntity implements WorldlyContainer {

    public static final int TOTAL_PROCESS_TIME = 200;

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    private static final int[] SLOTS = new int[]{0, 1, 2, 3};

    private boolean isBlending = false;
    private int blendProgress = 0;

    public BlenderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BLENDER.get(), pos, state, 4000);
    }

    public boolean isBlending() {
        return this.isBlending;
    }

    public float getBlendProgress(float partialTick) {
        if (!this.isBlending) return 0.0F;
        return Math.min(1.0F, (this.blendProgress + partialTick) / (float) TOTAL_PROCESS_TIME);
    }

    public boolean startBlending() {
        if (this.isBlending || this.level == null) return false;

        var recipeOpt = this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.BLENDING.get(), this, this.level);
        if (recipeOpt.isPresent()) {
            BlendingRecipe recipe = recipeOpt.get();
            if (this.canFill(recipe.getResultFluid(), recipe.getFluidAmount())) {
                this.isBlending = true;
                this.blendProgress = 0;
                this.level.playSound(null, this.worldPosition, ModSoundEvents.BLOCK_BLENDER_RUNNING.get(), SoundSource.BLOCKS, 0.75F, 1.0F);
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BlenderBlockEntity blender) {
        if (!blender.isBlending) return;

        blender.blendProgress++;

        if (blender.blendProgress % 20 == 0 && blender.blendProgress < TOTAL_PROCESS_TIME - 10) {
            level.playSound(null, pos, ModSoundEvents.BLOCK_BLENDER_RUNNING.get(),
                    SoundSource.BLOCKS, 0.75F, 1.0F);
        }

        if (blender.blendProgress >= TOTAL_PROCESS_TIME) {
            blender.finishBlending();
        }
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, BlenderBlockEntity blender) {
        if (blender.isBlending && blender.blendProgress < TOTAL_PROCESS_TIME) {
            blender.blendProgress++;
        }
    }

    private void finishBlending() {
        if (this.level == null) return;

        var recipeOpt = this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.BLENDING.get(), this, this.level);
        if (recipeOpt.isPresent()) {
            BlendingRecipe recipe = recipeOpt.get();

            for (BlendingRecipe.CountedIngredient req : recipe.getCountedIngredients()) {
                int needed = req.count();
                for (int i = 0; i < this.getContainerSize(); i++) {
                    ItemStack stack = this.getItem(i);
                    if (!stack.isEmpty() && req.ingredient().test(stack)) {
                        int take = Math.min(needed, stack.getCount());
                        stack.shrink(take);
                        needed -= take;
                        if (needed <= 0) break;
                    }
                }
            }

            this.fill(recipe.getResultFluid(), recipe.getFluidAmount());

            ItemStack remainder = recipe.getRemainder();
            if (!remainder.isEmpty()) {
                Block.popResource(this.level, this.worldPosition.above(), remainder);
            }

            this.level.playSound(null, this.worldPosition, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        this.isBlending = false;
        this.blendProgress = 0;
        this.markUpdated();
    }

    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.inventory.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        if (this.isBlending) return ItemStack.EMPTY;
        ItemStack stack = ContainerHelper.removeItem(this.inventory, index, count);
        if (!stack.isEmpty()) this.markUpdated();
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (stack.getCount() > this.getMaxStackSize()) stack.setCount(this.getMaxStackSize());
        this.markUpdated();
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
        this.markUpdated();
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

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory);
        this.isBlending = tag.getBoolean("IsBlending");
        this.blendProgress = tag.getInt("BlendProgress");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putBoolean("IsBlending", this.isBlending);
        tag.putInt("BlendProgress", this.blendProgress);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putBoolean("IsBlending", this.isBlending);
        tag.putInt("BlendProgress", this.blendProgress);
        return tag;
    }

    public boolean isValidIngredient(ItemStack stack) {
        if (stack.isEmpty() || this.level == null) return false;

        List<BlendingRecipe> recipes = this.level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.BLENDING.get());
        for (BlendingRecipe recipe : recipes) {
            for (BlendingRecipe.CountedIngredient countedIngredient : recipe.getCountedIngredients()) {
                if (countedIngredient.ingredient().test(stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dropAllItems() {
        if (this.level == null || this.level.isClientSide) return;

        for (int i = 0; i < this.inventory.size(); i++) {
            ItemStack stack = this.inventory.get(i);
            if (!stack.isEmpty()) {
                Block.popResource(this.level, this.worldPosition.above(), stack.copy());
                this.inventory.set(i, ItemStack.EMPTY);
            }
        }
        this.markUpdated();
    }

    @Override
    public boolean fill(Fluid fluid, int amount) {
        boolean filled = super.fill(fluid, amount);
        if (filled && this.fluidAmount > 0) {
            this.dropAllItems();
        }
        return filled;
    }

    @Override
    public void setFluid(Fluid fluid, int amount) {
        super.setFluid(fluid, amount);
        if (this.fluidAmount > 0 && this.fluid != Fluids.EMPTY) {
            this.dropAllItems();
        }
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return this.isBlending ? new int[0] : SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        if (this.isBlending() || (this.fluid != Fluids.EMPTY && this.fluidAmount > 0)) {
            return false;
        }
        return this.isValidIngredient(stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return !this.isBlending;
    }
}