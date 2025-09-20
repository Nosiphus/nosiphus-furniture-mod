package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ModernBedBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final EnumProperty<Connected> CONNECTED = EnumProperty.create("connected", Connected.class);
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public ModernBedBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(CONNECTED, Connected.SINGLE).setValue(TYPE, Type.BACK));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {

        //Single Bed - Back
        final VoxelShape[] SINGLE_BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 0.0, 15.0, 5.5, 14.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_BACK_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 0.0, 1.0, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_BACK_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 0.0, 16.0, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_BACK_FOOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.0, 16.0, 7.0, 16.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_BACK_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 0.0, 15.0, 9.0, 14.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_BACK_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 14.0, 16.0, 8.0, 15.0), Direction.SOUTH));

        //Single Bed - Head
        final VoxelShape[] SINGLE_HEAD_HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 2.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_HEADBOARD_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 15.0, 0.0, 15.0, 16.0, 2.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 2.0, 1.0, 8.0, 16.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 2.0, 16.0, 8.0, 16.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 2.0, 15.0, 5.5, 16.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 8.0, 15.0, 9.0, 16.0), Direction.SOUTH));
        final VoxelShape[] SINGLE_HEAD_PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 15.0, 9.5, 8.0), Direction.SOUTH));

        //Left Bed - Back
        final VoxelShape[] LEFT_BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 0.0, 16.0, 5.5, 15.0), Direction.SOUTH));
        final VoxelShape[] LEFT_BACK_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 0.0, 1.0, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] LEFT_BACK_FOOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.0, 16.0, 7.0, 16.0), Direction.SOUTH));
        final VoxelShape[] LEFT_BACK_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 0.0, 16.0, 9.0, 14.0), Direction.SOUTH));
        final VoxelShape[] LEFT_BACK_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 14.0, 16.0, 8.0, 15.0), Direction.SOUTH));

        //Left Bed - Head
        final VoxelShape[] LEFT_HEAD_HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 2.0), Direction.SOUTH));
        final VoxelShape[] LEFT_HEAD_HEADBOARD_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 15.0, 0.0, 16.0, 16.0, 2.0), Direction.SOUTH));
        final VoxelShape[] LEFT_HEAD_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 2.0, 1.0, 8.0, 16.0), Direction.SOUTH));
        final VoxelShape[] LEFT_HEAD_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 2.0, 16.0, 5.5, 16.0), Direction.SOUTH));
        final VoxelShape[] LEFT_HEAD_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 8.0, 16.0, 9.0, 16.0), Direction.SOUTH));
        final VoxelShape[] LEFT_HEAD_PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 16.0, 9.5, 8.0), Direction.SOUTH));

        //Right Bed - Back
        final VoxelShape[] RIGHT_BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.5, 0.0, 15.0, 5.5, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_BACK_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 0.0, 16.0, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_BACK_FOOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.0, 16.0, 7.0, 16.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_BACK_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 0.0, 15.0, 9.0, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_BACK_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 14.0, 16.0, 8.0, 15.0), Direction.SOUTH));

        //Right Bed - Head
        final VoxelShape[] RIGHT_HEAD_HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 2.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_HEAD_HEADBOARD_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 0.0, 15.0, 16.0, 2.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_HEAD_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 2.0, 16.0, 8.0, 16.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_HEAD_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.5, 2.0, 15.0, 5.5, 16.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_HEAD_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 8.0, 15.0, 9.0, 16.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_HEAD_PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 2.0, 15.0, 9.5, 8.0), Direction.SOUTH));

        //Middle Bed - Back
        final VoxelShape[] MIDDLE_BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.5, 0.0, 16.0, 5.5, 14.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_BACK_FOOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.0, 16.0, 7.0, 16.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_BACK_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 0.0, 16.0, 9.0, 14.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_BACK_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 14.0, 16.0, 8.0, 15.0), Direction.SOUTH));

        //Middle Bed - Head
        final VoxelShape[] MIDDLE_HEAD_HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_HEAD_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.5, 2.0, 16.0, 5.5, 16.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_HEAD_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 8.0, 16.0, 9.0, 16.0), Direction.SOUTH));
        final VoxelShape[] MIDDLE_HEAD_PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 2.0, 16.0, 9.5, 8.0), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            Connected connected = state.getValue(CONNECTED);
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();

            switch(connected) {
                case SINGLE:
                    switch(type) {
                        case BACK:
                            shapes.add(SINGLE_BACK_BASE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_BACK_LEFT_SIDE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_BACK_RIGHT_SIDE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_BACK_FOOT[direction.get2DDataValue()]);
                            shapes.add(SINGLE_BACK_BLANKET[direction.get2DDataValue()]);
                            shapes.add(SINGLE_BACK_FRONT[direction.get2DDataValue()]);
                            break;
                        case HEAD:
                            shapes.add(SINGLE_HEAD_HEADBOARD[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_HEADBOARD_TOP[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_LEFT_SIDE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_RIGHT_SIDE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_BASE[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_BLANKET[direction.get2DDataValue()]);
                            shapes.add(SINGLE_HEAD_PILLOW[direction.get2DDataValue()]);
                            break;
                    }
                    break;
                case LEFT:
                    switch(type) {
                        case BACK:
                            shapes.add(LEFT_BACK_BASE[direction.get2DDataValue()]);
                            shapes.add(LEFT_BACK_LEFT_SIDE[direction.get2DDataValue()]);
                            shapes.add(LEFT_BACK_FOOT[direction.get2DDataValue()]);
                            shapes.add(LEFT_BACK_BLANKET[direction.get2DDataValue()]);
                            shapes.add(LEFT_BACK_FRONT[direction.get2DDataValue()]);
                            break;
                        case HEAD:
                            shapes.add(LEFT_HEAD_HEADBOARD[direction.get2DDataValue()]);
                            shapes.add(LEFT_HEAD_HEADBOARD_TOP[direction.get2DDataValue()]);
                            shapes.add(LEFT_HEAD_LEFT_SIDE[direction.get2DDataValue()]);
                            shapes.add(LEFT_HEAD_BASE[direction.get2DDataValue()]);
                            shapes.add(LEFT_HEAD_BLANKET[direction.get2DDataValue()]);
                            shapes.add(LEFT_HEAD_PILLOW[direction.get2DDataValue()]);
                            break;
                    }
                    break;
                case RIGHT:
                    switch(type) {
                        case BACK:
                            shapes.add(RIGHT_BACK_BASE[direction.get2DDataValue()]);
                            shapes.add(RIGHT_BACK_RIGHT_SIDE[direction.get2DDataValue()]);
                            shapes.add(RIGHT_BACK_FOOT[direction.get2DDataValue()]);
                            shapes.add(RIGHT_BACK_BLANKET[direction.get2DDataValue()]);
                            shapes.add(RIGHT_BACK_FRONT[direction.get2DDataValue()]);
                            break;
                        case HEAD:
                            shapes.add(RIGHT_HEAD_HEADBOARD[direction.get2DDataValue()]);
                            shapes.add(RIGHT_HEAD_HEADBOARD_TOP[direction.get2DDataValue()]);
                            shapes.add(RIGHT_HEAD_RIGHT_SIDE[direction.get2DDataValue()]);
                            shapes.add(RIGHT_HEAD_BASE[direction.get2DDataValue()]);
                            shapes.add(RIGHT_HEAD_BLANKET[direction.get2DDataValue()]);
                            shapes.add(RIGHT_HEAD_PILLOW[direction.get2DDataValue()]);
                            break;
                    }
                    break;
                case MIDDLE:
                    switch(type) {
                        case BACK:
                            shapes.add(MIDDLE_BACK_BASE[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_BACK_FOOT[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_BACK_BLANKET[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_BACK_FRONT[direction.get2DDataValue()]);
                            break;
                        case HEAD:
                            shapes.add(MIDDLE_HEAD_HEADBOARD[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_HEAD_BASE[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_HEAD_BLANKET[direction.get2DDataValue()]);
                            shapes.add(MIDDLE_HEAD_PILLOW[direction.get2DDataValue()]);
                            break;
                    }
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
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return SHAPES.get(state);
    }

    //use

    //newBlockEntity

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        Level level = context.getLevel();
        BlockPos headPos = context.getClickedPos().relative(direction);
        if(level.getBlockState(headPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(headPos)) {
            BlockState state = this.defaultBlockState().setValue(DIRECTION, direction);
            return this.getModernBedState(state, context.getLevel(), context.getClickedPos(), state.getValue(DIRECTION));
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(!level.isClientSide()) {
            BlockPos headPos = pos.relative(state.getValue(DIRECTION));
            level.setBlock(headPos, state.setValue(TYPE, ModernBedBlock.Type.HEAD), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        super.onRemove(state, level, pos, newState, isMoving);
        if(!state.is(newState.getBlock()))
        {
            Direction direction = state.getValue(DIRECTION);
            ModernBedBlock.Type type = state.getValue(TYPE);
            BlockPos otherPos = pos.relative(type == ModernBedBlock.Type.HEAD ? direction.getOpposite() : direction);
            BlockState otherState = level.getBlockState(otherPos);
            if(otherState.getBlock() instanceof ModernBedBlock && otherState.getValue(TYPE) != type)
            {
                level.removeBlock(otherPos, false);
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos) {
        return this.getModernBedState(state, level, pos, state.getValue(DIRECTION));
    }

    private BlockState getModernBedState(BlockState state, LevelAccessor level, BlockPos pos, Direction dir) {
        boolean left = this.isModernBed(level, pos, dir.getCounterClockWise(), dir) || this.isModernBed(level, pos, dir.getCounterClockWise(), dir.getCounterClockWise());
        boolean right = this.isModernBed(level, pos, dir.getClockWise(), dir) || this.isModernBed(level, pos, dir.getClockWise(), dir.getClockWise());

        if(left && right) {
            return state.setValue(CONNECTED, Connected.MIDDLE);
        } else if (left) {
            return state.setValue(CONNECTED, Connected.RIGHT);
        } else if (right) {
            return state.setValue(CONNECTED, Connected.LEFT);
        }
        return state.setValue(CONNECTED, Connected.SINGLE);
    }

    private boolean isModernBed(LevelAccessor level, BlockPos source, Direction direction, Direction targetDirection) {
        BlockState state = level.getBlockState(source.relative(direction));
        if(state.getBlock() == this) {
            Direction bedDirection = state.getValue(DIRECTION);
            return bedDirection.equals(targetDirection);
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(CONNECTED);
        builder.add(TYPE);
    }

    public enum Connected implements StringRepresentable {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle");

        private final String name;

        Connected(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    public enum Type implements StringRepresentable {
        HEAD("head"),
        BACK("back");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}