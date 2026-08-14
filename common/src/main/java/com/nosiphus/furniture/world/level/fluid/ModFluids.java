package com.nosiphus.furniture.world.level.fluid;

import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class ModFluids {

    public static void init() {

    }

    public static final Supplier<FlowingFluid> SOAPY_WATER = Services.REGISTRY.registerSourceFluid("soapy_water",
            () -> ModFluids.SOAPY_WATER.get(),
            () -> ModFluids.SOAPY_WATER_FLOWING.get(),
            () -> ModItems.SOAPY_WATER_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.SOAPY_WATER.get()
    );

    public static final Supplier<FlowingFluid> SOAPY_WATER_FLOWING = Services.REGISTRY.registerFlowingFluid("soapy_water_flowing",
            () -> ModFluids.SOAPY_WATER.get(),
            () -> ModFluids.SOAPY_WATER_FLOWING.get(),
            () -> ModItems.SOAPY_WATER_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.SOAPY_WATER.get()
    );

    public static final Supplier<FlowingFluid> SUPER_SOAPY_WATER = Services.REGISTRY.registerSourceFluid("super_soapy_water",
            () -> ModFluids.SUPER_SOAPY_WATER.get(),
            () -> ModFluids.SUPER_SOAPY_WATER_FLOWING.get(),
            () -> ModItems.SUPER_SOAPY_WATER_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.SUPER_SOAPY_WATER.get()
    );

    public static final Supplier<FlowingFluid> SUPER_SOAPY_WATER_FLOWING = Services.REGISTRY.registerFlowingFluid("super_soapy_water_flowing",
            () -> ModFluids.SUPER_SOAPY_WATER.get(),
            () -> ModFluids.SUPER_SOAPY_WATER_FLOWING.get(),
            () -> ModItems.SUPER_SOAPY_WATER_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.SUPER_SOAPY_WATER.get()
    );
}