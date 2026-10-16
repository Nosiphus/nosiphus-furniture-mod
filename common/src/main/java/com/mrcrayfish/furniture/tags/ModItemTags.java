package com.mrcrayfish.furniture.tags;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> BLINDS = tag("blinds");
    public static final TagKey<Item> COOLERS = tag("coolers");
    public static final TagKey<Item> CRATES = tag("crates");
    public static final TagKey<Item> GRILLS = tag("grills");
    public static final TagKey<Item> HEDGES = tag("fences/hedge");
    public static final TagKey<Item> MAIL_BOXES = tag("mail_boxes");
    public static final TagKey<Item> PARK_BENCHES = tag("park_benches");
    public static final TagKey<Item> PICKET_FENCES = tag("fences/picket");
    public static final TagKey<Item> PICKET_FENCE_GATES = tag("fence_gates/picket");
    public static final TagKey<Item> SOFAS = tag("sofas");
    public static final TagKey<Item> TERRACOTTA_KITCHEN_COUNTERS = tag("terracotta_kitchen_counters");
    public static final TagKey<Item> TERRACOTTA_KITCHEN_DRAWERS = tag("terracotta_kitchen_drawers");
    public static final TagKey<Item> TERRACOTTA_KITCHEN_SINKS = tag("terracotta_kitchen_sinks");
    public static final TagKey<Item> TRAMPOLINES = tag("trampolines");
    public static final TagKey<Item> UPGRADED_FENCES = tag("fences/upgraded");
    public static final TagKey<Item> UPGRADED_FENCE_GATES = tag("fence_gates/upgraded");
    public static final TagKey<Item> WOODEN_BEDSIDE_CABINETS = tag("wooden_bedside_cabinets");
    public static final TagKey<Item> WOODEN_CABINETS = tag("wooden_cabinets");
    public static final TagKey<Item> WOODEN_CHAIRS = tag("wooden_chairs");
    public static final TagKey<Item> WOODEN_COFFEE_TABLES = tag("wooden_coffee_tables");
    public static final TagKey<Item> WOODEN_DESKS = tag("wooden_desks");
    public static final TagKey<Item> WOODEN_DESK_CABINETS = tag("wooden_desk_cabinets");
    public static final TagKey<Item> WOODEN_KITCHEN_COUNTERS = tag("wooden_kitchen_counters");
    public static final TagKey<Item> WOODEN_KITCHEN_DRAWERS = tag("wooden_kitchen_drawers");
    public static final TagKey<Item> WOODEN_KITCHEN_SINKS = tag("wooden_kitchen_sinks");
    public static final TagKey<Item> WOODEN_TABLES = tag("wooden_tables");

    public static final TagKey<Item> BEDROOM = tag("bedroom");
    public static final TagKey<Item> GENERAL = tag("general");
    public static final TagKey<Item> ITEMS = tag("items");
    public static final TagKey<Item> KITCHEN = tag("kitchen");
    public static final TagKey<Item> OUTDOORS = tag("outdoors");
    public static final TagKey<Item> STORAGE = tag("storage");

    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name));
    }
}