package com.nosiphus.furniture.datagen;

import com.nosiphus.furniture.core.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider
{
    public RecipeGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        // Tables
        table(consumer, ModBlocks.TABLE_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_LIME_MODERN.get(), Blocks.LIME_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_PINK_MODERN.get(), Blocks.PINK_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_RED_MODERN.get(), Blocks.RED_CONCRETE, Blocks.STONE);
        table(consumer, ModBlocks.TABLE_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE, Blocks.STONE);

        // Chairs
        chair(consumer, ModBlocks.CHAIR_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_LIME_MODERN.get(), Blocks.LIME_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_PINK_MODERN.get(), Blocks.PINK_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_RED_MODERN.get(), Blocks.RED_CONCRETE, Blocks.STONE);
        chair(consumer, ModBlocks.CHAIR_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE, Blocks.STONE);

        // Coffee Tables
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_LIME_MODERN.get(), Blocks.LIME_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_PINK_MODERN.get(), Blocks.PINK_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_RED_MODERN.get(), Blocks.RED_CONCRETE, Blocks.STONE);
        coffeeTable(consumer, ModBlocks.COFFEE_TABLE_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE, Blocks.STONE);

        //Office Chairs
        //to be added

        // Cabinets
        cabinet(consumer, ModBlocks.CABINET_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_LIME_MODERN.get(), Blocks.LIME_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_PINK_MODERN.get(), Blocks.PINK_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_RED_MODERN.get(), Blocks.RED_CONCRETE, Blocks.STONE);
        cabinet(consumer, ModBlocks.CABINET_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE, Blocks.STONE);

        // Coffee Table
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get(), Blocks.STONE, Blocks.WHITE_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get(), Blocks.STONE, Blocks.ORANGE_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get(), Blocks.STONE, Blocks.MAGENTA_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get(), Blocks.STONE, Blocks.LIGHT_BLUE_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get(), Blocks.STONE, Blocks.YELLOW_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get(), Blocks.STONE, Blocks.LIME_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get(), Blocks.STONE, Blocks.PINK_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get(), Blocks.STONE, Blocks.GRAY_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get(), Blocks.STONE, Blocks.LIGHT_GRAY_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get(), Blocks.STONE, Blocks.CYAN_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get(), Blocks.STONE, Blocks.PURPLE_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get(), Blocks.STONE, Blocks.BLUE_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get(), Blocks.STONE, Blocks.BROWN_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get(), Blocks.STONE, Blocks.GREEN_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_RED_MODERN.get(), Blocks.STONE, Blocks.RED_CONCRETE);
        bedsideCabinet(consumer, ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get(), Blocks.STONE, Blocks.BLACK_CONCRETE);

        // Desks
        desk(consumer, ModBlocks.DESK_WHITE_MODERN.get(), Blocks.STONE, Blocks.WHITE_CONCRETE);
        desk(consumer, ModBlocks.DESK_ORANGE_MODERN.get(), Blocks.STONE, Blocks.ORANGE_CONCRETE);
        desk(consumer, ModBlocks.DESK_MAGENTA_MODERN.get(), Blocks.STONE, Blocks.MAGENTA_CONCRETE);
        desk(consumer, ModBlocks.DESK_LIGHT_BLUE_MODERN.get(), Blocks.STONE, Blocks.LIGHT_BLUE_CONCRETE);
        desk(consumer, ModBlocks.DESK_YELLOW_MODERN.get(), Blocks.STONE, Blocks.YELLOW_CONCRETE);
        desk(consumer, ModBlocks.DESK_LIME_MODERN.get(), Blocks.STONE, Blocks.LIME_CONCRETE);
        desk(consumer, ModBlocks.DESK_PINK_MODERN.get(), Blocks.STONE, Blocks.PINK_CONCRETE);
        desk(consumer, ModBlocks.DESK_GRAY_MODERN.get(), Blocks.STONE, Blocks.GRAY_CONCRETE);
        desk(consumer, ModBlocks.DESK_LIGHT_GRAY_MODERN.get(), Blocks.STONE, Blocks.LIGHT_GRAY_CONCRETE);
        desk(consumer, ModBlocks.DESK_CYAN_MODERN.get(), Blocks.STONE, Blocks.CYAN_CONCRETE);
        desk(consumer, ModBlocks.DESK_PURPLE_MODERN.get(), Blocks.STONE, Blocks.PURPLE_CONCRETE);
        desk(consumer, ModBlocks.DESK_BLUE_MODERN.get(), Blocks.STONE, Blocks.BLUE_CONCRETE);
        desk(consumer, ModBlocks.DESK_BROWN_MODERN.get(), Blocks.STONE, Blocks.BROWN_CONCRETE);
        desk(consumer, ModBlocks.DESK_GREEN_MODERN.get(), Blocks.STONE, Blocks.GREEN_CONCRETE);
        desk(consumer, ModBlocks.DESK_RED_MODERN.get(), Blocks.STONE, Blocks.RED_CONCRETE);
        desk(consumer, ModBlocks.DESK_BLACK_MODERN.get(), Blocks.STONE, Blocks.BLACK_CONCRETE);

        // Desk Cabinets
        deskCabinet(consumer, ModBlocks.DESK_CABINET_WHITE_MODERN.get(), Blocks.STONE, Blocks.WHITE_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_ORANGE_MODERN.get(), Blocks.STONE, Blocks.ORANGE_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_MAGENTA_MODERN.get(), Blocks.STONE, Blocks.MAGENTA_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get(), Blocks.STONE, Blocks.LIGHT_BLUE_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_YELLOW_MODERN.get(), Blocks.STONE, Blocks.YELLOW_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_LIME_MODERN.get(), Blocks.STONE, Blocks.LIME_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_PINK_MODERN.get(), Blocks.STONE, Blocks.PINK_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_GRAY_MODERN.get(), Blocks.STONE, Blocks.GRAY_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get(), Blocks.STONE, Blocks.LIGHT_GRAY_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_CYAN_MODERN.get(), Blocks.STONE, Blocks.CYAN_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_PURPLE_MODERN.get(), Blocks.STONE, Blocks.PURPLE_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_BLUE_MODERN.get(), Blocks.STONE, Blocks.BLUE_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_BROWN_MODERN.get(), Blocks.STONE, Blocks.BROWN_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_GREEN_MODERN.get(), Blocks.STONE, Blocks.GREEN_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_RED_MODERN.get(), Blocks.STONE, Blocks.RED_CONCRETE);
        deskCabinet(consumer, ModBlocks.DESK_CABINET_BLACK_MODERN.get(), Blocks.STONE, Blocks.BLACK_CONCRETE);

        // Sofa
        sofa(consumer, ModBlocks.SOFA_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_LIME_MODERN.get(), Blocks.LIME_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_PINK_MODERN.get(), Blocks.PINK_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_RED_MODERN.get(), Blocks.RED_CONCRETE);
        sofa(consumer, ModBlocks.SOFA_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE);

        //Modern Kitchen Counters
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_WHITE_MODERN.get(), Tags.Items.DYES_WHITE);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_ORANGE_MODERN.get(), Tags.Items.DYES_ORANGE);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_MAGENTA_MODERN.get(), Tags.Items.DYES_MAGENTA);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_LIGHT_BLUE_MODERN.get(), Tags.Items.DYES_LIGHT_BLUE);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_YELLOW_MODERN.get(), Tags.Items.DYES_YELLOW);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_LIME_MODERN.get(), Tags.Items.DYES_LIME);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_PINK_MODERN.get(), Tags.Items.DYES_PINK);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_GRAY_MODERN.get(), Tags.Items.DYES_GRAY);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_LIGHT_GRAY_MODERN.get(), Tags.Items.DYES_LIGHT_GRAY);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_CYAN_MODERN.get(), Tags.Items.DYES_CYAN);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_PURPLE_MODERN.get(), Tags.Items.DYES_PURPLE);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_BLUE_MODERN.get(), Tags.Items.DYES_BLUE);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_BROWN_MODERN.get(), Tags.Items.DYES_BROWN);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_GREEN_MODERN.get(), Tags.Items.DYES_GREEN);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_RED_MODERN.get(), Tags.Items.DYES_RED);
        modernKitchenCounter(consumer, ModBlocks.KITCHEN_COUNTER_BLACK_MODERN.get(), Tags.Items.DYES_BLACK);

        // Modern Kitchen Drawers
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get(), Tags.Items.DYES_WHITE);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get(), Tags.Items.DYES_ORANGE);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get(), Tags.Items.DYES_MAGENTA);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get(), Tags.Items.DYES_LIGHT_BLUE);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get(), Tags.Items.DYES_YELLOW);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get(), Tags.Items.DYES_LIME);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get(), Tags.Items.DYES_PINK);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get(), Tags.Items.DYES_GRAY);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get(), Tags.Items.DYES_LIGHT_GRAY);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get(), Tags.Items.DYES_CYAN);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get(), Tags.Items.DYES_PURPLE);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get(), Tags.Items.DYES_BLUE);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get(), Tags.Items.DYES_BROWN);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get(), Tags.Items.DYES_GREEN);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_RED_MODERN.get(), Tags.Items.DYES_RED);
        modernKitchenDrawer(consumer, ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get(), Tags.Items.DYES_BLACK);

        // Modern Kitchen Sinks
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_WHITE_MODERN.get(), Blocks.WHITE_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get(), Blocks.ORANGE_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get(), Blocks.MAGENTA_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get(), Blocks.LIGHT_BLUE_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get(), Blocks.YELLOW_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_LIME_MODERN.get(), Blocks.LIME_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_PINK_MODERN.get(), Blocks.PINK_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_GRAY_MODERN.get(), Blocks.GRAY_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get(), Blocks.LIGHT_GRAY_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_CYAN_MODERN.get(), Blocks.CYAN_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get(), Blocks.PURPLE_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_BLUE_MODERN.get(), Blocks.BLUE_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_BROWN_MODERN.get(), Blocks.BROWN_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_GREEN_MODERN.get(), Blocks.GREEN_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_RED_MODERN.get(), Blocks.RED_CONCRETE);
        modernKitchenSink(consumer, ModBlocks.KITCHEN_SINK_BLACK_MODERN.get(), Blocks.BLACK_CONCRETE);

        // Bar Stools
        barStool(consumer, ModBlocks.BAR_STOOL_WHITE.get(), Blocks.WHITE_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_ORANGE.get(), Blocks.ORANGE_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_MAGENTA.get(), Blocks.MAGENTA_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_LIGHT_BLUE.get(), Blocks.LIGHT_BLUE_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_YELLOW.get(), Blocks.YELLOW_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_LIME.get(), Blocks.LIME_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_PINK.get(), Blocks.PINK_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_GRAY.get(), Blocks.GRAY_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_LIGHT_GRAY.get(), Blocks.LIGHT_GRAY_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_CYAN.get(), Blocks.CYAN_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_PURPLE.get(), Blocks.PURPLE_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_BLUE.get(), Blocks.BLUE_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_BROWN.get(), Blocks.BROWN_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_GREEN.get(), Blocks.GREEN_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_RED.get(), Blocks.RED_WOOL);
        barStool(consumer, ModBlocks.BAR_STOOL_BLACK.get(), Blocks.BLACK_WOOL);

        //Microwave
        ShapedRecipeBuilder.shaped(ModBlocks.MICROWAVE_LIGHT.get())
                .pattern("IIC")
                .pattern("GGB")
                .pattern("IIC")
                .define('C', Blocks.WHITE_CONCRETE)
                .define('B', Blocks.STONE_BUTTON)
                .define('G', Blocks.WHITE_STAINED_GLASS_PANE)
                .define('I', Items.IRON_INGOT)
                .group("microwave")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MICROWAVE_DARK.get())
                .pattern("IIC")
                .pattern("GGB")
                .pattern("IIC")
                .define('C', Blocks.GRAY_CONCRETE)
                .define('B', Blocks.STONE_BUTTON)
                .define('G', Blocks.GRAY_STAINED_GLASS_PANE)
                .define('I', Items.IRON_INGOT)
                .group("microwave")
                .save(consumer);

        //Oven
        ShapedRecipeBuilder.shaped(ModBlocks.OVEN_LIGHT.get())
                .pattern("WWW")
                .pattern("WFW")
                .pattern("WWW")
                .define('W', Blocks.WHITE_CONCRETE)
                .define('F', Blocks.FURNACE)
                .group("sink")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.OVEN_DARK.get())
                .pattern("GGG")
                .pattern("GFG")
                .pattern("GGG")
                .define('G', Blocks.GRAY_CONCRETE)
                .define('F', Blocks.FURNACE)
                .group("sink")
                .save(consumer);

        //Oven Range Hood
        ShapedRecipeBuilder.shaped(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get())
                .pattern(" W ")
                .pattern(" W ")
                .pattern("WSW")
                .define('W', Blocks.WHITE_CONCRETE)
                .define('S', Blocks.SEA_LANTERN)
                .group("sink")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.OVEN_RANGE_HOOD_DARK.get())
                .pattern(" G ")
                .pattern(" G ")
                .pattern("GSG")
                .define('G', Blocks.GRAY_CONCRETE)
                .define('S', Blocks.SEA_LANTERN)
                .group("sink")
                .save(consumer);

        //Shower Head
        ShapedRecipeBuilder.shaped(ModBlocks.SHOWER_HEAD_LIGHT.get())
                .pattern("II ")
                .pattern(" I ")
                .pattern("CCC")
                .define('C', Blocks.WHITE_CONCRETE)
                .define('I', Items.IRON_INGOT)
                .group("shower_head")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SHOWER_HEAD_DARK.get())
                .pattern("II ")
                .pattern(" I ")
                .pattern("CCC")
                .define('C', Blocks.GRAY_CONCRETE)
                .define('I', Items.IRON_INGOT)
                .group("shower_head")
                .save(consumer);

        //Sink
        ShapedRecipeBuilder.shaped(ModBlocks.SINK_LIGHT.get())
                .pattern("BIB")
                .pattern("WWW")
                .pattern(" W ")
                .define('B', Blocks.STONE_BUTTON)
                .define('I', Items.IRON_INGOT)
                .define('W', Blocks.WHITE_CONCRETE)
                .group("sink")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SINK_DARK.get())
                .pattern("BIB")
                .pattern("GGG")
                .pattern(" G ")
                .define('B', Blocks.STONE_BUTTON)
                .define('I', Items.IRON_INGOT)
                .define('G', Blocks.GRAY_CONCRETE)
                .group("sink")
                .save(consumer);

        //Toilet
        ShapedRecipeBuilder.shaped(ModBlocks.TOILET_LIGHT.get())
                .pattern("WG ")
                .pattern("WWW")
                .pattern(" W ")
                .define('W', Blocks.WHITE_CONCRETE)
                .define('G', Blocks.GRAY_CONCRETE)
                .group("toilet")
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.TOILET_DARK.get())
                .pattern("GW ")
                .pattern("GGG")
                .pattern(" G ")
                .define('W', Blocks.WHITE_CONCRETE)
                .define('G', Blocks.GRAY_CONCRETE)
                .group("toilet")
                .save(consumer);
    }

    private static void table(Consumer<FinishedRecipe> consumer, ItemLike table, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(table, 4)
                .pattern("LLL")
                .pattern(" P ")
                .pattern(" P ")
                .define('L', log)
                .define('P', planks)
                .group("table")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void chair(Consumer<FinishedRecipe> consumer, ItemLike chair, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(chair, 4)
                .pattern("L  ")
                .pattern("LLL")
                .pattern("P P")
                .define('L', log)
                .define('P', planks)
                .group("chair")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void coffeeTable(Consumer<FinishedRecipe> consumer, ItemLike table, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(table, 4)
                .pattern("LLL")
                .pattern("P P")
                .define('L', log)
                .define('P', planks)
                .group("coffee_table")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void cabinet(Consumer<FinishedRecipe> consumer, ItemLike cabinet, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(cabinet, 2)
                .pattern("PPL")
                .pattern("P L")
                .pattern("PPL")
                .define('L', log)
                .define('P', planks)
                .group("cabinet")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void bedsideCabinet(Consumer<FinishedRecipe> consumer, ItemLike cabinet, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(cabinet, 2)
                .pattern("LLL")
                .pattern("P P")
                .pattern("PPP")
                .define('L', log)
                .define('P', planks)
                .group("bedside_cabinet")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void desk(Consumer<FinishedRecipe> consumer, ItemLike desk, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(desk, 2)
                .pattern("LLL")
                .pattern("P P")
                .pattern("P P")
                .define('L', log)
                .define('P', planks)
                .group("desk")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void deskCabinet(Consumer<FinishedRecipe> consumer, ItemLike desk, ItemLike log, ItemLike planks)
    {
        ShapedRecipeBuilder.shaped(desk, 2)
                .pattern("LLL")
                .pattern("PPP")
                .pattern("P P")
                .define('L', log)
                .define('P', planks)
                .group("desk_cabinet")
                .unlockedBy("has_log", has(log))
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private static void sofa(Consumer<FinishedRecipe> consumer, ItemLike sofa, ItemLike wool)
    {
        ShapedRecipeBuilder.shaped(sofa, 2)
                .pattern("W  ")
                .pattern("WWW")
                .pattern("LLL")
                .define('W', wool)
                .define('L', ItemTags.LOGS)
                .group("sofa")
                .unlockedBy("has_wool", has(wool))
                .save(consumer);
    }

    private static void modernKitchenCounter(Consumer<FinishedRecipe> consumer, ItemLike counter, TagKey<Item> dye)
    {
        ShapedRecipeBuilder.shaped(counter, 8)
                .pattern("CDC")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Blocks.STONE)
                .define('D', dye)
                .define('C', Blocks.WHITE_CONCRETE)
                .group("kitchen_counter")
                .unlockedBy("has_stone", has(Blocks.STONE))
                .unlockedBy("has_concrete", has(Blocks.WHITE_CONCRETE))
                .save(consumer);
    }

    private static void modernKitchenDrawer(Consumer<FinishedRecipe> consumer, ItemLike counter, TagKey<Item> dye)
    {
        ShapedRecipeBuilder.shaped(counter, 4)
                .pattern("CDC")
                .pattern("SBS")
                .pattern("SSS")
                .define('S', Blocks.STONE)
                .define('D', dye)
                .define('C', Blocks.WHITE_CONCRETE)
                .define('B', Tags.Items.CHESTS_WOODEN)
                .group("kitchen_drawer")
                .unlockedBy("has_stone", has(Blocks.STONE))
                .unlockedBy("has_concrete", has(Blocks.WHITE_CONCRETE))
                .unlockedBy("has_chest", has(Tags.Items.CHESTS_WOODEN))
                .save(consumer);
    }

    private static void modernKitchenSink(Consumer<FinishedRecipe> consumer, ItemLike sink, ItemLike top)
    {
        ShapedRecipeBuilder.shaped(sink, 2)
                .pattern("CIC")
                .pattern("PBP")
                .pattern("PPP")
                .define('C', top)
                .define('I', Tags.Items.INGOTS_IRON)
                .define('P', Blocks.STONE)
                .define('B', Items.BUCKET)
                .group("kitchen_sink")
                .unlockedBy("has_top", has(top))
                .unlockedBy("has_andesite", has(Blocks.POLISHED_ANDESITE))
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);
    }

    private static void barStool(Consumer<FinishedRecipe> consumer, ItemLike barStool, ItemLike wool)
    {
        ShapedRecipeBuilder.shaped(barStool, 2)
                .pattern("WWW")
                .pattern("GGG")
                .pattern("C C")
                .define('W', wool)
                .define('G', Blocks.GRAY_CONCRETE)
                .define('C', Blocks.WHITE_CONCRETE)
                .group("bar_stool")
                .unlockedBy("has_wool", has(wool))
                .unlockedBy("has_gray_concrete", has(Blocks.GRAY_CONCRETE))
                .unlockedBy("has_white_concrete", has(Blocks.WHITE_CONCRETE))
                .save(consumer);

    }

}