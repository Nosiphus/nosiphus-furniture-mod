package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LiquidCrystalDisplayTelevisionBlockEntity extends BlockEntity {

    public LiquidCrystalDisplayTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), pos, state);
    }

}
