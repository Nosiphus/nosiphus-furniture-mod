package com.mrcrayfish.furniture.world.item.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Author: MrCrayfish
 */
public class ModRecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "cfm");

    public static final DeferredHolder<RecipeSerializer<?>, SimpleCookingSerializer<GrillCookingRecipe>> GRILL_COOKING = RECIPE_SERIALIZERS.register("grill_cooking",
            () -> new SimpleCookingSerializer<>(GrillCookingRecipe::new, 100));
}