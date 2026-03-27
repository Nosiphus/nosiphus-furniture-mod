package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;

public class WaterTankBlockEntity extends FluidHandlerSyncedBlockEntity {

    public WaterTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.WATER_TANK.get(), pos, state, FluidType.BUCKET_VOLUME * 20);
    }

}