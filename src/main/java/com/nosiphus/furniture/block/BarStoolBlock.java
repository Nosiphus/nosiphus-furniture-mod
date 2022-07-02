package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class BarStoolBlock extends FurnitureHorizontalBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public BarStoolBlock(Properties properties) {

        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());

    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {

        final VoxelShape[] CUSHION = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.5, 12.0, 3.5, 12.5, 12.5, 12.5), Direction.NORTH));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 9.0, 3.0, 13.0, 12.0, 13.0), Direction.NORTH));
        final VoxelShape[] NORTH_WEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 0.0, 4.0, 6.0, 9.0, 6.0), Direction.NORTH));
        final VoxelShape[] NORTH_EAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.0, 0.0, 4.0, 12.0, 9.0, 6.0), Direction.NORTH));
        final VoxelShape[] SOUTH_WEST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 0.0, 10.0, 6.0, 9.0, 12.0), Direction.NORTH));
        final VoxelShape[] SOUTH_EAST_LEG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.0, 0.0, 10.0, 12.0, 9.0, 12.0), Direction.NORTH));
        final VoxelShape[] WEST_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 4.0, 6.0, 5.5, 5.0, 10.0), Direction.NORTH));
        final VoxelShape[] EAST_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.5, 4.0, 6.0, 11.5, 5.0, 10.0), Direction.NORTH));
        final VoxelShape[] SOUTH_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.0, 4.0, 10.5, 10.0, 5.0, 11.5), Direction.NORTH));
        final VoxelShape[] NORTH_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.0, 4.0, 4.5, 10.0, 5.0, 5.5), Direction.NORTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(CUSHION[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);
            shapes.add(NORTH_WEST_LEG[direction.get2DDataValue()]);
            shapes.add(NORTH_EAST_LEG[direction.get2DDataValue()]);
            shapes.add(SOUTH_WEST_LEG[direction.get2DDataValue()]);
            shapes.add(SOUTH_EAST_LEG[direction.get2DDataValue()]);
            shapes.add(WEST_SUPPORT[direction.get2DDataValue()]);
            shapes.add(EAST_SUPPORT[direction.get2DDataValue()]);
            shapes.add(SOUTH_SUPPORT[direction.get2DDataValue()]);
            shapes.add(NORTH_SUPPORT[direction.get2DDataValue()]);
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
        ItemStack stack = player.getItemInHand(hand);
        return SeatEntity.create(level, pos, 0.4, player, state.getValue(DIRECTION));
    }

}
