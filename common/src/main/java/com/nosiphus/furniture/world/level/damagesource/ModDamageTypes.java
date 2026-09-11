package com.nosiphus.furniture.world.level.damagesource;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> ELECTRIC_FENCE = ResourceKey.create(
            Registries.DAMAGE_TYPE,
            new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "electric_fence")
    );
}