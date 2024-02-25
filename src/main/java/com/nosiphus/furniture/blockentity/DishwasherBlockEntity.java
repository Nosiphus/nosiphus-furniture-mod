package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.tileentity.BasicLootBlockEntity;
import com.nosiphus.furniture.inventory.container.DishwasherMenu;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DishwasherBlockEntity extends BasicLootBlockEntity {

    protected DishwasherBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public DishwasherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DISHWASHER.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 7;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.nfm.dishwasher");
    }

    @Override
    protected AbstractContainerMenu createMenu(int ID, Inventory inventory) {
        return new DishwasherMenu(ID, inventory, this);
    }

}
