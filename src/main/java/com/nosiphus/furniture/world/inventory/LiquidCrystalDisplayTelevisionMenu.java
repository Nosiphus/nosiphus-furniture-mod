package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LiquidCrystalDisplayTelevisionMenu extends AbstractContainerMenu {

    protected final LiquidCrystalDisplayTelevisionBlockEntity blockEntity;

    public LiquidCrystalDisplayTelevisionMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, (LiquidCrystalDisplayTelevisionBlockEntity) inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public LiquidCrystalDisplayTelevisionMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), id);
        if (!(entity instanceof LiquidCrystalDisplayTelevisionBlockEntity tv)) {
            throw new IllegalStateException("BlockEntity is not a LiquidCrystalDisplayTelevision!");
        }
        this.blockEntity = tv;
    }

    public LiquidCrystalDisplayTelevisionBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public boolean isPowered() {
        return blockEntity.isPowered();
    }

    public int getChannel() {
        return blockEntity.getChannel();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }
}
