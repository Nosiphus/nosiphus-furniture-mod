package com.mrcrayfish.furniture.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks
{

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("cfm");

    // Tables
    public static final DeferredBlock<Block> OAK_TABLE = BLOCKS.register("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_TABLE = BLOCKS.register("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_TABLE = BLOCKS.register("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_TABLE = BLOCKS.register("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_TABLE = BLOCKS.register("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_TABLE = BLOCKS.register("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_TABLE = BLOCKS.register("cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_TABLE = BLOCKS.register("crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_TABLE = BLOCKS.register("warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_TABLE = BLOCKS.register("stripped_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_TABLE = BLOCKS.register("stripped_spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_TABLE = BLOCKS.register("stripped_birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_TABLE = BLOCKS.register("stripped_jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_TABLE = BLOCKS.register("stripped_acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_TABLE = BLOCKS.register("stripped_dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_TABLE = BLOCKS.register("stripped_mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_TABLE = BLOCKS.register("stripped_cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_TABLE = BLOCKS.register("stripped_crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_TABLE = BLOCKS.register("stripped_warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Chairs
    public static final DeferredBlock<Block> OAK_CHAIR = BLOCKS.register("oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_CHAIR = BLOCKS.register("spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_CHAIR = BLOCKS.register("birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_CHAIR = BLOCKS.register("jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_CHAIR = BLOCKS.register("acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_CHAIR = BLOCKS.register("mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_CHAIR = BLOCKS.register("cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_CHAIR = BLOCKS.register("crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_CHAIR = BLOCKS.register("warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_CHAIR = BLOCKS.register("stripped_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_CHAIR = BLOCKS.register("stripped_spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_CHAIR = BLOCKS.register("stripped_birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_CHAIR = BLOCKS.register("stripped_jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_CHAIR = BLOCKS.register("stripped_acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_CHAIR = BLOCKS.register("stripped_dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_CHAIR = BLOCKS.register("stripped_mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_CHAIR = BLOCKS.register("stripped_cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_CHAIR = BLOCKS.register("stripped_crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_CHAIR = BLOCKS.register("stripped_warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Coffee Tables
    public static final DeferredBlock<Block> OAK_COFFEE_TABLE = BLOCKS.register("oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_COFFEE_TABLE = BLOCKS.register("spruce_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_COFFEE_TABLE = BLOCKS.register("birch_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_COFFEE_TABLE = BLOCKS.register("jungle_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_COFFEE_TABLE = BLOCKS.register("acacia_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_COFFEE_TABLE = BLOCKS.register("dark_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_COFFEE_TABLE = BLOCKS.register("mangrove_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_COFFEE_TABLE = BLOCKS.register("cherry_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_COFFEE_TABLE = BLOCKS.register("crimson_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_COFFEE_TABLE = BLOCKS.register("warped_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_COFFEE_TABLE = BLOCKS.register("stripped_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_COFFEE_TABLE = BLOCKS.register("stripped_spruce_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_COFFEE_TABLE = BLOCKS.register("stripped_birch_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_COFFEE_TABLE = BLOCKS.register("stripped_jungle_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_COFFEE_TABLE = BLOCKS.register("stripped_acacia_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_COFFEE_TABLE = BLOCKS.register("stripped_dark_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_COFFEE_TABLE = BLOCKS.register("stripped_mangrove_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_COFFEE_TABLE = BLOCKS.register("stripped_cherry_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_COFFEE_TABLE = BLOCKS.register("stripped_crimson_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_COFFEE_TABLE = BLOCKS.register("stripped_warped_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Cabinets
    public static final DeferredBlock<Block> OAK_CABINET = BLOCKS.register("oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_CABINET = BLOCKS.register("spruce_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_CABINET = BLOCKS.register("birch_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_CABINET = BLOCKS.register("jungle_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_CABINET = BLOCKS.register("acacia_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_CABINET = BLOCKS.register("dark_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_CABINET = BLOCKS.register("mangrove_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_CABINET = BLOCKS.register("cherry_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_CABINET = BLOCKS.register("crimson_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_CABINET = BLOCKS.register("warped_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_CABINET = BLOCKS.register("stripped_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_CABINET = BLOCKS.register("stripped_spruce_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_CABINET = BLOCKS.register("stripped_birch_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_CABINET = BLOCKS.register("stripped_jungle_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_CABINET = BLOCKS.register("stripped_acacia_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_CABINET = BLOCKS.register("stripped_dark_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_CABINET = BLOCKS.register("stripped_mangrove_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_CABINET = BLOCKS.register("stripped_cherry_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_CABINET = BLOCKS.register("stripped_crimson_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_CABINET = BLOCKS.register("stripped_warped_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Bedside Cabinets
    public static final DeferredBlock<Block> OAK_BEDSIDE_CABINET = BLOCKS.register("oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_BEDSIDE_CABINET = BLOCKS.register("spruce_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_BEDSIDE_CABINET = BLOCKS.register("birch_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_BEDSIDE_CABINET = BLOCKS.register("jungle_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_BEDSIDE_CABINET = BLOCKS.register("acacia_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_BEDSIDE_CABINET = BLOCKS.register("dark_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_BEDSIDE_CABINET = BLOCKS.register("mangrove_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_BEDSIDE_CABINET = BLOCKS.register("cherry_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_BEDSIDE_CABINET = BLOCKS.register("crimson_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_BEDSIDE_CABINET = BLOCKS.register("warped_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_BEDSIDE_CABINET = BLOCKS.register("stripped_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_BEDSIDE_CABINET = BLOCKS.register("stripped_spruce_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_BEDSIDE_CABINET = BLOCKS.register("stripped_birch_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_BEDSIDE_CABINET = BLOCKS.register("stripped_jungle_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_BEDSIDE_CABINET = BLOCKS.register("stripped_acacia_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_BEDSIDE_CABINET = BLOCKS.register("stripped_dark_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_BEDSIDE_CABINET = BLOCKS.register("stripped_mangrove_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_BEDSIDE_CABINET = BLOCKS.register("stripped_cherry_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_BEDSIDE_CABINET = BLOCKS.register("stripped_crimson_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_BEDSIDE_CABINET = BLOCKS.register("stripped_warped_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Desks
    public static final DeferredBlock<Block> OAK_DESK = BLOCKS.register("oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.OAK));
    public static final DeferredBlock<Block> SPRUCE_DESK = BLOCKS.register("spruce_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.SPRUCE));
    public static final DeferredBlock<Block> BIRCH_DESK = BLOCKS.register("birch_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.BIRCH));
    public static final DeferredBlock<Block> JUNGLE_DESK = BLOCKS.register("jungle_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.JUNGLE));
    public static final DeferredBlock<Block> ACACIA_DESK = BLOCKS.register("acacia_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.ACACIA));
    public static final DeferredBlock<Block> DARK_OAK_DESK = BLOCKS.register("dark_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.DARK_OAK));
    public static final DeferredBlock<Block> MANGROVE_DESK = BLOCKS.register("mangrove_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.MANGROVE));
    public static final DeferredBlock<Block> CHERRY_DESK = BLOCKS.register("cherry_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.CHERRY));
    public static final DeferredBlock<Block> CRIMSON_DESK = BLOCKS.register("crimson_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.CRIMSON));
    public static final DeferredBlock<Block> WARPED_DESK = BLOCKS.register("warped_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.WARPED));
    public static final DeferredBlock<Block> STRIPPED_OAK_DESK = BLOCKS.register("stripped_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_OAK));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_DESK = BLOCKS.register("stripped_spruce_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.STRIPPED_SPRUCE));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_DESK = BLOCKS.register("stripped_birch_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.STRIPPED_BIRCH));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_DESK = BLOCKS.register("stripped_jungle_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.STRIPPED_JUNGLE));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_DESK = BLOCKS.register("stripped_acacia_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.STRIPPED_ACACIA));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_DESK = BLOCKS.register("stripped_dark_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_DARK_OAK));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_DESK = BLOCKS.register("stripped_mangrove_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.STRIPPED_MANGROVE));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_DESK = BLOCKS.register("stripped_cherry_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.STRIPPED_CHERRY));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_DESK = BLOCKS.register("stripped_crimson_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.STRIPPED_CRIMSON));
    public static final DeferredBlock<Block> STRIPPED_WARPED_DESK = BLOCKS.register("stripped_warped_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.STRIPPED_WARPED));

    // Desk Cabinets
    public static final DeferredBlock<Block> OAK_DESK_CABINET = BLOCKS.register("oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.OAK));
    public static final DeferredBlock<Block> SPRUCE_DESK_CABINET = BLOCKS.register("spruce_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.SPRUCE));
    public static final DeferredBlock<Block> BIRCH_DESK_CABINET = BLOCKS.register("birch_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.BIRCH));
    public static final DeferredBlock<Block> JUNGLE_DESK_CABINET = BLOCKS.register("jungle_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.JUNGLE));
    public static final DeferredBlock<Block> ACACIA_DESK_CABINET = BLOCKS.register("acacia_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.ACACIA));
    public static final DeferredBlock<Block> DARK_OAK_DESK_CABINET = BLOCKS.register("dark_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.DARK_OAK));
    public static final DeferredBlock<Block> MANGROVE_DESK_CABINET = BLOCKS.register("mangrove_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.MANGROVE));
    public static final DeferredBlock<Block> CHERRY_DESK_CABINET = BLOCKS.register("cherry_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.CHERRY));
    public static final DeferredBlock<Block> CRIMSON_DESK_CABINET = BLOCKS.register("crimson_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.CRIMSON));
    public static final DeferredBlock<Block> WARPED_DESK_CABINET = BLOCKS.register("warped_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.WARPED));
    public static final DeferredBlock<Block> STRIPPED_OAK_DESK_CABINET = BLOCKS.register("stripped_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_OAK));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_DESK_CABINET = BLOCKS.register("stripped_spruce_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.STRIPPED_SPRUCE));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_DESK_CABINET = BLOCKS.register("stripped_birch_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.STRIPPED_BIRCH));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_DESK_CABINET = BLOCKS.register("stripped_jungle_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.STRIPPED_JUNGLE));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_DESK_CABINET = BLOCKS.register("stripped_acacia_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.STRIPPED_ACACIA));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_DESK_CABINET = BLOCKS.register("stripped_dark_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_DARK_OAK));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_DESK_CABINET = BLOCKS.register("stripped_mangrove_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.STRIPPED_MANGROVE));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_DESK_CABINET = BLOCKS.register("stripped_cherry_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.STRIPPED_CHERRY));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_DESK_CABINET = BLOCKS.register("stripped_crimson_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.STRIPPED_CRIMSON));
    public static final DeferredBlock<Block> STRIPPED_WARPED_DESK_CABINET = BLOCKS.register("stripped_warped_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.STRIPPED_WARPED));

    // Sofas
    public static final DeferredBlock<Block> WHITE_SOFA = BLOCKS.register("white_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_SOFA = BLOCKS.register("light_gray_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> GRAY_SOFA = BLOCKS.register("gray_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BLACK_SOFA = BLOCKS.register("black_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BROWN_SOFA = BLOCKS.register("brown_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> RED_SOFA = BLOCKS.register("red_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ORANGE_SOFA = BLOCKS.register("orange_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BEIGE_SOFA = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))) : null;
    public static final DeferredBlock<Block> YELLOW_SOFA = BLOCKS.register("yellow_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LIME_SOFA = BLOCKS.register("lime_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> GREEN_SOFA = BLOCKS.register("green_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CYAN_SOFA = BLOCKS.register("cyan_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_SOFA = BLOCKS.register("light_blue_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BLUE_SOFA = BLOCKS.register("blue_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PURPLE_SOFA = BLOCKS.register("purple_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MAGENTA_SOFA = BLOCKS.register("magenta_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PINK_SOFA = BLOCKS.register("pink_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> RAINBOW_SOFA = BLOCKS.register("rainbow_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    // Blinds
    public static final DeferredBlock<Block> OAK_BLINDS = BLOCKS.register("oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_BLINDS = BLOCKS.register("spruce_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_BLINDS = BLOCKS.register("birch_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_BLINDS = BLOCKS.register("jungle_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_BLINDS = BLOCKS.register("acacia_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_BLINDS = BLOCKS.register("dark_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_BLINDS = BLOCKS.register("mangrove_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_BLINDS = BLOCKS.register("cherry_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_BLINDS = BLOCKS.register("crimson_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_BLINDS = BLOCKS.register("warped_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_BLINDS = BLOCKS.register("stripped_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_BLINDS = BLOCKS.register("stripped_spruce_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_BLINDS = BLOCKS.register("stripped_birch_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_BLINDS = BLOCKS.register("stripped_jungle_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_BLINDS = BLOCKS.register("stripped_acacia_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_BLINDS = BLOCKS.register("stripped_dark_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_BLINDS = BLOCKS.register("stripped_mangrove_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_BLINDS = BLOCKS.register("stripped_cherry_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_BLINDS = BLOCKS.register("stripped_crimson_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_BLINDS = BLOCKS.register("stripped_warped_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Upgraded Fences
    public static final DeferredBlock<Block> OAK_UPGRADED_FENCE = BLOCKS.register("oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_UPGRADED_FENCE = BLOCKS.register("spruce_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_UPGRADED_FENCE = BLOCKS.register("birch_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_UPGRADED_FENCE = BLOCKS.register("jungle_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_UPGRADED_FENCE = BLOCKS.register("acacia_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_UPGRADED_FENCE = BLOCKS.register("dark_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_UPGRADED_FENCE = BLOCKS.register("mangrove_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_UPGRADED_FENCE = BLOCKS.register("cherry_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_UPGRADED_FENCE = BLOCKS.register("crimson_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_UPGRADED_FENCE = BLOCKS.register("warped_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_UPGRADED_FENCE = BLOCKS.register("stripped_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_UPGRADED_FENCE = BLOCKS.register("stripped_spruce_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_UPGRADED_FENCE = BLOCKS.register("stripped_birch_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_UPGRADED_FENCE = BLOCKS.register("stripped_jungle_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_UPGRADED_FENCE = BLOCKS.register("stripped_acacia_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_UPGRADED_FENCE = BLOCKS.register("stripped_dark_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_UPGRADED_FENCE = BLOCKS.register("stripped_mangrove_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_UPGRADED_FENCE = BLOCKS.register("stripped_cherry_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_UPGRADED_FENCE = BLOCKS.register("stripped_crimson_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_UPGRADED_FENCE = BLOCKS.register("stripped_warped_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Upgraded Gates
    public static final DeferredBlock<Block> OAK_UPGRADED_GATE = BLOCKS.register("oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_UPGRADED_GATE = BLOCKS.register("spruce_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_UPGRADED_GATE = BLOCKS.register("birch_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_UPGRADED_GATE = BLOCKS.register("jungle_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_UPGRADED_GATE = BLOCKS.register("acacia_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_UPGRADED_GATE = BLOCKS.register("dark_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_UPGRADED_GATE = BLOCKS.register("mangrove_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_UPGRADED_GATE = BLOCKS.register("cherry_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_UPGRADED_GATE = BLOCKS.register("crimson_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_UPGRADED_GATE = BLOCKS.register("warped_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_UPGRADED_GATE = BLOCKS.register("stripped_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_UPGRADED_GATE = BLOCKS.register("stripped_spruce_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_UPGRADED_GATE = BLOCKS.register("stripped_birch_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_UPGRADED_GATE = BLOCKS.register("stripped_jungle_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_UPGRADED_GATE = BLOCKS.register("stripped_acacia_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_UPGRADED_GATE = BLOCKS.register("stripped_dark_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_UPGRADED_GATE = BLOCKS.register("stripped_mangrove_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_UPGRADED_GATE = BLOCKS.register("stripped_cherry_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_UPGRADED_GATE = BLOCKS.register("stripped_crimson_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_UPGRADED_GATE = BLOCKS.register("stripped_warped_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Picket Fences
    public static final DeferredBlock<Block> WHITE_PICKET_FENCE = BLOCKS.register("white_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIGHT_GRAY_PICKET_FENCE = BLOCKS.register("light_gray_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GRAY_PICKET_FENCE = BLOCKS.register("gray_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BLACK_PICKET_FENCE = BLOCKS.register("black_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BROWN_PICKET_FENCE = BLOCKS.register("brown_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RED_PICKET_FENCE = BLOCKS.register("red_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ORANGE_PICKET_FENCE = BLOCKS.register("orange_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BEIGE_PICKET_FENCE = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD))) : null;
    public static final DeferredBlock<Block> YELLOW_PICKET_FENCE = BLOCKS.register("yellow_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIME_PICKET_FENCE = BLOCKS.register("lime_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GREEN_PICKET_FENCE = BLOCKS.register("green_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CYAN_PICKET_FENCE = BLOCKS.register("cyan_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIGHT_BLUE_PICKET_FENCE = BLOCKS.register("light_blue_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BLUE_PICKET_FENCE = BLOCKS.register("blue_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PURPLE_PICKET_FENCE = BLOCKS.register("purple_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MAGENTA_PICKET_FENCE = BLOCKS.register("magenta_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PINK_PICKET_FENCE = BLOCKS.register("pink_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));

    // Picket Gates
    public static final DeferredBlock<Block> WHITE_PICKET_GATE = BLOCKS.register("white_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIGHT_GRAY_PICKET_GATE = BLOCKS.register("light_gray_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GRAY_PICKET_GATE = BLOCKS.register("gray_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BLACK_PICKET_GATE = BLOCKS.register("black_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BROWN_PICKET_GATE = BLOCKS.register("brown_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RED_PICKET_GATE = BLOCKS.register("red_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ORANGE_PICKET_GATE = BLOCKS.register("orange_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BEIGE_PICKET_GATE = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD))) : null;
    public static final DeferredBlock<Block> YELLOW_PICKET_GATE = BLOCKS.register("yellow_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIME_PICKET_GATE = BLOCKS.register("lime_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GREEN_PICKET_GATE = BLOCKS.register("green_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CYAN_PICKET_GATE = BLOCKS.register("cyan_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LIGHT_BLUE_PICKET_GATE = BLOCKS.register("light_blue_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BLUE_PICKET_GATE = BLOCKS.register("blue_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PURPLE_PICKET_GATE = BLOCKS.register("purple_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MAGENTA_PICKET_GATE = BLOCKS.register("magenta_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PINK_PICKET_GATE = BLOCKS.register("pink_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));

    // Crates
    public static final DeferredBlock<Block> OAK_CRATE = BLOCKS.register("oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> SPRUCE_CRATE = BLOCKS.register("spruce_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> BIRCH_CRATE = BLOCKS.register("birch_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> JUNGLE_CRATE = BLOCKS.register("jungle_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> ACACIA_CRATE = BLOCKS.register("acacia_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> DARK_OAK_CRATE = BLOCKS.register("dark_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> MANGROVE_CRATE = BLOCKS.register("mangrove_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> CHERRY_CRATE = BLOCKS.register("cherry_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> CRIMSON_CRATE = BLOCKS.register("crimson_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> WARPED_CRATE = BLOCKS.register("warped_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_OAK_CRATE = BLOCKS.register("stripped_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_CRATE = BLOCKS.register("stripped_spruce_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_CRATE = BLOCKS.register("stripped_birch_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_CRATE = BLOCKS.register("stripped_jungle_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_CRATE = BLOCKS.register("stripped_acacia_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_CRATE = BLOCKS.register("stripped_dark_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_CRATE = BLOCKS.register("stripped_mangrove_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_CRATE = BLOCKS.register("stripped_cherry_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_CRATE = BLOCKS.register("stripped_crimson_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_CRATE = BLOCKS.register("stripped_warped_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));

    // Park Benches
    public static final DeferredBlock<Block> OAK_PARK_BENCH = BLOCKS.register("oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_PARK_BENCH = BLOCKS.register("spruce_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PARK_BENCH = BLOCKS.register("birch_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_PARK_BENCH = BLOCKS.register("jungle_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_PARK_BENCH = BLOCKS.register("acacia_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PARK_BENCH = BLOCKS.register("dark_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PARK_BENCH = BLOCKS.register("mangrove_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_PARK_BENCH = BLOCKS.register("cherry_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_PARK_BENCH = BLOCKS.register("crimson_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_PARK_BENCH = BLOCKS.register("warped_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_PARK_BENCH = BLOCKS.register("stripped_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_PARK_BENCH = BLOCKS.register("stripped_spruce_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_PARK_BENCH = BLOCKS.register("stripped_birch_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_PARK_BENCH = BLOCKS.register("stripped_jungle_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_PARK_BENCH = BLOCKS.register("stripped_acacia_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_PARK_BENCH = BLOCKS.register("stripped_dark_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_PARK_BENCH = BLOCKS.register("stripped_mangrove_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_PARK_BENCH = BLOCKS.register("stripped_cherry_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_PARK_BENCH = BLOCKS.register("stripped_crimson_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_PARK_BENCH = BLOCKS.register("stripped_warped_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Post Box
    public static final DeferredBlock<Block> POST_BOX = BLOCKS.register("post_box",
            () -> new PostBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL)));

    // Mail Boxes
    public static final DeferredBlock<Block> OAK_MAIL_BOX = BLOCKS.register("oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_MAIL_BOX = BLOCKS.register("spruce_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_MAIL_BOX = BLOCKS.register("birch_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_MAIL_BOX = BLOCKS.register("jungle_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_MAIL_BOX = BLOCKS.register("acacia_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_MAIL_BOX = BLOCKS.register("dark_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_MAIL_BOX = BLOCKS.register("mangrove_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_MAIL_BOX = BLOCKS.register("cherry_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_MAIL_BOX = BLOCKS.register("crimson_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_MAIL_BOX = BLOCKS.register("warped_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_MAIL_BOX = BLOCKS.register("stripped_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_MAIL_BOX = BLOCKS.register("stripped_spruce_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_MAIL_BOX = BLOCKS.register("stripped_birch_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_MAIL_BOX = BLOCKS.register("stripped_jungle_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_MAIL_BOX = BLOCKS.register("stripped_acacia_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_MAIL_BOX = BLOCKS.register("stripped_dark_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_MAIL_BOX = BLOCKS.register("stripped_mangrove_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_MAIL_BOX = BLOCKS.register("stripped_cherry_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_MAIL_BOX = BLOCKS.register("stripped_crimson_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_MAIL_BOX = BLOCKS.register("stripped_warped_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Hedges
    public static final DeferredBlock<Block> OAK_HEDGE = BLOCKS.register("oak_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> SPRUCE_HEDGE = BLOCKS.register("spruce_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> BIRCH_HEDGE = BLOCKS.register("birch_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<Block> JUNGLE_HEDGE = BLOCKS.register("jungle_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<Block> ACACIA_HEDGE = BLOCKS.register("acacia_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<Block> DARK_OAK_HEDGE = BLOCKS.register("dark_oak_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<Block> MANGROVE_HEDGE = BLOCKS.register("mangrove_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES)));
    public static final DeferredBlock<Block> CHERRY_HEDGE = BLOCKS.register("cherry_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)));
    public static final DeferredBlock<Block> AZALEA_HEDGE = BLOCKS.register("azalea_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES)));
    public static final DeferredBlock<Block> FLOWERING_AZALEA_HEDGE = BLOCKS.register("flowering_azalea_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWERING_AZALEA_LEAVES)));

    // Rock Path
    public static final DeferredBlock<Block> ROCK_PATH = BLOCKS.register("rock_path",
            () -> new RockPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    // Trampolines
    public static final DeferredBlock<Block> WHITE_TRAMPOLINE = BLOCKS.register("white_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TRAMPOLINE = BLOCKS.register("light_gray_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_TRAMPOLINE = BLOCKS.register("gray_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_TRAMPOLINE = BLOCKS.register("black_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_TRAMPOLINE = BLOCKS.register("brown_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_TRAMPOLINE = BLOCKS.register("red_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_TRAMPOLINE = BLOCKS.register("orange_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_TRAMPOLINE = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final DeferredBlock<Block> YELLOW_TRAMPOLINE = BLOCKS.register("yellow_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_TRAMPOLINE = BLOCKS.register("lime_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_TRAMPOLINE = BLOCKS.register("green_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_TRAMPOLINE = BLOCKS.register("cyan_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TRAMPOLINE = BLOCKS.register("light_blue_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_TRAMPOLINE = BLOCKS.register("blue_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_TRAMPOLINE = BLOCKS.register("purple_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_TRAMPOLINE = BLOCKS.register("magenta_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_TRAMPOLINE = BLOCKS.register("pink_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Coolers
    public static final DeferredBlock<Block> WHITE_COOLER = BLOCKS.register("white_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_COOLER = BLOCKS.register("light_gray_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_COOLER = BLOCKS.register("gray_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_COOLER = BLOCKS.register("black_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_COOLER = BLOCKS.register("brown_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_COOLER = BLOCKS.register("red_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_COOLER = BLOCKS.register("orange_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_COOLER = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final DeferredBlock<Block> YELLOW_COOLER = BLOCKS.register("yellow_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_COOLER = BLOCKS.register("lime_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_COOLER = BLOCKS.register("green_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_COOLER = BLOCKS.register("cyan_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_COOLER = BLOCKS.register("light_blue_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_COOLER = BLOCKS.register("blue_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_COOLER = BLOCKS.register("purple_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_COOLER = BLOCKS.register("magenta_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_COOLER = BLOCKS.register("pink_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Grills
    public static final DeferredBlock<Block> WHITE_GRILL = BLOCKS.register("white_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIGHT_GRAY_GRILL = BLOCKS.register("light_gray_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> GRAY_GRILL = BLOCKS.register("gray_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BLACK_GRILL = BLOCKS.register("black_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BROWN_GRILL = BLOCKS.register("brown_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> RED_GRILL = BLOCKS.register("red_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> ORANGE_GRILL = BLOCKS.register("orange_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BEIGE_GRILL = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))) : null;
    public static final DeferredBlock<Block> YELLOW_GRILL = BLOCKS.register("yellow_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIME_GRILL = BLOCKS.register("lime_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> GREEN_GRILL = BLOCKS.register("green_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> CYAN_GRILL = BLOCKS.register("cyan_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> LIGHT_BLUE_GRILL = BLOCKS.register("light_blue_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> BLUE_GRILL = BLOCKS.register("blue_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> PURPLE_GRILL = BLOCKS.register("purple_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> MAGENTA_GRILL = BLOCKS.register("magenta_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> PINK_GRILL = BLOCKS.register("pink_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    // Door Mat
    public static final DeferredBlock<Block> DOOR_MAT = BLOCKS.register("door_mat",
            () -> new DoorMatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));

    // Diving Board
    public static final DeferredBlock<Block> DIVING_BOARD = BLOCKS.register("diving_board",
            () -> new DivingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    // Kitchen Counters
    public static final DeferredBlock<Block> OAK_KITCHEN_COUNTER = BLOCKS.register("oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_KITCHEN_COUNTER = BLOCKS.register("spruce_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_KITCHEN_COUNTER = BLOCKS.register("birch_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_KITCHEN_COUNTER = BLOCKS.register("jungle_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_KITCHEN_COUNTER = BLOCKS.register("acacia_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_KITCHEN_COUNTER = BLOCKS.register("dark_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_KITCHEN_COUNTER = BLOCKS.register("mangrove_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_KITCHEN_COUNTER = BLOCKS.register("cherry_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_KITCHEN_COUNTER = BLOCKS.register("crimson_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_KITCHEN_COUNTER = BLOCKS.register("warped_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_KITCHEN_COUNTER = BLOCKS.register("stripped_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_KITCHEN_COUNTER = BLOCKS.register("stripped_spruce_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_KITCHEN_COUNTER = BLOCKS.register("stripped_birch_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_KITCHEN_COUNTER = BLOCKS.register("stripped_jungle_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_KITCHEN_COUNTER = BLOCKS.register("stripped_acacia_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_KITCHEN_COUNTER = BLOCKS.register("stripped_dark_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_KITCHEN_COUNTER = BLOCKS.register("stripped_mangrove_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_KITCHEN_COUNTER = BLOCKS.register("stripped_cherry_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_KITCHEN_COUNTER = BLOCKS.register("stripped_crimson_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_KITCHEN_COUNTER = BLOCKS.register("stripped_warped_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WHITE_KITCHEN_COUNTER = BLOCKS.register("white_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_KITCHEN_COUNTER = BLOCKS.register("light_gray_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_KITCHEN_COUNTER = BLOCKS.register("gray_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_KITCHEN_COUNTER = BLOCKS.register("black_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_KITCHEN_COUNTER = BLOCKS.register("brown_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_KITCHEN_COUNTER = BLOCKS.register("red_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_KITCHEN_COUNTER = BLOCKS.register("orange_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_KITCHEN_COUNTER = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final DeferredBlock<Block> YELLOW_KITCHEN_COUNTER = BLOCKS.register("yellow_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_KITCHEN_COUNTER = BLOCKS.register("lime_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_KITCHEN_COUNTER = BLOCKS.register("green_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_KITCHEN_COUNTER = BLOCKS.register("cyan_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_KITCHEN_COUNTER = BLOCKS.register("light_blue_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_KITCHEN_COUNTER = BLOCKS.register("blue_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_KITCHEN_COUNTER = BLOCKS.register("purple_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_KITCHEN_COUNTER = BLOCKS.register("magenta_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_KITCHEN_COUNTER = BLOCKS.register("pink_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Kitchen Drawers
    public static final DeferredBlock<Block> OAK_KITCHEN_DRAWER = BLOCKS.register("oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_KITCHEN_DRAWER = BLOCKS.register("spruce_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_KITCHEN_DRAWER = BLOCKS.register("birch_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_KITCHEN_DRAWER = BLOCKS.register("jungle_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_KITCHEN_DRAWER = BLOCKS.register("acacia_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_KITCHEN_DRAWER = BLOCKS.register("dark_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_KITCHEN_DRAWER = BLOCKS.register("mangrove_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_KITCHEN_DRAWER = BLOCKS.register("cherry_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_KITCHEN_DRAWER = BLOCKS.register("crimson_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_KITCHEN_DRAWER = BLOCKS.register("warped_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_OAK_KITCHEN_DRAWER = BLOCKS.register("stripped_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_KITCHEN_DRAWER = BLOCKS.register("stripped_spruce_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_KITCHEN_DRAWER = BLOCKS.register("stripped_birch_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_KITCHEN_DRAWER = BLOCKS.register("stripped_jungle_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_KITCHEN_DRAWER = BLOCKS.register("stripped_acacia_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_KITCHEN_DRAWER = BLOCKS.register("stripped_dark_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_KITCHEN_DRAWER = BLOCKS.register("stripped_mangrove_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_KITCHEN_DRAWER = BLOCKS.register("stripped_cherry_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_KITCHEN_DRAWER = BLOCKS.register("stripped_crimson_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_KITCHEN_DRAWER = BLOCKS.register("stripped_warped_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WHITE_KITCHEN_DRAWER = BLOCKS.register("white_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_KITCHEN_DRAWER = BLOCKS.register("light_gray_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_KITCHEN_DRAWER = BLOCKS.register("gray_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_KITCHEN_DRAWER = BLOCKS.register("black_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_KITCHEN_DRAWER = BLOCKS.register("brown_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_KITCHEN_DRAWER = BLOCKS.register("red_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_KITCHEN_DRAWER = BLOCKS.register("orange_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_KITCHEN_DRAWER = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final DeferredBlock<Block> YELLOW_KITCHEN_DRAWER = BLOCKS.register("yellow_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_KITCHEN_DRAWER = BLOCKS.register("lime_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_KITCHEN_DRAWER = BLOCKS.register("green_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_KITCHEN_DRAWER = BLOCKS.register("cyan_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_KITCHEN_DRAWER = BLOCKS.register("light_blue_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_KITCHEN_DRAWER = BLOCKS.register("blue_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_KITCHEN_DRAWER = BLOCKS.register("purple_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_KITCHEN_DRAWER = BLOCKS.register("magenta_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_KITCHEN_DRAWER = BLOCKS.register("pink_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Kitchen Sinks
    public static final DeferredBlock<Block> OAK_KITCHEN_SINK_LIGHT = BLOCKS.register("oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true));
    public static final DeferredBlock<Block> SPRUCE_KITCHEN_SINK_LIGHT = BLOCKS.register("spruce_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), true));
    public static final DeferredBlock<Block> BIRCH_KITCHEN_SINK_LIGHT = BLOCKS.register("birch_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), true));
    public static final DeferredBlock<Block> JUNGLE_KITCHEN_SINK_LIGHT = BLOCKS.register("jungle_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), true));
    public static final DeferredBlock<Block> ACACIA_KITCHEN_SINK_LIGHT = BLOCKS.register("acacia_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), true));
    public static final DeferredBlock<Block> DARK_OAK_KITCHEN_SINK_LIGHT = BLOCKS.register("dark_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), true));
    public static final DeferredBlock<Block> MANGROVE_KITCHEN_SINK_LIGHT = BLOCKS.register("mangrove_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), true));
    public static final DeferredBlock<Block> CHERRY_KITCHEN_SINK_LIGHT = BLOCKS.register("cherry_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), true));
    public static final DeferredBlock<Block> CRIMSON_KITCHEN_SINK_LIGHT = BLOCKS.register("crimson_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), true));
    public static final DeferredBlock<Block> WARPED_KITCHEN_SINK_LIGHT = BLOCKS.register("warped_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_OAK_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_spruce_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_birch_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_jungle_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_acacia_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_dark_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_mangrove_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_cherry_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_crimson_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_WARPED_KITCHEN_SINK_LIGHT = BLOCKS.register("stripped_warped_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), true));
    public static final DeferredBlock<Block> OAK_KITCHEN_SINK_DARK = BLOCKS.register("oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true));
    public static final DeferredBlock<Block> SPRUCE_KITCHEN_SINK_DARK = BLOCKS.register("spruce_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), true));
    public static final DeferredBlock<Block> BIRCH_KITCHEN_SINK_DARK = BLOCKS.register("birch_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), true));
    public static final DeferredBlock<Block> JUNGLE_KITCHEN_SINK_DARK = BLOCKS.register("jungle_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), true));
    public static final DeferredBlock<Block> ACACIA_KITCHEN_SINK_DARK = BLOCKS.register("acacia_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), true));
    public static final DeferredBlock<Block> DARK_OAK_KITCHEN_SINK_DARK = BLOCKS.register("dark_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), true));
    public static final DeferredBlock<Block> MANGROVE_KITCHEN_SINK_DARK = BLOCKS.register("mangrove_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), true));
    public static final DeferredBlock<Block> CHERRY_KITCHEN_SINK_DARK = BLOCKS.register("cherry_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), true));
    public static final DeferredBlock<Block> CRIMSON_KITCHEN_SINK_DARK = BLOCKS.register("crimson_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), true));
    public static final DeferredBlock<Block> WARPED_KITCHEN_SINK_DARK = BLOCKS.register("warped_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_OAK_KITCHEN_SINK_DARK = BLOCKS.register("stripped_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_KITCHEN_SINK_DARK = BLOCKS.register("stripped_spruce_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_KITCHEN_SINK_DARK = BLOCKS.register("stripped_birch_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_KITCHEN_SINK_DARK = BLOCKS.register("stripped_jungle_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_KITCHEN_SINK_DARK = BLOCKS.register("stripped_acacia_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_KITCHEN_SINK_DARK = BLOCKS.register("stripped_dark_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_KITCHEN_SINK_DARK = BLOCKS.register("stripped_mangrove_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_KITCHEN_SINK_DARK = BLOCKS.register("stripped_cherry_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_KITCHEN_SINK_DARK = BLOCKS.register("stripped_crimson_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), true));
    public static final DeferredBlock<Block> STRIPPED_WARPED_KITCHEN_SINK_DARK = BLOCKS.register("stripped_warped_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), true));
    public static final DeferredBlock<Block> WHITE_KITCHEN_SINK = BLOCKS.register("white_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), false));
    public static final DeferredBlock<Block> LIGHT_GRAY_KITCHEN_SINK = BLOCKS.register("light_gray_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final DeferredBlock<Block> GRAY_KITCHEN_SINK = BLOCKS.register("gray_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), false));
    public static final DeferredBlock<Block> BLACK_KITCHEN_SINK = BLOCKS.register("black_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), false));
    public static final DeferredBlock<Block> BROWN_KITCHEN_SINK = BLOCKS.register("brown_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), false));
    public static final DeferredBlock<Block> RED_KITCHEN_SINK = BLOCKS.register("red_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), false));
    public static final DeferredBlock<Block> ORANGE_KITCHEN_SINK = BLOCKS.register("orange_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), false));
    public static final DeferredBlock<Block> BEIGE_KITCHEN_SINK = ModList.get().isLoaded("yogmod") ? BLOCKS.register("beige_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false)) : null;
    public static final DeferredBlock<Block> YELLOW_KITCHEN_SINK = BLOCKS.register("yellow_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false));
    public static final DeferredBlock<Block> LIME_KITCHEN_SINK = BLOCKS.register("lime_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), false));
    public static final DeferredBlock<Block> GREEN_KITCHEN_SINK = BLOCKS.register("green_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), false));
    public static final DeferredBlock<Block> CYAN_KITCHEN_SINK = BLOCKS.register("cyan_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), false));
    public static final DeferredBlock<Block> LIGHT_BLUE_KITCHEN_SINK = BLOCKS.register("light_blue_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final DeferredBlock<Block> BLUE_KITCHEN_SINK = BLOCKS.register("blue_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), false));
    public static final DeferredBlock<Block> PURPLE_KITCHEN_SINK = BLOCKS.register("purple_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), false));
    public static final DeferredBlock<Block> MAGENTA_KITCHEN_SINK = BLOCKS.register("magenta_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), false));
    public static final DeferredBlock<Block> PINK_KITCHEN_SINK = BLOCKS.register("pink_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), false));

    // Appliances
    public static final DeferredBlock<Block> FREEZER_LIGHT = BLOCKS.register("freezer_light",
        () -> new FreezerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FRIDGE_LIGHT));
    public static final DeferredBlock<Block> FRIDGE_LIGHT = BLOCKS.register("fridge_light",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FREEZER_LIGHT));
    public static final DeferredBlock<Block> FREEZER_DARK = BLOCKS.register("freezer_dark",
            () -> new FreezerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FRIDGE_DARK));
    public static final DeferredBlock<Block> FRIDGE_DARK = BLOCKS.register("fridge_dark",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FREEZER_DARK));


}
