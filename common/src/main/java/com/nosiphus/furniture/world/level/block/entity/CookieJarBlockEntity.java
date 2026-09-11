package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CookieJarBlockEntity extends BlockEntity implements WorldlyContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(9, ItemStack.EMPTY);

    public CookieJarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.COOKIE_JAR.get(), pos, state);
    }

    public NonNullList<ItemStack> getCookieJar() {
        return this.inventory;
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public boolean addItem(ItemStack stack, int slot) {
        if (slot >= 0 && slot < 9 && this.inventory.get(slot).isEmpty()) {
            ItemStack single = stack.copy();
            single.setCount(1);
            this.inventory.set(slot, single);
            this.markUpdated();
            return true;
        }
        return false;
    }

    public void removeItem(int slot) {
        if (slot >= 0 && slot < 9 && !this.inventory.get(slot).isEmpty()) {
            if (this.level != null && !this.level.isClientSide) {
                double x = worldPosition.getX() + 0.5;
                double y = worldPosition.getY() + 0.2;
                double z = worldPosition.getZ() + 0.5;
                ItemEntity entity = new ItemEntity(this.level, x, y, z, this.inventory.get(slot).copy());
                this.level.addFreshEntity(entity);
            }
            this.inventory.set(slot, ItemStack.EMPTY);
            this.markUpdated();
        }
    }

    @Override
    public int getContainerSize() { return 9; }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

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
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
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
    public int[] getSlotsForFace(Direction side) {
        return side == Direction.DOWN ? new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8} : new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}