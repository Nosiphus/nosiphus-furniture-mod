package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalWaterloggedBlock;
import com.mrcrayfish.furniture.entity.SeatEntity;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import com.nosiphus.furniture.blockentity.OfficeChairBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class OfficeChairBlock extends FurnitureHorizontalWaterloggedBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public OfficeChairBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BACK_RIGHT_EXTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 2.0, 3.1, 2.5, 4.5), Direction.SOUTH));
        final VoxelShape[] BACK_RIGHT_AXLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 0.2, 2.2, 3.4, 2.3, 4.3), Direction.SOUTH));
        final VoxelShape[] BACK_RIGHT_INTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.4, 0.0, 2.0, 4.5, 2.5, 4.5), Direction.SOUTH));
        final VoxelShape[] BACK_LEFT_INTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.5, 0.0, 2.0, 12.6, 2.5, 4.5), Direction.SOUTH));
        final VoxelShape[] BACK_LEFT_AXLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.6, 0.2, 2.2, 12.9, 2.3, 4.3), Direction.SOUTH));
        final VoxelShape[] BACK_LEFT_EXTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.9, 0.0, 2.0, 14.0, 2.5, 4.5), Direction.SOUTH));
        final VoxelShape[] FRONT_RIGHT_EXTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 0.0, 11.5, 3.1, 2.5, 13.0), Direction.SOUTH));
        final VoxelShape[] FRONT_RIGHT_AXLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.6, 0.2, 11.7, 12.9, 2.3, 13.8), Direction.SOUTH));
        final VoxelShape[] FRONT_RIGHT_INTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.4, 0.0, 11.5, 4.5, 2.5, 13.0), Direction.SOUTH));
        final VoxelShape[] FRONT_LEFT_INTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.5, 0.0, 11.5, 12.6, 2.5, 13.0), Direction.SOUTH));
        final VoxelShape[] FRONT_LEFT_AXLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.1, 0.2, 11.7, 3.4, 2.3, 13.8), Direction.SOUTH));
        final VoxelShape[] FRONT_LEFT_EXTERNAL_WHEEL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.9, 0.0, 11.5, 14.0, 2.5, 13.0), Direction.SOUTH));
        final VoxelShape[] CENTRAL_SUPPORT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 4.5, 7.0, 9.0, 9.5, 9.0), Direction.SOUTH));

        final VoxelShape[] CENTRAL_SUPPORT_CENTER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.0, 9.0, 6.0, 10.0, 9.5, 10.0), Direction.SOUTH));
        final VoxelShape[] CHAIR_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 9.5, 5.0, 13.5, 11.0, 15.0), Direction.SOUTH));
        final VoxelShape[] CHAIR_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.5, 12.0, 2.6, 13.5, 26.0, 4.1), Direction.SOUTH));
        final VoxelShape[] CHAIR_BOTTOM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.5, 10.0, 5.4, 2.5, 11.5, 13.0), Direction.SOUTH));
        final VoxelShape[] CHAIR_BACK_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.5, 12.3, 3.1, 2.5, 26.0, 4.6), Direction.SOUTH));
        final VoxelShape[] CHAIR_ARM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.5, 10.0, 13.0, 2.5, 15.0, 14.5), Direction.SOUTH));
        final VoxelShape[] CHAIR_ARMREST_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.2, 15.0, 2.8, 2.8, 15.5, 15.0), Direction.SOUTH));
        final VoxelShape[] CHAIR_BOTTOM_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 12.3, 3.1, 14.5, 26.0, 4.6), Direction.SOUTH));
        final VoxelShape[] CHAIR_BACK_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 10.0, 5.4, 14.5, 11.5, 13.0), Direction.SOUTH));
        final VoxelShape[] CHAIR_ARM_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 10.0, 13.0, 14.5, 15.0, 14.5), Direction.SOUTH));
        final VoxelShape[] CHAIR_ARMREST_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.2, 15.0, 2.8, 14.8, 15.5, 15.0), Direction.SOUTH));
        final VoxelShape[] PILLOW = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 22.0, 4.0, 11.0, 25.4, 4.5), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BACK_RIGHT_EXTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(BACK_RIGHT_AXLE[direction.get2DDataValue()]);
            shapes.add(BACK_RIGHT_INTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT_EXTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT_AXLE[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT_INTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_EXTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_AXLE[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT_INTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT_EXTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT_AXLE[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT_INTERNAL_WHEEL[direction.get2DDataValue()]);
            shapes.add(CENTRAL_SUPPORT[direction.get2DDataValue()]);


            /*
            if (Minecraft.getInstance().player != null && Minecraft.getInstance().player.getRidingEntity() instanceof SeatEntity) {
            } else {
            */
            shapes.add(CENTRAL_SUPPORT_CENTER[direction.get2DDataValue()]);
            shapes.add(CHAIR_BOTTOM[direction.get2DDataValue()]);
            shapes.add(CHAIR_BACK[direction.get2DDataValue()]);
            shapes.add(CHAIR_BOTTOM_RIGHT[direction.get2DDataValue()]);
            shapes.add(CHAIR_BACK_RIGHT[direction.get2DDataValue()]);
            shapes.add(CHAIR_ARM_RIGHT[direction.get2DDataValue()]);
            shapes.add(CHAIR_ARMREST_RIGHT[direction.get2DDataValue()]);
            shapes.add(CHAIR_BOTTOM_LEFT[direction.get2DDataValue()]);
            shapes.add(CHAIR_BACK_LEFT[direction.get2DDataValue()]);
            shapes.add(CHAIR_ARM_LEFT[direction.get2DDataValue()]);
            shapes.add(CHAIR_ARMREST_LEFT[direction.get2DDataValue()]);
            shapes.add(PILLOW[direction.get2DDataValue()]);
            // }

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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new OfficeChairBlockEntity(pos, state); }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        return SeatEntity.create(level, pos, 0.4, player, state.getValue(DIRECTION));
    }
}