package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.FurnitureBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.BirdBathBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirdBathBlock extends FurnitureBlock implements EntityBlock
{

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public BirdBathBlock(Properties properties)
    {
        super(properties);
    }

    private VoxelShape getShape(BlockState state)
    {

        if(SHAPES.containsKey(state))
        {
            return SHAPES.get(state);
        }

        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(Block.box(4.0, 0.0, 4.0, 12.0, 1.6, 12.0));
        shapes.add(Block.box(5.0, 1.6, 5.0, 11.0, 11.2, 11.0));
        shapes.add(Block.box(1.0, 11.2, 1.0, 15.0, 12.8, 15.0));
        shapes.add(Block.box(0.0, 12.8, 0.0, 1.6, 14.4, 16.0));
        shapes.add(Block.box(1.6, 12.8, 0.0, 14.4, 14.4, 1.6));
        shapes.add(Block.box(1.6, 12.8, 14.4, 14.4, 14.4, 16.0));
        shapes.add(Block.box(14.4, 12.8, 0.0, 16.0, 14.4, 16.0));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return this.getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return this.getShape(state);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof BirdBathBlockEntity blockEntity) {
            if (heldStack.is(Items.GLASS_BOTTLE)) {
                IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, hitResult.getDirection());
                if (handler != null && handler.getFluidInTank(0).getAmount() >= FluidType.BUCKET_VOLUME / 4) {
                    if (!level.isClientSide()) {
                        if (!player.getAbilities().instabuild) {
                            ItemStack waterPotion = new ItemStack(Items.POTION);
                            waterPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));

                            heldStack.shrink(1);
                            if (heldStack.isEmpty()) {
                                player.setItemInHand(hand, waterPotion);
                            } else if (!player.getInventory().add(waterPotion)) {
                                player.drop(waterPotion, false);
                            }
                        }
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        handler.drain(FluidType.BUCKET_VOLUME / 4, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.setChanged();
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide());
                }
            }
            if (heldStack.getCapability(Capabilities.FluidHandler.ITEM) != null) {
                if (!level.isClientSide()) {
                    if (FluidUtil.interactWithFluidHandler(player, hand, level, pos, hitResult.getDirection())) {
                        blockEntity.setChanged();
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof BirdBathBlockEntity blockEntity) {
            BlockPos waterPos = pos.below().below();
            if (this.isWaterSource(level, waterPos)) {
                IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, hitResult.getDirection());
                if (handler != null && handler.getFluidInTank(0).getAmount() < handler.getTankCapacity(0)) {
                    if (!level.isClientSide()) {
                        handler.fill(new FluidStack(Fluids.WATER, FluidType.BUCKET_VOLUME), IFluidHandler.FluidAction.EXECUTE);
                        level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER, pos.getX() + 0.5, pos.getY() + 1.15, pos.getZ() + 0.5, 10, 0.01, 0.01, 0.01, 0);

                        if (!this.isInfiniteWaterSource(level, waterPos)) {
                            level.setBlockAndUpdate(waterPos, Blocks.AIR.defaultBlockState());
                        }
                        blockEntity.setChanged();
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    private boolean isInfiniteWaterSource(Level level, BlockPos pos) {
        int adjacentSources = 0;
        if (isWaterSource(level, pos.north())) adjacentSources++;
        if (isWaterSource(level, pos.east())) adjacentSources++;
        if (isWaterSource(level, pos.south())) adjacentSources++;
        if (isWaterSource(level, pos.west())) adjacentSources++;
        return adjacentSources >= 2;
    }

    private boolean isWaterSource(Level level, BlockPos pos)
    {
        return level.getFluidState(pos).getType() == Fluids.WATER;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new BirdBathBlockEntity(pos, state);
    }

}