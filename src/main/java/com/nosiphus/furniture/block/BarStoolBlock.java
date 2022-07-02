package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalWaterloggedBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BarStoolBlock extends FurnitureHorizontalWaterloggedBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public BarStoolBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateContainer().getValidStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] CUSHION = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(3.5, 12.0, 3.5, 12.5, 12.5, 12.5), Direction.NORTH));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(3.0, 9.0, 3.0, 13.0, 12.0, 13.0), Direction.NORTH));
        final VoxelShape[] NORTH_WEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(4.0, 0.0, 4.0, 6.0, 9.0, 6.0), Direction.NORTH));
        final VoxelShape[] NORTH_EAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(10.0, 0.0, 4.0, 12.0, 9.0, 6.0), Direction.NORTH));
        final VoxelShape[] SOUTH_WEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(4.0, 0.0, 10.0, 6.0, 9.0, 12.0), Direction.NORTH));
        final VoxelShape[] SOUTH_EAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(10.0, 0.0, 10.0, 12.0, 9.0, 12.0), Direction.NORTH));
        final VoxelShape[] WEST_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(4.5, 4.0, 6.0, 5.5, 5.0, 10.0), Direction.NORTH));
        final VoxelShape[] EAST_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(10.5, 4.0, 6.0, 11.5, 5.0, 10.0), Direction.NORTH));
        final VoxelShape[] SOUTH_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(6.0, 4.0, 10.5, 10.0, 5.0, 11.5), Direction.NORTH));
        final VoxelShape[] NORTH_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(6.0, 4.0, 4.5, 10.0, 5.0, 5.5), Direction.NORTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states)
        {
            Direction direction = state.get(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(CUSHION[direction.getHorizontalIndex()]);
            shapes.add(BASE[direction.getHorizontalIndex()]);
            shapes.add(NORTH_WEST_LEG[direction.getHorizontalIndex()]);
            shapes.add(NORTH_EAST_LEG[direction.getHorizontalIndex()]);
            shapes.add(SOUTH_WEST_LEG[direction.getHorizontalIndex()]);
            shapes.add(SOUTH_EAST_LEG[direction.getHorizontalIndex()]);
            shapes.add(WEST_SUPPORT[direction.getHorizontalIndex()]);
            shapes.add(EAST_SUPPORT[direction.getHorizontalIndex()]);
            shapes.add(SOUTH_SUPPORT[direction.getHorizontalIndex()]);
            shapes.add(NORTH_SUPPORT[direction.getHorizontalIndex()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader reader, BlockPos pos) {
        return SHAPES.get(state);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result)
    {
        if(!world.isRemote)
        {
            ItemStack stack = playerEntity.getHeldItem(hand);
            return SeatEntity.create(world, pos, 0.4, playerEntity);
        }
        return ActionResultType.SUCCESS;
    }

}
