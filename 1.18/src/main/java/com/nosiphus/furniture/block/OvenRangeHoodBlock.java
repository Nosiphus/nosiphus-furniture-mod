package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalWaterloggedBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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

public class OvenRangeHoodBlock extends FurnitureHorizontalWaterloggedBlock
{

    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public OvenRangeHoodBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(DOWN, false).setValue(LIT, true));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] MAIN_HOOD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.4, 0.0, 16.0, 3.2, 16.0), Direction.EAST));
        final VoxelShape[] CEILING_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.0, 4.0, 3.2, 16.0, 16.0, 12.8), Direction.EAST));
        final VoxelShape[] CEILING_VENT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.0, 0.0, 3.2, 16.0, 16.0, 12.8), Direction.EAST));
        final VoxelShape[] MAIN_HOOD_OVERLAY = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 3.2, 0.0, 16.0, 4.0, 16.0), Direction.EAST));
        final VoxelShape[] FAR_LEFT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 2.0, 7.0, 0.8, 3.0), Direction.EAST));
        final VoxelShape[] LEFT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 4.0, 7.0, 0.8, 5.0), Direction.EAST));
        final VoxelShape[] CENTER_LEFT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 6.0, 7.0, 0.8, 7.0), Direction.EAST));
        final VoxelShape[] CENTER_RIGHT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 9.0, 7.0, 0.8, 10.0), Direction.EAST));
        final VoxelShape[] RIGHT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 11.0, 7.0, 0.8, 13.0), Direction.EAST));
        final VoxelShape[] FAR_RIGHT_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 0.0, 13.0, 7.0, 0.8, 14.0), Direction.EAST));
        final VoxelShape[] BACK_LIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 0.0, 1.6, 14.4, 0.8, 14.4), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            boolean down = state.getValue(DOWN);
            List<VoxelShape> shapes = new ArrayList<>();
            if(!down) {

                shapes.add(MAIN_HOOD[direction.get2DDataValue()]);
                shapes.add(CEILING_SUPPORT[direction.get2DDataValue()]);
                shapes.add(MAIN_HOOD_OVERLAY[direction.get2DDataValue()]);
                shapes.add(FAR_LEFT_LIGHT[direction.get2DDataValue()]);
                shapes.add(LEFT_LIGHT[direction.get2DDataValue()]);
                shapes.add(CENTER_LEFT_LIGHT[direction.get2DDataValue()]);
                shapes.add(CENTER_RIGHT_LIGHT[direction.get2DDataValue()]);
                shapes.add(RIGHT_LIGHT[direction.get2DDataValue()]);
                shapes.add(FAR_RIGHT_LIGHT[direction.get2DDataValue()]);
                shapes.add(BACK_LIGHT[direction.get2DDataValue()]);

            } else if (down) {

                shapes.add(CEILING_VENT[direction.get2DDataValue()]);

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
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos)
    {
        boolean down = level.getBlockState(pos.below()).getBlock() == this;
        return state.setValue(DOWN, down);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(DOWN);
        builder.add(LIT);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if(state.getValue(LIT)) {
            level.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 2);
        } else {
            level.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 2);
        }
        return InteractionResult.SUCCESS;
    }
    
}