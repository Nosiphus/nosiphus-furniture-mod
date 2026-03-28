package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.BasicLootBlockEntity;
import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.inventory.BinMenu;
import com.nosiphus.furniture.world.level.block.BinBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BinBlockEntity extends BasicLootBlockEntity {

    private int openCount = 0;

    public BinBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BIN.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 12;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.nfm.bin");
    }

    @Override
    protected AbstractContainerMenu createMenu(int ID, Inventory inventory) {
        return new BinMenu(ID, inventory, this);
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu) {
        return menu instanceof BinMenu binMenu && binMenu.getBlockEntity() == this;
    }

    @Override
    public void startOpen(Player player) {
        super.startOpen(player);
        if (this.level != null && !this.level.isClientSide()) {
            this.openCount++;
            this.setBinState(this.getBlockState(), true);
        }
    }

    @Override
    public void stopOpen(Player player) {
        super.stopOpen(player);
        if (this.level != null && !this.level.isClientSide()) {
            this.openCount--;

            if (this.openCount <= 0) {
                this.openCount = 0; // Safety reset
                this.playBinSound(this.getBlockState(), ModSoundEvents.BLOCK_BIN_CLOSE.get());
                this.setBinState(this.getBlockState(), false);
            }
        }
    }

    public void playBinSound(BlockState state, SoundEvent event) {
        Direction direction = state.getValue(BinBlock.DIRECTION);
        double x = this.worldPosition.getX() + 0.5D + (direction.getStepX() * 0.4D);
        double y = this.worldPosition.getY() + 0.5D;
        double z = this.worldPosition.getZ() + 0.5D + (direction.getStepZ() * 0.4D);
        this.level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    private void setBinState(BlockState state, boolean open) {
        if (this.level != null) {
            if (state.getValue(BinBlock.OPEN) != open) {
                this.level.setBlock(this.worldPosition, state.setValue(BinBlock.OPEN, open), 3);
                this.markUpdated();
            }
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

}