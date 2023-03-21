package com.nosiphus.furniture.blockentity;

import com.nosiphus.furniture.client.menu.OvenMenu;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class OvenBlockEntity extends AbstractFurnaceBlockEntity {
    public OvenBlockEntity(BlockPos pos, BlockState state) {

        super(ModBlockEntities.OVEN.get(), pos, state, RecipeType.SMELTING);

    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container.nfm.oven");
    }

    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory)
    {
        return new OvenMenu(id, inventory, this, this.dataAccess);
    }

    @Override
    protected int getBurnDuration(@NotNull ItemStack itemStack) {
        return super.getBurnDuration(itemStack) / 8;
    }

}
