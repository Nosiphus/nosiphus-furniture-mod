package com.nosiphus.furniture.common;

import com.nosiphus.furniture.Reference;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

/**
 * Author: MrCrayfish
 */
public class ModTags
{
    public static class Items
    {
        public static final ITag.INamedTag<Item> BEDROOM = tag("bedroom");
        public static final ITag.INamedTag<Item> BATHROOM = tag("bathroom");
        public static final ITag.INamedTag<Item> GENERAL = tag("general");
        public static final ITag.INamedTag<Item> KITCHEN = tag("kitchen");
        public static final ITag.INamedTag<Item> STORAGE = tag("storage");

        private static ITag.INamedTag<Item> tag(String name)
        {
            return ItemTags.createOptional(new ResourceLocation(Reference.MOD_ID, name));
        }
    }
}