package com.mrcrayfish.furniture.mixin;

import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.CompatModule;
import net.mehvahdjukaar.every_compat.forge.EveryCompatForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;
import java.util.function.Supplier;

@Mixin(value = EveryCompatForge.class, remap = false)
public abstract class EveryCompatForgeMixin {

    @Redirect(
            method = "addModules",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/mehvahdjukaar/every_compat/EveryCompat;addIfLoaded(Ljava/lang/String;Ljava/util/function/Supplier;)V"
            )
    )
    private void redirectAddIfLoaded(String modId, Supplier<Function<String, CompatModule>> moduleSupplier) {
        if ("cfm".equals(modId) || "nfm".equals(modId)) {
            return;
        }
        EveryCompat.addIfLoaded(modId, moduleSupplier);
    }
}