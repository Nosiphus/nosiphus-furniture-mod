package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.CookieJarBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CookieJarBlock extends FurnitureBlock implements EntityBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public CookieJarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any());
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(Block.box(4.5, 0.01, 4.5, 11.5, 9.0, 11.5));
            shapes.add(Block.box(5.5, 9.0, 5.5, 10.5, 10.0, 10.5));
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
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

    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof CookieJarBlockEntity blockEntity) {
                Containers.dropContents(level, pos, blockEntity);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CookieJarBlockEntity blockEntity) {
            int cookieCount = (int) blockEntity.getCookieJar().stream().filter(stack -> !stack.isEmpty()).count();
            if (heldStack.is(Items.COOKIE)) {
                if (cookieCount < 9) {
                    if (!level.isClientSide()) {
                        if (blockEntity.addItem(heldStack, cookieCount)) {
                            if (!player.getAbilities().instabuild) {
                                heldStack.shrink(1);
                            }
                        }
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide());
                } else {
                    if (!level.isClientSide()) {
                        blockEntity.removeItem(8);
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide());
                }
            }
            if (cookieCount > 0) {
                if (!level.isClientSide()) {
                    blockEntity.removeItem(cookieCount - 1);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CookieJarBlockEntity blockEntity) {
            int cookieCount = (int) blockEntity.getCookieJar().stream().filter(stack -> !stack.isEmpty()).count();
            if (cookieCount > 0) {
                if (!level.isClientSide()) {
                    blockEntity.removeItem(cookieCount - 1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CookieJarBlockEntity(pos, state);
    }
}