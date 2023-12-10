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

public class ChristmasTreeBlock extends FurnitureHorizontalBlock
{

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ChristmasTreeBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {

        final VoxelShape[] POT_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 0.0, 4.5, 11.5, 1.0, 11.5), Direction.EAST));
        final VoxelShape[] POT_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.0, 0.5, 4.5, 12.0, 5.5, 11.5), Direction.EAST));
        final VoxelShape[] POT_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 0.5, 4.5, 5.0, 5.5, 11.5), Direction.EAST));
        final VoxelShape[] POT_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 0.5, 4.0, 11.5, 5.5, 5.0), Direction.EAST));
        final VoxelShape[] POT_4 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 0.5, 11.0, 11.5, 5.5, 12.0), Direction.EAST));
        final VoxelShape[] DIRT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 4.0, 5.0, 11.0, 5.0, 11.0), Direction.EAST));
        final VoxelShape[] STEM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 5.0, 7.0, 9.0, 16.0, 9.0), Direction.EAST));
        final VoxelShape[] LEAVES_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 7.0, 1.0, 15.0, 10.0, 15.0), Direction.EAST));
        final VoxelShape[] LEAVES_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 10.0, 2.0, 14.0, 13.0, 14.0), Direction.EAST));
        final VoxelShape[] LEAVES_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 13.0, 3.0, 13.0, 16.0, 13.0), Direction.EAST));
        final VoxelShape[] LEAVES_4 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 16.0, 4.0, 12.0, 19.0, 12.0), Direction.EAST));
        final VoxelShape[] LEAVES_5 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 19.0, 5.0, 11.0, 22.0, 11.0), Direction.EAST));
        final VoxelShape[] LEAVES_6 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.0, 22.0, 6.0, 10.0, 25.0, 10.0), Direction.EAST));
        final VoxelShape[] LEAVES_7 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 25.0, 7.0, 9.0, 28.0, 9.0), Direction.EAST));
        final VoxelShape[] STAR = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.0, 27.0, 7.5, 10.0, 31.0, 8.5), Direction.EAST));


        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(POT_BASE[direction.get2DDataValue()]);
            shapes.add(POT_1[direction.get2DDataValue()]);
            shapes.add(POT_2[direction.get2DDataValue()]);
            shapes.add(POT_3[direction.get2DDataValue()]);
            shapes.add(POT_4[direction.get2DDataValue()]);
            shapes.add(DIRT[direction.get2DDataValue()]);
            shapes.add(STEM[direction.get2DDataValue()]);
            shapes.add(LEAVES_1[direction.get2DDataValue()]);
            shapes.add(LEAVES_2[direction.get2DDataValue()]);
            shapes.add(LEAVES_3[direction.get2DDataValue()]);
            shapes.add(LEAVES_4[direction.get2DDataValue()]);
            shapes.add(LEAVES_5[direction.get2DDataValue()]);
            shapes.add(LEAVES_6[direction.get2DDataValue()]);
            shapes.add(LEAVES_7[direction.get2DDataValue()]);
            shapes.add(STAR[direction.get2DDataValue()]);
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
