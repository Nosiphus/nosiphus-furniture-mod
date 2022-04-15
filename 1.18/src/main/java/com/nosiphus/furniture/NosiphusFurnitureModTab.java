package com.nosiphus.furniture;

import com.nosiphus.furniture.core.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class NosiphusFurnitureModTab extends CreativeModeTab {

    public NosiphusFurnitureModTab(String label) {

        super(label);

    }

    @Override
    public ItemStack makeIcon() {

        return new ItemStack(ModBlocks.CHAIR_WHITE_MODERN.get());

    }

}
