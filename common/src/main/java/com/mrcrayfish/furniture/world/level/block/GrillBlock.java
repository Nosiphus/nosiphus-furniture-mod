package com.mrcrayfish.furniture.world.level.block;

import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.item.ModItems;
import com.mrcrayfish.furniture.world.level.block.entity.GrillBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
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
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Author: MrCrayfish
 */
public class GrillBlock extends FurnitureWaterloggedBlock implements EntityBlock
{
    public static final VoxelShape SHAPE = VoxelShapeHelper.combineAll(Arrays.asList(Block.box(0.0, 11.0, 0.0, 16.0, 16.0, 16.0), Block.box(1.5, 0.0, 1.5, 14.5, 11.0, 14.5)));

    public GrillBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos)
    {
        return 1.0F;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if(state.getBlock() != newState.getBlock())
        {
            if(level.getBlockEntity(pos) instanceof GrillBlockEntity blockEntity)
            {
                Containers.dropContents(level, pos, blockEntity.getGrill());
                Containers.dropContents(level, pos, blockEntity.getFuel());
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (hit.getDirection() != Direction.UP)
        {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (level.getBlockEntity(pos) instanceof GrillBlockEntity blockEntity)
        {
            int slotIndex = this.getPosition(hit, pos);

            if (stack.is(ModItems.SPATULA.get()))
            {
                if (!level.isClientSide)
                {
                    blockEntity.flipItem(slotIndex);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }

            if (Services.PLATFORM.getBurnTime(stack, RecipeType.SMELTING) > 0)
            {
                if (!level.isClientSide)
                {
                    if (blockEntity.addFuel(stack))
                    {
                        if (!player.getAbilities().instabuild)
                        {
                            stack.shrink(1);
                        }
                        level.playSound(null, pos, SoundEvents.ANCIENT_DEBRIS_HIT, SoundSource.BLOCKS, 1.0F, 1.5F);
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }

            var optional = blockEntity.findMatchingRecipe(stack);
            if (optional.isPresent())
            {
                if (!level.isClientSide)
                {
                    var recipe = optional.get();
                    byte rotation = (byte) player.getDirection().get2DDataValue();

                    if (blockEntity.addItem(stack, slotIndex, recipe.getCookingTime(), recipe.getExperience(), rotation))
                    {
                        if (!player.getAbilities().instabuild)
                        {
                            stack.shrink(1);
                        }
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit)
    {
        if (hit.getDirection() == Direction.UP && level.getBlockEntity(pos) instanceof GrillBlockEntity blockEntity)
        {
            if (!level.isClientSide)
            {
                blockEntity.removeItem(this.getPosition(hit, pos));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    private int getPosition(BlockHitResult hit, BlockPos pos)
    {
        Vec3 hitVec = hit.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
        int position = 0;
        if(hitVec.x() > 0.5) position += 1;
        if(hitVec.z() > 0.5) position += 2;
        return position;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new GrillBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
    {
        return createMailBoxTicker(level, type, ModBlockEntityTypes.GRILL.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createMailBoxTicker(Level level, BlockEntityType<T> blockEntityType, BlockEntityType<? extends GrillBlockEntity> grillBlockEntity)
    {
        if(level.isClientSide())
        {
            return createTickerHelper(blockEntityType, grillBlockEntity, GrillBlockEntity::clientTick);
        }
        else
        {
            return createTickerHelper(blockEntityType, grillBlockEntity, GrillBlockEntity::serverTick);
        }
    }
}