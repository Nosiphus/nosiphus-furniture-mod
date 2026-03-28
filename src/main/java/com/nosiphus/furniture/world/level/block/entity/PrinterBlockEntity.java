package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.PrinterMenu;
import com.nosiphus.furniture.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.WritableBookContent;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class PrinterBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) { markUpdated(); }
    };

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 1000;

    public PrinterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.PRINTER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PrinterBlockEntity.this.progress;
                    case 1 -> PrinterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PrinterBlockEntity.this.progress = value;
                    case 1 -> PrinterBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() { return 2; }
        };
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public Component getDisplayName() { return Component.translatable("container.nfm.printer"); }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new PrinterMenu(id, inventory, this, this.data);
    }

    public IItemHandler getItemHandler() { return itemHandler; }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("printer.progress", this.progress);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        this.progress = tag.getInt("printer.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PrinterBlockEntity printer) {
        if (level.isClientSide) return;

        if (printer.canCopy()) {
            if (printer.progress == 0) {
                int charCount = printer.getBookCharacterCount(printer.itemHandler.getStackInSlot(1));
                printer.maxProgress = Math.max(40, charCount / 10); // Tuned for printertter speed
            }

            printer.progress++;
            if (printer.progress >= printer.maxProgress) {
                printer.copyBook();
                printer.progress = 0;
            }
            printer.setChanged();
        } else {
            if (printer.progress > 0) {
                printer.progress = 0;
                printer.markUpdated();
            }
        }
    }

    private int getBookCharacterCount(ItemStack stack) {
        if (stack.isEmpty()) return 0;

        int count = 0;

        WrittenBookContent written = stack.get(DataComponents.WRITTEN_BOOK_CONTENT);
        if (written != null) {
            for (var page : written.pages()) {
                count += page.raw().getString().length();
            }
            return count;
        }

        WritableBookContent writable = stack.get(DataComponents.WRITABLE_BOOK_CONTENT);
        if (writable != null) {
            for (var page : writable.pages()) {
                count += page.raw().length();
            }
        }

        return count;
    }

    private void copyBook() {
        ItemStack input = itemHandler.getStackInSlot(1);
        ItemStack output = itemHandler.getStackInSlot(2);

        int inkCost = Math.max(1, getBookCharacterCount(input));

        ItemStack inkStack = itemHandler.getStackInSlot(0);
        if (!inkStack.isEmpty()) {
            inkStack.hurtAndBreak(inkCost, (ServerLevel)this.level, null, item -> {});
        }

        ItemStack copy = input.copy();
        copy.setCount(1);

        if (output.isEmpty()) {
            itemHandler.setStackInSlot(2, copy);
        } else {
            output.grow(1);
        }

        this.progress = 0;
        this.markUpdated();
    }

    private boolean canCopy() {
        ItemStack ink = itemHandler.getStackInSlot(0);
        ItemStack input = itemHandler.getStackInSlot(1);
        ItemStack output = itemHandler.getStackInSlot(2);

        if (input.isEmpty() || ink.isEmpty() || !ink.is(ModItems.INK_CARTRIDGE.get())) {
            return false;
        }

        int charCount = getBookCharacterCount(input);
        int remainingInk = ink.getMaxDamage() - ink.getDamageValue();
        if (remainingInk < charCount) {
            return false;
        }

        if (output.isEmpty()) return true;
        return ItemStack.isSameItemSameComponents(input, output) && output.getCount() < output.getMaxStackSize();
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
}