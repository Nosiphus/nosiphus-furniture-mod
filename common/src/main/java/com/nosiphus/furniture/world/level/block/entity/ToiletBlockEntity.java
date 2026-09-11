package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ToiletBlockEntity extends FluidHandlerSyncedBlockEntity {

    public ToiletBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TOILET.get(), pos, state, 1000);
    }

}