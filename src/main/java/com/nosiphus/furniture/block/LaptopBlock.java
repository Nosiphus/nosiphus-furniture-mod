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

public class LaptopBlock extends FurnitureHorizontalBlock
{

    //This class is no longer used now that the Devices Mod exists, but it remains in case they ever decide to use the more detailed model file.

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public LaptopBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.SOUTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {

        final VoxelShape[] KEY_1A = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 1.0, 5.0, 3.0, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1B = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 1.0, 5.0, 4.1, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1C = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.2, 1.0, 5.0, 5.2, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1D = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.3, 1.0, 5.0, 6.3, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1E = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 1.0, 5.0, 7.4, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1F = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 1.0, 5.0, 8.5, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1G = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.6, 1.0, 5.0, 9.6, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1H = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.7, 1.0, 5.0, 10.7, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1I = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.8, 1.0, 5.0, 11.8, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1J = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.9, 1.0, 5.0, 12.9, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_1K = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 1.0, 5.0, 14.0, 1.1, 5.8), Direction.SOUTH));
        final VoxelShape[] KEY_2A = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 1.0, 6.1, 3.0, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2B = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 1.0, 6.1, 4.1, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2C = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.2, 1.0, 6.1, 5.2, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2D = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.3, 1.0, 6.1, 6.3, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2E = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 1.0, 6.1, 7.4, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2F = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 1.0, 6.1, 8.5, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2G = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.6, 1.0, 6.1, 9.6, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2H = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.7, 1.0, 6.1, 10.7, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2I = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.8, 1.0, 6.1, 11.8, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2J = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.9, 1.0, 6.1, 12.9, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_2K = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 1.0, 6.1, 14.0, 1.1, 7.1), Direction.SOUTH));
        final VoxelShape[] KEY_3A = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 1.0, 7.2, 3.0, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3B = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 1.0, 7.2, 4.1, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3C = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.2, 1.0, 7.2, 5.2, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3D = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.3, 1.0, 7.2, 6.3, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3E = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 1.0, 7.2, 7.4, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3F = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 1.0, 7.2, 8.5, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3G = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.6, 1.0, 7.2, 9.6, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3HI = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.7, 1.0, 7.2, 11.8, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3J = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.9, 1.0, 7.2, 12.9, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_3K = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 1.0, 7.2, 14.0, 1.1, 8.2), Direction.SOUTH));
        final VoxelShape[] KEY_4A = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 1.0, 8.3, 3.0, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4B = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 1.0, 8.3, 4.1, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4C = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.2, 1.0, 8.3, 5.2, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4D = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.3, 1.0, 8.3, 6.3, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4E = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 1.0, 8.3, 7.4, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4F = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 1.0, 8.3, 8.5, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4G = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.6, 1.0, 8.3, 9.6, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4H = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.7, 1.0, 8.3, 10.7, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4I = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.8, 1.0, 8.3, 11.8, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4J = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.9, 1.0, 8.3, 12.9, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_4K = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 1.0, 8.3, 14.0, 1.1, 9.3), Direction.SOUTH));
        final VoxelShape[] KEY_5A = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 1.0, 9.4, 3.0, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5B = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 1.0, 9.4, 4.1, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5CDEFG = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.2, 1.0, 9.4, 9.6, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5H = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.7, 1.0, 9.4, 10.7, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5I = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.8, 1.0, 9.4, 11.8, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5J = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.9, 1.0, 9.4, 12.9, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] KEY_5K = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 1.0, 9.4, 14.0, 1.1, 10.4), Direction.SOUTH));
        final VoxelShape[] TRACKPAD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 1.0, 11.5, 9.0, 1.1, 14.5), Direction.SOUTH));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 3.0, 15.0, 1.0, 15.0), Direction.SOUTH));
        final VoxelShape[] USB_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.98, 0.3, 6.0, 1.9, 0.8, 7.0), Direction.SOUTH));
        final VoxelShape[] USB_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.98, 0.3, 8.0, 1.9, 0.8, 9.0), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(KEY_1A[direction.get2DDataValue()]);
            shapes.add(KEY_1B[direction.get2DDataValue()]);
            shapes.add(KEY_1C[direction.get2DDataValue()]);
            shapes.add(KEY_1D[direction.get2DDataValue()]);
            shapes.add(KEY_1E[direction.get2DDataValue()]);
            shapes.add(KEY_1F[direction.get2DDataValue()]);
            shapes.add(KEY_1G[direction.get2DDataValue()]);
            shapes.add(KEY_1H[direction.get2DDataValue()]);
            shapes.add(KEY_1I[direction.get2DDataValue()]);
            shapes.add(KEY_1J[direction.get2DDataValue()]);
            shapes.add(KEY_1K[direction.get2DDataValue()]);
            shapes.add(KEY_2A[direction.get2DDataValue()]);
            shapes.add(KEY_2B[direction.get2DDataValue()]);
            shapes.add(KEY_2C[direction.get2DDataValue()]);
            shapes.add(KEY_2D[direction.get2DDataValue()]);
            shapes.add(KEY_2E[direction.get2DDataValue()]);
            shapes.add(KEY_2F[direction.get2DDataValue()]);
            shapes.add(KEY_2G[direction.get2DDataValue()]);
            shapes.add(KEY_2H[direction.get2DDataValue()]);
            shapes.add(KEY_2I[direction.get2DDataValue()]);
            shapes.add(KEY_2J[direction.get2DDataValue()]);
            shapes.add(KEY_2K[direction.get2DDataValue()]);
            shapes.add(KEY_3A[direction.get2DDataValue()]);
            shapes.add(KEY_3B[direction.get2DDataValue()]);
            shapes.add(KEY_3C[direction.get2DDataValue()]);
            shapes.add(KEY_3D[direction.get2DDataValue()]);
            shapes.add(KEY_3E[direction.get2DDataValue()]);
            shapes.add(KEY_3F[direction.get2DDataValue()]);
            shapes.add(KEY_3G[direction.get2DDataValue()]);
            shapes.add(KEY_3HI[direction.get2DDataValue()]);
            shapes.add(KEY_3J[direction.get2DDataValue()]);
            shapes.add(KEY_3K[direction.get2DDataValue()]);
            shapes.add(KEY_4A[direction.get2DDataValue()]);
            shapes.add(KEY_4B[direction.get2DDataValue()]);
            shapes.add(KEY_4C[direction.get2DDataValue()]);
            shapes.add(KEY_4D[direction.get2DDataValue()]);
            shapes.add(KEY_4E[direction.get2DDataValue()]);
            shapes.add(KEY_4F[direction.get2DDataValue()]);
            shapes.add(KEY_4G[direction.get2DDataValue()]);
            shapes.add(KEY_4H[direction.get2DDataValue()]);
            shapes.add(KEY_4I[direction.get2DDataValue()]);
            shapes.add(KEY_4J[direction.get2DDataValue()]);
            shapes.add(KEY_4K[direction.get2DDataValue()]);
            shapes.add(KEY_5A[direction.get2DDataValue()]);
            shapes.add(KEY_5B[direction.get2DDataValue()]);
            shapes.add(KEY_5CDEFG[direction.get2DDataValue()]);
            shapes.add(KEY_5H[direction.get2DDataValue()]);
            shapes.add(KEY_5I[direction.get2DDataValue()]);
            shapes.add(KEY_5J[direction.get2DDataValue()]);
            shapes.add(KEY_5K[direction.get2DDataValue()]);
            shapes.add(TRACKPAD[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);
            shapes.add(USB_1[direction.get2DDataValue()]);
            shapes.add(USB_2[direction.get2DDataValue()]);
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