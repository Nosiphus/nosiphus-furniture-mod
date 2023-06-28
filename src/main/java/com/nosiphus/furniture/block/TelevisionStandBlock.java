package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.tileentity.BasicLootBlockEntity;
import com.mrcrayfish.furniture.tileentity.CabinetBlockEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TelevisionStandBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public TelevisionStandBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.SINGLE).setValue(OPEN, false));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] TABLE_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 14.5, 1.0, 16.0, 16.0, 15.0), Direction.SOUTH));

        final VoxelShape[] NORTHWEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 2.0, 2.5, 3.5, 3.5), Direction.SOUTH));
        final VoxelShape[] NORTHEAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0.0, 2.0, 15.0, 3.5, 3.5), Direction.SOUTH));
        final VoxelShape[] SOUTHWEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 12.5, 2.5, 3.5, 14.0), Direction.SOUTH));
        final VoxelShape[] SOUTHEAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0.0, 12.5, 15.0, 3.5, 14.0), Direction.SOUTH));

        //Single
        final VoxelShape[] LEFT_SIDE_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 2.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_SIDE_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 5.0, 2.0, 15.0, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BACK_SIDE_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 5.0, 2.0, 13.5, 14.5, 3.5), Direction.SOUTH));
        final VoxelShape[] TOP_SHELF_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 9.0, 3.5, 13.5, 10.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BOTTOM_SHELF_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 3.5, 2.0, 15.0, 5.0, 14.0), Direction.SOUTH));

        //Left
        final VoxelShape[] LEFT_SIDE_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 2.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_SIDE_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.5, 5.0, 2.0, 16.0, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BACK_SIDE_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 5.0, 2.0, 14.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BOTTOM_SHELF_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 3.5, 2.0, 16.0, 5.0, 14.0), Direction.SOUTH));
        final VoxelShape[] DOOR_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 5.0, 13.5, 15.0, 14.0, 14.5), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_TOP_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 11.0, 14.5, 14.0, 12.0, 15.0), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 7.0, 15.0, 14.0, 12.0, 15.5), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_BOTTOM_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 7.0, 14.5, 14.0, 8.0, 15.0), Direction.SOUTH));

        //Right
        final VoxelShape[] LEFT_SIDE_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 2.0, 1.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_SIDE_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 5.0, 2.0, 15.0, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BACK_SIDE_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.5, 5.0, 2.0, 13.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BOTTOM_SHELF_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 3.5, 2.0, 15.0, 5.0, 14.0), Direction.SOUTH));
        final VoxelShape[] DOOR_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 13.5, 13.5, 14.0, 14.5), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_TOP_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 11.0, 14.5, 3.0, 12.0, 15.0), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 15.0, 3.0, 12.0, 15.5), Direction.SOUTH));
        final VoxelShape[] DOOR_HANDLE_BOTTOM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 14.5, 3.0, 8.0, 15.0), Direction.SOUTH));

        //Middle
        final VoxelShape[] LEFT_SIDE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 2.0, 0.5, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_SIDE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 5.0, 2.0, 16.0, 14.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BACK_SIDE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 5.0, 2.0, 15.5, 14.5, 3.5), Direction.SOUTH));
        final VoxelShape[] TOP_SHELF_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 9.0, 3.5, 15.5, 10.5, 14.0), Direction.SOUTH));
        final VoxelShape[] BOTTOM_SHELF_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 3.5, 2.0, 16.0, 5.0, 14.0), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state: states)
        {
            Direction direction = state.getValue(DIRECTION);
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(TABLE_TOP[direction.get2DDataValue()]);
            switch(type)
            {
                case SINGLE:
                    shapes.add(NORTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(NORTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(LEFT_SIDE_SINGLE[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BACK_SIDE_SINGLE[direction.get2DDataValue()]);
                    shapes.add(TOP_SHELF_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_SINGLE[direction.get2DDataValue()]);
                    break;
                case LEFT:
                    shapes.add(NORTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHWEST_LEG[direction.get2DDataValue()]);
                    shapes.add(LEFT_SIDE_LEFT[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE_LEFT[direction.get2DDataValue()]);
                    shapes.add(BACK_SIDE_LEFT[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_LEFT[direction.get2DDataValue()]);
                    shapes.add(DOOR_LEFT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_TOP_LEFT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_LEFT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_BOTTOM_LEFT[direction.get2DDataValue()]);
                    break;
                case RIGHT:
                    shapes.add(NORTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(SOUTHEAST_LEG[direction.get2DDataValue()]);
                    shapes.add(LEFT_SIDE_RIGHT[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE_RIGHT[direction.get2DDataValue()]);
                    shapes.add(BACK_SIDE_RIGHT[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_RIGHT[direction.get2DDataValue()]);
                    shapes.add(DOOR_RIGHT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_TOP_RIGHT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_RIGHT[direction.get2DDataValue()]);
                    shapes.add(DOOR_HANDLE_BOTTOM_RIGHT[direction.get2DDataValue()]);
                    break;
                case MIDDLE:
                    shapes.add(LEFT_SIDE_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(RIGHT_SIDE_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(BACK_SIDE_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(TOP_SHELF_MIDDLE[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_SHELF_MIDDLE[direction.get2DDataValue()]);
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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(state.getValue(DIRECTION).getOpposite() == result.getDirection())
        {
            if(!level.isClientSide())
            {
                if(level.getBlockEntity(pos) instanceof CabinetBlockEntity blockEntity)
                {
                    player.openMenu(blockEntity);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random)
    {
        if(level.getBlockEntity(pos) instanceof BasicLootBlockEntity blockEntity)
        {
            blockEntity.updateOpenerCount();
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
        builder.add(OPEN);
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new CabinetBlockEntity(pos, state);
    }

}