package com.nosiphus.furniture.world.item.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "nfm");

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ChoppingRecipe>> CHOPPING =
            RECIPE_SERIALIZERS.register("chopping", ChoppingRecipe.Serializer::new);
}