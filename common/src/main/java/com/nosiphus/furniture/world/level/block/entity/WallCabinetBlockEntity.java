package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.level.block.entity.BasicLootBlockEntity;
import com.nosiphus.furniture.world.inventory.WallCabinetMenu;
import com.nosiphus.furniture.world.level.block.WallCabinetBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WallCabinetBlockEntity extends BasicLootBlockEntity {

    public WallCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.WALL_CABINET.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 9;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.nfm.wall_cabinet");
    }

    @Override
    protected AbstractContainerMenu createMenu(int ID, Inventory inventory) {
        return new WallCabinetMenu(ID, inventory, this);
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu) {
        return menu instanceof WallCabinetMenu wallCabinetMenu && wallCabinetMenu.getBlockEntity() == this;
    }

    @Override
    public void startOpen(Player player) {
        if (this.level != null && !this.level.isClientSide) {
            this.playWallCabinetSound(this.getBlockState(), ModSoundEvents.BLOCK_CABINET_OPEN.get());
            this.setWallCabinetState(this.getBlockState(), true);
        }
        super.startOpen(player);
    }

    @Override
    public void stopOpen(Player player) {
        if (this.level != null && !this.level.isClientSide) {
            this.playWallCabinetSound(this.getBlockState(), ModSoundEvents.BLOCK_CABINET_CLOSE.get());
            this.setWallCabinetState(this.getBlockState(), false);
        }
        super.stopOpen(player);
    }

    private void playWallCabinetSound(BlockState state, SoundEvent event) {
        Vec3i directionVec = state.getValue(WallCabinetBlock.DIRECTION).getOpposite().getNormal();
        double x = this.worldPosition.getX() + 0.5D + directionVec.getX() / 2.0D;
        double y = this.worldPosition.getY() + 0.5D + directionVec.getY() / 2.0D;
        double z = this.worldPosition.getZ() + 0.5D + directionVec.getZ() / 2.0D;
        if (this.level != null) {
            this.level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    private void setWallCabinetState(BlockState state, boolean open) {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, state.setValue(WallCabinetBlock.OPEN, open), 3);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}