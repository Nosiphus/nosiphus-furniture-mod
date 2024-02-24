package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.tileentity.BasicLootBlockEntity;
import com.nosiphus.furniture.client.menu.DishwasherMenu;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DishwasherBlockEntity extends BasicLootBlockEntity {

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

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu) {
        return menu instanceof DishwasherMenu dishwasherMenu && dishwasherMenu.getBlockEntity() == this;
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }


}
