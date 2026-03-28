package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.block.entity.ToasterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
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

public class ToasterBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ToasterBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {

        final VoxelShape[] LEVER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 4.0, 2.5, 9.0, 4.8, 3.5), Direction.EAST));
        final VoxelShape[] NORTH_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 0.0, 3.5, 9.5, 6.4, 4.5), Direction.EAST));
        final VoxelShape[] WEST_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.5, 0.0, 3.5, 6.5, 6.4, 12.5), Direction.EAST));
        final VoxelShape[] CENTER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 0.0, 4.5, 8.5, 6.4, 11.5), Direction.EAST));
        final VoxelShape[] EAST_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.5, 0.0, 3.5, 10.5, 6.4, 12.5), Direction.EAST));
        final VoxelShape[] SOUTH_SIDE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 0.0, 11.5, 9.5, 6.4, 12.5), Direction.EAST));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 0.0, 3.0, 11.0, 1.0, 13.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(LEVER[direction.get2DDataValue()]);
            shapes.add(NORTH_SIDE[direction.get2DDataValue()]);
            shapes.add(WEST_SIDE[direction.get2DDataValue()]);
            shapes.add(CENTER[direction.get2DDataValue()]);
            shapes.add(EAST_SIDE[direction.get2DDataValue()]);
            shapes.add(SOUTH_SIDE[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);
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

    public int getDirection(BlockState state) {
        if(state.getValue(DIRECTION) == Direction.NORTH) {
            return 0;
        } else if (state.getValue(DIRECTION) == Direction.EAST) {
            return 1;
        } else if (state.getValue(DIRECTION) == Direction.SOUTH) {
            return 2;
        } else if (state.getValue(DIRECTION) == Direction.WEST) {
            return 3;
        }
        return 0;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof ToasterBlockEntity blockEntity) {
                Containers.dropContents(level, pos, blockEntity.getToaster());
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ToasterBlockEntity toaster) {
            if (!heldItem.isEmpty()) {
                var input = new SingleRecipeInput(heldItem);
                var recipeOptional = level.getRecipeManager().getRecipeFor(ModRecipeTypes.TOASTING.get(), input, level);

                if (recipeOptional.isPresent()) {
                    var recipe = recipeOptional.get().value();
                    int slot = this.getSlotFromHit(hitResult, pos, state);
                    if (toaster.addItem(heldItem, slot, recipe.getCookingTime(), recipe.getExperience())) {
                        if (!player.getAbilities().instabuild) {
                            heldItem.shrink(1);
                        }
                        level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 0.5F, 1.0F);
                        return ItemInteractionResult.sidedSuccess(level.isClientSide);
                    }
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ToasterBlockEntity toaster) {
            int slot = this.getSlotFromHit(hitResult, pos, state);
            if (!toaster.getItem(slot).isEmpty()) {
                if (!level.isClientSide) {
                    toaster.removeItem(slot);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    private int getSlotFromHit(BlockHitResult hit, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(DIRECTION);
        double hitX = hit.getLocation().x - (double) pos.getX();
        double hitZ = hit.getLocation().z - (double) pos.getZ();

        return switch (facing) {
            case NORTH -> hitZ < 0.5 ? 0 : 1;
            case SOUTH -> hitZ > 0.5 ? 0 : 1;
            case EAST  -> hitX < 0.5 ? 0 : 1;
            case WEST  -> hitX > 0.5 ? 0 : 1;
            default    -> 0;
        };
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ToasterBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
    {
        return createMailBoxTicker(level, type, ModBlockEntityTypes.TOASTER.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createMailBoxTicker(Level level, BlockEntityType<T> blockEntityType, BlockEntityType<? extends ToasterBlockEntity> toasterBlockEntity)
    {
        return createTickerHelper(blockEntityType, toasterBlockEntity, ToasterBlockEntity::tick);
    }

}