package com.nosiphus.furniture.client;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ModFluidRenderers {

    public static final ResourceLocation WATER_STILL = ResourceLocation.parse("block/water_still");
    public static final ResourceLocation WATER_FLOW = ResourceLocation.parse("block/water_flow");

    public static final ResourceLocation COOKIES_AND_CREAM_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/cookies_and_cream");
    public static final ResourceLocation EGG_NOG_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/egg_nog");
    public static final ResourceLocation ENERGY_DRINK_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/energy_drink");
    public static final ResourceLocation FRUIT_CRUSH_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/fruit_crush");
    public static final ResourceLocation VEGGIE_JUICE_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/veggie_juice");

    public static final ResourceLocation SOAP_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/soapy_water");
    public static final ResourceLocation SUPER_SOAP_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/super_soapy_water");

    public static final int COOKIES_AND_CREAM_TINT = 0xB59774;
    public static final int EGG_NOG_TINT = 0xB2A47D;
    public static final int ENERGY_DRINK_TINT = 0x421006;
    public static final int FRUIT_CRUSH_TINT = 0xBB2B1B;
    public static final int VEGGIE_JUICE_TINT = 0xB06357;

    public static final int SOAPY_WATER_TINT = 0x1FA0FF;
    public static final int SUPER_SOAPY_WATER_TINT = 0xC5FF1F;

    public static void register() {
        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.COOKIES_AND_CREAM.get(),
                ModFluids.COOKIES_AND_CREAM_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, COOKIES_AND_CREAM_OVERLAY, COOKIES_AND_CREAM_TINT)
        );

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.EGG_NOG.get(),
                ModFluids.EGG_NOG_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, EGG_NOG_OVERLAY, EGG_NOG_TINT)
        );

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.ENERGY_DRINK.get(),
                ModFluids.ENERGY_DRINK_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, ENERGY_DRINK_OVERLAY, ENERGY_DRINK_TINT)
        );

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.FRUIT_CRUSH.get(),
                ModFluids.FRUIT_CRUSH_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, FRUIT_CRUSH_OVERLAY, FRUIT_CRUSH_TINT)
        );

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.VEGGIE_JUICE.get(),
                ModFluids.VEGGIE_JUICE_FLOWING.get(),
                new SimpleFluidRenderHandler(WATER_STILL, WATER_FLOW, VEGGIE_JUICE_OVERLAY, VEGGIE_JUICE_TINT)
        );

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
                ModFluids.COOKIES_AND_CREAM.get(),
                ModFluids.COOKIES_AND_CREAM_FLOWING.get(),
                ModFluids.EGG_NOG.get(),
                ModFluids.EGG_NOG_FLOWING.get(),
                ModFluids.ENERGY_DRINK.get(),
                ModFluids.ENERGY_DRINK_FLOWING.get(),
                ModFluids.FRUIT_CRUSH.get(),
                ModFluids.FRUIT_CRUSH_FLOWING.get(),
                ModFluids.VEGGIE_JUICE.get(),
                ModFluids.VEGGIE_JUICE_FLOWING.get(),
                ModFluids.SOAPY_WATER.get(),
                ModFluids.SOAPY_WATER_FLOWING.get(),
                ModFluids.SUPER_SOAPY_WATER.get(),
                ModFluids.SUPER_SOAPY_WATER_FLOWING.get()
        );
    }
}