package com.nosiphus.furniture.tags;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModFluidTags {
    public static final TagKey<Fluid> SOAPY_FLUIDS = TagKey.create(
            Registries.FLUID,
            ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "soapy_fluids")
    );
}