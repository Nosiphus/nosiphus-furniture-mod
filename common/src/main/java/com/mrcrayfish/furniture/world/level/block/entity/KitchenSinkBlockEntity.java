package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.KitchenSinkBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class KitchenSinkBlockEntity extends FluidHandlerSyncedBlockEntity {

    protected KitchenSinkBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {
        super(type, pos, state, capacity);
    }

    public KitchenSinkBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.KITCHEN_SINK.get(), pos, state, 10000);
    }

    public boolean isBigSink() {
        if (this.getBlockState().getBlock() instanceof KitchenSinkBlock sinkBlock) {
            return sinkBlock.isBigSink();
        }
        return false;
    }
}