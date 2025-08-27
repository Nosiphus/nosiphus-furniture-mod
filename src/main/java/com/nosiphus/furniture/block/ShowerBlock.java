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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ShowerBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public ShowerBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.BOTTOM));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BOTTOM_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0), Direction.EAST));
        final VoxelShape[] BOTTOM_FRONT_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 1.0, 0.0, 1.0, 16.0, 1.0), Direction.EAST));
        final VoxelShape[] BOTTOM_LEFT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 1.0, 0.5, 15.5, 16.0, 0.6), Direction.EAST));
        final VoxelShape[] BOTTOM_BACK_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 1.0, 0.0, 16.0, 16.0, 1.0), Direction.EAST));
        final VoxelShape[] BOTTOM_BACK_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 1.0, 0.5, 15.6, 16.0, 15.5), Direction.EAST));
        final VoxelShape[] BOTTOM_BACK_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 1.0, 15.0, 16.0, 16.0, 16.0), Direction.EAST));
        final VoxelShape[] BOTTOM_RIGHT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 1.0, 15.5, 15.5, 16.0, 15.6), Direction.EAST));
        final VoxelShape[] BOTTOM_FRONT_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 1.0, 15.0, 1.0, 16.0, 16.0), Direction.EAST));

        final VoxelShape[] TOP_FRONT_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 1.0, 15.0, 1.0), Direction.EAST));
        final VoxelShape[] TOP_LEFT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0.0, 0.5, 15.5, 15.0, 0.6), Direction.EAST));
        final VoxelShape[] TOP_BACK_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 0.0, 0.0, 16.0, 15.0, 1.0), Direction.EAST));
        final VoxelShape[] TOP_BACK_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 0.0, 0.5, 15.6, 15.0, 15.5), Direction.EAST));
        final VoxelShape[] TOP_BACK_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 0.0, 15.0, 16.0, 15.0, 16.0), Direction.EAST));
        final VoxelShape[] TOP_RIGHT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0.0, 15.5, 15.5, 15.0, 15.6), Direction.EAST));
        final VoxelShape[] TOP_FRONT_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 15.0, 1.0, 15.0, 16.0), Direction.EAST));
        final VoxelShape[] TOP_FRONT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 1.0, 1.0, 16.0, 15.0), Direction.EAST));
        final VoxelShape[] TOP_LEFT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 1.0), Direction.EAST));
        final VoxelShape[] TOP_RIGHT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 15.0, 16.0, 16.0, 16.0), Direction.EAST));
        final VoxelShape[] TOP_BACK_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 15.0, 1.0, 16.0, 16.0, 15.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();

            if(state.getValue(TYPE) == Type.TOP) {
                shapes.add(TOP_FRONT_LEFT_FRAME[direction.get2DDataValue()]);
                shapes.add(TOP_LEFT_GLASS[direction.get2DDataValue()]);
                shapes.add(TOP_BACK_LEFT_FRAME[direction.get2DDataValue()]);
                shapes.add(TOP_BACK_GLASS[direction.get2DDataValue()]);
                shapes.add(TOP_BACK_RIGHT_FRAME[direction.get2DDataValue()]);
                shapes.add(TOP_RIGHT_GLASS[direction.get2DDataValue()]);
                shapes.add(TOP_FRONT_RIGHT_FRAME[direction.get2DDataValue()]);
                shapes.add(TOP_FRONT_SUPPORT[direction.get2DDataValue()]);
                shapes.add(TOP_LEFT_SUPPORT[direction.get2DDataValue()]);
                shapes.add(TOP_RIGHT_SUPPORT[direction.get2DDataValue()]);
                shapes.add(TOP_BACK_SUPPORT[direction.get2DDataValue()]);
            } else if (state.getValue(TYPE) == Type.BOTTOM) {
                shapes.add(BOTTOM_BASE[direction.get2DDataValue()]);
                shapes.add(BOTTOM_FRONT_LEFT_FRAME[direction.get2DDataValue()]);
                shapes.add(BOTTOM_LEFT_GLASS[direction.get2DDataValue()]);
                shapes.add(BOTTOM_BACK_LEFT_FRAME[direction.get2DDataValue()]);
                shapes.add(BOTTOM_BACK_GLASS[direction.get2DDataValue()]);
                shapes.add(BOTTOM_BACK_RIGHT_FRAME[direction.get2DDataValue()]);
                shapes.add(BOTTOM_RIGHT_GLASS[direction.get2DDataValue()]);
                shapes.add(BOTTOM_FRONT_RIGHT_FRAME[direction.get2DDataValue()]);
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

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        Level level = context.getLevel();
        BlockPos topPos = context.getClickedPos().relative(Direction.UP);
        if(level.getBlockState(topPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(topPos)) {
            return this.defaultBlockState().setValue(DIRECTION, direction);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(!level.isClientSide()) {
            BlockPos topPos = pos.relative(Direction.UP);
            level.setBlock(topPos, state.setValue(TYPE, Type.TOP), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        if (!state.is(newState.getBlock())) {
            Type type = state.getValue(TYPE);
            Direction otherDirection = (type == Type.TOP) ? Direction.DOWN : Direction.UP;
            BlockPos otherPos = pos.relative(otherDirection);
            BlockState otherState = level.getBlockState(otherPos);
            if (otherState.getBlock() instanceof ShowerBlock && otherState.getValue(TYPE) != type) {
                level.removeBlock(otherPos, false);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
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