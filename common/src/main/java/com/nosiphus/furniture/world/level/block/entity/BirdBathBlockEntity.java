package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BirdBathBlockEntity extends FluidHandlerSyncedBlockEntity {

    public BirdBathBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BIRD_BATH.get(), pos, state, 1000);
    }

}