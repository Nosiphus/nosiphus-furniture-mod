package com.mrcrayfish.furniture.world.level.block;

import com.mrcrayfish.furniture.platform.Services;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.function.Supplier;

public class ModBlocks
{
    public static void init() {

    }

    private static <T extends Block> Supplier<T> register(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    private static <T extends Block> Supplier<T> registerOptional(String name, String requiredModId, Supplier<T> supplier)
    {
        if (Services.PLATFORM.isModLoaded(requiredModId))
        {
            return register(name, supplier);
        }
        return () -> null;
    }

    // Tables
    public static final Supplier<Block> OAK_TABLE = register("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_TABLE = register("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_TABLE = register("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_TABLE = register("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_TABLE = register("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_TABLE = register("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_TABLE = register("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_TABLE = register("cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_TABLE = register("crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_TABLE = register("warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_TABLE = register("stripped_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_TABLE = register("stripped_spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_TABLE = register("stripped_birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_TABLE = register("stripped_jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_TABLE = register("stripped_acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_TABLE = register("stripped_dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_TABLE = register("stripped_mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_TABLE = register("stripped_cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_TABLE = register("stripped_crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_TABLE = register("stripped_warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Chairs
    public static final Supplier<Block> OAK_CHAIR = register("oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_CHAIR = register("spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_CHAIR = register("birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_CHAIR = register("jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_CHAIR = register("acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_CHAIR = register("dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_CHAIR = register("mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_CHAIR = register("cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_CHAIR = register("crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_CHAIR = register("warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_CHAIR = register("stripped_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_CHAIR = register("stripped_spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_CHAIR = register("stripped_birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_CHAIR = register("stripped_jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_CHAIR = register("stripped_acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_CHAIR = register("stripped_dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_CHAIR = register("stripped_mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_CHAIR = register("stripped_cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_CHAIR = register("stripped_crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_CHAIR = register("stripped_warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Coffee Tables
    public static final Supplier<Block> OAK_COFFEE_TABLE = register("oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_COFFEE_TABLE = register("spruce_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_COFFEE_TABLE = register("birch_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_COFFEE_TABLE = register("jungle_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_COFFEE_TABLE = register("acacia_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_COFFEE_TABLE = register("dark_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_COFFEE_TABLE = register("mangrove_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_COFFEE_TABLE = register("cherry_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_COFFEE_TABLE = register("crimson_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_COFFEE_TABLE = register("warped_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_COFFEE_TABLE = register("stripped_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_COFFEE_TABLE = register("stripped_spruce_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_COFFEE_TABLE = register("stripped_birch_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_COFFEE_TABLE = register("stripped_jungle_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_COFFEE_TABLE = register("stripped_acacia_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_COFFEE_TABLE = register("stripped_dark_oak_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_COFFEE_TABLE = register("stripped_mangrove_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_COFFEE_TABLE = register("stripped_cherry_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_COFFEE_TABLE = register("stripped_crimson_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_COFFEE_TABLE = register("stripped_warped_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Cabinets
    public static final Supplier<Block> OAK_CABINET = register("oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_CABINET = register("spruce_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_CABINET = register("birch_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_CABINET = register("jungle_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_CABINET = register("acacia_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_CABINET = register("dark_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_CABINET = register("mangrove_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_CABINET = register("cherry_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_CABINET = register("crimson_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_CABINET = register("warped_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_CABINET = register("stripped_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_CABINET = register("stripped_spruce_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_CABINET = register("stripped_birch_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_CABINET = register("stripped_jungle_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_CABINET = register("stripped_acacia_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_CABINET = register("stripped_dark_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_CABINET = register("stripped_mangrove_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_CABINET = register("stripped_cherry_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_CABINET = register("stripped_crimson_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_CABINET = register("stripped_warped_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Bedside Cabinets
    public static final Supplier<Block> OAK_BEDSIDE_CABINET = register("oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_BEDSIDE_CABINET = register("spruce_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_BEDSIDE_CABINET = register("birch_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_BEDSIDE_CABINET = register("jungle_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_BEDSIDE_CABINET = register("acacia_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BEDSIDE_CABINET = register("dark_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_BEDSIDE_CABINET = register("mangrove_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_BEDSIDE_CABINET = register("cherry_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_BEDSIDE_CABINET = register("crimson_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_BEDSIDE_CABINET = register("warped_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_BEDSIDE_CABINET = register("stripped_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_BEDSIDE_CABINET = register("stripped_spruce_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_BEDSIDE_CABINET = register("stripped_birch_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_BEDSIDE_CABINET = register("stripped_jungle_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_BEDSIDE_CABINET = register("stripped_acacia_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_BEDSIDE_CABINET = register("stripped_dark_oak_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_BEDSIDE_CABINET = register("stripped_mangrove_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_BEDSIDE_CABINET = register("stripped_cherry_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_BEDSIDE_CABINET = register("stripped_crimson_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_BEDSIDE_CABINET = register("stripped_warped_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Desks
    public static final Supplier<Block> OAK_DESK = register("oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.OAK));
    public static final Supplier<Block> SPRUCE_DESK = register("spruce_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.SPRUCE));
    public static final Supplier<Block> BIRCH_DESK = register("birch_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.BIRCH));
    public static final Supplier<Block> JUNGLE_DESK = register("jungle_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.JUNGLE));
    public static final Supplier<Block> ACACIA_DESK = register("acacia_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.ACACIA));
    public static final Supplier<Block> DARK_OAK_DESK = register("dark_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.DARK_OAK));
    public static final Supplier<Block> MANGROVE_DESK = register("mangrove_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.MANGROVE));
    public static final Supplier<Block> CHERRY_DESK = register("cherry_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.CHERRY));
    public static final Supplier<Block> CRIMSON_DESK = register("crimson_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.CRIMSON));
    public static final Supplier<Block> WARPED_DESK = register("warped_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.WARPED));
    public static final Supplier<Block> STRIPPED_OAK_DESK = register("stripped_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_OAK));
    public static final Supplier<Block> STRIPPED_SPRUCE_DESK = register("stripped_spruce_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.STRIPPED_SPRUCE));
    public static final Supplier<Block> STRIPPED_BIRCH_DESK = register("stripped_birch_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.STRIPPED_BIRCH));
    public static final Supplier<Block> STRIPPED_JUNGLE_DESK = register("stripped_jungle_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.STRIPPED_JUNGLE));
    public static final Supplier<Block> STRIPPED_ACACIA_DESK = register("stripped_acacia_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.STRIPPED_ACACIA));
    public static final Supplier<Block> STRIPPED_DARK_OAK_DESK = register("stripped_dark_oak_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_DARK_OAK));
    public static final Supplier<Block> STRIPPED_MANGROVE_DESK = register("stripped_mangrove_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.STRIPPED_MANGROVE));
    public static final Supplier<Block> STRIPPED_CHERRY_DESK = register("stripped_cherry_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.STRIPPED_CHERRY));
    public static final Supplier<Block> STRIPPED_CRIMSON_DESK = register("stripped_crimson_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.STRIPPED_CRIMSON));
    public static final Supplier<Block> STRIPPED_WARPED_DESK = register("stripped_warped_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.STRIPPED_WARPED));

    // Desk Cabinets
    public static final Supplier<Block> OAK_DESK_CABINET = register("oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.OAK));
    public static final Supplier<Block> SPRUCE_DESK_CABINET = register("spruce_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.SPRUCE));
    public static final Supplier<Block> BIRCH_DESK_CABINET = register("birch_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.BIRCH));
    public static final Supplier<Block> JUNGLE_DESK_CABINET = register("jungle_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.JUNGLE));
    public static final Supplier<Block> ACACIA_DESK_CABINET = register("acacia_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.ACACIA));
    public static final Supplier<Block> DARK_OAK_DESK_CABINET = register("dark_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.DARK_OAK));
    public static final Supplier<Block> MANGROVE_DESK_CABINET = register("mangrove_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.MANGROVE));
    public static final Supplier<Block> CHERRY_DESK_CABINET = register("cherry_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.CHERRY));
    public static final Supplier<Block> CRIMSON_DESK_CABINET = register("crimson_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.CRIMSON));
    public static final Supplier<Block> WARPED_DESK_CABINET = register("warped_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.WARPED));
    public static final Supplier<Block> STRIPPED_OAK_DESK_CABINET = register("stripped_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_OAK));
    public static final Supplier<Block> STRIPPED_SPRUCE_DESK_CABINET = register("stripped_spruce_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), DeskBlock.MaterialType.STRIPPED_SPRUCE));
    public static final Supplier<Block> STRIPPED_BIRCH_DESK_CABINET = register("stripped_birch_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), DeskBlock.MaterialType.STRIPPED_BIRCH));
    public static final Supplier<Block> STRIPPED_JUNGLE_DESK_CABINET = register("stripped_jungle_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), DeskBlock.MaterialType.STRIPPED_JUNGLE));
    public static final Supplier<Block> STRIPPED_ACACIA_DESK_CABINET = register("stripped_acacia_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), DeskBlock.MaterialType.STRIPPED_ACACIA));
    public static final Supplier<Block> STRIPPED_DARK_OAK_DESK_CABINET = register("stripped_dark_oak_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), DeskBlock.MaterialType.STRIPPED_DARK_OAK));
    public static final Supplier<Block> STRIPPED_MANGROVE_DESK_CABINET = register("stripped_mangrove_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), DeskBlock.MaterialType.STRIPPED_MANGROVE));
    public static final Supplier<Block> STRIPPED_CHERRY_DESK_CABINET = register("stripped_cherry_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), DeskBlock.MaterialType.STRIPPED_CHERRY));
    public static final Supplier<Block> STRIPPED_CRIMSON_DESK_CABINET = register("stripped_crimson_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), DeskBlock.MaterialType.STRIPPED_CRIMSON));
    public static final Supplier<Block> STRIPPED_WARPED_DESK_CABINET = register("stripped_warped_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), DeskBlock.MaterialType.STRIPPED_WARPED));

    // Sofas
    public static final Supplier<Block> WHITE_SOFA = register("white_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> LIGHT_GRAY_SOFA = register("light_gray_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> GRAY_SOFA = register("gray_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> BLACK_SOFA = register("black_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> BROWN_SOFA = register("brown_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> RED_SOFA = register("red_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> ORANGE_SOFA = register("orange_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> BEIGE_SOFA = registerOptional("beige_sofa", "yogmod",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> YELLOW_SOFA = register("yellow_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> LIME_SOFA = register("lime_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> GREEN_SOFA = register("green_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> CYAN_SOFA = register("cyan_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> LIGHT_BLUE_SOFA = register("light_blue_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> BLUE_SOFA = register("blue_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> PURPLE_SOFA = register("purple_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> MAGENTA_SOFA = register("magenta_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> PINK_SOFA = register("pink_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> RAINBOW_SOFA = register("rainbow_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    // Blinds
    public static final Supplier<Block> OAK_BLINDS = register("oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_BLINDS = register("spruce_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_BLINDS = register("birch_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_BLINDS = register("jungle_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_BLINDS = register("acacia_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BLINDS = register("dark_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_BLINDS = register("mangrove_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_BLINDS = register("cherry_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_BLINDS = register("crimson_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_BLINDS = register("warped_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_BLINDS = register("stripped_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_BLINDS = register("stripped_spruce_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_BLINDS = register("stripped_birch_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_BLINDS = register("stripped_jungle_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_BLINDS = register("stripped_acacia_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_BLINDS = register("stripped_dark_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_BLINDS = register("stripped_mangrove_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_BLINDS = register("stripped_cherry_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_BLINDS = register("stripped_crimson_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_BLINDS = register("stripped_warped_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Upgraded Fences
    public static final Supplier<Block> OAK_UPGRADED_FENCE = register("oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_UPGRADED_FENCE = register("spruce_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_UPGRADED_FENCE = register("birch_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_UPGRADED_FENCE = register("jungle_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_UPGRADED_FENCE = register("acacia_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_UPGRADED_FENCE = register("dark_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_UPGRADED_FENCE = register("mangrove_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_UPGRADED_FENCE = register("cherry_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_UPGRADED_FENCE = register("crimson_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_UPGRADED_FENCE = register("warped_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_UPGRADED_FENCE = register("stripped_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_UPGRADED_FENCE = register("stripped_spruce_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_UPGRADED_FENCE = register("stripped_birch_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_UPGRADED_FENCE = register("stripped_jungle_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_UPGRADED_FENCE = register("stripped_acacia_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_UPGRADED_FENCE = register("stripped_dark_oak_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_UPGRADED_FENCE = register("stripped_mangrove_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_UPGRADED_FENCE = register("stripped_cherry_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_UPGRADED_FENCE = register("stripped_crimson_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_UPGRADED_FENCE = register("stripped_warped_upgraded_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Upgraded Gates
    public static final Supplier<Block> OAK_UPGRADED_GATE = register("oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_UPGRADED_GATE = register("spruce_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_UPGRADED_GATE = register("birch_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_UPGRADED_GATE = register("jungle_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_UPGRADED_GATE = register("acacia_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_UPGRADED_GATE = register("dark_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_UPGRADED_GATE = register("mangrove_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_UPGRADED_GATE = register("cherry_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_UPGRADED_GATE = register("crimson_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_UPGRADED_GATE = register("warped_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_UPGRADED_GATE = register("stripped_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_UPGRADED_GATE = register("stripped_spruce_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_UPGRADED_GATE = register("stripped_birch_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_UPGRADED_GATE = register("stripped_jungle_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_UPGRADED_GATE = register("stripped_acacia_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_UPGRADED_GATE = register("stripped_dark_oak_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_UPGRADED_GATE = register("stripped_mangrove_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_UPGRADED_GATE = register("stripped_cherry_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_UPGRADED_GATE = register("stripped_crimson_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_UPGRADED_GATE = register("stripped_warped_upgraded_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Picket Fences
    public static final Supplier<Block> WHITE_PICKET_FENCE = register("white_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIGHT_GRAY_PICKET_FENCE = register("light_gray_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> GRAY_PICKET_FENCE = register("gray_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BLACK_PICKET_FENCE = register("black_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BROWN_PICKET_FENCE = register("brown_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> RED_PICKET_FENCE = register("red_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> ORANGE_PICKET_FENCE = register("orange_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BEIGE_PICKET_FENCE = registerOptional("beige_picket_fence", "yogmod",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> YELLOW_PICKET_FENCE = register("yellow_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIME_PICKET_FENCE = register("lime_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> GREEN_PICKET_FENCE = register("green_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> CYAN_PICKET_FENCE = register("cyan_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIGHT_BLUE_PICKET_FENCE = register("light_blue_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BLUE_PICKET_FENCE = register("blue_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> PURPLE_PICKET_FENCE = register("purple_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> MAGENTA_PICKET_FENCE = register("magenta_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> PINK_PICKET_FENCE = register("pink_picket_fence",
            () -> new UpgradedFenceBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));

    // Picket Gates
    public static final Supplier<Block> WHITE_PICKET_GATE = register("white_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIGHT_GRAY_PICKET_GATE = register("light_gray_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> GRAY_PICKET_GATE = register("gray_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BLACK_PICKET_GATE = register("black_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BROWN_PICKET_GATE = register("brown_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> RED_PICKET_GATE = register("red_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> ORANGE_PICKET_GATE = register("orange_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BEIGE_PICKET_GATE = registerOptional("beige_picket_gate", "yogmod",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> YELLOW_PICKET_GATE = register("yellow_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIME_PICKET_GATE = register("lime_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> GREEN_PICKET_GATE = register("green_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> CYAN_PICKET_GATE = register("cyan_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> LIGHT_BLUE_PICKET_GATE = register("light_blue_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> BLUE_PICKET_GATE = register("blue_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> PURPLE_PICKET_GATE = register("purple_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> MAGENTA_PICKET_GATE = register("magenta_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final Supplier<Block> PINK_PICKET_GATE = register("pink_picket_gate",
            () -> new UpgradedGateBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));

    // Crates
    public static final Supplier<Block> OAK_CRATE = register("oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> SPRUCE_CRATE = register("spruce_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> BIRCH_CRATE = register("birch_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> JUNGLE_CRATE = register("jungle_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> ACACIA_CRATE = register("acacia_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> DARK_OAK_CRATE = register("dark_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> MANGROVE_CRATE = register("mangrove_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> CHERRY_CRATE = register("cherry_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> CRIMSON_CRATE = register("crimson_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> WARPED_CRATE = register("warped_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_OAK_CRATE = register("stripped_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_SPRUCE_CRATE = register("stripped_spruce_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_BIRCH_CRATE = register("stripped_birch_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_JUNGLE_CRATE = register("stripped_jungle_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_ACACIA_CRATE = register("stripped_acacia_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_CRATE = register("stripped_dark_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_MANGROVE_CRATE = register("stripped_mangrove_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_CHERRY_CRATE = register("stripped_cherry_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_CRIMSON_CRATE = register("stripped_crimson_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final Supplier<Block> STRIPPED_WARPED_CRATE = register("stripped_warped_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.CHEST)));

    // Park Benches
    public static final Supplier<Block> OAK_PARK_BENCH = register("oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_PARK_BENCH = register("spruce_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_PARK_BENCH = register("birch_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_PARK_BENCH = register("jungle_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_PARK_BENCH = register("acacia_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_PARK_BENCH = register("dark_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_PARK_BENCH = register("mangrove_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_PARK_BENCH = register("cherry_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_PARK_BENCH = register("crimson_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_PARK_BENCH = register("warped_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_PARK_BENCH = register("stripped_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_PARK_BENCH = register("stripped_spruce_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_PARK_BENCH = register("stripped_birch_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_PARK_BENCH = register("stripped_jungle_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_PARK_BENCH = register("stripped_acacia_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_PARK_BENCH = register("stripped_dark_oak_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_PARK_BENCH = register("stripped_mangrove_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_PARK_BENCH = register("stripped_cherry_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_PARK_BENCH = register("stripped_crimson_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_PARK_BENCH = register("stripped_warped_park_bench",
            () -> new ParkBenchBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Post Box
    public static final Supplier<Block> POST_BOX = register("post_box",
            () -> new PostBoxBlock(BlockBehaviour.Properties.copy(Blocks.ANVIL)));

    // Mail Boxes
    public static final Supplier<Block> OAK_MAIL_BOX = register("oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_MAIL_BOX = register("spruce_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_MAIL_BOX = register("birch_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_MAIL_BOX = register("jungle_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_MAIL_BOX = register("acacia_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_MAIL_BOX = register("dark_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_MAIL_BOX = register("mangrove_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_MAIL_BOX = register("cherry_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_MAIL_BOX = register("crimson_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_MAIL_BOX = register("warped_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_MAIL_BOX = register("stripped_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_MAIL_BOX = register("stripped_spruce_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_MAIL_BOX = register("stripped_birch_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_MAIL_BOX = register("stripped_jungle_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_MAIL_BOX = register("stripped_acacia_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_MAIL_BOX = register("stripped_dark_oak_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_MAIL_BOX = register("stripped_mangrove_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_MAIL_BOX = register("stripped_cherry_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_MAIL_BOX = register("stripped_crimson_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_MAIL_BOX = register("stripped_warped_mail_box",
            () -> new MailBoxBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    // Hedges
    public static final Supplier<Block> OAK_HEDGE = register("oak_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final Supplier<Block> SPRUCE_HEDGE = register("spruce_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)));
    public static final Supplier<Block> BIRCH_HEDGE = register("birch_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));
    public static final Supplier<Block> JUNGLE_HEDGE = register("jungle_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES)));
    public static final Supplier<Block> ACACIA_HEDGE = register("acacia_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LEAVES)));
    public static final Supplier<Block> DARK_OAK_HEDGE = register("dark_oak_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LEAVES)));
    public static final Supplier<Block> MANGROVE_HEDGE = register("mangrove_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LEAVES)));
    public static final Supplier<Block> CHERRY_HEDGE = register("cherry_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES)));
    public static final Supplier<Block> AZALEA_HEDGE = register("azalea_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final Supplier<Block> FLOWERING_AZALEA_HEDGE = register("flowering_azalea_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.FLOWERING_AZALEA_LEAVES)));

    // Rock Path
    public static final Supplier<Block> ROCK_PATH = register("rock_path",
            () -> new RockPathBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    // Trampolines
    public static final Supplier<Block> WHITE_TRAMPOLINE = register("white_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_TRAMPOLINE = register("light_gray_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_TRAMPOLINE = register("gray_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_TRAMPOLINE = register("black_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_TRAMPOLINE = register("brown_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_TRAMPOLINE = register("red_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_TRAMPOLINE = register("orange_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_TRAMPOLINE = registerOptional("beige_trampoline", "yogmod",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> YELLOW_TRAMPOLINE = register("yellow_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_TRAMPOLINE = register("lime_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_TRAMPOLINE = register("green_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_TRAMPOLINE = register("cyan_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_TRAMPOLINE = register("light_blue_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_TRAMPOLINE = register("blue_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_TRAMPOLINE = register("purple_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_TRAMPOLINE = register("magenta_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_TRAMPOLINE = register("pink_trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    // Coolers
    public static final Supplier<Block> WHITE_COOLER = register("white_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_COOLER = register("light_gray_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_COOLER = register("gray_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_COOLER = register("black_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_COOLER = register("brown_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_COOLER = register("red_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_COOLER = register("orange_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_COOLER = registerOptional("beige_cooler", "yogmod",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> YELLOW_COOLER = register("yellow_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_COOLER = register("lime_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_COOLER = register("green_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_COOLER = register("cyan_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_COOLER = register("light_blue_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_COOLER = register("blue_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_COOLER = register("purple_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_COOLER = register("magenta_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_COOLER = register("pink_cooler",
            () -> new CoolerBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    // Grills
    public static final Supplier<Block> WHITE_GRILL = register("white_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> LIGHT_GRAY_GRILL = register("light_gray_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> GRAY_GRILL = register("gray_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> BLACK_GRILL = register("black_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> BROWN_GRILL = register("brown_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> RED_GRILL = register("red_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> ORANGE_GRILL = register("orange_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> BEIGE_GRILL = registerOptional("beige_grill", "yogmod",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> YELLOW_GRILL = register("yellow_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> LIME_GRILL = register("lime_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> GREEN_GRILL = register("green_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> CYAN_GRILL = register("cyan_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> LIGHT_BLUE_GRILL = register("light_blue_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> BLUE_GRILL = register("blue_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> PURPLE_GRILL = register("purple_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> MAGENTA_GRILL = register("magenta_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> PINK_GRILL = register("pink_grill",
            () -> new GrillBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    // Door Mat
    public static final Supplier<Block> DOOR_MAT = register("door_mat",
            () -> new DoorMatBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));

    // Diving Board
    public static final Supplier<Block> DIVING_BOARD = register("diving_board",
            () -> new DivingBoardBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    // Kitchen Counters
    public static final Supplier<Block> OAK_KITCHEN_COUNTER = register("oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_KITCHEN_COUNTER = register("spruce_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_KITCHEN_COUNTER = register("birch_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_KITCHEN_COUNTER = register("jungle_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_KITCHEN_COUNTER = register("acacia_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_KITCHEN_COUNTER = register("dark_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_KITCHEN_COUNTER = register("mangrove_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_KITCHEN_COUNTER = register("cherry_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_KITCHEN_COUNTER = register("crimson_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_KITCHEN_COUNTER = register("warped_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_KITCHEN_COUNTER = register("stripped_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_KITCHEN_COUNTER = register("stripped_spruce_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_KITCHEN_COUNTER = register("stripped_birch_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_KITCHEN_COUNTER = register("stripped_jungle_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_KITCHEN_COUNTER = register("stripped_acacia_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_KITCHEN_COUNTER = register("stripped_dark_oak_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_KITCHEN_COUNTER = register("stripped_mangrove_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_KITCHEN_COUNTER = register("stripped_cherry_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_KITCHEN_COUNTER = register("stripped_crimson_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_KITCHEN_COUNTER = register("stripped_warped_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WHITE_KITCHEN_COUNTER = register("white_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_KITCHEN_COUNTER = register("light_gray_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_KITCHEN_COUNTER = register("gray_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_KITCHEN_COUNTER = register("black_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_KITCHEN_COUNTER = register("brown_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_KITCHEN_COUNTER = register("red_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_KITCHEN_COUNTER = register("orange_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_KITCHEN_COUNTER = registerOptional("beige_kitchen_counter", "yogmod",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> YELLOW_KITCHEN_COUNTER = register("yellow_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_KITCHEN_COUNTER = register("lime_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_KITCHEN_COUNTER = register("green_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_KITCHEN_COUNTER = register("cyan_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_KITCHEN_COUNTER = register("light_blue_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_KITCHEN_COUNTER = register("blue_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_KITCHEN_COUNTER = register("purple_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_KITCHEN_COUNTER = register("magenta_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_KITCHEN_COUNTER = register("pink_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    // Kitchen Drawers
    public static final Supplier<Block> OAK_KITCHEN_DRAWER = register("oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_KITCHEN_DRAWER = register("spruce_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_KITCHEN_DRAWER = register("birch_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_KITCHEN_DRAWER = register("jungle_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_KITCHEN_DRAWER = register("acacia_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_KITCHEN_DRAWER = register("dark_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_KITCHEN_DRAWER = register("mangrove_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_KITCHEN_DRAWER = register("cherry_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_KITCHEN_DRAWER = register("crimson_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_KITCHEN_DRAWER = register("warped_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> STRIPPED_OAK_KITCHEN_DRAWER = register("stripped_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_SPRUCE_KITCHEN_DRAWER = register("stripped_spruce_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> STRIPPED_BIRCH_KITCHEN_DRAWER = register("stripped_birch_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> STRIPPED_JUNGLE_KITCHEN_DRAWER = register("stripped_jungle_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> STRIPPED_ACACIA_KITCHEN_DRAWER = register("stripped_acacia_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_KITCHEN_DRAWER = register("stripped_dark_oak_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> STRIPPED_MANGROVE_KITCHEN_DRAWER = register("stripped_mangrove_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> STRIPPED_CHERRY_KITCHEN_DRAWER = register("stripped_cherry_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> STRIPPED_CRIMSON_KITCHEN_DRAWER = register("stripped_crimson_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> STRIPPED_WARPED_KITCHEN_DRAWER = register("stripped_warped_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WHITE_KITCHEN_DRAWER = register("white_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_KITCHEN_DRAWER = register("light_gray_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_KITCHEN_DRAWER = register("gray_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_KITCHEN_DRAWER = register("black_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_KITCHEN_DRAWER = register("brown_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_KITCHEN_DRAWER = register("red_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_KITCHEN_DRAWER = register("orange_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_KITCHEN_DRAWER = registerOptional("beige_kitchen_drawer", "yogmod",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> YELLOW_KITCHEN_DRAWER = register("yellow_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_KITCHEN_DRAWER = register("lime_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_KITCHEN_DRAWER = register("green_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_KITCHEN_DRAWER = register("cyan_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_KITCHEN_DRAWER = register("light_blue_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_KITCHEN_DRAWER = register("blue_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_KITCHEN_DRAWER = register("purple_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_KITCHEN_DRAWER = register("magenta_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_KITCHEN_DRAWER = register("pink_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    // Kitchen Sinks
    public static final Supplier<Block> OAK_KITCHEN_SINK_LIGHT = register("oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), true));
    public static final Supplier<Block> SPRUCE_KITCHEN_SINK_LIGHT = register("spruce_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), true));
    public static final Supplier<Block> BIRCH_KITCHEN_SINK_LIGHT = register("birch_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), true));
    public static final Supplier<Block> JUNGLE_KITCHEN_SINK_LIGHT = register("jungle_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), true));
    public static final Supplier<Block> ACACIA_KITCHEN_SINK_LIGHT = register("acacia_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), true));
    public static final Supplier<Block> DARK_OAK_KITCHEN_SINK_LIGHT = register("dark_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), true));
    public static final Supplier<Block> MANGROVE_KITCHEN_SINK_LIGHT = register("mangrove_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), true));
    public static final Supplier<Block> CHERRY_KITCHEN_SINK_LIGHT = register("cherry_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), true));
    public static final Supplier<Block> CRIMSON_KITCHEN_SINK_LIGHT = register("crimson_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), true));
    public static final Supplier<Block> WARPED_KITCHEN_SINK_LIGHT = register("warped_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), true));
    public static final Supplier<Block> STRIPPED_OAK_KITCHEN_SINK_LIGHT = register("stripped_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), true));
    public static final Supplier<Block> STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT = register("stripped_spruce_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_BIRCH_KITCHEN_SINK_LIGHT = register("stripped_birch_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), true));
    public static final Supplier<Block> STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT = register("stripped_jungle_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_ACACIA_KITCHEN_SINK_LIGHT = register("stripped_acacia_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), true));
    public static final Supplier<Block> STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT = register("stripped_dark_oak_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), true));
    public static final Supplier<Block> STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT = register("stripped_mangrove_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_CHERRY_KITCHEN_SINK_LIGHT = register("stripped_cherry_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), true));
    public static final Supplier<Block> STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT = register("stripped_crimson_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), true));
    public static final Supplier<Block> STRIPPED_WARPED_KITCHEN_SINK_LIGHT = register("stripped_warped_kitchen_sink_light",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), true));
    public static final Supplier<Block> OAK_KITCHEN_SINK_DARK = register("oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), true));
    public static final Supplier<Block> SPRUCE_KITCHEN_SINK_DARK = register("spruce_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), true));
    public static final Supplier<Block> BIRCH_KITCHEN_SINK_DARK = register("birch_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), true));
    public static final Supplier<Block> JUNGLE_KITCHEN_SINK_DARK = register("jungle_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), true));
    public static final Supplier<Block> ACACIA_KITCHEN_SINK_DARK = register("acacia_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), true));
    public static final Supplier<Block> DARK_OAK_KITCHEN_SINK_DARK = register("dark_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), true));
    public static final Supplier<Block> MANGROVE_KITCHEN_SINK_DARK = register("mangrove_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), true));
    public static final Supplier<Block> CHERRY_KITCHEN_SINK_DARK = register("cherry_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), true));
    public static final Supplier<Block> CRIMSON_KITCHEN_SINK_DARK = register("crimson_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), true));
    public static final Supplier<Block> WARPED_KITCHEN_SINK_DARK = register("warped_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), true));
    public static final Supplier<Block> STRIPPED_OAK_KITCHEN_SINK_DARK = register("stripped_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), true));
    public static final Supplier<Block> STRIPPED_SPRUCE_KITCHEN_SINK_DARK = register("stripped_spruce_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_BIRCH_KITCHEN_SINK_DARK = register("stripped_birch_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), true));
    public static final Supplier<Block> STRIPPED_JUNGLE_KITCHEN_SINK_DARK = register("stripped_jungle_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_ACACIA_KITCHEN_SINK_DARK = register("stripped_acacia_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), true));
    public static final Supplier<Block> STRIPPED_DARK_OAK_KITCHEN_SINK_DARK = register("stripped_dark_oak_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), true));
    public static final Supplier<Block> STRIPPED_MANGROVE_KITCHEN_SINK_DARK = register("stripped_mangrove_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), true));
    public static final Supplier<Block> STRIPPED_CHERRY_KITCHEN_SINK_DARK = register("stripped_cherry_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS), true));
    public static final Supplier<Block> STRIPPED_CRIMSON_KITCHEN_SINK_DARK = register("stripped_crimson_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), true));
    public static final Supplier<Block> STRIPPED_WARPED_KITCHEN_SINK_DARK = register("stripped_warped_kitchen_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), true));
    public static final Supplier<Block> WHITE_KITCHEN_SINK = register("white_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), false));
    public static final Supplier<Block> LIGHT_GRAY_KITCHEN_SINK = register("light_gray_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final Supplier<Block> GRAY_KITCHEN_SINK = register("gray_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), false));
    public static final Supplier<Block> BLACK_KITCHEN_SINK = register("black_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), false));
    public static final Supplier<Block> BROWN_KITCHEN_SINK = register("brown_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), false));
    public static final Supplier<Block> RED_KITCHEN_SINK = register("red_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), false));
    public static final Supplier<Block> ORANGE_KITCHEN_SINK = register("orange_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), false));
    public static final Supplier<Block> BEIGE_KITCHEN_SINK = registerOptional("beige_kitchen_sink", "yogmod",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), false));
    public static final Supplier<Block> YELLOW_KITCHEN_SINK = register("yellow_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), false));
    public static final Supplier<Block> LIME_KITCHEN_SINK = register("lime_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), false));
    public static final Supplier<Block> GREEN_KITCHEN_SINK = register("green_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), false));
    public static final Supplier<Block> CYAN_KITCHEN_SINK = register("cyan_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), false));
    public static final Supplier<Block> LIGHT_BLUE_KITCHEN_SINK = register("light_blue_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final Supplier<Block> BLUE_KITCHEN_SINK = register("blue_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), false));
    public static final Supplier<Block> PURPLE_KITCHEN_SINK = register("purple_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), false));
    public static final Supplier<Block> MAGENTA_KITCHEN_SINK = register("magenta_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), false));
    public static final Supplier<Block> PINK_KITCHEN_SINK = register("pink_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), false));

    // Appliances
    public static final Supplier<Block> FREEZER_LIGHT = register("freezer_light",
            () -> new FreezerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FRIDGE_LIGHT.get()));
    public static final Supplier<Block> FRIDGE_LIGHT = register("fridge_light",
            () -> new FridgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FREEZER_LIGHT.get()));
    public static final Supplier<Block> FREEZER_DARK = register("freezer_dark",
            () -> new FreezerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FRIDGE_DARK.get()));
    public static final Supplier<Block> FRIDGE_DARK = register("fridge_dark",
            () -> new FridgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), () -> ModBlocks.FREEZER_DARK.get()));
}