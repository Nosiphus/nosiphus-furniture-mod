package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.entity.ChoppingBoardBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ChoppingBoardBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ChoppingBoardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.EAST));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] CHOPPING_BOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.0, 0.0, 0.5, 13.0, 1.0, 15.5), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(CHOPPING_BOARD[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
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

    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos)
    {
        return 1.0F;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof ChoppingBoardBlockEntity blockEntity) {
                Containers.dropContents(level, pos, blockEntity);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (hitResult.getDirection() != Direction.UP) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (level.getBlockEntity(pos) instanceof ChoppingBoardBlockEntity blockEntity) {
            if (heldStack.is(ModItems.KNIFE.get())) {
                if (!level.isClientSide()) {
                    if (blockEntity.chopItem()) {
                        heldStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                    }
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (!heldStack.isEmpty()) {
                if (!level.isClientSide()) {
                    if (blockEntity.addItem(heldStack)) {
                        return ItemInteractionResult.SUCCESS;
                    }
                    blockEntity.removeItem();
                }
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ChoppingBoardBlockEntity blockEntity) {
            if (!level.isClientSide()) {
                blockEntity.removeItem();
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChoppingBoardBlockEntity(pos, state);
    }

}