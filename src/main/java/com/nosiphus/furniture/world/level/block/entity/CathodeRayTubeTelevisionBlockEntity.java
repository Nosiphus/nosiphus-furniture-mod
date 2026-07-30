package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CathodeRayTubeTelevisionBlockEntity extends BlockEntity {

    private final String[] channelUrls = new String[]{"", "", ""};

    public CathodeRayTubeTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CATHODE_RAY_TUBE_TELEVISION.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putString("ChannelUrl0", this.channelUrls[0]);
        tag.putString("ChannelUrl1", this.channelUrls[1]);
        tag.putString("ChannelUrl2", this.channelUrls[2]);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("ChannelUrl0")) this.channelUrls[0] = tag.getString("ChannelUrl0");
        if (tag.contains("ChannelUrl1")) this.channelUrls[1] = tag.getString("ChannelUrl1");
        if (tag.contains("ChannelUrl2")) this.channelUrls[2] = tag.getString("ChannelUrl2");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
