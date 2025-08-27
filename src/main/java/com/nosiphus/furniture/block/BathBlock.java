package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import com.nosiphus.furniture.blockentity.BathBlockEntity;
import com.nosiphus.furniture.entity.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BathBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public BathBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.BACK));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] HEAD_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Direction.EAST));
        final VoxelShape[] HEAD_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 0.0, 16.0, 14.0, 2.0), Direction.EAST));
        final VoxelShape[] HEAD_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 14.0, 16.0, 14.0, 16.0), Direction.EAST));
        final VoxelShape[] HEAD_FRONT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12.0, 2.0, 2.0, 16.0, 14.0, 14.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 7.0, 15.0, 18.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 18.0, 7.0, 15.0, 20.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_TAP_HOLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(9.0, 17.68, 7.0, 11.0, 18.0, 9.0), Direction.EAST));
        final VoxelShape[] HEAD_HOT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 2.0, 15.0, 16.0, 4.0), Direction.EAST));
        final VoxelShape[] HEAD_COLD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.0, 14.0, 12.0, 15.0, 16.0, 14.0), Direction.EAST));

        final VoxelShape[] BACK_BOTTOM = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Direction.EAST));
        final VoxelShape[] BACK_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 0.0, 16.0, 14.0, 2.0), Direction.EAST));
        final VoxelShape[] BACK_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 14.0, 16.0, 14.0, 16.0), Direction.EAST));
        final VoxelShape[] BACK_BACK = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 2.0, 2.0, 2.0, 14.0, 14.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();

            if(state.getValue(TYPE) == Type.HEAD) {
                shapes.add(HEAD_BOTTOM[direction.get2DDataValue()]);
                shapes.add(HEAD_LEFT[direction.get2DDataValue()]);
                shapes.add(HEAD_RIGHT[direction.get2DDataValue()]);
                shapes.add(HEAD_FRONT[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_BASE[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_TOP[direction.get2DDataValue()]);
                shapes.add(HEAD_TAP_HOLE[direction.get2DDataValue()]);
                shapes.add(HEAD_HOT[direction.get2DDataValue()]);
                shapes.add(HEAD_COLD[direction.get2DDataValue()]);
            } else if (state.getValue(TYPE) == Type.BACK) {
                shapes.add(BACK_BOTTOM[direction.get2DDataValue()]);
                shapes.add(BACK_LEFT[direction.get2DDataValue()]);
                shapes.add(BACK_RIGHT[direction.get2DDataValue()]);
                shapes.add(BACK_BACK[direction.get2DDataValue()]);
            }

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
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player playerEntity, InteractionHand hand, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            ItemStack heldItem = playerEntity.getItemInHand(hand);
            if(blockEntity instanceof BathBlockEntity) {
                if(heldItem.getItem() == Items.GLASS_BOTTLE)
                {
                    IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                    if(handler.getFluidInTank(0).getAmount() > 0 && !level.isClientSide())
                    {
                        if(!playerEntity.getAbilities().instabuild)
                        {
                            ItemStack waterPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                            heldItem.shrink(1);
                            if(heldItem.isEmpty())
                            {
                                playerEntity.setItemInHand(hand, waterPotion);
                            }
                            else if(!playerEntity.getInventory().add(waterPotion))
                            {
                                playerEntity.drop(waterPotion, false);
                            }
                            else if(playerEntity instanceof ServerPlayer)
                            {
                                playerEntity.inventoryMenu.sendAllDataToRemote();
                            }
                        }

                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        handler.drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.setChanged();
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                }

                if(!heldItem.isEmpty() && heldItem.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent())
                {
                    blockEntity.setChanged();
                    return FluidUtil.interactWithFluidHandler(playerEntity, hand, level, pos, result.getDirection()) ? InteractionResult.SUCCESS : InteractionResult.PASS;
                }

                BlockPos waterPos = pos.below().below();
                if(this.isWaterSource(level, waterPos))
                {
                    IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                    if(handler.getFluidInTank(0).getAmount() != handler.getTankCapacity(0))
                    {
                        handler.fill(new FluidStack(Fluids.WATER, FluidType.BUCKET_VOLUME), IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.setChanged();
                        level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        Direction direction = state.getValue(DIRECTION);
                        double posX = pos.getX() + 0.5 + direction.getNormal().getX() * 0.1;
                        double posY = pos.getY() + 1.15;
                        double posZ = pos.getZ() + 0.5 + direction.getNormal().getZ() * 0.1;
                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER, posX, posY, posZ, 10, 0.01, 0.01, 0.01, 0);

                        int adjacentSources = 0;
                        adjacentSources += this.isWaterSource(level, waterPos.north()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.east()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.south()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.west()) ? 1 : 0;
                        if(adjacentSources < 2) //If it has less then two adjacent water sources, it is not infinite and thus it should be consumed
                        {
                            level.setBlockAndUpdate(waterPos, Blocks.AIR.defaultBlockState());
                            blockEntity.setChanged();
                        }
                    }
                }
            }
            return SeatEntity.create(level, pos, 0.05, playerEntity);
        }
        return InteractionResult.SUCCESS;
    }

    private boolean isWaterSource(Level level, BlockPos pos)
    {
        return level.getFluidState(pos).getType() == Fluids.WATER;
    }

    @javax.annotation.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if(state.getValue(TYPE) == Type.BACK) {
            return new BathBlockEntity(pos, state);
        }
        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        Level level = context.getLevel();
        BlockPos headPos = context.getClickedPos().relative(direction);
        if(level.getBlockState(headPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(headPos)) {
            return this.defaultBlockState().setValue(DIRECTION, direction);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(!level.isClientSide()) {
            BlockPos headPos = pos.relative(state.getValue(DIRECTION));
            level.setBlock(headPos, state.setValue(TYPE, Type.HEAD), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        super.onRemove(state, level, pos, newState, isMoving);
        if(!state.is(newState.getBlock()))
        {
            Direction direction = state.getValue(DIRECTION);
            Type type = state.getValue(TYPE);
            BlockPos otherPos = pos.relative(type == Type.HEAD ? direction.getOpposite() : direction);
            BlockState otherState = level.getBlockState(otherPos);
            if(otherState.getBlock() instanceof BathBlock && otherState.getValue(TYPE) != type)
            {
                level.removeBlock(otherPos, false);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable {
        HEAD("head"),
        BACK("back");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}