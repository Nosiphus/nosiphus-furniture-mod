package com.nosiphus.furniture.world.item.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Author: MrCrayfish
 */
public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "nfm");

    public static final DeferredHolder<RecipeType<?>, RecipeType<ChoppingRecipe>> CHOPPING = RECIPE_TYPES.register("chopping",
            () -> new RecipeType<ChoppingRecipe>() {
                @Override
                public String toString() {
                    return "nfm:chopping";
                }
            });
}