package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class WreathBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public WreathBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] WREATH = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 2.0, 0.0, 14.0, 14.0, 3.0), Direction.SOUTH));
        final VoxelShape[] DECORATION_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 7.5, 2.5, 3.5, 8.5, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.5, 10.0, 2.5, 4.5, 11.0, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.5, 11.5, 2.5, 6.5, 12.5, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_4 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.0, 12.5, 2.5, 9.0, 13.5, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_5 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.0, 11.5, 2.5, 11.0, 12.5, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_6 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 10.0, 2.5, 13.0, 11.0, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_7 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.5, 7.0, 2.5, 13.5, 8.0, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_8 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.5, 4.0, 2.5, 11.5, 5.0, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_9 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.0, 3.0, 2.5, 9.0, 4.0, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_10 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 3.5, 2.5, 6.0, 4.5, 3.5), Direction.SOUTH));
        final VoxelShape[] DECORATION_11 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 5.5, 2.5, 4.0, 6.5, 3.5), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(WREATH[direction.get2DDataValue()]);
            shapes.add(DECORATION_1[direction.get2DDataValue()]);
            shapes.add(DECORATION_2[direction.get2DDataValue()]);
            shapes.add(DECORATION_3[direction.get2DDataValue()]);
            shapes.add(DECORATION_4[direction.get2DDataValue()]);
            shapes.add(DECORATION_5[direction.get2DDataValue()]);
            shapes.add(DECORATION_6[direction.get2DDataValue()]);
            shapes.add(DECORATION_7[direction.get2DDataValue()]);
            shapes.add(DECORATION_8[direction.get2DDataValue()]);
            shapes.add(DECORATION_9[direction.get2DDataValue()]);
            shapes.add(DECORATION_10[direction.get2DDataValue()]);
            shapes.add(DECORATION_11[direction.get2DDataValue()]);
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

}