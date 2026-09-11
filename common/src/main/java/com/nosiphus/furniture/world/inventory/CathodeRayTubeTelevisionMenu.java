package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CathodeRayTubeTelevisionMenu extends AbstractContainerMenu {

    private final CathodeRayTubeTelevisionBlockEntity blockEntity;

    public CathodeRayTubeTelevisionMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, getBlockEntity(inventory, extraData));

        if (this.blockEntity != null) {
            this.blockEntity.setChannelUrl(0, extraData.readUtf());
            this.blockEntity.setChannelUrl(1, extraData.readUtf());
            this.blockEntity.setChannelUrl(2, extraData.readUtf());
        }
    }

    public CathodeRayTubeTelevisionMenu(int id, Inventory inventory, CathodeRayTubeTelevisionBlockEntity blockEntity) {
        super(ModMenuTypes.CATHODE_RAY_TUBE_TELEVISION.get(), id);
        this.blockEntity = blockEntity;
    }

    private static CathodeRayTubeTelevisionBlockEntity getBlockEntity(Inventory playerInventory, FriendlyByteBuf extraData) {
        BlockPos pos = extraData.readBlockPos();
        BlockEntity be = playerInventory.player.level().getBlockEntity(pos);
        if (be instanceof CathodeRayTubeTelevisionBlockEntity tv) {
            return tv;
        }
        throw new IllegalStateException("BlockEntity at " + pos + " is not a CathodeRayTubeTelevisionBlockEntity!");
    }

    public CathodeRayTubeTelevisionBlockEntity getBlockEntity() {
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