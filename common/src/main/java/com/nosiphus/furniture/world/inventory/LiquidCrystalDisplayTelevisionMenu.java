package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LiquidCrystalDisplayTelevisionMenu extends AbstractContainerMenu {

    private final LiquidCrystalDisplayTelevisionBlockEntity blockEntity;

    public LiquidCrystalDisplayTelevisionMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, getBlockEntity(inventory, extraData));

        if (this.blockEntity != null) {
            this.blockEntity.setChannelUrl(0, extraData.readUtf());
            this.blockEntity.setChannelUrl(1, extraData.readUtf());
            this.blockEntity.setChannelUrl(2, extraData.readUtf());
        }
    }

    public LiquidCrystalDisplayTelevisionMenu(int id, Inventory inventory, LiquidCrystalDisplayTelevisionBlockEntity blockEntity) {
        super(ModMenuTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), id);
        this.blockEntity = blockEntity;
    }

    private static LiquidCrystalDisplayTelevisionBlockEntity getBlockEntity(Inventory playerInventory, FriendlyByteBuf extraData) {
        BlockPos pos = extraData.readBlockPos();
        BlockEntity be = playerInventory.player.level().getBlockEntity(pos);
        if (be instanceof LiquidCrystalDisplayTelevisionBlockEntity tv) {
            return tv;
        }
        throw new IllegalStateException("BlockEntity at " + pos + " is not a LiquidCrystalDisplayTelevisionBlockEntity!");
    }

    public LiquidCrystalDisplayTelevisionBlockEntity getBlockEntity() {
        return this.blockEntity;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity != null && blockEntity.stillValid(player);
    }
}