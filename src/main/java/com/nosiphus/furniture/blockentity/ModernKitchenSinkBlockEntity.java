package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.tileentity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class ModernKitchenSinkBlockEntity extends FluidHandlerSyncedBlockEntity
{

    protected ModernKitchenSinkBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity)
    {
        super(type, pos, state, capacity);
    }

    public ModernKitchenSinkBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.MODERN_KITCHEN_SINK.get(), pos, state, FluidType.BUCKET_VOLUME * 10);
    }

}
