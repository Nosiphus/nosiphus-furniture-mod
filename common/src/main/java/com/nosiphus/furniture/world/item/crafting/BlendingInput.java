package com.nosiphus.furniture.world.item.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record BlendingInput(List<ItemStack> inputs) implements RecipeInput {

    @Override
    public ItemStack getItem(int index) {
        if (index < 0 || index >= this.inputs.size()) {
            throw new IllegalArgumentException("Invalid slot index for blender input: " + index);
        }
        return this.inputs.get(index);
    }

    @Override
    public int size() {
        return this.inputs.size();
    }
}