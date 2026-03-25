package com.mrcrayfish.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class DivingBoardBlock extends FurnitureHorizontalBlock
{
    public static final EnumProperty<DivingBoardPart> PART = EnumProperty.create("part", DivingBoardPart.class);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public DivingBoardBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(PART, DivingBoardPart.BASE).setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BOARD = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1, 4, 0, 15, 6, 16), Direction.SOUTH));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(3, 0, 2, 13, 4, 15), Direction.SOUTH));
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BOARD[state.getValue(DIRECTION).get2DDataValue()]);
            if(state.getValue(PART) == DivingBoardPart.BASE)
            {
                shapes.add(BASE[state.getValue(DIRECTION).get2DDataValue()]);
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
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return SHAPES.get(state);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player)
    {
        Direction direction = state.getValue(DIRECTION);
        DivingBoardPart part = state.getValue(PART);
        BlockPos otherPos = part == DivingBoardPart.BASE ? pos.relative(direction) : pos.relative(direction.getOpposite());
        BlockState otherBlockState = level.getBlockState(otherPos);
        if(otherBlockState.getBlock() == this && otherBlockState.getValue(PART) != part)
        {
            level.setBlock(otherPos, Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, otherPos, Block.getId(otherBlockState));
        }
        super.playerWillDestroy(level, pos, state, player);
        return otherBlockState;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
    {
        super.setPlacedBy(level, pos, state, placer, stack);
        if(!level.isClientSide)
        {
            Direction dir = state.getValue(DIRECTION);
            level.setBlock(pos.relative(dir), state.setValue(PART, DivingBoardPart.BOARD), 3);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos)
    {
        Direction boardDir = state.getValue(PART) == DivingBoardPart.BASE ? state.getValue(DIRECTION) : state.getValue(DIRECTION).getOpposite();
        if (facing == boardDir && !facingState.is(this))
        {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        if (state.getValue(PART) == DivingBoardPart.BASE)
        {
            BlockPos boardPos = pos.relative(state.getValue(DIRECTION));
            return level.getBlockState(boardPos).isAir() || (level.getBlockState(boardPos).is(this) && level.getBlockState(boardPos).getValue(PART) == DivingBoardPart.BOARD);
        }
        return super.canSurvive(state, level, pos);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance)
    {
        if(state.getValue(PART) != DivingBoardPart.BOARD)
        {
            super.fallOn(level, state, pos, entity, fallDistance);
            return;
        }

        if(entity instanceof LivingEntity)
        {
            float strength = 5.0F;
            float maxHeight = 8F;
            float height = fallDistance * strength;
            if(height > 0 && !entity.isShiftKeyDown())
            {
                if(height > maxHeight - 0.25F) height = maxHeight - 0.25F;
                entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
                entity.push(0, Math.sqrt(0.22 * (height + 0.25F)), 0);
                if(level.isClientSide)
                {
                    var particleOptions = ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, 1.0F, 1.0F, 1.0F);
                    for(int i = 0; i < 5; i++)
                    {
                        level.addParticle(particleOptions, entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
                    }
                }
                else
                {
                    level.playSound(null, pos, ModSoundEvents.BLOCK_DIVING_BOARD_BOUNCE.get(), SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.1F + 1.0F);
                }
            }
        }
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter worldIn, Entity entityIn)
    {
    }

    @Override
    public boolean addLandingEffects(BlockState state1, ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles)
    {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(PART);
    }

    public enum DivingBoardPart implements StringRepresentable
    {
        BASE("base"),
        BOARD("board");

        private final String name;

        DivingBoardPart(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }
}