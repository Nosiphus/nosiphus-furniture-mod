package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;

public class TapBlockEntity extends FluidHandlerSyncedBlockEntity {

    public TapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TAP.get(), pos, state, FluidType.BUCKET_VOLUME);
    }

}
