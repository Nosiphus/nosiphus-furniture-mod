package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CathodeRayTubeTelevisionMenu extends AbstractContainerMenu {

    protected final CathodeRayTubeTelevisionBlockEntity blockEntity;

    public CathodeRayTubeTelevisionMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, (CathodeRayTubeTelevisionBlockEntity) inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public CathodeRayTubeTelevisionMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.CATHODE_RAY_TUBE_TELEVISION.get(), id);
        if (!(entity instanceof CathodeRayTubeTelevisionBlockEntity tv)) {
            throw new IllegalStateException("BlockEntity is not a CathodeRayTubeTelevision!");
        }
        this.blockEntity = tv;
    }

    public CathodeRayTubeTelevisionBlockEntity getBlockEntity() {
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
