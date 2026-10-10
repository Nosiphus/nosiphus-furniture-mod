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

    // Drinks
    public static final Supplier<FlowingFluid> COOKIES_AND_CREAM = Services.REGISTRY.registerSourceFluid("cookies_and_cream",
            () -> ModFluids.COOKIES_AND_CREAM.get(),
            () -> ModFluids.COOKIES_AND_CREAM_FLOWING.get(),
            () -> ModItems.COOKIES_AND_CREAM_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.COOKIES_AND_CREAM.get()
    );

    public static final Supplier<FlowingFluid> COOKIES_AND_CREAM_FLOWING = Services.REGISTRY.registerFlowingFluid("cookies_and_cream_flowing",
            () -> ModFluids.COOKIES_AND_CREAM.get(),
            () -> ModFluids.COOKIES_AND_CREAM_FLOWING.get(),
            () -> ModItems.COOKIES_AND_CREAM_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.COOKIES_AND_CREAM.get()
    );

    public static final Supplier<FlowingFluid> EGG_NOG = Services.REGISTRY.registerSourceFluid("egg_nog",
            () -> ModFluids.EGG_NOG.get(),
            () -> ModFluids.EGG_NOG_FLOWING.get(),
            () -> ModItems.EGG_NOG_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.EGG_NOG.get()
    );

    public static final Supplier<FlowingFluid> EGG_NOG_FLOWING = Services.REGISTRY.registerFlowingFluid("egg_nog_flowing",
            () -> ModFluids.EGG_NOG.get(),
            () -> ModFluids.EGG_NOG_FLOWING.get(),
            () -> ModItems.EGG_NOG_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.EGG_NOG.get()
    );

    public static final Supplier<FlowingFluid> ENERGY_DRINK = Services.REGISTRY.registerSourceFluid("energy_drink",
            () -> ModFluids.ENERGY_DRINK.get(),
            () -> ModFluids.ENERGY_DRINK_FLOWING.get(),
            () -> ModItems.ENERGY_DRINK_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.ENERGY_DRINK.get()
    );

    public static final Supplier<FlowingFluid> ENERGY_DRINK_FLOWING = Services.REGISTRY.registerFlowingFluid("energy_drink_flowing",
            () -> ModFluids.ENERGY_DRINK.get(),
            () -> ModFluids.ENERGY_DRINK_FLOWING.get(),
            () -> ModItems.ENERGY_DRINK_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.ENERGY_DRINK.get()
    );

    public static final Supplier<FlowingFluid> FRUIT_CRUSH = Services.REGISTRY.registerSourceFluid("fruit_crush",
            () -> ModFluids.FRUIT_CRUSH.get(),
            () -> ModFluids.FRUIT_CRUSH_FLOWING.get(),
            () -> ModItems.FRUIT_CRUSH_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.FRUIT_CRUSH.get()
    );

    public static final Supplier<FlowingFluid> FRUIT_CRUSH_FLOWING = Services.REGISTRY.registerFlowingFluid("fruit_crush_flowing",
            () -> ModFluids.FRUIT_CRUSH.get(),
            () -> ModFluids.FRUIT_CRUSH_FLOWING.get(),
            () -> ModItems.FRUIT_CRUSH_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.FRUIT_CRUSH.get()
    );

    public static final Supplier<FlowingFluid> VEGGIE_JUICE = Services.REGISTRY.registerSourceFluid("veggie_juice",
            () -> ModFluids.VEGGIE_JUICE.get(),
            () -> ModFluids.VEGGIE_JUICE_FLOWING.get(),
            () -> ModItems.VEGGIE_JUICE_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.VEGGIE_JUICE.get()
    );

    public static final Supplier<FlowingFluid> VEGGIE_JUICE_FLOWING = Services.REGISTRY.registerFlowingFluid("veggie_juice_flowing",
            () -> ModFluids.VEGGIE_JUICE.get(),
            () -> ModFluids.VEGGIE_JUICE_FLOWING.get(),
            () -> ModItems.VEGGIE_JUICE_BUCKET.get(),
            () -> (LiquidBlock) ModBlocks.VEGGIE_JUICE.get()
    );

    // Soaps
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