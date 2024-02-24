package com.nosiphus.furniture.client.menu;

import com.nosiphus.furniture.blockentity.DishwasherBlockEntity;
import com.nosiphus.furniture.core.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class DishwasherMenu extends AbstractContainerMenu {

    protected final DishwasherBlockEntity blockEntity;

    public DishwasherMenu(int ID, Inventory inventory, DishwasherBlockEntity blockEntity) {
        super(ModMenuTypes.DISHWASHER.get(), ID);
        this.blockEntity = blockEntity;
        blockEntity.startOpen(inventory.player);



    }

}
