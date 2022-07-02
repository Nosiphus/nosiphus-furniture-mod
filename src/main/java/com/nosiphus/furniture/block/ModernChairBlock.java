package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalWaterloggedBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ModernChairBlock extends FurnitureHorizontalWaterloggedBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ModernChairBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BACKREST = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.1, 9.5, 11.5, 13.9, 19.5, 13.0), Direction.NORTH));
        final VoxelShape[] SEAT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.1, 8.0, 3.0, 13.9, 9.5, 14.0), Direction.SOUTH));
        final VoxelShape[] FRONT_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 7.0, 2.0, 14.0, 8.0, 3.5), Direction.NORTH));
        final VoxelShape[] LEFT_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 6.5, 12.5, 14.0, 8.0, 14.0), Direction.WEST));
        final VoxelShape[] RIGHT_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 6.5, 12.5, 13.0, 8.0, 14.0), Direction.EAST));
        final VoxelShape[] BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 6.5, 11.5, 14.0, 8.0, 13.0), Direction.NORTH));
        final VoxelShape[] FRONT_LEFT_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 12.5, 3.5, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] FRONT_RIGHT_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.5, 0.0, 12.5, 14.0, 8.0, 14.0), Direction.SOUTH));
        final VoxelShape[] LEFT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 12.5, 14.0, 1.5, 14.0), Direction.WEST));
        final VoxelShape[] RIGHT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 12.5, 14.0, 1.5, 14.0), Direction.EAST));
        final VoxelShape[] BACK_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 12.5, 14.0, 1.5, 14.0), Direction.NORTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BACKREST[direction.get2DDataValue()]);
            shapes.add(SEAT[direction.get2DDataValue()]);
            shapes.add(FRONT_BASE[direction.get2DDataValue()]);
            shapes.add(BACK_BASE[direction.get2DDataValue()]);
            shapes.add(LEFT_BASE[direction.get2DDataValue()]);
            shapes.add(RIGHT_BASE[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT_LEG[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_LEG[direction.get2DDataValue()]);
            shapes.add(LEFT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(RIGHT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(BACK_SUPPORT[direction.get2DDataValue()]);
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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        return SeatEntity.create(level, pos, 0.4, player, state.getValue(DIRECTION));
    }
}