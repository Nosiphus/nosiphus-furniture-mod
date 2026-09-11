package com.nosiphus.furniture.mixin;

import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {

    @Inject(method = "getCategory", at = @At("HEAD"), cancellable = true)
    private static void nfm$handleCookingRecipeCategory(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookCategories> cir) {
        if (recipe instanceof CookingRecipe) {
            cir.setReturnValue(RecipeBookCategories.CAMPFIRE);
        }
    }
}