package com.nosiphus.furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModernBedBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final EnumProperty<ModernBedBlock.Type> TYPE = EnumProperty.create("type", ModernBedBlock.Type.class);
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;
    private final DyeColor color;

    public ModernBedBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.color = dyeColor;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(PART, BedPart.HEAD).setValue(OCCUPIED, Boolean.valueOf(false)));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    @Nullable
    public static Direction getBedOrientation(BlockGetter getter, BlockPos pos) {
        BlockState state = getter.getBlockState(pos);
        return state.getBlock() instanceof ModernBedBlock ? state.getValue(DIRECTION) : null;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            if (state.getValue(PART) != BedPart.HEAD) {
                pos = pos.relative(state.getValue(DIRECTION));
                state = level.getBlockState(pos);
                if (!state.is(this)) {
                    return InteractionResult.CONSUME;
                }
            }

            if (!canSetSpawn(level)) {
                level.removeBlock(pos, false);
                BlockPos blockPos = pos.relative(state.getValue(DIRECTION).getOpposite());
                if (level.getBlockState(blockPos).is(this)) {
                    level.removeBlock(blockPos, false);
                }

                level.explode((Entity) null, DamageSource.badRespawnPointExplosion(), (ExplosionDamageCalculator) null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, 5.0F, true, Explosion.BlockInteraction.DESTROY);
                return InteractionResult.SUCCESS;
            } else if (state.getValue(OCCUPIED)) {
                if (!this.kickVillagerOutOfBed(level, pos)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
                }
                return InteractionResult.SUCCESS;
            } else {
                player.startSleepInBed(pos).ifLeft((bedSleepingProblem) -> {
                    if (bedSleepingProblem.getMessage() != null) {
                        player.displayClientMessage(bedSleepingProblem.getMessage(), true);
                    }
                });
                return InteractionResult.SUCCESS;
            }

        }
    }

    public static boolean canSetSpawn(Level level) {
        return level.dimensionType().bedWorks();
    }

    private boolean kickVillagerOutOfBed(Level level, BlockPos pos) {
        List<Villager> list = level.getEntitiesOfClass(Villager.class, new AABB(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            list.get(0).stopSleeping();
            return true;
        }
    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float damageValue) {
        super.fallOn(level, state, pos, entity, damageValue * 0.5F);
    }

    public void updateEntityAfterFallOn(BlockGetter getter, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(getter, entity);
        } else {
            this.bounceUp(entity);
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0D) {
            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setDeltaMovement(vec3.x, -vec3.y * (double) 0.66F * d0, vec3.z);
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor accessor, BlockPos pos, BlockPos pos1) {
        if (direction == getNeighborDirection(state.getValue(PART), state.getValue(DIRECTION))) {
            return state1.is(this) && state1.getValue(PART) != state.getValue(PART) ? state.setValue(OCCUPIED, state1.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, direction, state1, accessor, pos, pos1);
        }
    }

    private static Direction getNeighborDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BedPart bedPart = state.getValue(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos pos1 = pos.relative(getNeighborDirection(bedPart, state.getValue(DIRECTION)));
                BlockState state1 = state.getBlockState(pos1);
                if (state1.is(this) && state1.getValue(PART) == BedPart.HEAD) {
                    level.setBlock(pos1, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, pos1, Block.getId(state1));
                }
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        BlockPos pos = context.getClickedPos();
        BlockPos pos1 = pos.relative(direction);
        Level level = context.getLevel();
        return level.getBlockState(pos1).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(pos1) ? this.defaultBlockState().setValue(DIRECTION, direction) : null;
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] HEADBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 2.0), Direction.SOUTH));
        final VoxelShape[] RIGHT_FRAME_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 4.0, 2.0, 1.0, 8.0, 30.0), Direction.SOUTH));
        final VoxelShape[] LEFT_FRAME_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(15.0, 4.0, 2.0, 16.0, 8.0, 30.0), Direction.SOUTH));
        final VoxelShape[] BOTTOM_FRAME_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 4.5, 2.0, 15.0, 5.5, 30.0), Direction.SOUTH));
        final VoxelShape[] BASEBOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 0.0, 30.0, 16.0, 7.6, 32.0), Direction.SOUTH));
        final VoxelShape[] BASEBOARD_CAP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.0, 7.0, 30.0, 16.0, 8.0, 31.0), Direction.SOUTH));
        final VoxelShape[] BLANKET_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 8.0, 15.0, 9.0, 30.0), Direction.SOUTH));
        final VoxelShape[] PILLOW_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 5.0, 2.0, 15.0, 9.5, 8.0), Direction.SOUTH));
        final VoxelShape[] HEADBOARD_CAP_SINGLE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1.0, 15.0, 0.0, 15.0, 16.0, 2.0), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            ModernBedBlock.Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(HEADBOARD[direction.get2DDataValue()]);
            switch(type) {
                case SINGLE:
                    shapes.add(RIGHT_FRAME_SINGLE[direction.get2DDataValue()]);
                    shapes.add(LEFT_FRAME_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BOTTOM_FRAME_SINGLE[direction.get2DDataValue()]);
                    shapes.add(BASEBOARD[direction.get2DDataValue()]);
                    shapes.add(BASEBOARD_CAP[direction.get2DDataValue()]);
                    shapes.add(BLANKET_SINGLE[direction.get2DDataValue()]);
                    shapes.add(PILLOW_SINGLE[direction.get2DDataValue()]);
                    shapes.add(HEADBOARD_CAP_SINGLE[direction.get2DDataValue()]);
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
                case MIDDLE:
                    break;
            }
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return SHAPES.get(state);
    }

    public enum Type implements StringRepresentable
    {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle");

        private final String id;

        Type(String id)
        {
            this.id = id;
        }

        @Override
        public String getSerializedName()
        {
            return id;
        }

        @Override
        public String toString()
        {
            return id;
        }
    }

}