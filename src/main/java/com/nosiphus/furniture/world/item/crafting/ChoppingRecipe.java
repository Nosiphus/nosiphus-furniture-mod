package com.nosiphus.furniture.world.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ChoppingRecipe implements Recipe<ChoppingInput> {
    private final Ingredient base;
    private final ItemStack result;

    public ChoppingRecipe(Ingredient base, ItemStack result) {
        this.base = base;
        this.result = result;
    }

    @Override
    public boolean matches(ChoppingInput input, Level level) {
        return this.base.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(ChoppingInput input, HolderLookup.Provider registries) {
        ItemStack itemStack = this.result.copy();
        itemStack.applyComponents(input.getItem(0).getComponents());
        return itemStack;
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
        public static final MapCodec<ChoppingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("base").forGetter(r -> r.base),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(inst, ChoppingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ChoppingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, r -> r.base,
                ItemStack.STREAM_CODEC, r -> r.result,
                ChoppingRecipe::new
        );

        @Override
        public MapCodec<ChoppingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ChoppingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}