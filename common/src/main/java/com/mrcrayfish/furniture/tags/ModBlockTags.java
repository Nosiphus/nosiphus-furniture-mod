package com.mrcrayfish.furniture.tags;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> UPGRADED_FENCES = tag("fences/upgraded");
    public static final TagKey<Block> PICKET_FENCES = tag("fences/picket");
    public static final TagKey<Block> UPGRADED_FENCE_GATES = tag("fence_gates/upgraded");
    public static final TagKey<Block> PICKET_FENCE_GATES = tag("fence_gates/picket");
    public static final TagKey<Block> HEDGES = tag("fences/hedge");

    private static TagKey<Block> tag(String name)
    {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, name));
    }
}