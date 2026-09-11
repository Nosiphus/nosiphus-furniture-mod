package com.nosiphus.furniture.mixin;

import com.nosiphus.furniture.tags.ModFluidTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow public Level level;
    @Shadow protected boolean wasEyeInWater;

    @Shadow public abstract boolean isEyeInFluid(TagKey<Fluid> fluidTag);
    @Shadow public abstract boolean isSwimming();
    @Shadow public abstract boolean isSprinting();
    @Shadow public abstract boolean isUnderWater();
    @Shadow public abstract boolean isPassenger();
    @Shadow public abstract void setSwimming(boolean swimming);
    @Shadow public abstract BlockPos blockPosition();

    @Redirect(
            method = "updateInWaterStateAndDoWaterCurrentPushing",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;updateFluidHeightAndDoFluidPushing(Lnet/minecraft/tags/TagKey;D)Z"
            )
    )
    private boolean nfm$checkWaterAndSoapyWater(Entity entity, TagKey<Fluid> fluidTag, double motionScale) {
        boolean inWater = entity.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, motionScale);
        boolean inSoapyWater = entity.updateFluidHeightAndDoFluidPushing(ModFluidTags.SOAPY_FLUIDS, motionScale);
        return inWater || inSoapyWater;
    }

    @Inject(method = "updateFluidOnEyes", at = @At("TAIL"))
    private void nfm$soapyWaterEyeCheck(CallbackInfo ci) {
        if (this.isEyeInFluid(ModFluidTags.SOAPY_FLUIDS)) {
            this.wasEyeInWater = true;
        }
    }

    @Inject(method = "updateSwimming", at = @At("TAIL"))
    private void nfm$soapyWaterSwimming(CallbackInfo ci) {
        if (!this.isSwimming()) {
            if (this.isSprinting() && this.isUnderWater() && !this.isPassenger()
                    && this.level.getFluidState(this.blockPosition()).is(ModFluidTags.SOAPY_FLUIDS)) {
                this.setSwimming(true);
            }
        }
    }
}