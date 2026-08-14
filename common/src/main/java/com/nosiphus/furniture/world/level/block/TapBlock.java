package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.entity.TapBlockEntity;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TapBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public TapBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] HANDLE_CENTER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 14.4, 7.5, 8.5, 15.2, 8.5), Direction.EAST));
        final VoxelShape[] HANDLE_X = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.22, 15.2, 7.5, 9.78, 16.0, 8.5), Direction.EAST));
        final VoxelShape[] HANDLE_Z = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 15.2, 6.22, 8.5, 16.0, 9.78), Direction.EAST));
        final VoxelShape[] SPOUT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 11.2, 7.0, 4.0, 12.8, 9.0), Direction.EAST));
        final VoxelShape[] BAR = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2.0, 12.8, 7.0, 9.0, 14.4, 9.0), Direction.EAST));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 0.0, 7.0, 9.0, 12.8, 9.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(HANDLE_CENTER[direction.get2DDataValue()]);
            shapes.add(HANDLE_X[direction.get2DDataValue()]);
            shapes.add(HANDLE_Z[direction.get2DDataValue()]);
            shapes.add(SPOUT[direction.get2DDataValue()]);
            shapes.add(BAR[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);

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
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof TapBlockEntity tap) {
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                if (tap.getFluidAmount() >= 250) {
                    if (!level.isClientSide) {
                        ItemStack waterBottle = new ItemStack(Items.POTION);
                        waterBottle.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));

                        if (!player.getAbilities().instabuild) {
                            heldItem.consume(1, player);
                            if (heldItem.isEmpty()) {
                                player.setItemInHand(hand, waterBottle);
                            } else if (!player.getInventory().add(waterBottle)) {
                                player.drop(waterBottle, false);
                            }
                        }

                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        tap.drain(250);
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            Fluid fillFluid = Fluids.EMPTY;
            if (heldItem.is(Items.WATER_BUCKET)) fillFluid = Fluids.WATER;
            else if (heldItem.is(ModItems.SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SOAPY_WATER.get();
            else if (heldItem.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SUPER_SOAPY_WATER.get();

            if (fillFluid != Fluids.EMPTY) {
                if (tap.canFill(fillFluid, 1000)) {
                    if (!level.isClientSide) {
                        tap.fill(fillFluid, 1000);
                        if (!player.getAbilities().instabuild) {
                            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
            } else if (heldItem.is(Items.BUCKET)) {
                if (tap.getFluidAmount() >= 1000) {
                    if (!level.isClientSide) {
                        Fluid currentFluid = tap.getFluid();
                        ItemStack filledBucket = new ItemStack(Items.WATER_BUCKET);
                        if (currentFluid == ModFluids.SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SOAPY_WATER_BUCKET.get());
                        else if (currentFluid == ModFluids.SUPER_SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SUPER_SOAPY_WATER_BUCKET.get());

                        tap.drain(1000);
                        heldItem.shrink(1);
                        if (heldItem.isEmpty()) {
                            player.setItemInHand(hand, filledBucket);
                        } else if (!player.getInventory().add(filledBucket)) {
                            player.drop(filledBucket, false);
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof TapBlockEntity tap) {
            if (!level.isClientSide) {
                BlockPos sourcePos = pos.below().below();
                if (this.isWaterSource(level, sourcePos)) {
                    if (tap.canFill(Fluids.WATER, 1000)) {
                        tap.fill(Fluids.WATER, 1000);

                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        Direction dir = state.getValue(DIRECTION);
                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER,
                                pos.getX() + 0.5 + dir.getNormal().getX() * 0.1,
                                pos.getY() + 0.0,
                                pos.getZ() + 0.5 + dir.getNormal().getZ() * 0.1,
                                10, 0.01, 0.01, 0.01, 0);

                        if (!isInfiniteSource(level, sourcePos)) {
                            level.setBlockAndUpdate(sourcePos, Blocks.AIR.defaultBlockState());
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private boolean isInfiniteSource(Level level, BlockPos pos) {
        int adjacentSources = 0;
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (level.getBlockState(pos.relative(dir)).is(Blocks.WATER) && level.getFluidState(pos.relative(dir)).isSource()) {
                adjacentSources++;
            }
        }
        return adjacentSources >= 2;
    }

    private boolean isWaterSource(Level level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.WATER) && level.getFluidState(pos).isSource();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TapBlockEntity(pos, state);
    }

}