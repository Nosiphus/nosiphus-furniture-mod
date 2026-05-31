package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.ComputerBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ComputerMenu extends AbstractContainerMenu {

    protected final ComputerBlockEntity blockEntity;

    public ComputerMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, (ComputerBlockEntity) inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ComputerMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.COMPUTER.get(), id);
        if (!(entity instanceof ComputerBlockEntity computer)) {
            throw new IllegalStateException("BlockEntity is not a Computer!");
        }
        this.blockEntity = computer;
    }

    public ComputerBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public boolean isPowered() {
        return blockEntity.isPowered();
    }

    public int getChannel() {
        return blockEntity.getChannel();
    }

    public String getGifUrl() {
        return blockEntity.getGifUrl();
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
