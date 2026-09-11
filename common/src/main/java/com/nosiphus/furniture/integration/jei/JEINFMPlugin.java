package com.nosiphus.furniture.integration.jei;

import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEINFMPlugin implements IModPlugin {

    public static final RecipeType<CookingRecipe> COOKING_TYPE = new RecipeType<>(CookingRecipeCategory.UID, CookingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("nfm", "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CookingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<CookingRecipe> cookingRecipes = recipeManager.getAllRecipesFor(ModRecipeTypes.COOKING.get());

        registration.addRecipes(COOKING_TYPE, cookingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MICROWAVE_LIGHT.get()), COOKING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MICROWAVE_DARK.get()), COOKING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.OVEN_LIGHT.get()), COOKING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.OVEN_DARK.get()), COOKING_TYPE);
    }
}