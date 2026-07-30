package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CathodeRayTubeTelevisionBlockEntity extends BlockEntity {

    public CathodeRayTubeTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CATHODE_RAY_TUBE_TELEVISION.get(), pos, state);
    }

}
