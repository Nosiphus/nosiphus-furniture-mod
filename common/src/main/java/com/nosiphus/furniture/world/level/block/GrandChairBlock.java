package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.entity.decoration.SeatEntity;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GrandChairBlock extends FurnitureHorizontalBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public GrandChairBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.BOTTOM));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] LEG_LEFT_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 2.0, 4.0, 5.0, 4.0), Direction.EAST));
        final VoxelShape[] LEG_RIGHT_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 0.0, 2.0, 14.0, 5.0, 4.0), Direction.EAST));
        final VoxelShape[] LEG_RIGHT_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 0.0, 12.0, 14.0, 5.0, 14.0), Direction.EAST));
        final VoxelShape[] LEG_LEFT_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 12.0, 4.0, 5.0, 14.0), Direction.EAST));
        final VoxelShape[] BUM_REST = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 1.0, 14.0, 8.0, 15.0), Direction.EAST));
        final VoxelShape[] BACK_REST = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 1.0, 14.0, 16.0, 2.0), Direction.EAST));
        final VoxelShape[] ARM_REST_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 6.0, 1.0, 2.0, 12.0, 15.0), Direction.EAST));
        final VoxelShape[] ARM_REST_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 6.0, 1.0, 16.0, 12.0, 15.0), Direction.EAST));
        final VoxelShape[] SIDE_BOTTOM_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 12.0, 1.0, 2.0, 16.0, 5.0), Direction.EAST));
        final VoxelShape[] SIDE_BOTTOM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 12.0, 1.0, 16.0, 16.0, 5.0), Direction.EAST));
        final VoxelShape[] BUM_REST_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 1.0, 15.0, 7.0, 15.0), Direction.EAST));
        final VoxelShape[] BACK_REST_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 0.0, 14.0, 16.0, 1.0), Direction.EAST));
        final VoxelShape[] FRONT_WOOL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 6.0, 14.5, 14.0, 7.5, 15.5), Direction.EAST));

        final VoxelShape[] TOP_SIDE_BOTTOM_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 1.0, 2.0, 4.0, 5.0), Direction.EAST));
        final VoxelShape[] TOP_SIDE_TOP_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 1.0, 2.0, 12.0, 6.0), Direction.EAST));
        final VoxelShape[] TOP_SIDE_TOP_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 4.0, 1.0, 16.0, 12.0, 6.0), Direction.EAST));
        final VoxelShape[] TOP_SIDE_BOTTOM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 0.0, 1.0, 16.0, 4.0, 5.0), Direction.EAST));
        final VoxelShape[] BACK_REST_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 1.0, 14.0, 12.0, 2.0), Direction.EAST));
        final VoxelShape[] BACK_REST_BACK_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 0.0, 14.0, 12.0, 1.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();

            if(state.getValue(TYPE) == Type.TOP) {
                shapes.add(TOP_SIDE_BOTTOM_LEFT[direction.get2DDataValue()]);
                shapes.add(TOP_SIDE_TOP_LEFT[direction.get2DDataValue()]);
                shapes.add(TOP_SIDE_TOP_RIGHT[direction.get2DDataValue()]);
                shapes.add(TOP_SIDE_BOTTOM_RIGHT[direction.get2DDataValue()]);
                shapes.add(BACK_REST_2[direction.get2DDataValue()]);
                shapes.add(BACK_REST_BACK_2[direction.get2DDataValue()]);
            } else if (state.getValue(TYPE) == Type.BOTTOM) {
                shapes.add(LEG_LEFT_BACK[direction.get2DDataValue()]);
                shapes.add(LEG_RIGHT_BACK[direction.get2DDataValue()]);
                shapes.add(LEG_RIGHT_FRONT[direction.get2DDataValue()]);
                shapes.add(LEG_LEFT_FRONT[direction.get2DDataValue()]);
                shapes.add(BUM_REST[direction.get2DDataValue()]);
                shapes.add(BACK_REST[direction.get2DDataValue()]);
                shapes.add(ARM_REST_LEFT[direction.get2DDataValue()]);
                shapes.add(ARM_REST_RIGHT[direction.get2DDataValue()]);
                shapes.add(SIDE_BOTTOM_LEFT[direction.get2DDataValue()]);
                shapes.add(SIDE_BOTTOM_RIGHT[direction.get2DDataValue()]);
                shapes.add(BUM_REST_SUPPORT[direction.get2DDataValue()]);
                shapes.add(BACK_REST_BACK[direction.get2DDataValue()]);
                shapes.add(FRONT_WOOL[direction.get2DDataValue()]);
            }

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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return SeatEntity.create(level, pos, 0.5, player, state.getValue(DIRECTION).getCounterClockWise());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction playerDirection = context.getHorizontalDirection();
        Direction rotatedDirection = playerDirection.getClockWise();
        Level level = context.getLevel();
        BlockPos topPos = context.getClickedPos().above();
        if(level.getBlockState(topPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(topPos)) {
            return this.defaultBlockState().setValue(DIRECTION, rotatedDirection);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(!level.isClientSide()) {
            BlockPos topPos = pos.above();
            level.setBlock(topPos, state.setValue(TYPE, Type.TOP), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            Direction dir = state.getValue(TYPE) == Type.TOP ? Direction.DOWN : Direction.UP;
            BlockPos otherPos = pos.relative(dir);
            BlockState otherState = level.getBlockState(otherPos);
            if (otherState.is(this) && otherState.getValue(TYPE) != state.getValue(TYPE)) {
                level.destroyBlock(otherPos, false);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable {
        TOP("top"),
        BOTTOM("bottom");

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