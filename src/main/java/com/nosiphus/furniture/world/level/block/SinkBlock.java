package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.SinkBlockEntity;
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

public class SinkBlock extends FurnitureHorizontalBlock implements EntityBlock
{

    public final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public SinkBlock(Properties properties)
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
        if (level.getBlockEntity(pos) instanceof SinkBlockEntity sink) {

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
                        sink.markUpdated();
                    }
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            var itemFluidCap = heldItem.getCapability(Capabilities.FluidHandler.ITEM);
            if (itemFluidCap != null) {
                if (!level.isClientSide) {
                    if (FluidUtil.interactWithFluidHandler(player, hand, level, pos, hitResult.getDirection())) {
                        sink.markUpdated();
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }

            if (heldItem.isEmpty() && !level.isClientSide) {
                BlockPos sourcePos = pos.below().below();
                if (this.isWaterSource(level, sourcePos)) {
                    IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);

                    if (handler != null && handler.getFluidInTank(0).getAmount() < handler.getTankCapacity(0)) {
                        handler.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                        sink.markUpdated();

                        level.playSound(null, pos.above(), SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER,
                                pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.5,
                                10, 0.1, 0.1, 0.1, 0);

                        if (!isInfiniteSource(level, sourcePos)) {
                            level.setBlockAndUpdate(sourcePos, Blocks.AIR.defaultBlockState());
                        }
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new SinkBlockEntity(pos, state);
    }
}