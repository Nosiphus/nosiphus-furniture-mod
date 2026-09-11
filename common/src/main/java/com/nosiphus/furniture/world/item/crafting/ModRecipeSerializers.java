package com.nosiphus.furniture.world.item.crafting;

import com.nosiphus.furniture.platform.Services;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers
{
    public static final Supplier<RecipeSerializer<ChoppingRecipe>> CHOPPING =
            Services.REGISTRY.registerRecipeSerializer("chopping", ChoppingRecipe.Serializer::new);

    public static final Supplier<RecipeSerializer<CookingRecipe>> COOKING =
            Services.REGISTRY.registerRecipeSerializer("cooking", CookingRecipe.Serializer::new);

    public static final Supplier<RecipeSerializer<ToastingRecipe>> TOASTING =
            Services.REGISTRY.registerRecipeSerializer("toasting", () -> new SimpleCookingSerializer<>(ToastingRecipe::new, 100));

    public static void init() {}
}