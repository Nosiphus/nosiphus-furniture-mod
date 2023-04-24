package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class TelevisionStandBlock extends FurnitureHorizontalBlock
{
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public TelevisionStandBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.SINGLE));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] NORTHWEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 2.0, 2.5, 3.5, 3.5), Direction.EAST));
        final VoxelShape[] NORTHEAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0.0, 2.0, 15.0, 3.5, 3.5), Direction.EAST));
        final VoxelShape[] SOUTHWEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 12.5, 2.5, 3.5, 14.0), Direction.EAST));
        final VoxelShape[] SOUTHEAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0.0, 12.5, 15.0, 3.5, 14.0), Direction.EAST));
        final VoxelShape[] LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 2.5, 14.5, 14.0), Direction.EAST));
        final VoxelShape[] RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 5.0, 2.0, 15.0, 14.5, 14.0), Direction.EAST));
        final VoxelShape[] BACK_SIDE_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 5.0, 2.0, 13.5, 14.5, 3.5), Direction.EAST));
        final VoxelShape[] TOP_SHELF_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 9.0, 3.5, 13.5, 10.5, 14.0), Direction.EAST));
        final VoxelShape[] BOTTOM_SHELF_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 3.5, 2.0, 15.0, 5.0, 14.0), Direction.EAST));
        final VoxelShape[] TABLE_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 14.5, 2.0, 16.0, 16.0, 14.0), Direction.EAST));
        final VoxelShape[] TABLE_TOP_NORTH_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.5, 1.0, 15.0, 16.0, 2.0), Direction.EAST));
        final VoxelShape[] TABLE_TOP_SOUTH_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.5, 14.0, 15.0, 16.0, 15.0), Direction.EAST));

        final VoxelShape[] TABLE_TOP_NORTH_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.5, 1.0, 16.0, 16.0, 2.0), Direction.EAST));
        final VoxelShape[] TABLE_TOP_SOUTH_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.5, 14.0, 16.0, 16.0, 15.0), Direction.EAST));

        final VoxelShape[] TABLE_TOP_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 14.5, 1.0, 16.0, 16.0, 15.0), Direction.EAST));
        final VoxelShape[] TOP_SHELF_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 9.0, 3.5, 15.5, 10.5, 14.0), Direction.EAST));
        final VoxelShape[] BOTTOM_SHELF_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 3.5, 2.0, 16.0, 5.0, 14.0), Direction.EAST));
        final VoxelShape[] LEFT_SIDE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 2.0, 0.5, 14.5, 14.0), Direction.EAST));
        final VoxelShape[] RIGHT_SIDE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 5.0, 2.0, 16.0, 14.0, 14.0), Direction.EAST));


        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state: states)
        {
            Direction direction = state.getValue(DIRECTION);
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            switch(type)
            {
                case SINGLE:
                    shapes.add(TABLE_TOP[direction.get2DDataValue()]);
                    shapes.add(TABLE_TOP_NORTH_SINGLE[direction.get2DDataValue()]);
                    shapes.add(TABLE_TOP_SOUTH_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BACK_SIDE_SINGLE[direction.get2DDataValue()]);
                    shapes.add(TOP_SHELF_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_SINGLE[direction.get2DDataValue()]);
                    shapes.add(NORTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(NORTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHEAST_LEG[direction.get2DDataValue()]);
                    break;
                case LEFT:
                    shapes.add(TABLE_TOP[direction.get2DDataValue()]);
                    shapes.add(TABLE_TOP_NORTH_LEFT[direction.get2DDataValue()]);
                    shapes.add(TABLE_TOP_SOUTH_LEFT[direction.get2DDataValue()]);
                    shapes.add(LEFT_SIDE[direction.get2DDataValue()]);
                    shapes.add(NORTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHWEST_LEG[direction.get2DDataValue()]);
                    break;
                case RIGHT:
                    shapes.add(TABLE_TOP[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE[direction.get2DDataValue()]);
                    shapes.add(NORTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHEAST_LEG[direction.get2DDataValue()]);
                    break;
                case MIDDLE:
                    shapes.add(TABLE_TOP_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(TOP_SHELF_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(LEFT_SIDE_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE_MIDDLE[direction.get2DDataValue()]);
                    break;

            }
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

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockState state = super.getStateForPlacement(context);
        return this.getTVStandState(state, context.getLevel(), context.getClickedPos(), state.getValue(DIRECTION));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos)
    {
        return this.getTVStandState(state, level, pos, state.getValue(DIRECTION));
    }

    private BlockState getTVStandState(BlockState state, LevelAccessor level, BlockPos pos, Direction dir)
    {
        boolean left = this.isTVStand(level, pos, dir.getCounterClockWise(), dir) || this.isTVStand(level, pos, dir.getCounterClockWise(), dir.getCounterClockWise());
        boolean right = this.isTVStand(level, pos, dir.getClockWise(), dir) || this.isTVStand(level, pos, dir.getClockWise(), dir.getClockWise());

        if(left && right)
        {
            return state.setValue(TYPE, Type.MIDDLE);
        }
        else if(left)
        {
            return state.setValue(TYPE, Type.RIGHT);
        }
        else if(right)
        {
            return state.setValue(TYPE, Type.LEFT);
        }
        return state.setValue(TYPE, Type.SINGLE);
    }

    private boolean isTVStand(LevelAccessor level, BlockPos source, Direction direction, Direction targetDirection)
    {
        BlockState state = level.getBlockState(source.relative(direction));
        if(state.getBlock() == this)
        {
            Direction tvStandDirection = state.getValue(DIRECTION);
            return tvStandDirection.equals(targetDirection);
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable
    {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle");

        private final String id;

        Type(String id)
        {
            this.id = id;
        }

        @Override
        public String getSerializedName()
        {
            return id;
        }

        @Override
        public String toString()
        {
            return id;
        }
    }

}