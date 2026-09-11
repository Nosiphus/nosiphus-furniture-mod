package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StereoBlockEntity extends BlockEntity {
    private int trackIndex = 0;

    public StereoBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.STEREO.get(), pos, state);
    }

    public int getTrackIndex() { return trackIndex; }
    public void setTrackIndex(int index) { this.trackIndex = index; }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.trackIndex = tag.getInt("TrackIndex");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("TrackIndex", this.trackIndex);
    }
}