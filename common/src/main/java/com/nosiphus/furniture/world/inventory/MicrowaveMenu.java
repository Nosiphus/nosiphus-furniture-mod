package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.MicrowaveBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MicrowaveMenu extends AbstractContainerMenu {
    protected final MicrowaveBlockEntity blockEntity;
    private final ContainerData data;

    public MicrowaveMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public MicrowaveMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.MICROWAVE.get(), id);
        if (!(entity instanceof MicrowaveBlockEntity microwave)) {
            throw new IllegalStateException("This is not a microwave.");
        }

        this.blockEntity = microwave;
        this.data = data;

        checkContainerDataCount(data, 2);

        this.addSlot(new Slot(microwave, 0, 65, 43));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 92));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 150));
        }

        this.addDataSlots(data);
    }

    public boolean isCooking() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressBarSize = 27;

        return (maxProgress != 0 && progress != 0) ? (progress * progressBarSize / maxProgress) : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();

            if (index < 1) {
                if (!this.moveItemStackTo(slotStack, 1, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, 1, false)) {
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

    public MicrowaveBlockEntity getBlockEntity() {
        return blockEntity;
    }
}