package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.CupBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CupBlock extends FurnitureBlock implements EntityBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public CupBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any());
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(Block.box(5.5, 0.01, 5.5, 6.0, 7.0, 10.5));
            shapes.add(Block.box(10.0, 0.01, 5.5, 10.5, 7.0, 10.5));
            shapes.add(Block.box(6.0, 0.01, 5.5, 10.0, 7.0, 6.0));
            shapes.add(Block.box(6.0, 0.01, 10.0, 10.0, 7.0, 10.5));
            shapes.add(Block.box(6.0, 0.01, 6.0, 10.0, 0.5, 10.0));
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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!(level.getBlockEntity(pos) instanceof CupBlockEntity cup)) {
            return InteractionResult.PASS;
        }

        if (player.isShiftKeyDown() && heldItem.isEmpty()) {
            if (!level.isClientSide) {
                ItemStack dropStack = new ItemStack(this);
                if (cup.getFluid() != Fluids.EMPTY && cup.getFluidAmount() > 0) {
                    CompoundTag beTag = new CompoundTag();
                    cup.saveAdditional(beTag);
                    dropStack.getOrCreateTag().put("BlockEntityTag", beTag);
                }
                if (!player.getInventory().add(dropStack)) {
                    player.drop(dropStack, false);
                }
                level.removeBlock(pos, false);
                level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 0.6F, 1.0F);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (!player.isShiftKeyDown() && heldItem.isEmpty()) {
            if (cup.getFluid() != Fluids.EMPTY && cup.getFluidAmount() > 0) {
                if (!level.isClientSide) {
                    cup.drinkDirectly(player);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            return InteractionResult.PASS;
        }

        if (heldItem.getItem() instanceof BucketItem bucketItem && bucketItem.content != Fluids.EMPTY) {
            Fluid incomingFluid = bucketItem.content;
            if (cup.canFill(incomingFluid, 1000)) {
                if (!level.isClientSide) {
                    cup.fill(incomingFluid, 1000);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(
                            heldItem,
                            player,
                            BucketItem.getEmptySuccessItem(heldItem, player)
                    ));
                    SoundEvent emptySound = incomingFluid.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
                    level.playSound(null, pos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            return InteractionResult.PASS;
        }

        if (heldItem.is(Items.BUCKET)) {
            if (cup.getFluid() != Fluids.EMPTY && cup.getFluidAmount() >= 1000) {
                Fluid fluidInCup = cup.getFluid();
                Item filledBucket = fluidInCup.getBucket();

                if (filledBucket != null && filledBucket != Items.AIR) {
                    if (!level.isClientSide) {
                        cup.drain(1000);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, new ItemStack(filledBucket)));
                        SoundEvent fillSound = fluidInCup.is(FluidTags.LAVA) ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL;
                        level.playSound(null, pos, fillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            return InteractionResult.PASS;
        }

        if (heldItem.is(Items.POTION)) {
            Fluid potionFluid = PotionUtils.getPotion(heldItem) == Potions.WATER
                    ? Fluids.WATER
                    : cup.getPotionFluidEquivalent(heldItem);

            if (potionFluid != Fluids.EMPTY && cup.canFill(potionFluid, 250)) {
                if (!level.isClientSide) {
                    cup.fill(potionFluid, 250);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, new ItemStack(Items.GLASS_BOTTLE)));
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } else if (heldItem.is(Items.GLASS_BOTTLE)) {
            if (cup.getFluid() != Fluids.EMPTY && cup.getFluidAmount() >= 250) {
                if (!level.isClientSide) {
                    ItemStack filledBottle = cup.createBottleFromFluid(cup.getFluid());
                    if (!filledBottle.isEmpty()) {
                        cup.drain(250);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, filledBottle));
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CupBlockEntity(pos, state);
    }
}