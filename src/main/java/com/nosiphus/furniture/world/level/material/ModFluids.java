package com.nosiphus.furniture.world.level.material;

import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, "nfm");

    public static final DeferredHolder<Fluid, FlowingFluid> SOAPY_WATER = FLUIDS.register("soapy_water",
            () -> new BaseFlowingFluid.Source(ModFluids.SOAPY_WATER_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SOAPY_WATER_FLOWING = FLUIDS.register("soapy_water_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SOAPY_WATER_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SUPER_SOAPY_WATER = FLUIDS.register("super_soapy_water",
            () -> new BaseFlowingFluid.Source(ModFluids.SUPER_SOAPY_WATER_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SUPER_SOAPY_WATER_FLOWING = FLUIDS.register("super_soapy_water_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SUPER_SOAPY_WATER_PROPERTIES));

    public static final BaseFlowingFluid.Properties SOAPY_WATER_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SOAPY_WATER_TYPE, SOAPY_WATER, SOAPY_WATER_FLOWING)
            .bucket(ModItems.SOAPY_WATER_BUCKET)
            .block(ModBlocks.SOAPY_WATER)
            .levelDecreasePerBlock(2)
            .slopeFindDistance(2);

    public static final BaseFlowingFluid.Properties SUPER_SOAPY_WATER_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SUPER_SOAPY_WATER_TYPE, SUPER_SOAPY_WATER, SUPER_SOAPY_WATER_FLOWING)
            .bucket(ModItems.SUPER_SOAPY_WATER_BUCKET)
            .block(ModBlocks.SUPER_SOAPY_WATER)
            .levelDecreasePerBlock(2)
            .slopeFindDistance(2);;
}