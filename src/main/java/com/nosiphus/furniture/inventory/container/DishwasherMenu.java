package com.nosiphus.furniture.inventory.container;

import com.nosiphus.furniture.block.DishwasherBlock;
import com.nosiphus.furniture.blockentity.DishwasherBlockEntity;
import com.nosiphus.furniture.core.ModContainers;
import com.nosiphus.furniture.inventory.container.slot.SoapyWaterSlot;
import com.nosiphus.furniture.inventory.container.slot.ToolSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class DishwasherMenu extends AbstractContainerMenu {

    protected final DishwasherBlockEntity blockEntity;

    public DishwasherMenu(int ID, Inventory inventory, DishwasherBlockEntity blockEntity) {
        super(ModContainers.DISHWASHER.get(), ID);
        this.blockEntity = blockEntity;
        blockEntity.startOpen(inventory.player);

        this.addSlot(new ToolSlot(blockEntity, 0, 56, 43, 0));
        this.addSlot(new ToolSlot(blockEntity, 1, 80, 43, 1));
        this.addSlot(new ToolSlot(blockEntity, 2, 104, 43, 2));
        this.addSlot(new ToolSlot(blockEntity, 3, 56, 74, 3));
        this.addSlot(new ToolSlot(blockEntity, 4, 80, 74, 4));
        this.addSlot(new ToolSlot(blockEntity, 5, 104, 74, 5));
        this.addSlot(new SoapyWaterSlot(blockEntity, 6, 125, 7));

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; ++j)
            {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 146));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 204));
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
