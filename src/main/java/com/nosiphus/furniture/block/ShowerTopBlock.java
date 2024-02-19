package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ShowerTopBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;
    private final Supplier<RegistryObject<Block>> bottom;

    public ShowerTopBlock(Properties properties, Supplier<RegistryObject<Block>> bottom)
    {
        super(properties);
        this.bottom = bottom;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] FRONT_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 1.0, 15.0, 1.0), Direction.EAST));
        final VoxelShape[] LEFT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0.0, 0.5, 15.5, 15.0, 0.6), Direction.EAST));
        final VoxelShape[] BACK_LEFT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 0.0, 0.0, 16.0, 15.0, 1.0), Direction.EAST));
        final VoxelShape[] BACK_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.5, 0.0, 0.5, 15.6, 15.0, 15.5), Direction.EAST));
        final VoxelShape[] BACK_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 0.0, 15.0, 16.0, 15.0, 16.0), Direction.EAST));
        final VoxelShape[] RIGHT_GLASS = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0.0, 15.5, 15.5, 15.0, 15.6), Direction.EAST));
        final VoxelShape[] FRONT_RIGHT_FRAME = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 15.0, 1.0, 15.0, 16.0), Direction.EAST));
        final VoxelShape[] FRONT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 1.0, 1.0, 16.0, 15.0), Direction.EAST));
        final VoxelShape[] LEFT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 1.0), Direction.EAST));
        final VoxelShape[] RIGHT_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 15.0, 15.0, 16.0, 16.0, 16.0), Direction.EAST));
        final VoxelShape[] BACK_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 15.0, 1.0, 16.0, 16.0, 15.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(FRONT_LEFT_FRAME[direction.get2DDataValue()]);
            shapes.add(LEFT_GLASS[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT_FRAME[direction.get2DDataValue()]);
            shapes.add(BACK_GLASS[direction.get2DDataValue()]);
            shapes.add(BACK_RIGHT_FRAME[direction.get2DDataValue()]);
            shapes.add(RIGHT_GLASS[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_FRAME[direction.get2DDataValue()]);
            shapes.add(FRONT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(LEFT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(RIGHT_SUPPORT[direction.get2DDataValue()]);
            shapes.add(BACK_SUPPORT[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player)
    {
        BlockState belowState = level.getBlockState(pos.below());
        if(belowState.getBlock() instanceof ShowerBottomBlock)
        {
            level.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, pos.below(), Block.getId(belowState));
        }
        super.playerWillDestroy(level, pos, state, player);
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

}