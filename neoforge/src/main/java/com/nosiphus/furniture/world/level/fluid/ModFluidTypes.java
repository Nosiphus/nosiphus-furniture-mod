package com.nosiphus.furniture.world.level.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class ModFluidTypes {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, NosiphusFurnitureMod.MOD_ID);

    public static final ResourceLocation WATER_STILL = ResourceLocation.parse("block/water_still");
    public static final ResourceLocation WATER_FLOW = ResourceLocation.parse("block/water_flow");

    public static final ResourceLocation COOKIES_AND_CREAM_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/cookies_and_cream");
    public static final ResourceLocation COOKIES_AND_CREAM_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/cookies_and_cream.png");
    public static final ResourceLocation EGG_NOG_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/egg_nog");
    public static final ResourceLocation EGG_NOG_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/egg_nog.png");
    public static final ResourceLocation ENERGY_DRINK_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/energy_drink");
    public static final ResourceLocation ENERGY_DRINK_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/energy_drink.png");
    public static final ResourceLocation FRUIT_CRUSH_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/fruit_crush");
    public static final ResourceLocation FRUIT_CRUSH_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/fruit_crush.png");
    public static final ResourceLocation VEGGIE_JUICE_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/veggie_juice");
    public static final ResourceLocation VEGGIE_JUICE_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/veggie_juice.png");

    public static final ResourceLocation SOAP_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/soapy_water");
    public static final ResourceLocation SOAP_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/soapy_water.png");
    public static final ResourceLocation SUPER_SOAP_OVERLAY = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "block/super_soapy_water");
    public static final ResourceLocation SUPER_SOAP_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/super_soapy_water.png");

    public static final DeferredHolder<FluidType, FluidType> COOKIES_AND_CREAM_TYPE = register("cookies_and_cream",
            0xA1B59774, new Vec3(181f / 255f, 151f / 255f, 116f / 255f), COOKIES_AND_CREAM_OVERLAY, COOKIES_AND_CREAM_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> EGG_NOG_TYPE = register("egg_nog",
            0xA1B2A47D, new Vec3(178f / 255f, 164f / 255f, 125f / 255f), EGG_NOG_OVERLAY, EGG_NOG_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> ENERGY_DRINK_TYPE = register("energy_drink",
            0xA1421006, new Vec3(66f / 255f, 16f / 255f, 6f / 255f), ENERGY_DRINK_OVERLAY, ENERGY_DRINK_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> FRUIT_CRUSH_TYPE = register("fruit_crush",
            0xA1BB2B1B, new Vec3(187f / 255f, 43f / 255f, 27f / 255f), FRUIT_CRUSH_OVERLAY, FRUIT_CRUSH_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> VEGGIE_JUICE_TYPE = register("veggie_juice",
            0xA1B06357, new Vec3(176f / 255f, 99f / 255f, 87f / 255f), VEGGIE_JUICE_OVERLAY, VEGGIE_JUICE_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> SOAPY_WATER_TYPE = register("soapy_water",
            0xA11FA0FF, new Vec3(31f / 255f, 160f / 255f, 255f / 255f), SOAP_OVERLAY, SOAP_SCREEN, 7);

    public static final DeferredHolder<FluidType, FluidType> SUPER_SOAPY_WATER_TYPE = register("super_soapy_water",
            0xA1C5FF1F, new Vec3(197f / 255f, 255f / 255f, 31f / 255f), SUPER_SOAP_OVERLAY, SUPER_SOAP_SCREEN, 9);

    private static DeferredHolder<FluidType, FluidType> register(String name, int tint, Vec3 fogColor, ResourceLocation sideOverlay, ResourceLocation screenOverlay, int viscosity) {
        return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                .lightLevel(2)
                .density(15)
                .viscosity(viscosity)
                .canSwim(true)
                .canDrown(true)
                .canExtinguish(false)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {

            @Override
            public boolean canSwim(Entity entity) {
                return true;
            }

            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() { return WATER_STILL; }

                    @Override
                    public ResourceLocation getFlowingTexture() { return WATER_FLOW; }

                    @Override
                    public ResourceLocation getOverlayTexture() { return sideOverlay; }

                    @Override
                    public ResourceLocation getRenderOverlayTexture(Minecraft mc) { return screenOverlay; }

                    @Override
                    public int getTintColor() { return tint; }

                    @Override
                    public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                        return new Vector3f((float) fogColor.x, (float) fogColor.y, (float) fogColor.z);
                    }

                    @Override
                    public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                        RenderSystem.setShaderFogStart(1f);
                        RenderSystem.setShaderFogEnd(6f);
                    }
                });
            }
        });
    }
}