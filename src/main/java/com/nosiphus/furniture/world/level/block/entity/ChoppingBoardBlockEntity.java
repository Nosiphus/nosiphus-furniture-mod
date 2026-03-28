package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.item.crafting.ChoppingInput;
import com.nosiphus.furniture.world.item.crafting.ChoppingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChoppingBoardBlockEntity extends BlockEntity implements WorldlyContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    public ChoppingBoardBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CHOPPING_BOARD.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public boolean addItem(ItemStack stack) {
        if (this.inventory.get(0).isEmpty()) {
            this.inventory.set(0, stack.copyWithCount(1));
            this.markUpdated();
            return true;
        }
        return false;
    }

    public boolean chopItem() {
        ItemStack current = this.inventory.get(0);
        if (current.isEmpty() || this.level == null) return false;

        ChoppingInput input = new ChoppingInput(current);
        Optional<RecipeHolder<ChoppingRecipe>> recipe = this.level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.CHOPPING.get(), input, this.level);

        if (recipe.isPresent()) {
            if (!this.level.isClientSide) {
                double x = worldPosition.getX() + 0.5;
                double y = worldPosition.getY() + 0.2;
                double z = worldPosition.getZ() + 0.5;

                ItemStack result = recipe.get().value().assemble(input, this.level.registryAccess());
                ItemEntity entity = new ItemEntity(level, x, y, z, result);
                this.level.addFreshEntity(entity);

                this.level.playSound(null, x, y, z, ModSoundEvents.BLOCK_CHOPPING_BOARD_KNIFE_CHOP.get(),
                        SoundSource.BLOCKS, 1.0F, 0.5F);
            }
            this.inventory.set(0, ItemStack.EMPTY);
            this.markUpdated();
            return true;
        }
        return false;
    }

    public void removeItem() {
        if (!this.inventory.get(0).isEmpty() && this.level != null) {
            if (!this.level.isClientSide) {
                ItemEntity entity = new ItemEntity(this.level, worldPosition.getX() + 0.5, worldPosition.getY() + 0.2,
                        worldPosition.getZ() + 0.5, this.inventory.get(0).copy());
                this.level.addFreshEntity(entity);
            }
            this.inventory.set(0, ItemStack.EMPTY);
            this.markUpdated();
        }
    }

    @Override
    public int getContainerSize() { return 1; }

    @Override
    public boolean isEmpty() { return this.inventory.get(0).isEmpty(); }

    @Override
    public ItemStack getItem(int index) { return this.inventory.get(index); }

    @Override
    public ItemStack removeItem(int index, int count) {
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
    public int getMaxStackSize() { return 1; }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
        this.markUpdated();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.inventory, registries);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public int[] getSlotsForFace(Direction side) { return new int[]{0}; }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) { return false; }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) { return false; }
}