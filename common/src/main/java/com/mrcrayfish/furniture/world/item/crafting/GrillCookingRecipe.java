package com.mrcrayfish.furniture.world.item.crafting;

import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Author: MrCrayfish
 */
public class GrillCookingRecipe extends AbstractCookingRecipe
{
    public GrillCookingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime)
    {
        super(ModRecipeTypes.GRILL_COOKING.get(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public ItemStack getToastSymbol()
    {
        return new ItemStack(ModBlocks.RED_GRILL.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.GRILL_COOKING.get();
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}