package com.nosiphus.furniture.core;

import com.mrcrayfish.furniture.block.*;
import com.nosiphus.furniture.block.*;
import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.Reference;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/**
 * Author: MrCrayfish, Nosiphus
 */
public class ModBlocks {

    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    //Tables
    public static final RegistryObject<Block> TABLE_WHITE_MODERN = register("white_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_ORANGE_MODERN = register("orange_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_MAGENTA_MODERN = register("magenta_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_BLUE_MODERN = register("light_blue_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_YELLOW_MODERN = register("yellow_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIME_MODERN = register("lime_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PINK_MODERN = register("pink_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GRAY_MODERN = register("gray_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_GRAY_MODERN = register("light_gray_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_CYAN_MODERN = register("cyan_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PURPLE_MODERN = register("purple_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLUE_MODERN = register("blue_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BROWN_MODERN = register("brown_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GREEN_MODERN = register("green_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_RED_MODERN = register("red_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLACK_MODERN = register("black_modern_table", new ModernTableBlock(Block.Properties.from(Blocks.BLACK_CONCRETE)));

    //Chairs
    public static final RegistryObject<Block> CHAIR_WHITE_MODERN = register("white_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_ORANGE_MODERN = register("orange_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_MAGENTA_MODERN = register("magenta_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIGHT_BLUE_MODERN = register("light_blue_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_YELLOW_MODERN = register("yellow_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIME_MODERN = register("lime_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.LIME_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_PINK_MODERN = register("pink_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.PINK_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_GRAY_MODERN = register("gray_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIGHT_GRAY_MODERN = register("light_gray_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_CYAN_MODERN = register("cyan_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.CYAN_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_PURPLE_MODERN = register("purple_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_BLUE_MODERN = register("blue_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.BLUE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_BROWN_MODERN = register("brown_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.BROWN_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_GREEN_MODERN = register("green_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.GREEN_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_RED_MODERN = register("red_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.RED_CONCRETE).notSolid()));
    public static final RegistryObject<Block> CHAIR_BLACK_MODERN = register("black_modern_chair", new ModernChairBlock(Block.Properties.from(Blocks.BLACK_CONCRETE).notSolid()));

    //Office Chairs
    public static final RegistryObject<Block> CHAIR_WHITE_OFFICE = register("white_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.WHITE_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_ORANGE_OFFICE = register("orange_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.ORANGE_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_MAGENTA_OFFICE = register("magenta_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.MAGENTA_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIGHT_BLUE_OFFICE = register("light_blue_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.LIGHT_BLUE_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_YELLOW_OFFICE = register("yellow_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.YELLOW_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIME_OFFICE = register("lime_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.LIME_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_PINK_OFFICE = register("pink_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.PINK_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_GRAY_OFFICE = register("gray_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.GRAY_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_LIGHT_GRAY_OFFICE = register("light_gray_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.LIGHT_GRAY_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_CYAN_OFFICE = register("cyan_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.CYAN_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_PURPLE_OFFICE = register("purple_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.PURPLE_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_BLUE_OFFICE = register("blue_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.BLUE_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_BROWN_OFFICE = register("brown_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.BROWN_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_GREEN_OFFICE = register("green_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.GREEN_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_RED_OFFICE = register("red_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.RED_WOOL).notSolid()));
    public static final RegistryObject<Block> CHAIR_BLACK_OFFICE = register("black_office_chair", new OfficeChairBlock(AbstractBlock.Properties.from(Blocks.BLACK_WOOL).notSolid()));

    //Coffee Tables
    public static final RegistryObject<Block> COFFEE_TABLE_WHITE_MODERN = register("white_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_ORANGE_MODERN = register("orange_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_MAGENTA_MODERN = register("magenta_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_BLUE_MODERN = register("light_blue_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_YELLOW_MODERN = register("yellow_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIME_MODERN = register("lime_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PINK_MODERN = register("pink_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GRAY_MODERN = register("gray_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_GRAY_MODERN = register("light_gray_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_CYAN_MODERN = register("cyan_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PURPLE_MODERN = register("purple_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLUE_MODERN = register("blue_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BROWN_MODERN = register("brown_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GREEN_MODERN = register("green_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_RED_MODERN = register("red_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLACK_MODERN = register("black_modern_coffee_table", new ModernCoffeeTableBlock(Block.Properties.from(Blocks.BLACK_CONCRETE)));

    //Cabinets
    public static final RegistryObject<Block> CABINET_WHITE_MODERN = register("white_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_ORANGE_MODERN = register("orange_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_MAGENTA_MODERN = register("magenta_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_BLUE_MODERN = register("light_blue_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_YELLOW_MODERN = register("yellow_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIME_MODERN = register("lime_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PINK_MODERN = register("pink_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GRAY_MODERN = register("gray_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_GRAY_MODERN = register("light_gray_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_CYAN_MODERN = register("cyan_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PURPLE_MODERN = register("purple_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLUE_MODERN = register("blue_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BROWN_MODERN = register("brown_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GREEN_MODERN = register("green_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_RED_MODERN = register("red_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLACK_MODERN = register("black_modern_cabinet", new CabinetBlock(AbstractBlock.Properties.from(Blocks.BLACK_CONCRETE)));

    //Bedside Cabinets
    public static final RegistryObject<Block> BEDSIDE_CABINET_WHITE_MODERN = register("white_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_ORANGE_MODERN = register("orange_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_MAGENTA_MODERN = register("magenta_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIGHT_BLUE_MODERN = register("light_blue_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_YELLOW_MODERN = register("yellow_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIME_MODERN = register("lime_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_PINK_MODERN = register("pink_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_GRAY_MODERN = register("gray_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIGHT_GRAY_MODERN = register("light_gray_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_CYAN_MODERN = register("cyan_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_PURPLE_MODERN = register("purple_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BLUE_MODERN = register("blue_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BROWN_MODERN = register("brown_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_GREEN_MODERN = register("green_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_RED_MODERN = register("red_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BLACK_MODERN = register("black_modern_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Properties.from(Blocks.BLACK_CONCRETE)));

    //Desk
    public static final RegistryObject<Block> DESK_WHITE_MODERN = register("white_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE), ModernDeskBlock.MaterialType.WHITE_CONCRETE));
    public static final RegistryObject<Block> DESK_ORANGE_MODERN = register("orange_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.ORANGE_CONCRETE), ModernDeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final RegistryObject<Block> DESK_MAGENTA_MODERN = register("magenta_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.MAGENTA_CONCRETE), ModernDeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final RegistryObject<Block> DESK_LIGHT_BLUE_MODERN = register("light_blue_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.LIGHT_BLUE_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_YELLOW_MODERN = register("yellow_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.YELLOW_CONCRETE), ModernDeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final RegistryObject<Block> DESK_LIME_MODERN = register("lime_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.LIME_CONCRETE), ModernDeskBlock.MaterialType.LIME_CONCRETE));
    public static final RegistryObject<Block> DESK_PINK_MODERN = register("pink_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.PINK_CONCRETE), ModernDeskBlock.MaterialType.PINK_CONCRETE));
    public static final RegistryObject<Block> DESK_GRAY_MODERN = register("gray_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE), ModernDeskBlock.MaterialType.GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_LIGHT_GRAY_MODERN = register("light_gray_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.LIGHT_GRAY_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CYAN_MODERN = register("cyan_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.CYAN_CONCRETE), ModernDeskBlock.MaterialType.CYAN_CONCRETE));
    public static final RegistryObject<Block> DESK_PURPLE_MODERN = register("purple_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.PURPLE_CONCRETE), ModernDeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final RegistryObject<Block> DESK_BLUE_MODERN = register("blue_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.BLUE_CONCRETE), ModernDeskBlock.MaterialType.BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_BROWN_MODERN = register("brown_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.BROWN_CONCRETE), ModernDeskBlock.MaterialType.BROWN_CONCRETE));
    public static final RegistryObject<Block> DESK_GREEN_MODERN = register("green_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.GREEN_CONCRETE), ModernDeskBlock.MaterialType.GREEN_CONCRETE));
    public static final RegistryObject<Block> DESK_RED_MODERN = register("red_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.RED_CONCRETE), ModernDeskBlock.MaterialType.RED_CONCRETE));
    public static final RegistryObject<Block> DESK_BLACK_MODERN = register("black_modern_desk", new ModernDeskBlock(AbstractBlock.Properties.from(Blocks.BLACK_CONCRETE), ModernDeskBlock.MaterialType.BLACK_CONCRETE));

    //Desk Cabinets
    public static final RegistryObject<Block> DESK_CABINET_WHITE_MODERN = register("white_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE), ModernDeskBlock.MaterialType.WHITE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_ORANGE_MODERN = register("orange_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.ORANGE_CONCRETE), ModernDeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_MAGENTA_MODERN = register("magenta_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.MAGENTA_CONCRETE), ModernDeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIGHT_BLUE_MODERN = register("light_blue_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_BLUE_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_YELLOW_MODERN = register("yellow_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.YELLOW_CONCRETE), ModernDeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIME_MODERN = register("lime_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.LIME_CONCRETE), ModernDeskBlock.MaterialType.LIME_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_PINK_MODERN = register("pink_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.PINK_CONCRETE), ModernDeskBlock.MaterialType.PINK_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_GRAY_MODERN = register("gray_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE), ModernDeskBlock.MaterialType.GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIGHT_GRAY_MODERN = register("light_gray_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.LIGHT_GRAY_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_CYAN_MODERN = register("cyan_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.CYAN_CONCRETE), ModernDeskBlock.MaterialType.CYAN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_PURPLE_MODERN = register("purple_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.PURPLE_CONCRETE), ModernDeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BLUE_MODERN = register("blue_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.BLUE_CONCRETE), ModernDeskBlock.MaterialType.BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BROWN_MODERN = register("brown_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.BROWN_CONCRETE), ModernDeskBlock.MaterialType.BROWN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_GREEN_MODERN = register("green_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.GREEN_CONCRETE), ModernDeskBlock.MaterialType.GREEN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_RED_MODERN = register("red_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.RED_CONCRETE), ModernDeskBlock.MaterialType.RED_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BLACK_MODERN = register("black_modern_desk_cabinet", new ModernDeskCabinetBlock(AbstractBlock.Properties.from(Blocks.BLACK_CONCRETE), ModernDeskBlock.MaterialType.BLACK_CONCRETE));

    //Sofas
    public static final RegistryObject<Block> SOFA_WHITE_MODERN = register("white_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.WHITE_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_ORANGE_MODERN = register("orange_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_MAGENTA_MODERN = register("magenta_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_LIGHT_BLUE_MODERN = register("light_blue_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_YELLOW_MODERN = register("yellow_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_LIME_MODERN = register("lime_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.LIME_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_PINK_MODERN = register("pink_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.PINK_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_GRAY_MODERN = register("gray_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.GRAY_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_LIGHT_GRAY_MODERN = register("light_gray_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_CYAN_MODERN = register("cyan_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.CYAN_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_PURPLE_MODERN = register("purple_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_BLUE_MODERN = register("blue_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.BLUE_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_BROWN_MODERN = register("brown_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.BROWN_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_GREEN_MODERN = register("green_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.GREEN_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_RED_MODERN = register("red_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.RED_CONCRETE).sound(SoundType.STONE).notSolid()));
    public static final RegistryObject<Block> SOFA_BLACK_MODERN = register("black_modern_sofa", new ModernSofaBlock(Block.Properties.from(Blocks.BLACK_CONCRETE).sound(SoundType.STONE).notSolid()));

    //Kitchen Counters
    public static final RegistryObject<Block> KITCHEN_COUNTER_WHITE_MODERN = register("white_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_ORANGE_MODERN = register("orange_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_MAGENTA_MODERN = register("magenta_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIGHT_BLUE_MODERN = register("light_blue_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_YELLOW_MODERN = register("yellow_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIME_MODERN = register("lime_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_PINK_MODERN = register("pink_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_GRAY_MODERN = register("gray_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIGHT_GRAY_MODERN = register("light_gray_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_CYAN_MODERN = register("cyan_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_PURPLE_MODERN = register("purple_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BLUE_MODERN = register("blue_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BROWN_MODERN = register("brown_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_GREEN_MODERN = register("green_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_RED_MODERN = register("red_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BLACK_MODERN = register("black_modern_kitchen_counter", new KitchenCounterBlock(Block.Properties.from(Blocks.BLACK_CONCRETE)));

    //Kitchen Drawers
    public static final RegistryObject<Block> KITCHEN_DRAWER_WHITE_MODERN = register("white_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_ORANGE_MODERN = register("orange_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_MAGENTA_MODERN = register("magenta_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIGHT_BLUE_MODERN = register("light_blue_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_YELLOW_MODERN = register("yellow_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIME_MODERN = register("lime_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_PINK_MODERN = register("pink_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_GRAY_MODERN = register("gray_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIGHT_GRAY_MODERN = register("light_gray_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_CYAN_MODERN = register("cyan_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_PURPLE_MODERN = register("purple_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BLUE_MODERN = register("blue_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BROWN_MODERN = register("brown_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_GREEN_MODERN = register("green_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_RED_MODERN = register("red_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BLACK_MODERN = register("black_modern_kitchen_drawer", new KitchenDrawerBlock(Block.Properties.from(Blocks.BLACK_CONCRETE)));

    //Kitchen Sinks
    public static final RegistryObject<Block> KITCHEN_SINK_WHITE_MODERN = register("white_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.WHITE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_ORANGE_MODERN = register("orange_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.ORANGE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_MAGENTA_MODERN = register("magenta_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.MAGENTA_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_BLUE_MODERN = register("light_blue_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_YELLOW_MODERN = register("yellow_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.YELLOW_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIME_MODERN = register("lime_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.LIME_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_PINK_MODERN = register("pink_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.PINK_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_GRAY_MODERN = register("gray_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.GRAY_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_GRAY_MODERN = register("light_gray_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_CYAN_MODERN = register("cyan_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.CYAN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_PURPLE_MODERN = register("purple_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.PURPLE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BLUE_MODERN = register("blue_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.BLUE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BROWN_MODERN = register("brown_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.BROWN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_GREEN_MODERN = register("green_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.GREEN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_RED_MODERN = register("red_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.RED_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BLACK_MODERN = register("black_modern_kitchen_sink", new KitchenSinkBlock(Block.Properties.from(Blocks.BLACK_CONCRETE), false));

    //Appliances
    public static final RegistryObject<Block> MICROWAVE_LIGHT = register("microwave_light", new MicrowaveBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> MICROWAVE_DARK = register("microwave_dark", new MicrowaveBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> OVEN_LIGHT = register("oven_light", new OvenBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> OVEN_DARK = register("oven_dark", new OvenBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> OVEN_RANGE_HOOD_LIGHT = register("oven_range_hood_light", new OvenRangeHoodBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).setLightLevel(getLightValueLit(14)).notSolid()));
    public static final RegistryObject<Block> OVEN_RANGE_HOOD_DARK = register("oven_range_hood_dark", new OvenRangeHoodBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).setLightLevel(getLightValueLit(14)).notSolid()));
    public static final RegistryObject<Block> SINK_LIGHT = register("sink_light", new SinkBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> SINK_DARK = register("sink_dark", new SinkBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> SHOWER_LIGHT = register("shower_light", new ShowerBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> SHOWER_DARK = register("shower_dark", new ShowerBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> SHOWER_HEAD_LIGHT = register("shower_head_light", new ShowerHeadBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> SHOWER_HEAD_DARK = register("shower_head_dark", new ShowerHeadBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));
    public static final RegistryObject<Block> TOILET_LIGHT = register("toilet_light", new ToiletBlock(AbstractBlock.Properties.from(Blocks.WHITE_CONCRETE).notSolid()));
    public static final RegistryObject<Block> TOILET_DARK = register("toilet_dark", new ToiletBlock(AbstractBlock.Properties.from(Blocks.GRAY_CONCRETE).notSolid()));

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

    private static RegistryObject<Block> register(String name, Block block)
    {
        return register(name, block, new Item.Properties().group(NosiphusFurnitureMod.GROUP));
    }

    private static RegistryObject<Block> register(String name, Block block, Item.Properties properties)
    {
        return register(name, block, () -> new BlockItem(block, properties));
    }

    private static RegistryObject<Block> register(String name, Block block, @Nullable Supplier<BlockItem> supplier)
    {
        if(supplier != null)
        {
            ModItems.REGISTER.register(name, supplier);
        }
        return REGISTER.register(name, () -> block);
    }

    private static RegistryObject<Block> register(String name, Block block, @Nullable Function<Block, BlockItem> function)
    {
        if(function != null)
        {
            ModItems.REGISTER.register(name, () -> function.apply(block));
        }
        return REGISTER.register(name, () -> block);
    }

}
