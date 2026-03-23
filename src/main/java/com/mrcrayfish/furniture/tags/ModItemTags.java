package com.mrcrayfish.furniture.tags;

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

    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("cfm", name));
    }

}
