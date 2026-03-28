package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.PrinterBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class PrinterMenu extends AbstractContainerMenu {
    protected final PrinterBlockEntity blockEntity;
    private final ContainerData data;

    public PrinterMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public PrinterMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.PRINTER.get(), id);
        if (!(entity instanceof PrinterBlockEntity printer)) {
            throw new IllegalStateException("This is not a printer.");
        }

        this.blockEntity = printer;
        this.data = data;

        checkContainerDataCount(data, 2);
        IItemHandler handler = blockEntity.getItemHandler();

        this.addSlot(new SlotItemHandler(handler, 0, 55, 30));
        this.addSlot(new SlotItemHandler(handler, 1, 80, 5));
        this.addSlot(new SlotItemHandler(handler, 2, 80, 61));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 103));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 161));
        }

        this.addDataSlots(data);
    }

    public boolean isPrinting() {
        return data.get(0) > 0;
    }

    public int getRemainingInkLevel() {
        ItemStack inkStack = this.slots.get(0).getItem();
        if (inkStack.isEmpty() || !inkStack.isDamageableItem()) {
            return 0;
        }

        int maxDamage = inkStack.getMaxDamage();
        int currentDamage = inkStack.getDamageValue();
        int remainingInk = maxDamage - currentDamage;
        int barSize = 16;

        return (remainingInk * barSize) / maxDamage;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int barSize = 16;

        return (maxProgress != 0 && progress != 0) ? (progress * barSize / maxProgress) : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();

            if (index < 3) {
                if (!this.moveItemStackTo(slotStack, 3, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, 3, false)) {
                return ItemStack.EMPTY;
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
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }

    public PrinterBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}