package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.OvenMenu;
import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class OvenBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(10, ItemStack.EMPTY);

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

    @Override
    public int getContainerSize() { return this.inventory.size(); }

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
        if (stack.getCount() > this.getMaxStackSize()) stack.setCount(this.getMaxStackSize());
        this.markUpdated();
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

    @Override
    public int[] getSlotsForFace(Direction side) { return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) { return true; }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) { return true; }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        for (int i = 0; i < 4; i++) {
            tag.putInt("oven.progress" + (i + 1), this.progress[i]);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory);
        for (int i = 0; i < 4; i++) {
            this.progress[i] = tag.getInt("oven.progress" + (i + 1));
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void drops() {
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, this);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OvenBlockEntity be) {
        if (level.isClientSide) return;

        boolean changed = false;
        int[] inputs = {0, 2, 4, 6};
        int[] outputs = {1, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            int inputSlot = inputs[i];
            int outputSlot = outputs[i];

            ItemStack inputStack = be.getItem(inputSlot);
            if (inputStack.isEmpty()) {
                if (be.progress[i] > 0) {
                    be.progress[i] = 0;
                    changed = true;
                }
                continue;
            }

            SimpleContainer container = new SimpleContainer(inputStack);
            Optional<CookingRecipe> recipe = level.getRecipeManager()
                    .getRecipeFor(ModRecipeTypes.COOKING.get(), container, level);

            if (recipe.isPresent() && be.canCraft(recipe.get(), outputSlot, level.registryAccess())) {
                be.progress[i]++;
                changed = true;
                if (be.progress[i] >= be.maxProgress) {
                    be.craftItem(recipe.get(), inputSlot, outputSlot, level.registryAccess());
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

    private boolean canCraft(CookingRecipe recipe, int outputSlot, RegistryAccess registryAccess) {
        ItemStack result = recipe.getResultItem(registryAccess);
        ItemStack currentOutput = this.getItem(outputSlot);
        if (currentOutput.isEmpty()) return true;
        return ItemStack.isSameItem(currentOutput, result) &&
                ItemStack.matches(currentOutput, result) &&
                currentOutput.getCount() + result.getCount() <= currentOutput.getMaxStackSize();
    }

    private void craftItem(CookingRecipe recipe, int inputSlot, int outputSlot, RegistryAccess registryAccess) {
        ItemStack result = recipe.getResultItem(registryAccess);
        ItemStack inputStack = this.getItem(inputSlot);
        if (!inputStack.isEmpty()) {
            inputStack.shrink(1);
        }

        ItemStack currentOutput = this.getItem(outputSlot);
        if (currentOutput.isEmpty()) {
            this.setItem(outputSlot, result.copy());
        } else {
            currentOutput.grow(result.getCount());
        }
    }
}