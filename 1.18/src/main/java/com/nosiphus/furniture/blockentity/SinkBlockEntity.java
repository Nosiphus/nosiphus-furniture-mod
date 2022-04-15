package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.tileentity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidAttributes;

public class SinkBlockEntity extends FluidHandlerSyncedBlockEntity {

    protected SinkBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {

        super(type, pos, state, capacity);

    }

    public SinkBlockEntity(BlockPos pos, BlockState state) {

        super(ModBlockEntities.SINK.get(), pos, state,FluidAttributes.BUCKET_VOLUME * 10);

    }

}
