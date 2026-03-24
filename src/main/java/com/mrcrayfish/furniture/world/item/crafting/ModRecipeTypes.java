package com.mrcrayfish.furniture.world.item.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Author: MrCrayfish
 */
public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "cfm");

    public static final DeferredHolder<RecipeType<?>, RecipeType<GrillCookingRecipe>> GRILL_COOKING = RECIPE_TYPES.register("grill_cooking",
            () -> new RecipeType<GrillCookingRecipe>() {
                @Override
                public String toString() {
                    return "cfm:grill_cooking";
                }
    });




}