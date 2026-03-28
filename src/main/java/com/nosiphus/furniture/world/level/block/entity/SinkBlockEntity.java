package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;

public class SinkBlockEntity extends FluidHandlerSyncedBlockEntity {

    public SinkBlockEntity(BlockPos pos, BlockState state) {

        super(ModBlockEntityTypes.SINK.get(), pos, state, FluidType.BUCKET_VOLUME * 10);

    }

}