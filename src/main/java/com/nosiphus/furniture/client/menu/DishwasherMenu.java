package com.nosiphus.furniture.client.menu;

import com.nosiphus.furniture.blockentity.DishwasherBlockEntity;
import com.nosiphus.furniture.core.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class DishwasherMenu extends AbstractContainerMenu {

    protected final DishwasherBlockEntity blockEntity;

    public DishwasherMenu(int ID, Inventory inventory, DishwasherBlockEntity blockEntity) {
        super(ModMenuTypes.DISHWASHER.get(), ID);
        this.blockEntity = blockEntity;
        blockEntity.startOpen(inventory.player);

        for(int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 173));
        }

    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player playerEntity, int index)
    {
        ItemStack clickedStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem())
        {
            ItemStack slotStack = slot.getItem();
            clickedStack = slotStack.copy();
            if(index < this.blockEntity.getContainerSize())
            {
                if(!this.moveItemStackTo(slotStack, this.blockEntity.getContainerSize(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.moveItemStackTo(slotStack, 0, this.blockEntity.getContainerSize(), false))
            {
                return ItemStack.EMPTY;
            }

            if(slotStack.isEmpty())
            {
                slot.set(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
        }
        return clickedStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.blockEntity.stopOpen(player);
    }

    public DishwasherBlockEntity getBlockEntity() {
        return blockEntity;
    }



}
