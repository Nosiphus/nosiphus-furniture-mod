package com.nosiphus.furniture.world.item.crafting;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ToastingRecipe extends AbstractCookingRecipe
{
    public ToastingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime)
    {
        super(ModRecipeTypes.TOASTING.get(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public ItemStack getToastSymbol()
    {
        return new ItemStack(ModBlocks.TOASTER_LIGHT.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.TOASTING.get();
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}