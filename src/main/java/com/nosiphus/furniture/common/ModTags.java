package com.nosiphus.furniture.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags
{
    public static class Items
    {
        public static final TagKey<Item> BEDROOM = tag("bedroom");
        public static final TagKey<Item> BATHROOM = tag("bathroom");
        public static final TagKey<Item> GENERAL = tag("general");
        public static final TagKey<Item> KITCHEN = tag("kitchen");
        public static final TagKey<Item> STORAGE = tag("storage");

        private static TagKey<Item> tag(String name)
        {
            return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("nfm", name));
        }
    }
}
