package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.level.damagesource.ModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ElectricFenceBlock extends FenceBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ElectricFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape POST = Block.box(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);
        final VoxelShape NORTH_SIDE = Block.box(7.3, 0.0, 0.0, 8.7, 16.0, 8.0);
        final VoxelShape EAST_SIDE = Block.box(8.0, 0.0, 7.3, 16.0, 16.0, 8.7);
        final VoxelShape SOUTH_SIDE = Block.box(7.3, 0.0, 8.0, 8.7, 16.0, 16.0);
        final VoxelShape WEST_SIDE = Block.box(0.0, 0.0, 7.3, 8.0, 16.0, 8.7);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states) {
            boolean north = state.getValue(NORTH);
            boolean east = state.getValue(EAST);
            boolean south = state.getValue(SOUTH);
            boolean west = state.getValue(WEST);

            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(POST);

            if(north) shapes.add(NORTH_SIDE);
            if(east) shapes.add(EAST_SIDE);
            if(south) shapes.add(SOUTH_SIDE);
            if(west) shapes.add(WEST_SIDE);

            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide() && entity instanceof LivingEntity living && !living.isDeadOrDying()) {
            if (entity instanceof Creeper creeper) {
                if (!creeper.isPowered()) {
                    LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
                    if (lightningBolt != null) {
                        lightningBolt.moveTo(Vec3.atBottomCenterOf(pos));
                        creeper.ignite();
                        creeper.thunderHit((ServerLevel) level, lightningBolt);
                    }
                }
            } else if (entity instanceof Player player) {
                if (!player.getAbilities().instabuild) {
                    this.zapEntity(level, pos, player);
                }
            } else {
                this.zapEntity(level, pos, entity);
            }
        }
    }

    private void zapEntity(Level level, BlockPos pos, Entity entity) {
        var damageTypeHolder = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageTypes.ELECTRIC_FENCE);
        entity.hurt(new net.minecraft.world.damagesource.DamageSource(damageTypeHolder), 2.0F);
        level.playSound(null, pos, ModSoundEvents.BLOCK_ELECTRIC_FENCE_ZAP.get(), SoundSource.BLOCKS, 0.2F, 1.0F);
    }
}