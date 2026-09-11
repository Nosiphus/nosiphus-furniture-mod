package com.nosiphus.furniture.world.level.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import java.util.function.Supplier;

public abstract class BaseFluid extends FlowingFluid {

    private final Supplier<? extends Fluid> stillSupplier;
    private final Supplier<? extends Fluid> flowingSupplier;
    private final Supplier<? extends Item> bucketSupplier;
    private final Supplier<? extends LiquidBlock> blockSupplier;

    protected BaseFluid(
            Supplier<? extends Fluid> stillSupplier,
            Supplier<? extends Fluid> flowingSupplier,
            Supplier<? extends Item> bucketSupplier,
            Supplier<? extends LiquidBlock> blockSupplier
    ) {
        this.stillSupplier = stillSupplier;
        this.flowingSupplier = flowingSupplier;
        this.bucketSupplier = bucketSupplier;
        this.blockSupplier = blockSupplier;
    }

    @Override
    public Fluid getSource() {
        return stillSupplier.get();
    }

    @Override
    public Fluid getFlowing() {
        return flowingSupplier.get();
    }

    @Override
    public Item getBucket() {
        return bucketSupplier.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !isSame(fluid);
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return blockSupplier.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    protected int getDropOff(LevelReader level) {
        return 2;
    }

    @Override
    protected int getSlopeFindDistance(LevelReader level) {
        return 2;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        Block.dropResources(state, level, pos, level.getBlockEntity(pos));
    }

    public static class Source extends BaseFluid {
        public Source(
                Supplier<? extends Fluid> stillSupplier,
                Supplier<? extends Fluid> flowingSupplier,
                Supplier<? extends Item> bucketSupplier,
                Supplier<? extends LiquidBlock> blockSupplier
        ) {
            super(stillSupplier, flowingSupplier, bucketSupplier, blockSupplier);
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends BaseFluid {
        public Flowing(
                Supplier<? extends Fluid> stillSupplier,
                Supplier<? extends Fluid> flowingSupplier,
                Supplier<? extends Item> bucketSupplier,
                Supplier<? extends LiquidBlock> blockSupplier
        ) {
            super(stillSupplier, flowingSupplier, bucketSupplier, blockSupplier);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}