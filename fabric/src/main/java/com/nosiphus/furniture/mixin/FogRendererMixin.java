package com.nosiphus.furniture.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {

    @Shadow private static float fogRed;
    @Shadow private static float fogGreen;
    @Shadow private static float fogBlue;

    @Inject(method = "setupColor", at = @At("RETURN"))
    private static void setupSoapyWaterFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, CallbackInfo ci) {
        BlockPos pos = camera.getBlockPosition();
        FluidState state = level.getFluidState(pos);

        if (state.is(ModFluids.SOAPY_WATER.get()) || state.is(ModFluids.SOAPY_WATER_FLOWING.get())) {
            fogRed = 31f / 255f;
            fogGreen = 160f / 255f;
            fogBlue = 255f / 255f;
        } else if (state.is(ModFluids.SUPER_SOAPY_WATER.get()) || state.is(ModFluids.SUPER_SOAPY_WATER_FLOWING.get())) {
            fogRed = 197f / 255f;
            fogGreen = 255f / 255f;
            fogBlue = 31f / 255f;
        }
    }

    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void setupSoapyWaterFogDistance(Camera camera, FogRenderer.FogMode mode, float renderDistance, boolean thickFog, float partialTick, CallbackInfo ci) {
        FluidState state = camera.getEntity().level().getFluidState(camera.getBlockPosition());

        if (state.is(ModFluids.SOAPY_WATER.get()) || state.is(ModFluids.SOAPY_WATER_FLOWING.get()) ||
                state.is(ModFluids.SUPER_SOAPY_WATER.get()) || state.is(ModFluids.SUPER_SOAPY_WATER_FLOWING.get())) {

            RenderSystem.setShaderFogStart(1.0f);
            RenderSystem.setShaderFogEnd(6.0f);
            ci.cancel();
        }
    }
}