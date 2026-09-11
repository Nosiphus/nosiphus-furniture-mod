package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BathBlockEntity extends FluidHandlerSyncedBlockEntity {

    public BathBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BATH.get(), pos, state, 32000);
    }

}