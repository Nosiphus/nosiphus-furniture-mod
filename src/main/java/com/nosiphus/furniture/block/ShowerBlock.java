package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ShowerBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ShowerBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0), Direction.EAST));
        final VoxelShape[] FRONT_TOP_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 31.0, 1.0, 1.0, 32.0, 15.0), Direction.EAST));
        final VoxelShape[] FRONT_LEFT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 1.0, 0.0, 1.0, 31.0, 1.0), Direction.EAST));
        final VoxelShape[] LEFT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 1.0, 0.5, 15.5, 31.0, 0.6), Direction.EAST));
        final VoxelShape[] LEFT_TOP_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 31.0, 0.0, 16.0, 32.0, 1.0), Direction.EAST));
        final VoxelShape[] BACK_LEFT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 1.0, 0.0, 16.0, 31.0, 1.0), Direction.EAST));
        final VoxelShape[] BACK_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 1.0, 0.5, 15.6, 31.0, 15.5), Direction.EAST));
        final VoxelShape[] BACK_TOP_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 31.0, 1.0, 1.0, 32.0, 15.0), Direction.EAST));
        final VoxelShape[] BACK_RIGHT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 1.0, 15.0, 16.0, 31.0, 16.0), Direction.EAST));
        final VoxelShape[] RIGHT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 1.0, 15.5, 15.5, 31.0, 15.6), Direction.EAST));
        final VoxelShape[] RIGHT_TOP_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 31.0, 15.0, 16.0, 32.0, 16.0), Direction.EAST));
        final VoxelShape[] FRONT_RIGHT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 1.0, 15.0, 1.0, 31.0, 16.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BASE[direction.get2DDataValue()]);
            shapes.add(FRONT_TOP_FRAME[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(LEFT_GLASS[direction.get2DDataValue()]);
            shapes.add(LEFT_TOP_FRAME[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(BACK_GLASS[direction.get2DDataValue()]);
            shapes.add(BACK_TOP_FRAME[direction.get2DDataValue()]);
            shapes.add(BACK_RIGHT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(RIGHT_GLASS[direction.get2DDataValue()]);
            shapes.add(RIGHT_TOP_FRAME[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_SUPPORT[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return SHAPES.get(state);
    }

}