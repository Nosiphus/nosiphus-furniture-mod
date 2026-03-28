package com.nosiphus.furniture.world.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CookingRecipe implements Recipe<SingleRecipeInput> {
    private final Ingredient base;
    private final ItemStack result;

    public CookingRecipe(Ingredient base, ItemStack result) {
        this.base = base;
        this.result = result;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.base.test(input.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
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
        return ModRecipeSerializers.COOKING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.COOKING.get();
    }

    public static class Serializer implements RecipeSerializer<CookingRecipe> {
        public static final MapCodec<CookingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("base").forGetter(r -> r.base),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(inst, CookingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CookingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, r -> r.base,
                ItemStack.STREAM_CODEC, r -> r.result,
                CookingRecipe::new
        );

        @Override
        public MapCodec<CookingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CookingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}