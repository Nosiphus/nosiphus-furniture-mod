package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.entity.SinkBlockEntity;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinkBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public SinkBlock(Properties properties) {
        super(properties);
    }

    private VoxelShape getShape(BlockState state) {
        if(SHAPES.containsKey(state)) {
            return SHAPES.get(state);
        }

        List<VoxelShape> shapes = new ArrayList<>();
        Direction direction = state.getValue(DIRECTION);

        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(8.0, 0.0, 3.2, 16.0, 11.0, 12.8), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 11.0, 0.0, 16.0, 12.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 12.0, 0.0, 16.0, 16.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 12.0, 0.0, 12.0, 16.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 12.0, 14.0, 12.0, 16.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 12.0, 2.0, 2.0, 16.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 16.0, 7.0, 15.0, 20.0, 9.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 20.0, 7.0, 15.0, 22.0, 9.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 16.0, 2.0, 15.0, 18.0, 4.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 16.0, 12.0, 15.0, 18.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 19.68, 7.0, 11.0, 20.0, 9.0), Direction.EAST))[direction.get2DDataValue()]);

        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return this.getShape(state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (level.getBlockEntity(pos) instanceof SinkBlockEntity sink) {
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                if (sink.getFluidAmount() >= 250) {
                    if (!level.isClientSide) {
                        ItemStack waterBottle = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

                        if (!player.getAbilities().instabuild) {
                            heldItem.shrink(1);
                            if (heldItem.isEmpty()) {
                                player.setItemInHand(hand, waterBottle);
                            } else if (!player.getInventory().add(waterBottle)) {
                                player.drop(waterBottle, false);
                            }
                        }

                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        sink.drain(250);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            Fluid fillFluid = Fluids.EMPTY;
            if (heldItem.is(Items.WATER_BUCKET)) fillFluid = Fluids.WATER;
            else if (heldItem.is(ModItems.SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SOAPY_WATER.get();
            else if (heldItem.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SUPER_SOAPY_WATER.get();

            if (fillFluid != Fluids.EMPTY) {
                if (sink.canFill(fillFluid, 1000)) {
                    if (!level.isClientSide) {
                        sink.fill(fillFluid, 1000);
                        if (!player.getAbilities().instabuild) {
                            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            } else if (heldItem.is(Items.BUCKET)) {
                if (sink.getFluidAmount() >= 1000) {
                    if (!level.isClientSide) {
                        Fluid currentFluid = sink.getFluid();
                        ItemStack filledBucket = new ItemStack(Items.WATER_BUCKET);
                        if (currentFluid == ModFluids.SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SOAPY_WATER_BUCKET.get());
                        else if (currentFluid == ModFluids.SUPER_SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SUPER_SOAPY_WATER_BUCKET.get());

                        sink.drain(1000);
                        heldItem.shrink(1);
                        if (heldItem.isEmpty()) {
                            player.setItemInHand(hand, filledBucket);
                        } else if (!player.getInventory().add(filledBucket)) {
                            player.drop(filledBucket, false);
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            if (heldItem.isEmpty() && !level.isClientSide) {
                BlockPos sourcePos = pos.below().below();
                if (this.isWaterSource(level, sourcePos)) {
                    if (sink.canFill(Fluids.WATER, 1000)) {
                        sink.fill(Fluids.WATER, 1000);

                        level.playSound(null, pos.above(), SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER,
                                pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.5,
                                10, 0.1, 0.1, 0.1, 0);

                        if (!isInfiniteSource(level, sourcePos)) {
                            level.setBlockAndUpdate(sourcePos, Blocks.AIR.defaultBlockState());
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }

    private boolean isInfiniteSource(Level level, BlockPos pos) {
        int adjacentSources = 0;
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (isWaterSource(level, pos.relative(dir))) {
                adjacentSources++;
            }
        }
        return adjacentSources >= 2;
    }

    private boolean isWaterSource(Level level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.WATER) && level.getBlockState(pos).getFluidState().isSource();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SinkBlockEntity(pos, state);
    }
}