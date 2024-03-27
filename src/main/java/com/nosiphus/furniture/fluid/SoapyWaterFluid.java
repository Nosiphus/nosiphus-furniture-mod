package com.nosiphus.furniture.fluid;

import com.nosiphus.furniture.core.ModFluids;
import com.nosiphus.furniture.core.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class SoapyWaterFluid extends FlowingFluid {

    public Fluid getFlowing() {
        return ModFluids.FLOWING_SOAPY_WATER.get();
    }

    public Fluid getSource() {
        return ModFluids.SOAPY_WATER.get();
    }

    public Item getBucket() {
        return ModItems.SOAPY_WATER.get();
    }

    public void animateTick(Level level, BlockPos pos, FluidState state, RandomSource source) {
        if (!state.isSource() && !state.getValue(FALLING)) {
            if (source.nextInt(64) == 0) {
                level.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, source.nextFloat() * 0.25F + 0.75F, source.nextFloat() + 0.5F, false);
            }
        } else if (source.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + source.nextDouble(), (double)pos.getY() + source.nextDouble(), (double)pos.getZ() + source.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Nullable
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean canConvertToSource() {
        return true;
    }

    protected void beforeDestroyingBlock(LevelAccessor accessor, BlockPos pos, BlockState state) {
        BlockEntity blockentity = state.hasBlockEntity() ? accessor.getBlockEntity(pos) : null;
        Block.dropResources(state, accessor, pos, blockentity);
    }

    public int getSlopeFindDistance(LevelReader reader) {
        return 4;
    }

    public BlockState createLegacyBlock(FluidState state) {
        return Blocks.WATER.defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
    }

    public boolean isSame(Fluid p_76456_) {
        return p_76456_ == Fluids.WATER || p_76456_ == Fluids.FLOWING_WATER;
    }

    public int getDropOff(LevelReader p_76469_) {
        return 1;
    }

    public int getTickDelay(LevelReader p_76454_) {
        return 5;
    }

    public boolean canBeReplacedWith(FluidState p_76458_, BlockGetter p_76459_, BlockPos p_76460_, Fluid p_76461_, Direction p_76462_) {
        return p_76462_ == Direction.DOWN && !p_76461_.is(FluidTags.WATER);
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }

    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    public static class Flowing extends WaterFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> state) {
            super.createFluidStateDefinition(state);
            state.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends SoapyWaterFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

}
