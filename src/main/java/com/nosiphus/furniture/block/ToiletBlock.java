package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import com.nosiphus.furniture.core.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
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

public class ToiletBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ToiletBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] LEFT_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 8.16, 12.8, 18.4, 9.76), Direction.EAST));
        final VoxelShape[] RIGHT_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 6.24, 12.8, 18.4, 7.84), Direction.EAST));
        final VoxelShape[] TANK_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.6, 16.0, 1.6, 16.0, 17.6, 14.4), Direction.EAST));
        final VoxelShape[] TANK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.4, 4.8, 2.4, 16.0, 16.0, 13.6), Direction.EAST));
        final VoxelShape[] RIGHT_BOWL_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 2.4, 10.4, 9.6, 4.0), Direction.EAST));
        final VoxelShape[] FRONT_BOWL_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 4.0, 3.2, 9.6, 12.0), Direction.EAST));
        final VoxelShape[] LEFT_BOWL_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 12.0, 10.4, 9.6, 13.6), Direction.EAST));
        final VoxelShape[] RIGHT_BOWL_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 4.0, 11.2, 5.6, 6.4), Direction.EAST));
        final VoxelShape[] LEFT_BOWL_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 9.6, 11.2, 5.6, 12.0), Direction.EAST));
        final VoxelShape[] BOWL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 4.8, 4.0, 11.2, 6.4, 12.0), Direction.EAST));
        final VoxelShape[] WATER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 6.4, 6.4, 11.2, 6.416, 9.6), Direction.EAST));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 0.0, 4.0, 14.4, 4.8, 12.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(LEFT_TOP[direction.get2DDataValue()]);
            shapes.add(RIGHT_TOP[direction.get2DDataValue()]);
            shapes.add(TANK_TOP[direction.get2DDataValue()]);
            shapes.add(TANK[direction.get2DDataValue()]);
            shapes.add(RIGHT_BOWL_SIDE[direction.get2DDataValue()]);
            shapes.add(FRONT_BOWL_SIDE[direction.get2DDataValue()]);
            shapes.add(LEFT_BOWL_SIDE[direction.get2DDataValue()]);
            shapes.add(RIGHT_BOWL_BOTTOM[direction.get2DDataValue()]);
            shapes.add(LEFT_BOWL_BOTTOM[direction.get2DDataValue()]);
            shapes.add(BOWL[direction.get2DDataValue()]);
            shapes.add(WATER[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);
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
        if(!level.isClientSide) {
            if (player.isCrouching()) {

                level.playSound(null, pos, ModSounds.BLOCK_TOILET_FLUSH.get(), SoundSource.BLOCKS, 0.75F, 1.0F);

            } else {
                return SeatEntity.create(level, pos, 0.4, player, state.getValue(DIRECTION));
            }
        }
        return InteractionResult.SUCCESS;
    }
}