package com.nosiphus.furniture.core;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.block.ModernTableBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "nfm");

    //Tables
    public static final RegistryObject<Block> TABLE_WHITE_MODERN = register("white_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_ORANGE_MODERN = register("orange_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_MAGENTA_MODERN = register("magenta_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_BLUE_MODERN = register("light_blue_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_YELLOW_MODERN = register("yellow_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIME_MODERN = register("lime_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PINK_MODERN = register("pink_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GRAY_MODERN = register("gray_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_GRAY_MODERN = register("light_gray_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_CYAN_MODERN = register("cyan_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PURPLE_MODERN = register("purple_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLUE_MODERN = register("blue_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BROWN_MODERN = register("brown_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GREEN_MODERN = register("green_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_RED_MODERN = register("red_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLACK_MODERN = register("black_modern_table", () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Chairs
    public static final RegistryObject<Block> CHAIR_WHITE_MODERN = register("white_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_ORANGE_MODERN = register("orange_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_MAGENTA_MODERN = register("magenta_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_BLUE_MODERN = register("light_blue_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_YELLOW_MODERN = register("yellow_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIME_MODERN = register("lime_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PINK_MODERN = register("pink_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GRAY_MODERN = register("gray_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_GRAY_MODERN = register("light_gray_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_CYAN_MODERN = register("cyan_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PURPLE_MODERN = register("purple_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLUE_MODERN = register("blue_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BROWN_MODERN = register("brown_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GREEN_MODERN = register("green_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_RED_MODERN = register("red_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLACK_MODERN = register("black_modern_chair", () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Office Chairs
    public static final RegistryObject<Block> OFFICE_CHAIR_WHITE = register("white_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_ORANGE = register("orange_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_MAGENTA = register("magenta_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_LIGHT_BLUE = register("light_blue_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_YELLOW = register("yellow_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_LIME = register("lime_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_PINK = register("pink_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_GRAY = register("gray_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_LIGHT_GRAY = register("light_gray_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_CYAN = register("cyan_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_PURPLE = register("purple_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_BLUE = register("blue_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_BROWN = register("brown_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_GREEN = register("green_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_RED = register("red_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> OFFICE_CHAIR_BLACK = register("black_office_chair", () -> new OfficeChairBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Coffee Tables
    public static final RegistryObject<Block> COFFEE_TABLE_WHITE_MODERN = register("white_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_ORANGE_MODERN = register("orange_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_MAGENTA_MODERN = register("magenta_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_BLUE_MODERN = register("light_blue_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_YELLOW_MODERN = register("yellow_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIME_MODERN = register("lime_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PINK_MODERN = register("pink_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GRAY_MODERN = register("gray_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_GRAY_MODERN = register("light_gray_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_CYAN_MODERN = register("cyan_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PURPLE_MODERN = register("purple_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLUE_MODERN = register("blue_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BROWN_MODERN = register("brown_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GREEN_MODERN = register("green_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_RED_MODERN = register("red_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLACK_MODERN = register("black_modern_coffee_table", () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Cabinets
    public static final RegistryObject<Block> CABINET_WHITE_MODERN = register("white_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_ORANGE_MODERN = register("orange_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_MAGENTA_MODERN = register("magenta_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_BLUE_MODERN = register("light_blue_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_YELLOW_MODERN = register("yellow_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIME_MODERN = register("lime_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PINK_MODERN = register("pink_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GRAY_MODERN = register("gray_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_GRAY_MODERN = register("light_gray_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_CYAN_MODERN = register("cyan_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PURPLE_MODERN = register("purple_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLUE_MODERN = register("blue_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BROWN_MODERN = register("brown_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GREEN_MODERN = register("green_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_RED_MODERN = register("red_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLACK_MODERN = register("black_modern_cabinet", () -> new ModernCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));






    private static RegistryObject<Block> register(String name, Supplier<Block> block)
    {
        return register(name, block, new Item.Properties().tab(NosiphusFurnitureMod.GROUP));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Item.Properties properties)
    {
        RegistryObject<Block> registryObject = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(), properties));
        return registryObject;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, @Nullable Function<RegistryObject<Block>, BlockItem> function)
    {
        RegistryObject<Block> registryObject = BLOCKS.register(name, block);
        if(function != null)
        {
            ModItems.ITEMS.register(name, () -> function.apply(registryObject));
        }
        return registryObject;
    }

    private static RegistryObject<Block> registerNoItem(String name, Supplier<Block> block)
    {
        return BLOCKS.register(name, block);
    }


}
