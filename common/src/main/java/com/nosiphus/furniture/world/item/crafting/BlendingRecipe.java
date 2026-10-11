package com.nosiphus.furniture.world.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;

public class BlendingRecipe implements Recipe<BlendingInput> {

    public record CountedIngredient(Ingredient ingredient, int count) {
        public static final Codec<CountedIngredient> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(CountedIngredient::ingredient),
                Codec.INT.optionalFieldOf("count", 1).forGetter(CountedIngredient::count)
        ).apply(instance, CountedIngredient::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CountedIngredient> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, CountedIngredient::ingredient,
                ByteBufCodecs.VAR_INT, CountedIngredient::count,
                CountedIngredient::new
        );

        public boolean test(ItemStack stack) {
            return this.ingredient.test(stack) && stack.getCount() >= this.count;
        }
    }

    private final NonNullList<CountedIngredient> ingredients;
    private final Fluid resultFluid;
    private final int fluidAmount;
    private final ItemStack remainder;

    public BlendingRecipe(NonNullList<CountedIngredient> ingredients, Fluid resultFluid, int fluidAmount, ItemStack remainder) {
        this.ingredients = ingredients;
        this.resultFluid = resultFluid;
        this.fluidAmount = fluidAmount;
        this.remainder = remainder;
    }

    @Override
    public boolean matches(BlendingInput input, Level level) {
        List<ItemStack> available = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
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
    public ItemStack assemble(BlendingInput input, HolderLookup.Provider registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
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

        public static final MapCodec<BlendingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                CountedIngredient.CODEC.listOf().fieldOf("ingredients").xmap(
                        list -> {
                            NonNullList<CountedIngredient> nbl = NonNullList.create();
                            nbl.addAll(list);
                            return nbl;
                        },
                        nbl -> nbl
                ).forGetter(r -> r.ingredients),
                BuiltInRegistries.FLUID.byNameCodec().fieldOf("result_fluid").forGetter(r -> r.resultFluid),
                Codec.INT.optionalFieldOf("fluid_amount", 1000).forGetter(r -> r.fluidAmount),
                ItemStack.STRICT_CODEC.optionalFieldOf("remainder", ItemStack.EMPTY).forGetter(r -> r.remainder)
        ).apply(instance, BlendingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BlendingRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::toNetwork,
                Serializer::fromNetwork
        );

        private static void toNetwork(RegistryFriendlyByteBuf buffer, BlendingRecipe recipe) {
            buffer.writeVarInt(recipe.ingredients.size());
            for (CountedIngredient ci : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ci.ingredient());
                buffer.writeVarInt(ci.count());
            }

            buffer.writeResourceLocation(BuiltInRegistries.FLUID.getKey(recipe.resultFluid));
            buffer.writeVarInt(recipe.fluidAmount);
            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.remainder);
        }

        private static BlendingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            int count = buffer.readVarInt();
            NonNullList<CountedIngredient> ingredients = NonNullList.create();
            for (int i = 0; i < count; i++) {
                Ingredient ing = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
                int amount = buffer.readVarInt();
                ingredients.add(new CountedIngredient(ing, amount));
            }

            ResourceLocation fluidId = buffer.readResourceLocation();
            Fluid fluid = BuiltInRegistries.FLUID.get(fluidId);
            int fluidAmount = buffer.readVarInt();
            ItemStack remainder = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new BlendingRecipe(ingredients, fluid, fluidAmount, remainder);
        }

        @Override
        public MapCodec<BlendingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BlendingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}