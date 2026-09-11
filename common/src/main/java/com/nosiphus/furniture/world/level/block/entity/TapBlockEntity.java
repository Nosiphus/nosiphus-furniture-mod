package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TapBlockEntity extends FluidHandlerSyncedBlockEntity {

    public TapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TAP.get(), pos, state, 1000);
    }

}