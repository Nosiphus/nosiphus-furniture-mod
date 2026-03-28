package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.OvenMenu;
import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class OvenBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) { markUpdated(); }
    };

    protected final ContainerData data;
    private final int[] progress = new int[4];
    private int maxProgress = 100;

    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.OVEN.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                if (index < 4) return OvenBlockEntity.this.progress[index];
                if (index == 4) return OvenBlockEntity.this.maxProgress;
                return 0;
            }

            @Override
            public void set(int index, int value) {
                if (index < 4) OvenBlockEntity.this.progress[index] = value;
                else if (index == 4) OvenBlockEntity.this.maxProgress = value;
            }

            @Override
            public int getCount() { return 5; }
        };
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public Component getDisplayName() { return Component.translatable("container.nfm.oven"); }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new OvenMenu(id, inventory, this, this.data);
    }

    public IItemHandler getItemHandler() { return itemHandler; }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        for (int i = 0; i < 4; i++) {
            tag.putInt("oven.progress" + (i + 1), this.progress[i]);
        }
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        for (int i = 0; i < 4; i++) {
            this.progress[i] = tag.getInt("oven.progress" + (i + 1));
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OvenBlockEntity be) {
        if (level.isClientSide) return;

        boolean changed = false;
        int[] inputs = {1, 3, 5, 7};
        int[] outputs = {2, 4, 6, 8};

        for (int i = 0; i < 4; i++) {
            int inputSlot = inputs[i];
            int outputSlot = outputs[i];

            ItemStack inputStack = be.itemHandler.getStackInSlot(inputSlot);
            if (inputStack.isEmpty()) {
                if (be.progress[i] > 0) {
                    be.progress[i] = 0;
                    changed = true;
                }
                continue;
            }

            SingleRecipeInput recipeInput = new SingleRecipeInput(inputStack);
            Optional<RecipeHolder<CookingRecipe>> recipe = level.getRecipeManager()
                    .getRecipeFor(ModRecipeTypes.COOKING.get(), recipeInput, level);

            if (recipe.isPresent() && be.canCraft(recipe.get().value(), outputSlot, level.registryAccess())) {
                be.progress[i]++;
                changed = true;
                if (be.progress[i] >= be.maxProgress) {
                    be.craftItem(recipe.get().value(), inputSlot, outputSlot, level.registryAccess());
                    be.progress[i] = 0;
                }
            } else {
                if (be.progress[i] > 0) {
                    be.progress[i] = 0;
                    changed = true;
                }
            }
        }

        if (changed) be.setChanged();
    }

    private boolean canCraft(CookingRecipe recipe, int outputSlot, HolderLookup.Provider registries) {
        ItemStack result = recipe.getResultItem(registries);
        ItemStack currentOutput = this.itemHandler.getStackInSlot(outputSlot);
        if (currentOutput.isEmpty()) return true;
        return ItemStack.isSameItemSameComponents(currentOutput, result) &&
                currentOutput.getCount() + result.getCount() <= currentOutput.getMaxStackSize();
    }

    private void craftItem(CookingRecipe recipe, int inputSlot, int outputSlot, HolderLookup.Provider registries) {
        ItemStack result = recipe.getResultItem(registries);
        this.itemHandler.extractItem(inputSlot, 1, false);

        ItemStack currentOutput = this.itemHandler.getStackInSlot(outputSlot);
        if (currentOutput.isEmpty()) {
            this.itemHandler.setStackInSlot(outputSlot, result.copy());
        } else {
            currentOutput.grow(result.getCount());
        }
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
}