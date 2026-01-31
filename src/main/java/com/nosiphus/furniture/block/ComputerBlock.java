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

public class ComputerBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ComputerBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] COMPUTER_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.5, 0.0, 2.0, 14.5, 4.8, 14.0), Direction.EAST));
        final VoxelShape[] KEYBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 1.0, 3.8, 1.0, 12.0), Direction.EAST));
        final VoxelShape[] MONITOR_BOTTOM_BEZEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 6.4, 2.0, 8.0, 7.4, 14.0), Direction.EAST));
        final VoxelShape[] MONITOR_TOP_BEZEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 15.0, 2.0, 8.0, 16.0, 14.0), Direction.EAST));
        final VoxelShape[] MONITOR_LEFT_BEZEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 7.4, 2.0, 8.0, 15.0, 3.0), Direction.EAST));
        final VoxelShape[] MONITOR_RIGHT_BEZEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 7.4, 13.0, 8.0, 15.0, 14.0), Direction.EAST));
        final VoxelShape[] MONITOR_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 7.4, 3.0, 14.0, 15.0, 13.0), Direction.EAST));
        final VoxelShape[] MONITOR_SCREEN = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.8, 7.4, 3.0, 6.4, 15.0, 13.0), Direction.EAST));
        final VoxelShape[] MONITOR_STAND = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.4, 4.8, 6.4, 10.6, 7.4, 9.6), Direction.EAST));
        final VoxelShape[] MONITOR_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.6, 4.8, 5.1, 11.4, 5.6, 10.9), Direction.EAST));
        final VoxelShape[] BUTTON_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 3.0, 3.0, 5.0, 4.0, 4.0), Direction.EAST));
        final VoxelShape[] COMPUTER_FRONT_PANEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 0.0, 2.0, 5.5, 4.8, 14.0), Direction.EAST));
        final VoxelShape[] BUTTON_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 3.0, 4.5, 5.0, 4.0, 5.5), Direction.EAST));
        final VoxelShape[] BUTTON_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.0, 3.0, 6.0, 5.0, 4.0, 7.0), Direction.EAST));
        final VoxelShape[] OPTICAL_DRIVE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.4, 3.0, 8.0, 5.4, 4.0, 13.0), Direction.EAST));
        final VoxelShape[] KEY_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 1.8, 2.2, 1.2, 2.6), Direction.EAST));
        final VoxelShape[] KEY_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 1.4, 3.4, 1.2, 2.2), Direction.EAST));
        final VoxelShape[] KEY_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 2.6, 3.4, 1.2, 3.4), Direction.EAST));
        final VoxelShape[] KEY_4 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 3.0, 2.2, 1.2, 3.8), Direction.EAST));
        final VoxelShape[] KEY_5 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 3.8, 3.4, 1.2, 4.6), Direction.EAST));
        final VoxelShape[] KEY_6 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 4.2, 2.2, 1.2, 5.0), Direction.EAST));
        final VoxelShape[] KEY_7 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 5.4, 2.2, 1.2, 6.2), Direction.EAST));
        final VoxelShape[] KEY_8 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 5.0, 3.4, 1.2, 5.8), Direction.EAST));
        final VoxelShape[] KEY_9 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 6.6, 2.2, 1.2, 7.4), Direction.EAST));
        final VoxelShape[] KEY_10 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 7.8, 2.2, 1.2, 8.6), Direction.EAST));
        final VoxelShape[] KEY_11 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 6.2, 3.4, 1.2, 7.0), Direction.EAST));
        final VoxelShape[] KEY_12 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 7.4, 3.4, 1.2, 8.2), Direction.EAST));
        final VoxelShape[] KEY_13 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 8.6, 3.4, 1.2, 9.4), Direction.EAST));
        final VoxelShape[] KEY_14 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 9.0, 2.2, 1.2, 9.8), Direction.EAST));
        final VoxelShape[] KEY_15 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.2, 9.8, 3.4, 1.2, 11.6), Direction.EAST));
        final VoxelShape[] KEY_16 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.4, 0.2, 10.2, 2.2, 1.2, 11.0), Direction.EAST));
        final VoxelShape[] MOUSE_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0.0, 13.0, 4.0, 1.0, 15.0), Direction.EAST));
        final VoxelShape[] MOUSE_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.1, 13.1, 3.8, 1.1, 13.9), Direction.EAST));
        final VoxelShape[] MOUSE_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.6, 0.1, 14.1, 3.8, 1.1, 14.9), Direction.EAST));


        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(COMPUTER_BASE[direction.get2DDataValue()]);
            shapes.add(KEYBOARD[direction.get2DDataValue()]);
            shapes.add(MONITOR_BOTTOM_BEZEL[direction.get2DDataValue()]);
            shapes.add(MONITOR_TOP_BEZEL[direction.get2DDataValue()]);
            shapes.add(MONITOR_LEFT_BEZEL[direction.get2DDataValue()]);
            shapes.add(MONITOR_RIGHT_BEZEL[direction.get2DDataValue()]);
            shapes.add(MONITOR_BACK[direction.get2DDataValue()]);
            shapes.add(MONITOR_SCREEN[direction.get2DDataValue()]);
            shapes.add(MONITOR_STAND[direction.get2DDataValue()]);
            shapes.add(MONITOR_BASE[direction.get2DDataValue()]);
            shapes.add(BUTTON_1[direction.get2DDataValue()]);
            shapes.add(COMPUTER_FRONT_PANEL[direction.get2DDataValue()]);
            shapes.add(BUTTON_2[direction.get2DDataValue()]);
            shapes.add(BUTTON_3[direction.get2DDataValue()]);
            shapes.add(OPTICAL_DRIVE[direction.get2DDataValue()]);
            shapes.add(KEY_1[direction.get2DDataValue()]);
            shapes.add(KEY_2[direction.get2DDataValue()]);
            shapes.add(KEY_3[direction.get2DDataValue()]);
            shapes.add(KEY_4[direction.get2DDataValue()]);
            shapes.add(KEY_5[direction.get2DDataValue()]);
            shapes.add(KEY_6[direction.get2DDataValue()]);
            shapes.add(KEY_7[direction.get2DDataValue()]);
            shapes.add(KEY_8[direction.get2DDataValue()]);
            shapes.add(KEY_9[direction.get2DDataValue()]);
            shapes.add(KEY_10[direction.get2DDataValue()]);
            shapes.add(KEY_11[direction.get2DDataValue()]);
            shapes.add(KEY_12[direction.get2DDataValue()]);
            shapes.add(KEY_13[direction.get2DDataValue()]);
            shapes.add(KEY_14[direction.get2DDataValue()]);
            shapes.add(KEY_15[direction.get2DDataValue()]);
            shapes.add(KEY_16[direction.get2DDataValue()]);
            shapes.add(MOUSE_BASE[direction.get2DDataValue()]);
            shapes.add(MOUSE_LEFT[direction.get2DDataValue()]);
            shapes.add(MOUSE_RIGHT[direction.get2DDataValue()]);
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