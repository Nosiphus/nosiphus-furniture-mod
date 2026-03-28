package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.OvenBlockEntity;
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

public class OvenMenu extends AbstractContainerMenu {
    protected final OvenBlockEntity blockEntity;
    private final ContainerData data;

    public OvenMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(5));
    }

    public OvenMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.OVEN.get(), id);
        if (!(entity instanceof OvenBlockEntity oven)) {
            throw new IllegalStateException("BlockEntity is not an Oven!");
        }

        this.blockEntity = oven;
        this.data = data;

        checkContainerDataCount(data, 5);
        IItemHandler handler = blockEntity.getItemHandler();

        this.addSlot(new SlotItemHandler(handler, 1, 53, 31));
        this.addSlot(new SlotItemHandler(handler, 2, 53, 73));

        this.addSlot(new SlotItemHandler(handler, 3, 71, 31));
        this.addSlot(new SlotItemHandler(handler, 4, 71, 73));

        this.addSlot(new SlotItemHandler(handler, 5, 89, 31));
        this.addSlot(new SlotItemHandler(handler, 6, 89, 73));

        this.addSlot(new SlotItemHandler(handler, 7, 107, 31));
        this.addSlot(new SlotItemHandler(handler, 8, 107, 73));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 146));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 204));
        }

        this.addDataSlots(data);
    }

    public boolean isCooking(int burnerIndex) {
        return data.get(burnerIndex) > 0;
    }

    public int getScaledProgress(int burnerIndex) {
        int progress = this.data.get(burnerIndex);
        int maxProgress = this.data.get(4);
        int progressBarSize = 14;

        return (maxProgress != 0 && progress != 0) ? (progress * progressBarSize / maxProgress) : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();

            if (index < 8) {
                if (!this.moveItemStackTo(slotStack, 8, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, 8, false)) {
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

    public OvenBlockEntity getBlockEntity() {
        return blockEntity;
    }
}