package com.mrcrayfish.furniture.world.item.crafting;

import com.mrcrayfish.furniture.platform.Services;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModRecipeSerializers
{

    public static void init() {

    }

    public static final Supplier<SimpleCookingSerializer<FreezerSolidifyRecipe>> FREEZER_SOLIDIFY = Services.REGISTRY.registerRecipeSerializer("freezer_solidify",
            () -> new SimpleCookingSerializer<>(FreezerSolidifyRecipe::new, 100));

    public static final Supplier<SimpleCookingSerializer<GrillCookingRecipe>> GRILL_COOKING = Services.REGISTRY.registerRecipeSerializer("grill_cooking",
            () -> new SimpleCookingSerializer<>(GrillCookingRecipe::new, 100));
}