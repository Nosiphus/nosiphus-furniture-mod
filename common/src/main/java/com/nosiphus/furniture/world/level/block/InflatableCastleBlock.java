package com.nosiphus.furniture.world.level.block;

import com.nosiphus.furniture.sounds.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class InflatableCastleBlock extends Block {

    public InflatableCastleBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float fallDistance) {
        if (entity instanceof LivingEntity) {
            float height = entity.fallDistance;
            if(height > 0 && !entity.isSteppingCarefully()) {
                if(height > 4) height = 4;
                entity.setDeltaMovement(entity.getDeltaMovement().x, 0, entity.getDeltaMovement().z);
                entity.push(0, getRequiredVelocity(height + 1), 0);
                if(level.isClientSide) {
                    var particleOptions = ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, 1.0F, 1.0F, 1.0F);
                    for(int i = 0; i < 5; i++) {
                        level.addParticle(particleOptions, entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
                    }
                } else {
                    level.playSound(null, blockPos, ModSoundEvents.BLOCK_INFLATABLE_CASTLE_BOUNCE.get(), SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.2F + 0.9F);
                }
            }
            entity.fallDistance = 0;
        }
    }

    public double getRequiredVelocity(float height) {
        return Math.sqrt(0.22 * height);
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter blockGetter, Entity entity) {
    }

    public boolean addLandingEffects(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, BlockState blockState1, LivingEntity livingEntity, int numberOfParticles) {
        return true;
    }
}