package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class CurtainBlock extends FurnitureHorizontalBlock
{
    public static final BooleanProperty CLOSED = BooleanProperty.create("closed");
    public static final BooleanProperty LEFT_CLOSED = BooleanProperty.create("left_closed");
    public static final BooleanProperty LEFT_EXISTS = BooleanProperty.create("left_exists");
    public static final BooleanProperty RIGHT_CLOSED = BooleanProperty.create("right_closed");
    public static final BooleanProperty RIGHT_EXISTS = BooleanProperty.create("right_exists");

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public CurtainBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.SOUTH).setValue(CLOSED, false).setValue(LEFT_CLOSED, false).setValue(LEFT_EXISTS, false).setValue(RIGHT_CLOSED, false).setValue(RIGHT_EXISTS, false));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] ROD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 14.0, 0.0, 16.0, 16.0, 16.0), Direction.EAST));
        final VoxelShape[] CURTAIN_AREA_OPEN = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 2.0, 0.0, 16.0, 14.0, 16.0), Direction.EAST));
        final VoxelShape[] CURTAIN_AREA_CLOSED = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 1.0, 0.0, 16.0, 14.0, 16.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state: states)
        {
            boolean closed = state.getValue(CLOSED);
            Direction direction = state.getValue(DIRECTION);

            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(ROD[direction.get2DDataValue()]);
            if(closed) {
                shapes.add(CURTAIN_AREA_CLOSED[direction.get2DDataValue()]);
            } else {
                shapes.add(CURTAIN_AREA_OPEN[direction.get2DDataValue()]);
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
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;
        return this.getCurtainState(state, context.getLevel(), context.getClickedPos(), state.getValue(DIRECTION));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.setBlock(pos, state.cycle(CLOSED), 3);
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos) {
        return this.getCurtainState(state, level, pos, state.getValue(DIRECTION));
    }

    private BlockState getCurtainState(BlockState state, LevelAccessor level, BlockPos pos, Direction dir) {
        Direction leftDir = dir.getCounterClockWise();
        Direction rightDir = dir.getClockWise();

        BlockState leftState = level.getBlockState(pos.relative(leftDir));
        BlockState rightState = level.getBlockState(pos.relative(rightDir));

        boolean leftExists = leftState.getBlock() instanceof CurtainBlock && leftState.getValue(DIRECTION) == dir;
        boolean rightExists = rightState.getBlock() instanceof CurtainBlock && rightState.getValue(DIRECTION) == dir;

        return state.setValue(LEFT_EXISTS, leftExists)
                .setValue(LEFT_CLOSED, leftExists && leftState.getValue(CLOSED))
                .setValue(RIGHT_EXISTS, rightExists)
                .setValue(RIGHT_CLOSED, rightExists && rightState.getValue(CLOSED));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(CLOSED);
        builder.add(LEFT_CLOSED);
        builder.add(LEFT_EXISTS);
        builder.add(RIGHT_CLOSED);
        builder.add(RIGHT_EXISTS);
    }

}