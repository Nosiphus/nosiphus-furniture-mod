package com.nosiphus.furniture.world.item.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BlendingRecipe implements Recipe<Container> {

    public record CountedIngredient(Ingredient ingredient, int count) {
        public boolean test(ItemStack stack) {
            return this.ingredient.test(stack) && stack.getCount() >= this.count;
        }

        public static CountedIngredient fromJson(JsonObject json) {
            Ingredient ingredient = Ingredient.fromJson(json.get("ingredient"));
            int count = GsonHelper.getAsInt(json, "count", 1);
            return new CountedIngredient(ingredient, count);
        }

        public void toNetwork(FriendlyByteBuf buffer) {
            this.ingredient.toNetwork(buffer);
            buffer.writeVarInt(this.count);
        }

        public static CountedIngredient fromNetwork(FriendlyByteBuf buffer) {
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            int count = buffer.readVarInt();
            return new CountedIngredient(ingredient, count);
        }
    }

    private final ResourceLocation id;
    private final NonNullList<CountedIngredient> ingredients;
    private final Fluid resultFluid;
    private final int fluidAmount;
    private final ItemStack remainder;

    public BlendingRecipe(ResourceLocation id, NonNullList<CountedIngredient> ingredients, Fluid resultFluid, int fluidAmount, ItemStack remainder) {
        this.id = id;
        this.ingredients = ingredients;
        this.resultFluid = resultFluid;
        this.fluidAmount = fluidAmount;
        this.remainder = remainder;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean matches(Container container, Level level) {
        List<ItemStack> available = new ArrayList<>();
        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                available.add(stack.copy());
            }
        }

        for (CountedIngredient req : this.ingredients) {
            int needed = req.count();
            for (ItemStack current : available) {
                if (req.ingredient().test(current)) {
                    int take = Math.min(needed, current.getCount());
                    needed -= take;
                    current.shrink(take);
                    if (needed <= 0) break;
                }
            }
            if (needed > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    public Fluid getResultFluid() {
        return this.resultFluid;
    }

    public int getFluidAmount() {
        return this.fluidAmount;
    }

    public ItemStack getRemainder() {
        return this.remainder.copy();
    }

    public NonNullList<CountedIngredient> getCountedIngredients() {
        return this.ingredients;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        for (CountedIngredient ci : this.ingredients) {
            list.add(ci.ingredient());
        }
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.BLENDING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.BLENDING.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.BLENDER_LIGHT.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Serializer implements RecipeSerializer<BlendingRecipe> {

        @Override
        public BlendingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            JsonArray ingredientsArray = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<CountedIngredient> ingredients = NonNullList.create();
            for (int i = 0; i < ingredientsArray.size(); i++) {
                ingredients.add(CountedIngredient.fromJson(ingredientsArray.get(i).getAsJsonObject()));
            }

            JsonObject resultObj = GsonHelper.getAsJsonObject(json, "result");
            ResourceLocation fluidId = new ResourceLocation(GsonHelper.getAsString(resultObj, "fluid"));
            Fluid resultFluid = BuiltInRegistries.FLUID.get(fluidId);
            int fluidAmount = GsonHelper.getAsInt(resultObj, "amount", 1000);

            ItemStack remainder = ItemStack.EMPTY;
            if (json.has("remainder")) {
                remainder = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "remainder"));
            }

            return new BlendingRecipe(recipeId, ingredients, resultFluid, fluidAmount, remainder);
        }

        @Nullable
        @Override
        public BlendingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            int size = buffer.readVarInt();
            NonNullList<CountedIngredient> ingredients = NonNullList.create();
            for (int i = 0; i < size; i++) {
                ingredients.add(CountedIngredient.fromNetwork(buffer));
            }

            ResourceLocation fluidId = buffer.readResourceLocation();
            Fluid resultFluid = BuiltInRegistries.FLUID.get(fluidId);
            int fluidAmount = buffer.readVarInt();
            ItemStack remainder = buffer.readItem();

            return new BlendingRecipe(recipeId, ingredients, resultFluid, fluidAmount, remainder);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, BlendingRecipe recipe) {
            buffer.writeVarInt(recipe.ingredients.size());
            for (CountedIngredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeResourceLocation(BuiltInRegistries.FLUID.getKey(recipe.resultFluid));
            buffer.writeVarInt(recipe.fluidAmount);
            buffer.writeItem(recipe.remainder);
        }
    }
}