package com.nosiphus.furniture.tags;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> BAR_STOOLS = tag("bar_stools");
    public static final TagKey<Item> BEDS = tag("beds");
    public static final TagKey<Item> BIRD_BATHS = tag("bird_baths");
    public static final TagKey<Item> CHOPPING_BOARDS = tag("chopping_boards");
    public static final TagKey<Item> CUPS = tag("cups");
    public static final TagKey<Item> CURTAINS = tag("curtains");
    public static final TagKey<Item> DIGITAL_CLOCKS = tag("digital_clocks");
    public static final TagKey<Item> DOOR_BELLS = tag("door_bells");
    public static final TagKey<Item> INFLATABLE_CASTLES = tag("inflatable_castles");
    public static final TagKey<Item> LAMPS = tag("lamps");
    public static final TagKey<Item> MODERN_BEDSIDE_CABINETS = tag("modern_bedside_cabinets");
    public static final TagKey<Item> MODERN_CABINETS = tag("modern_cabinets");
    public static final TagKey<Item> MODERN_CHAIRS = tag("modern_chairs");
    public static final TagKey<Item> MODERN_COFFEE_TABLES = tag("modern_coffee_tables");
    public static final TagKey<Item> MODERN_DESK_CABINETS = tag("modern_desk_cabinets");
    public static final TagKey<Item> MODERN_DESKS = tag("modern_desks");
    public static final TagKey<Item> MODERN_KITCHEN_COUNTERS = tag("modern_kitchen_counters");
    public static final TagKey<Item> MODERN_KITCHEN_DRAWERS = tag("modern_kitchen_drawers");
    public static final TagKey<Item> MODERN_KITCHEN_SINKS = tag("modern_kitchen_sinks");
    public static final TagKey<Item> MODERN_SOFAS = tag("modern_sofas");
    public static final TagKey<Item> MODERN_TABLES = tag("modern_tables");
    public static final TagKey<Item> STONE_BEDSIDE_CABINETS = tag("stone_bedside_cabinets");
    public static final TagKey<Item> STONE_CABINETS = tag("stone_cabinets");
    public static final TagKey<Item> STONE_CHAIRS = tag("stone_chairs");
    public static final TagKey<Item> STONE_COFFEE_TABLES = tag("stone_coffee_tables");
    public static final TagKey<Item> STONE_DESK_CABINETS = tag("stone_desk_cabinets");
    public static final TagKey<Item> STONE_DESKS = tag("stone_desks");
    public static final TagKey<Item> STONE_TABLES = tag("stone_tables");
    public static final TagKey<Item> TAPS = tag("taps");
    public static final TagKey<Item> TELEVISION_STANDS = tag("television_stands");
    public static final TagKey<Item> WALL_CABINETS = tag("wall_cabinets");
    public static final TagKey<Item> WATER_TANKS = tag("water_tanks");

    public static final TagKey<Item> GENERAL = tag("general");
    public static final TagKey<Item> STORAGE = tag("storage");
    public static final TagKey<Item> BEDROOM = tag("bedroom");
    public static final TagKey<Item> OUTDOORS = tag("outdoors");
    public static final TagKey<Item> KITCHEN = tag("kitchen");
    public static final TagKey<Item> BATHROOM = tag("bathroom");
    public static final TagKey<Item> ELECTRONICS = tag("electronics");
    public static final TagKey<Item> FESTIVE = tag("festive");
    public static final TagKey<Item> LIGHTING = tag("lighting");
    public static final TagKey<Item> ITEMS = tag("items");

    private static TagKey<Item> tag(String name)
    {
        return TagKey.create(Registries.ITEM, new ResourceLocation(NosiphusFurnitureMod.MOD_ID, name));
    }

}