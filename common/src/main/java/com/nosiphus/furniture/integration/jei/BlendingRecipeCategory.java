package com.nosiphus.furniture.integration.jei;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.world.item.crafting.BlendingRecipe;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.List;

public class BlendingRecipeCategory implements IRecipeCategory<BlendingRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "blending");
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableStatic arrow;

    public BlendingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createBlankDrawable(116, 54);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.BLENDER_LIGHT.get()));

        ResourceLocation vanillaGuiTextures = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/furnace.png");
        this.arrow = helper.createDrawable(vanillaGuiTextures, 79, 34, 24, 17);
    }

    @Override
    public RecipeType<BlendingRecipe> getRecipeType() {
        return JEINFMPlugin.BLENDING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.nfm.blender");
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
    public void setRecipe(IRecipeLayoutBuilder builder, BlendingRecipe recipe, IFocusGroup focuses) {
        List<BlendingRecipe.CountedIngredient> ingredients = recipe.getCountedIngredients();

        int[][] slotCoords = {
                {6, 9}, {24, 9},
                {6, 27}, {24, 27}
        };

        for (int i = 0; i < ingredients.size() && i < slotCoords.length; i++) {
            BlendingRecipe.CountedIngredient counted = ingredients.get(i);
            builder.addSlot(RecipeIngredientRole.INPUT, slotCoords[i][0], slotCoords[i][1])
                    .addIngredients(counted.ingredient())
                    .addTooltipCallback((view, tooltip) -> {
                        if (counted.count() > 1) {
                            tooltip.add(Component.literal("x" + counted.count()));
                        }
                    });
        }

        Fluid fluid = recipe.getResultFluid();
        int amount = recipe.getFluidAmount();
        if (fluid != null) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 11)
                    .addFluidStack(fluid, amount)
                    .setFluidRenderer(amount, true, 16, 32);
        }

        ItemStack remainder = recipe.getRemainder();
        if (!remainder.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 98, 27)
                    .addItemStack(remainder);
        }
    }

    @Override
    public void draw(BlendingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.arrow.draw(guiGraphics, 48, 18);
    }
}