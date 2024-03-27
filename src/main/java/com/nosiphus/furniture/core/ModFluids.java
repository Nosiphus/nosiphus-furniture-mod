package com.nosiphus.furniture.core;

import com.nosiphus.furniture.fluid.SoapyWaterFluid;
import net.minecraft.core.Registry;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, "nfm");

    public static final RegistryObject<FlowingFluid> FLOWING_SOAPY_WATER = register("flowing_soapy_water",
            () -> new SoapyWaterFluid.Flowing());
    public static final RegistryObject<FlowingFluid> SOAPY_WATER = register("flowing_super_soapy_water",
            () -> new SoapyWaterFluid.Source());

    public static <T extends Fluid> void register(String name, T tValue) {
        FLUIDS.register(name, tValue);
    }

}