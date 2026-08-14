package com.mrcrayfish.furniture.world.item.crafting;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.platform.Services;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModRecipeTypes
{

    public static void init() {

    }

    public static final Supplier<RecipeType<FreezerSolidifyRecipe>> FREEZER_SOLIDIFY = Services.REGISTRY.registerRecipeType("freezer_solidify",
            () -> create("freezer_solidify"));

    public static final Supplier<RecipeType<GrillCookingRecipe>> GRILL_COOKING = Services.REGISTRY.registerRecipeType("grill_cooking",
            () -> create("grill_cooking"));

    private static <T extends Recipe<?>> RecipeType<T> create(String name)
    {
        String id = MrCrayFishFurnitureMod.MOD_ID + ":" + name;
        return new RecipeType<>()
        {
            @Override
            public String toString()
            {
                return id;
            }
        };
    }
}