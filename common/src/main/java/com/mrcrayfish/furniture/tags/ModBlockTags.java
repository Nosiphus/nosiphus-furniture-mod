package com.mrcrayfish.furniture.tags;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> BLINDS = tag("blinds");
    public static final TagKey<Block> COOLERS = tag("coolers");
    public static final TagKey<Block> CRATES = tag("crates");
    public static final TagKey<Block> GRILLS = tag("grills");
    public static final TagKey<Block> HEDGES = tag("fences/hedge");
    public static final TagKey<Block> MAIL_BOXES = tag("mail_boxes");
    public static final TagKey<Block> PARK_BENCHES = tag("park_benches");
    public static final TagKey<Block> PICKET_FENCES = tag("fences/picket");
    public static final TagKey<Block> PICKET_FENCE_GATES = tag("fence_gates/picket");
    public static final TagKey<Block> SOFAS = tag("sofas");
    public static final TagKey<Block> TERRACOTTA_KITCHEN_COUNTERS = tag("terracotta_kitchen_counters");
    public static final TagKey<Block> TERRACOTTA_KITCHEN_DRAWERS = tag("terracotta_kitchen_drawers");
    public static final TagKey<Block> TERRACOTTA_KITCHEN_SINKS = tag("terracotta_kitchen_sinks");
    public static final TagKey<Block> TRAMPOLINES = tag("trampolines");
    public static final TagKey<Block> UPGRADED_FENCES = tag("fences/upgraded");
    public static final TagKey<Block> UPGRADED_FENCE_GATES = tag("fence_gates/upgraded");
    public static final TagKey<Block> WOODEN_BEDSIDE_CABINETS = tag("wooden_bedside_cabinets");
    public static final TagKey<Block> WOODEN_CABINETS = tag("wooden_cabinets");
    public static final TagKey<Block> WOODEN_CHAIRS = tag("wooden_chairs");
    public static final TagKey<Block> WOODEN_COFFEE_TABLES = tag("wooden_coffee_tables");
    public static final TagKey<Block> WOODEN_DESKS = tag("wooden_desks");
    public static final TagKey<Block> WOODEN_DESK_CABINETS = tag("wooden_desk_cabinets");
    public static final TagKey<Block> WOODEN_KITCHEN_COUNTERS = tag("wooden_kitchen_counters");
    public static final TagKey<Block> WOODEN_KITCHEN_DRAWERS = tag("wooden_kitchen_drawers");
    public static final TagKey<Block> WOODEN_KITCHEN_SINKS = tag("wooden_kitchen_sinks");
    public static final TagKey<Block> WOODEN_TABLES = tag("wooden_tables");

    private static TagKey<Block> tag(String name)
    {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name));
    }
}