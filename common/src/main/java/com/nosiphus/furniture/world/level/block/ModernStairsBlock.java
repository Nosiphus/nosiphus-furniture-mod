package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ModernStairsBlock extends FurnitureHorizontalBlock {

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ModernStairsBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.NONE));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] LOWER_STEP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 6.0, 8.0, 16.0, 8.0, 16.0), Direction.EAST));
        final VoxelShape[] UPPER_STEP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 14.0, 0.0, 16.0, 16.0, 8.0), Direction.EAST));
        final VoxelShape[] LOWER_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 0.0, 10.5, 9.5, 6.0, 13.5), Direction.EAST));
        final VoxelShape[] UPPER_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 8.0, 2.5, 9.5, 14.0, 5.5), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(LOWER_STEP[direction.get2DDataValue()]);
            shapes.add(UPPER_STEP[direction.get2DDataValue()]);
            shapes.add(LOWER_SUPPORT[direction.get2DDataValue()]);
            shapes.add(UPPER_SUPPORT[direction.get2DDataValue()]);

            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return SHAPES.get(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection().getClockWise());
        return this.getStairState(state, context.getLevel(), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return this.getStairState(state, level, pos);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        this.notifyDiagonalNeighbors(state, level, pos);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        if (!state.is(newState.getBlock())) {
            this.notifyDiagonalNeighbors(state, level, pos);
        }
    }

    private void notifyDiagonalNeighbors(BlockState state, Level level, BlockPos pos) {
        if (!level.isClientSide()) {
            Direction facing = state.getValue(DIRECTION);
            Direction climbDir = facing.getCounterClockWise();
            BlockPos upPos = pos.above().relative(climbDir);
            BlockPos downPos = pos.below().relative(climbDir.getOpposite());

            BlockState upState = level.getBlockState(upPos);
            if (upState.getBlock() instanceof ModernStairsBlock) {
                level.setBlock(upPos, ((ModernStairsBlock) upState.getBlock()).getStairState(upState, level, upPos), Block.UPDATE_ALL);
            }

            BlockState downState = level.getBlockState(downPos);
            if (downState.getBlock() instanceof ModernStairsBlock) {
                level.setBlock(downPos, ((ModernStairsBlock) downState.getBlock()).getStairState(downState, level, downPos), Block.UPDATE_ALL);
            }
        }
    }

    private BlockState getStairState(BlockState state, BlockGetter level, BlockPos pos) {
        Direction facing = state.getValue(DIRECTION);
        Direction climbDir = facing.getCounterClockWise();

        BlockState upState = level.getBlockState(pos.above().relative(climbDir));
        boolean up = upState.getBlock() == this && upState.getValue(DIRECTION) == facing;

        BlockState downState = level.getBlockState(pos.below().relative(climbDir.getOpposite()));
        boolean down = downState.getBlock() == this && downState.getValue(DIRECTION) == facing;

        Type type;
        if (up && down) {
            type = Type.BOTH;
        } else if (up) {
            type = Type.DOWN;
        } else if (down) {
            type = Type.UP;
        } else {
            type = Type.NONE;
        }

        return state.setValue(TYPE, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable {
        NONE("none"),
        UP("up"),
        DOWN("down"),
        BOTH("both");

        private final String id;

        Type(String id) {
            this.id = id;
        }

        @Override
        public String getSerializedName() {
            return id;
        }

        @Override
        public String toString() {
            return id;
        }
    }

}