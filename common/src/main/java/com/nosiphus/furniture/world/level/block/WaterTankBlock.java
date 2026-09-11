package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.entity.WaterTankBlockEntity;
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

public class WaterTankBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public WaterTankBlock(Properties properties) {
        super(properties);
    }

    private VoxelShape getShape(BlockState state) {
        if(SHAPES.containsKey(state)) {
            return SHAPES.get(state);
        }

        List<VoxelShape> shapes = new ArrayList<>();
        Direction direction = state.getValue(DIRECTION);

        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 1.5, 5.0, 1.5), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.5, 0.0, 0.0, 16.0, 5.0, 1.5), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.5, 0.0, 14.5, 16.0, 5.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 14.5, 1.5, 5.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 5.0, 0.0, 16.0, 6.0, 16.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 8.0, 1.0, 15.0, 9.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 10.0, 1.0, 15.0, 11.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 12.0, 1.0, 15.0, 13.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.0, 1.0, 15.0, 15.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 16.0, 1.0, 15.0, 17.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 18.0, 1.0, 15.0, 19.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 20.0, 1.0, 15.0, 21.0, 2.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 8.0, 14.0, 15.0, 9.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 10.0, 14.0, 15.0, 11.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 12.0, 14.0, 15.0, 13.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.0, 14.0, 15.0, 15.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 16.0, 14.0, 15.0, 17.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 18.0, 14.0, 15.0, 19.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 20.0, 14.0, 15.0, 21.0, 15.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 8.0, 2.0, 2.0, 9.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 10.0, 2.0, 2.0, 11.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 12.0, 2.0, 2.0, 13.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 14.0, 2.0, 2.0, 15.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 16.0, 2.0, 2.0, 17.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 18.0, 2.0, 2.0, 19.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 20.0, 2.0, 2.0, 21.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 8.0, 2.0, 15.0, 9.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 10.0, 2.0, 15.0, 11.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 12.0, 2.0, 15.0, 13.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 14.0, 2.0, 15.0, 15.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 16.0, 2.0, 15.0, 17.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 18.0, 2.0, 15.0, 19.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.0, 20.0, 2.0, 15.0, 21.0, 14.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.2, 6.0, 1.2, 14.8, 20.0, 1.8), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.2, 6.0, 14.2, 14.8, 20.0, 14.8), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.2, 6.0, 1.8, 1.8, 20.0, 14.2), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14.2, 6.0, 1.8, 14.8, 20.0, 14.2), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 6.0, 15.0, 9.0, 8.0, 19.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 5.0, 17.0, 9.0, 6.0, 19.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 8.0, 17.0, 8.5, 9.0, 18.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 8.9, 17.3, 9.5, 9.4, 17.7), Direction.EAST))[direction.get2DDataValue()]);

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
        ItemStack heldStack = player.getItemInHand(hand);

        if (level.getBlockEntity(pos) instanceof WaterTankBlockEntity blockEntity) {
            if (heldStack.is(Items.GLASS_BOTTLE)) {
                if (blockEntity.getFluidAmount() >= 250) {
                    if (!level.isClientSide()) {
                        if (!player.getAbilities().instabuild) {
                            ItemStack waterPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

                            heldStack.shrink(1);
                            if (heldStack.isEmpty()) {
                                player.setItemInHand(hand, waterPotion);
                            } else if (!player.getInventory().add(waterPotion)) {
                                player.drop(waterPotion, false);
                            }
                        }
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        blockEntity.drain(250);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                }
            }

            Fluid fillFluid = Fluids.EMPTY;
            if (heldStack.is(Items.WATER_BUCKET)) fillFluid = Fluids.WATER;
            else if (heldStack.is(ModItems.SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SOAPY_WATER.get();
            else if (heldStack.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get())) fillFluid = ModFluids.SUPER_SOAPY_WATER.get();

            if (fillFluid != Fluids.EMPTY) {
                if (blockEntity.canFill(fillFluid, 1000)) {
                    if (!level.isClientSide()) {
                        blockEntity.fill(fillFluid, 1000);
                        if (!player.getAbilities().instabuild) {
                            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                }
            } else if (heldStack.is(Items.BUCKET)) {
                if (blockEntity.getFluidAmount() >= 1000) {
                    if (!level.isClientSide()) {
                        Fluid currentFluid = blockEntity.getFluid();
                        ItemStack filledBucket = new ItemStack(Items.WATER_BUCKET);
                        if (currentFluid == ModFluids.SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SOAPY_WATER_BUCKET.get());
                        else if (currentFluid == ModFluids.SUPER_SOAPY_WATER.get()) filledBucket = new ItemStack(ModItems.SUPER_SOAPY_WATER_BUCKET.get());

                        blockEntity.drain(1000);
                        heldStack.shrink(1);
                        if (heldStack.isEmpty()) {
                            player.setItemInHand(hand, filledBucket);
                        } else if (!player.getInventory().add(filledBucket)) {
                            player.drop(filledBucket, false);
                        }
                        level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                }
            }

            if (!level.isClientSide()) {
                BlockPos waterPos = pos.below().below();
                if (this.isWaterSource(level, waterPos)) {
                    if (blockEntity.canFill(Fluids.WATER, 1000)) {
                        blockEntity.fill(Fluids.WATER, 1000);
                        level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER, pos.getX() + 0.5, pos.getY() + 1.15, pos.getZ() + 0.5, 10, 0.01, 0.01, 0.01, 0);

                        if (!this.isInfiniteWaterSource(level, waterPos)) {
                            level.setBlockAndUpdate(waterPos, Blocks.AIR.defaultBlockState());
                        }
                        return InteractionResult.SUCCESS;
                    }
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

    private boolean isWaterSource(Level level, BlockPos pos) {
        return level.getFluidState(pos).is(Fluids.WATER) && level.getFluidState(pos).isSource();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WaterTankBlockEntity(pos, state);
    }
}