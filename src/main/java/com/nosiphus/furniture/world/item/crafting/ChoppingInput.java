package com.nosiphus.furniture.world.item.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ChoppingInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        if (index != 0) throw new IllegalArgumentException("Chopping board only has one slot (index 0)");
        return this.input;
    }

    @Override
    public int size() {
        return 1;
    }
}