package com.nosiphus.furniture.integration.jei;

import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CookingRecipeCategory implements IRecipeCategory<CookingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation("nfm", "cooking");
    public final static ResourceLocation TEXTURE = new ResourceLocation("nfm", "textures/gui/microwave.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CookingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 22, 0, 132, 73);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MICROWAVE_LIGHT.get()));
    }

    @Override
    public RecipeType<CookingRecipe> getRecipeType() {
        return JEINFMPlugin.COOKING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.nfm.microwave");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, CookingRecipe cookingRecipe, IFocusGroup iFocusGroup) {
        RegistryAccess registryAccess = Minecraft.getInstance().level != null
                ? Minecraft.getInstance().level.registryAccess()
                : RegistryAccess.EMPTY;

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 43, 20).addIngredients(cookingRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 43, 43).addItemStack(cookingRecipe.getResultItem(registryAccess));
    }
}