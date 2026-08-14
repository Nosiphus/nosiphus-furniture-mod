package com.nosiphus.furniture.world.level.fluid;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Supplier;

public class BaseFluidNeoForge {

    public static class Source extends BaseFluid.Source {
        private final Supplier<FluidType> fluidTypeSupplier;

        public Source(
                Supplier<? extends Fluid> stillSupplier,
                Supplier<? extends Fluid> flowingSupplier,
                Supplier<? extends Item> bucketSupplier,
                Supplier<? extends LiquidBlock> blockSupplier,
                Supplier<FluidType> fluidTypeSupplier
        ) {
            super(stillSupplier, flowingSupplier, bucketSupplier, blockSupplier);
            this.fluidTypeSupplier = fluidTypeSupplier;
        }

        @Override
        public FluidType getFluidType() {
            return this.fluidTypeSupplier.get();
        }
    }

    public static class Flowing extends BaseFluid.Flowing {
        private final Supplier<FluidType> fluidTypeSupplier;

        public Flowing(
                Supplier<? extends Fluid> stillSupplier,
                Supplier<? extends Fluid> flowingSupplier,
                Supplier<? extends Item> bucketSupplier,
                Supplier<? extends LiquidBlock> blockSupplier,
                Supplier<FluidType> fluidTypeSupplier
        ) {
            super(stillSupplier, flowingSupplier, bucketSupplier, blockSupplier);
            this.fluidTypeSupplier = fluidTypeSupplier;
        }

        @Override
        public FluidType getFluidType() {
            return this.fluidTypeSupplier.get();
        }
    }
}