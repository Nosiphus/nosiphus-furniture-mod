package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.entity.decoration.SeatEntity;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.ToiletBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToiletBlock extends FurnitureHorizontalBlock implements EntityBlock
{

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public ToiletBlock(Properties properties)
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
        Direction direction = state.getValue(DIRECTION);

        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 8.16, 12.8, 18.4, 9.76), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(11.2, 6.4, 6.24, 12.8, 18.4, 7.84), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.6, 16.0, 1.6, 16.0, 17.6, 14.4), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(10.4, 4.8, 2.4, 16.0, 16.0, 13.6), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 2.4, 10.4, 9.6, 4.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 4.0, 3.2, 9.6, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.6, 4.8, 12.0, 10.4, 9.6, 13.6), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 4.0, 11.2, 5.6, 6.4), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.4, 4.8, 9.6, 11.2, 5.6, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 4.8, 4.0, 11.2, 6.4, 12.0), Direction.EAST))[direction.get2DDataValue()]);
        shapes.add(VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3.2, 0.0, 4.0, 14.4, 4.8, 12.0), Direction.EAST))[direction.get2DDataValue()]);

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
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ToiletBlockEntity toilet) {

            if (heldItem.is(Items.GLASS_BOTTLE)) {
                IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, hitResult.getDirection());

                if (handler != null && handler.getFluidInTank(0).getAmount() >= 250) {
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
                        handler.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        toilet.markUpdated();
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            var itemFluidCap = heldItem.getCapability(Capabilities.FluidHandler.ITEM);
            if (itemFluidCap != null) {
                if (!level.isClientSide) {
                    if (FluidUtil.interactWithFluidHandler(player, hand, level, pos, hitResult.getDirection())) {
                        toilet.markUpdated();
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ToiletBlockEntity toilet) {
            if (!level.isClientSide) {
                BlockPos sourcePos = pos.below().below();
                if (this.isWaterSource(level, sourcePos)) {
                    IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);

                    if (handler != null && handler.getFluidInTank(0).getAmount() < handler.getTankCapacity(0)) {
                        handler.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                        toilet.markUpdated();

                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        Direction dir = state.getValue(DIRECTION);
                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER,
                                pos.getX() + 0.5 + dir.getNormal().getX() * 0.1,
                                pos.getY() + 1.15,
                                pos.getZ() + 0.5 + dir.getNormal().getZ() * 0.1,
                                10, 0.01, 0.01, 0.01, 0);

                        if (!isInfiniteSource(level, sourcePos)) {
                            level.setBlockAndUpdate(sourcePos, Blocks.AIR.defaultBlockState());
                        }
                        return InteractionResult.SUCCESS;
                    }
                }

                return SeatEntity.create(level, pos, 0.6, player, state.getValue(DIRECTION));
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new ToiletBlockEntity(pos, state);
    }

}