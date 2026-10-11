package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.item.CupItem;
import com.nosiphus.furniture.world.level.block.entity.BlenderBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BlenderBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public BlenderBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] LID = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 14.0, 4.5, 11.5, 15.0, 11.5), Direction.EAST));
        final VoxelShape[] HANDLE_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 12.0, 2.5, 8.5, 13.0, 4.5), Direction.EAST));
        final VoxelShape[] HANDLE_MIDDLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 7.0, 2.5, 8.5, 12.0, 3.5), Direction.EAST));
        final VoxelShape[] HANDLE_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.5, 6.0, 2.5, 8.5, 7.0, 4.0), Direction.EAST));
        final VoxelShape[] CUP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4.5, 5.0, 4.5, 11.5, 14.0, 11.5), Direction.EAST));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.0, 0.0, 5.0, 11.0, 5.0, 11.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(LID[direction.get2DDataValue()]);
            shapes.add(HANDLE_TOP[direction.get2DDataValue()]);
            shapes.add(HANDLE_MIDDLE[direction.get2DDataValue()]);
            shapes.add(HANDLE_BOTTOM[direction.get2DDataValue()]);
            shapes.add(CUP[direction.get2DDataValue()]);
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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!(level.getBlockEntity(pos) instanceof BlenderBlockEntity blender)) {
            return InteractionResult.PASS;
        }

        if (blender.isBlending()) {
            return InteractionResult.CONSUME;
        }

        if (player.isShiftKeyDown() && hand == InteractionHand.MAIN_HAND) {
            if (!level.isClientSide) {
                if (blender.startBlending()) {
                    level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 0.8F, 1.2F);
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.getItem() instanceof BucketItem bucketItem && bucketItem.content != Fluids.EMPTY) {
            Fluid incomingFluid = bucketItem.content;
            if (blender.canFill(incomingFluid, 1000)) {
                if (!level.isClientSide) {
                    blender.fill(incomingFluid, 1000);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(
                            heldItem, player, BucketItem.getEmptySuccessItem(heldItem, player)
                    ));
                    SoundEvent emptySound = incomingFluid.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
                    level.playSound(null, pos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.sendBlockUpdated(pos, state, state, 3);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            return InteractionResult.PASS;
        }

        if (heldItem.is(Items.BUCKET)) {
            if (blender.getFluid() != Fluids.EMPTY && blender.getFluidAmount() >= 1000) {
                Fluid fluidInBlender = blender.getFluid();
                Item filledBucket = fluidInBlender.getBucket();
                if (filledBucket != null && filledBucket != Items.AIR) {
                    if (!level.isClientSide) {
                        blender.drain(1000);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, new ItemStack(filledBucket)));
                        SoundEvent fillSound = fluidInBlender.is(FluidTags.LAVA) ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL;
                        level.playSound(null, pos, fillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
                        level.sendBlockUpdated(pos, state, state, 3);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            return InteractionResult.PASS;
        }

        if (heldItem.is(Items.POTION)) {
            Fluid potionFluid = PotionUtils.getPotion(heldItem) == Potions.WATER
                    ? Fluids.WATER
                    : blender.getPotionFluidEquivalent(heldItem);

            if (potionFluid != Fluids.EMPTY && blender.canFill(potionFluid, 250)) {
                if (!level.isClientSide) {
                    blender.fill(potionFluid, 250);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, new ItemStack(Items.GLASS_BOTTLE)));
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.sendBlockUpdated(pos, state, state, 3);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } else if (heldItem.is(Items.GLASS_BOTTLE)) {
            if (blender.getFluid() != Fluids.EMPTY && blender.getFluidAmount() >= 250) {
                if (!level.isClientSide) {
                    ItemStack filledBottle = blender.createBottleFromFluid(blender.getFluid());
                    if (!filledBottle.isEmpty()) {
                        blender.drain(250);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(heldItem, player, filledBottle));
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        level.sendBlockUpdated(pos, state, state, 3);
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        if (heldItem.getItem() instanceof CupItem) {
            if (blender.getFluid() != Fluids.EMPTY && blender.getFluidAmount() > 0) {
                Fluid blenderFluid = blender.getFluid();
                Fluid cupFluid = CupItem.getFluid(heldItem);
                int cupAmount = CupItem.getFluidAmount(heldItem);
                int cupCapacity = 1000;

                if ((cupFluid == Fluids.EMPTY || cupFluid == blenderFluid) && cupAmount < cupCapacity) {
                    int spaceAvailable = cupCapacity - cupAmount;
                    int transferAmount = Math.min(blender.getFluidAmount(), spaceAvailable);

                    if (transferAmount > 0) {
                        if (!level.isClientSide) {
                            if (!player.getAbilities().instabuild) {
                                blender.drain(transferAmount);
                            }

                            ItemStack filledCup = heldItem.copyWithCount(1);
                            CompoundTag beTag = filledCup.getOrCreateTagElement("BlockEntityTag");
                            beTag.putString("FluidName", BuiltInRegistries.FLUID.getKey(blenderFluid).toString());
                            beTag.putInt("Amount", cupAmount + transferAmount);

                            ItemStack resultStack = ItemUtils.createFilledResult(heldItem, player, filledCup);
                            player.setItemInHand(hand, resultStack);

                            level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            level.sendBlockUpdated(pos, state, state, 3);
                            blender.setChanged();
                        }
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }
                }
            }
            return InteractionResult.PASS;
        }

        if (!heldItem.isEmpty()) {
            if (blender.getFluid() != Fluids.EMPTY && blender.getFluidAmount() > 0) {
                return InteractionResult.PASS;
            }

            if (!blender.isValidIngredient(heldItem)) {
                return InteractionResult.PASS;
            }

            for (int i = 0; i < blender.getContainerSize(); i++) {
                ItemStack slotStack = blender.getItem(i);
                if (slotStack.isEmpty()) {
                    if (!level.isClientSide) {
                        blender.setItem(i, heldItem.split(heldItem.getCount()));
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else if (ItemStack.isSameItemSameTags(slotStack, heldItem) && slotStack.getCount() < slotStack.getMaxStackSize()) {
                    if (!level.isClientSide) {
                        int transfer = Math.min(heldItem.getCount(), slotStack.getMaxStackSize() - slotStack.getCount());
                        slotStack.grow(transfer);
                        heldItem.shrink(transfer);
                        blender.markUpdated();
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        } else {
            for (int i = blender.getContainerSize() - 1; i >= 0; i--) {
                ItemStack slotStack = blender.getItem(i);
                if (!slotStack.isEmpty()) {
                    if (!level.isClientSide) {
                        player.setItemInHand(hand, slotStack.copy());
                        blender.setItem(i, ItemStack.EMPTY);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlenderBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type != ModBlockEntityTypes.BLENDER.get()) {
            return null;
        }
        return level.isClientSide
                ? (lvl, p, st, be) -> BlenderBlockEntity.clientTick(lvl, p, st, (BlenderBlockEntity) be)
                : (lvl, p, st, be) -> BlenderBlockEntity.serverTick(lvl, p, st, (BlenderBlockEntity) be);
    }
}