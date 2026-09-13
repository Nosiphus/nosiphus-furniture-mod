package com.nosiphus.furniture.integration.everycomp;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.tags.ModItemTags;
import com.nosiphus.furniture.world.level.block.ChoppingBoardBlock;
import com.nosiphus.furniture.world.level.block.DoorBellBlock;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.WaterTankBlock;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Objects;

public class EveryCompatModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> choppingBoards;
    public final SimpleEntrySet<WoodType, Block> doorBells;
    public final SimpleEntrySet<WoodType, Block> strippedDoorBells;
    public final SimpleEntrySet<WoodType, Block> waterTanks;

    public EveryCompatModule(String modId) {
        super(modId, NosiphusFurnitureMod.MOD_ID);
        ResourceLocation tab = modRes(NosiphusFurnitureMod.MOD_ID);

        choppingBoards = SimpleEntrySet.builder(WoodType.class, "chopping_board",
                        ModBlocks.OAK_CHOPPING_BOARD, () -> VanillaWoodTypes.OAK,
                        w -> new ChoppingBoardBlock(Utils.copyPropertySafe(w.planks))
                )
                .requiresChildren("slab")
                .addTile(ModBlockEntityTypes.CHOPPING_BOARD)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(choppingBoards);

        doorBells = SimpleEntrySet.builder(WoodType.class, "door_bell",
                        ModBlocks.OAK_DOOR_BELL, () -> VanillaWoodTypes.OAK,
                        w -> new DoorBellBlock(Utils.copyPropertySafe(w.log).noOcclusion())
                )
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.ELECTRONICS, Registries.ITEM)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(doorBells);

        strippedDoorBells = SimpleEntrySet.builder(WoodType.class, "door_bell", "stripped",
                        ModBlocks.STRIPPED_OAK_DOOR_BELL, () -> VanillaWoodTypes.OAK,
                        w -> new DoorBellBlock(Utils.copyPropertySafe(Objects.requireNonNull(w.getBlockOfThis("stripped_log"))).noOcclusion())
                )
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.ELECTRONICS, Registries.ITEM)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(strippedDoorBells);

        waterTanks = SimpleEntrySet.builder(WoodType.class, "water_tank",
                        ModBlocks.OAK_WATER_TANK, () -> VanillaWoodTypes.OAK,
                        w -> new WaterTankBlock(Utils.copyPropertySafe(Blocks.CAULDRON).noOcclusion())
                )
                .addTile(getModTile("water_tank"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(waterTanks);

    }

}