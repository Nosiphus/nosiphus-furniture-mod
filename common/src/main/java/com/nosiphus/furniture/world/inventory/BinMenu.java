package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.BinBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BinMenu extends AbstractContainerMenu {
    protected final BinBlockEntity blockEntity;

    public BinMenu(int id, Inventory inventory, BinBlockEntity blockEntity) {
        super(ModMenuTypes.BIN.get(), id);
        this.blockEntity = blockEntity;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                this.addSlot(new Slot(blockEntity, j + i * 3, j * 18 + 62, i * 18 + 18));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 115));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 173));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();
            if (index < 12) {
                if (!this.moveItemStackTo(slotStack, 12, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.moveItemStackTo(slotStack, 0, 12, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.blockEntity.stopOpen(player);
    }

    public BinBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public static void emptyBin(BinMenu menu) {
        for (int i = 0; i < 12; i++) {
            menu.getSlot(i).set(ItemStack.EMPTY);
        }
    }
}