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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BathBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public BathBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.BACK));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] HEAD_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Direction.EAST));
        final VoxelShape[] HEAD_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 0.0, 16.0, 14.0, 2.0), Direction.EAST));
        final VoxelShape[] HEAD_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 14.0, 16.0, 14.0, 16.0), Direction.EAST));
        final VoxelShape[] HEAD_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 2.0, 2.0, 16.0, 14.0, 14.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 7.0, 15.0, 18.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 18.0, 7.0, 15.0, 20.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_HOLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 17.68, 7.0, 11.0, 18.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_HOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 2.0, 15.0, 16.0, 4.0), Direction.EAST));
        final VoxelShape[] HEAD_COLD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 12.0, 15.0, 16.0, 14.0), Direction.EAST));

        final VoxelShape[] BACK_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Direction.EAST));
        final VoxelShape[] BACK_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 0.0, 16.0, 14.0, 2.0), Direction.EAST));
        final VoxelShape[] BACK_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 14.0, 16.0, 14.0, 16.0), Direction.EAST));
        final VoxelShape[] BACK_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 2.0, 2.0, 14.0, 14.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();

            if(state.getValue(TYPE) == Type.HEAD) {
                shapes.add(HEAD_BOTTOM[direction.get2DDataValue()]);
                shapes.add(HEAD_LEFT[direction.get2DDataValue()]);
                shapes.add(HEAD_RIGHT[direction.get2DDataValue()]);
                shapes.add(HEAD_FRONT[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_BASE[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_TOP[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_HOLE[direction.get2DDataValue()]);
                shapes.add(HEAD_HOT[direction.get2DDataValue()]);
                shapes.add(HEAD_COLD[direction.get2DDataValue()]);
            } else if (state.getValue(TYPE) == Type.BACK) {
                shapes.add(BACK_BOTTOM[direction.get2DDataValue()]);
                shapes.add(BACK_LEFT[direction.get2DDataValue()]);
                shapes.add(BACK_RIGHT[direction.get2DDataValue()]);
                shapes.add(BACK_BACK[direction.get2DDataValue()]);
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
        BlockPos headPos = context.getClickedPos().relative(direction);
        if(level.getBlockState(headPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(headPos)) {
            return this.defaultBlockState().setValue(DIRECTION, direction);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(!level.isClientSide()) {
            BlockPos headPos = pos.relative(state.getValue(DIRECTION));
            level.setBlock(headPos, state.setValue(TYPE, Type.HEAD), Block.UPDATE_ALL);
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
            Type type = state.getValue(TYPE);
            BlockPos otherPos = pos.relative(type == Type.HEAD ? direction.getOpposite() : direction);
            BlockState otherState = level.getBlockState(otherPos);
            if(otherState.getBlock() instanceof BathBlock && otherState.getValue(TYPE) != type)
            {
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