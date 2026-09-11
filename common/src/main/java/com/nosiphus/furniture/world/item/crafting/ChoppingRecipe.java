package com.nosiphus.furniture.world.item.crafting;

import com.google.gson.JsonObject;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ChoppingRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final Ingredient base;
    private final ItemStack result;

    public ChoppingRecipe(ResourceLocation id, Ingredient base, ItemStack result) {
        this.id = id;
        this.base = base;
        this.result = result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.base.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        ItemStack itemStack = this.result.copy();
        if (container.getItem(0).hasTag()) {
            itemStack.setTag(container.getItem(0).getTag().copy());
        }
        return itemStack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.base);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.CHOPPING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.CHOPPING.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.OAK_CHOPPING_BOARD.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Serializer implements RecipeSerializer<ChoppingRecipe> {

        @Override
        public ChoppingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            Ingredient base = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "base"));
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            return new ChoppingRecipe(recipeId, base, result);
        }

        @Nullable
        @Override
        public ChoppingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            Ingredient base = Ingredient.fromNetwork(buffer);
            ItemStack result = buffer.readItem();
            return new ChoppingRecipe(recipeId, base, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ChoppingRecipe recipe) {
            recipe.base.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }
}