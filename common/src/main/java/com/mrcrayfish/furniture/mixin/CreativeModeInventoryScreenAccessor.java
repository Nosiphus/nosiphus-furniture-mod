package com.mrcrayfish.furniture.mixin;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeModeInventoryScreen.class)
public interface CreativeModeInventoryScreenAccessor {

    @Accessor("selectedTab")
    static CreativeModeTab cfm$getSelectedTab() {
        throw new AssertionError();
    }

    @Accessor("selectedTab")
    static void cfm$setSelectedTab(CreativeModeTab tab) {
        throw new AssertionError();
    }
}