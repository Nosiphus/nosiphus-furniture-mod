package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.block.entity.PrinterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PrinterBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public PrinterBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.8, 3.0, 1.0, 12.8, 6.0, 15.0), Direction.EAST));
        final VoxelShape[] BACK_TRAY = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.8, 1.0, 3.0, 15.8, 9.6, 13.0), Direction.EAST));
        final VoxelShape[] FRONT_TRAY = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.5, 3.0, 4.8, 1.5, 13.0), Direction.EAST));
        final VoxelShape[] BACK_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.8, 1.0, 3.0, 14.8, 5.4, 4.0), Direction.EAST));
        final VoxelShape[] BACK_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.8, 1.0, 12.0, 14.8, 5.4, 13.0), Direction.EAST));
        final VoxelShape[] PAPER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.4, 2.0, 4.5, 14.4, 12.2, 11.5), Direction.EAST));
        final VoxelShape[] BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.8, 0.0, 1.0, 12.8, 1.5, 15.0), Direction.EAST));
        final VoxelShape[] BOTTOM_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.8, 1.5, 1.0, 12.8, 3.0, 15.0), Direction.EAST));
        final VoxelShape[] FRONT_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.8, 1.5, 1.0, 5.8, 3.0, 3.0), Direction.EAST));
        final VoxelShape[] FRONT_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.8, 1.5, 13.0, 5.8, 3.0, 15.0), Direction.EAST));
        final VoxelShape[] BOTTOM_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.8, 1.0, 4.0, 14.8, 2.0, 12.0), Direction.EAST));
        final VoxelShape[] BUTTON_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.4, 4.0, 2.0, 5.4, 5.0, 3.0), Direction.EAST));
        final VoxelShape[] BUTTON_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.4, 4.0, 3.5, 5.4, 5.0, 4.5), Direction.EAST));
        final VoxelShape[] BUTTON_3 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.4, 4.0, 5.0, 5.4, 5.0, 6.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(TOP[direction.get2DDataValue()]);
            shapes.add(BACK_TRAY[direction.get2DDataValue()]);
            shapes.add(FRONT_TRAY[direction.get2DDataValue()]);
            shapes.add(BACK_LEFT[direction.get2DDataValue()]);
            shapes.add(BACK_RIGHT[direction.get2DDataValue()]);
            shapes.add(PAPER[direction.get2DDataValue()]);
            shapes.add(BOTTOM[direction.get2DDataValue()]);
            shapes.add(BOTTOM_RIGHT[direction.get2DDataValue()]);
            shapes.add(FRONT_LEFT[direction.get2DDataValue()]);
            shapes.add(FRONT_RIGHT[direction.get2DDataValue()]);
            shapes.add(BOTTOM_BACK[direction.get2DDataValue()]);
            shapes.add(BUTTON_1[direction.get2DDataValue()]);
            shapes.add(BUTTON_2[direction.get2DDataValue()]);
            shapes.add(BUTTON_3[direction.get2DDataValue()]);

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
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PrinterBlockEntity) {
                ((PrinterBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (level.getBlockEntity(pos) instanceof PrinterBlockEntity blockEntity) {
                player.openMenu(blockEntity, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PrinterBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntityTypes.PRINTER.get(), PrinterBlockEntity::tick);
    }

}