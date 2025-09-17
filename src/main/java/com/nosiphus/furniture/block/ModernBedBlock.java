package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ModernBedBlock extends FurnitureHorizontalBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public ModernBedBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.BACK));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {

        //Single Bed - Back
        final VoxelShape[] SINGLE_BACK_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 0.0, 15.0, 5.5, 14.0), Direction.EAST));
        final VoxelShape[] SINGLE_BACK_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 0.0, 1.0, 8.0, 14.0), Direction.EAST));
        final VoxelShape[] SINGLE_BACK_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 0.0, 16.0, 8.0, 14.0), Direction.EAST));
        final VoxelShape[] SINGLE_BACK_FRONTBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.0, 16.0, 7.0, 16.0), Direction.EAST));
        final VoxelShape[] SINGLE_BACK_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 0.0, 15.0, 9.0, 14.0), Direction.EAST));
        final VoxelShape[] SINGLE_BACK_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 14.0, 16.0, 8.0, 15.0), Direction.EAST));

        //Single Bed - Head
        final VoxelShape[] SINGLE_HEAD_HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 2.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_HEADBOARD_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 15.0, 0.0, 15.0, 16.0, 2.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_RIGHT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 2.0, 1.0, 8.0, 16.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_LEFT_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 2.0, 16.0, 8.0, 16.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 2.0, 15.0, 5.5, 16.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_BLANKET = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 8.0, 15.0, 9.0, 16.0), Direction.EAST));
        final VoxelShape[] SINGLE_HEAD_PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 15.0, 9.5, 8.0), Direction.EAST));


        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();

            switch(type) {
                case BACK:
                    shapes.add(SINGLE_BACK_BASE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_BACK_RIGHT_SIDE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_BACK_LEFT_SIDE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_BACK_FRONTBOARD[direction.get2DDataValue()]);
                    shapes.add(SINGLE_BACK_BLANKET[direction.get2DDataValue()]);
                    shapes.add(SINGLE_BACK_FRONT[direction.get2DDataValue()]);
                case HEAD:
                    shapes.add(SINGLE_HEAD_HEADBOARD[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_HEADBOARD_TOP[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_RIGHT_SIDE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_LEFT_SIDE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_BASE[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_BLANKET[direction.get2DDataValue()]);
                    shapes.add(SINGLE_HEAD_PILLOW[direction.get2DDataValue()]);
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