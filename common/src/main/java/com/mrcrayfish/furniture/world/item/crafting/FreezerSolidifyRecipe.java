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
public class FreezerSolidifyRecipe extends AbstractCookingRecipe
{
    public FreezerSolidifyRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime)
    {
        super(ModRecipeTypes.FREEZER_SOLIDIFY.get(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public ItemStack getToastSymbol()
    {
        return new ItemStack(ModBlocks.FREEZER_LIGHT.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.FREEZER_SOLIDIFY.get();
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}