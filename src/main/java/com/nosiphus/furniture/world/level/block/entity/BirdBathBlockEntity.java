package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;

public class BirdBathBlockEntity extends FluidHandlerSyncedBlockEntity {

    public BirdBathBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.BIRD_BATH.get(), pos, state, FluidType.BUCKET_VOLUME);
    }

}