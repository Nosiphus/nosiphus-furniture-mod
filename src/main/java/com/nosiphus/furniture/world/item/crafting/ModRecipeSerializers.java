package com.nosiphus.furniture.world.item.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "nfm");

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ChoppingRecipe>> CHOPPING =
            RECIPE_SERIALIZERS.register("chopping", ChoppingRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CookingRecipe>> COOKING =
            RECIPE_SERIALIZERS.register("cooking", CookingRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, SimpleCookingSerializer<ToastingRecipe>> TOASTING = RECIPE_SERIALIZERS.register("toasting",
            () -> new SimpleCookingSerializer<>(ToastingRecipe::new, 100));
}