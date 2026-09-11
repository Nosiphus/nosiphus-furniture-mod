package com.nosiphus.furniture.world.item.crafting;

import com.nosiphus.furniture.platform.Services;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class ModRecipeTypes
{
    public static final Supplier<RecipeType<ChoppingRecipe>> CHOPPING = Services.REGISTRY.registerRecipeType("chopping",
            () -> new RecipeType<ChoppingRecipe>() {
                @Override
                public String toString() {
                    return "nfm:chopping";
                }
            });

    public static final Supplier<RecipeType<CookingRecipe>> COOKING = Services.REGISTRY.registerRecipeType("cooking",
            () -> new RecipeType<CookingRecipe>() {
                @Override
                public String toString() {
                    return "nfm:cooking";
                }
            });

    public static final Supplier<RecipeType<ToastingRecipe>> TOASTING = Services.REGISTRY.registerRecipeType("toasting",
            () -> new RecipeType<ToastingRecipe>() {
                @Override
                public String toString() {
                    return "nfm:toasting";
                }
            });

    public static void init() {}
}