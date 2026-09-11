package com.nosiphus.furniture.client;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ModFluidRenderers {

    public static final ResourceLocation WATER_STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOW = new ResourceLocation("block/water_flow");

    public static final ResourceLocation SOAP_OVERLAY = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "block/soapy_water");
    public static final ResourceLocation SUPER_SOAP_OVERLAY = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "block/super_soapy_water");

    public static final int SOAPY_WATER_TINT = 0x1FA0FF;
    public static final int SUPER_SOAPY_WATER_TINT = 0xC5FF1F;

    public static void register() {
        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.SOAPY_WATER.get(),
                ModFluids.SOAPY_WATER_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, SOAP_OVERLAY, SOAPY_WATER_TINT)
        );

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.SUPER_SOAPY_WATER.get(),
                ModFluids.SUPER_SOAPY_WATER_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, SUPER_SOAP_OVERLAY, SUPER_SOAPY_WATER_TINT)
        );

        BlockRenderLayerMap.INSTANCE.putFluids(
                RenderType.translucent(),
                ModFluids.SOAPY_WATER.get(),
                ModFluids.SOAPY_WATER_FLOWING.get(),
                ModFluids.SUPER_SOAPY_WATER.get(),
                ModFluids.SUPER_SOAPY_WATER_FLOWING.get()
        );
    }
}