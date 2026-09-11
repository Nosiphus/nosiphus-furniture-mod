package com.mrcrayfish.furniture.tags;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> UPGRADED_FENCES = tag("fences/upgraded");
    public static final TagKey<Item> PICKET_FENCES = tag("fences/picket");
    public static final TagKey<Item> UPGRADED_FENCE_GATES = tag("fence_gates/upgraded");
    public static final TagKey<Item> PICKET_FENCE_GATES = tag("fence_gates/picket");
    public static final TagKey<Item> HEDGES = tag("fences/hedge");
    public static final TagKey<Item> TRAMPOLINE = tag("trampoline");

    public static final TagKey<Item> BEDROOM = tag("bedroom");
    public static final TagKey<Item> GENERAL = tag("general");
    public static final TagKey<Item> ITEMS = tag("items");
    public static final TagKey<Item> KITCHEN = tag("kitchen");
    public static final TagKey<Item> OUTDOORS = tag("outdoors");
    public static final TagKey<Item> STORAGE = tag("storage");

    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(Registries.ITEM, new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, name));
    }
}