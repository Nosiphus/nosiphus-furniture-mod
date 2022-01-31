package com.nosiphus.furniture.datagen;

import com.nosiphus.furniture.core.ModBlocks;
import com.mrcrayfish.furniture.data.ForgeShapedRecipeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

/**
 * @author Ocelot
 */
public class RecipeGen extends RecipeProvider
{
    public RecipeGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
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

        //Microwave
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MICROWAVE_LIGHT.get())
                .patternLine("IIC")
                .patternLine("GGB")
                .patternLine("IIC")
                .key('C', Blocks.WHITE_CONCRETE)
                .key('B', Blocks.STONE_BUTTON)
                .key('G', Blocks.WHITE_STAINED_GLASS_PANE)
                .key('I', Items.IRON_INGOT)
                .setGroup("microwave")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MICROWAVE_DARK.get())
                .patternLine("IIC")
                .patternLine("GGB")
                .patternLine("IIC")
                .key('C', Blocks.GRAY_CONCRETE)
                .key('B', Blocks.STONE_BUTTON)
                .key('G', Blocks.GRAY_STAINED_GLASS_PANE)
                .key('I', Items.IRON_INGOT)
                .setGroup("microwave")
                .build(consumer);

        //Oven
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.OVEN_LIGHT.get())
                .patternLine("WWW")
                .patternLine("WFW")
                .patternLine("WWW")
                .key('W', Blocks.WHITE_CONCRETE)
                .key('F', Blocks.FURNACE)
                .setGroup("sink")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.OVEN_DARK.get())
                .patternLine("GGG")
                .patternLine("GFG")
                .patternLine("GGG")
                .key('G', Blocks.GRAY_CONCRETE)
                .key('F', Blocks.FURNACE)
                .setGroup("sink")
                .build(consumer);

        //Oven Range Hood
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get())
                .patternLine(" W ")
                .patternLine(" W ")
                .patternLine("WSW")
                .key('W', Blocks.WHITE_CONCRETE)
                .key('S', Blocks.SEA_LANTERN)
                .setGroup("sink")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.OVEN_RANGE_HOOD_DARK.get())
                .patternLine(" G ")
                .patternLine(" G ")
                .patternLine("GSG")
                .key('G', Blocks.GRAY_CONCRETE)
                .key('S', Blocks.SEA_LANTERN)
                .setGroup("sink")
                .build(consumer);

        //Shower Head
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SHOWER_HEAD_LIGHT.get())
                .patternLine("II ")
                .patternLine(" I ")
                .patternLine("CCC")
                .key('C', Blocks.WHITE_CONCRETE)
                .key('I', Items.IRON_INGOT)
                .setGroup("shower_head")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SHOWER_HEAD_DARK.get())
                .patternLine("II ")
                .patternLine(" I ")
                .patternLine("CCC")
                .key('C', Blocks.GRAY_CONCRETE)
                .key('I', Items.IRON_INGOT)
                .setGroup("shower_head")
                .build(consumer);

        //Sink
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SINK_LIGHT.get())
                .patternLine("BIB")
                .patternLine("WWW")
                .patternLine(" W ")
                .key('B', Blocks.STONE_BUTTON)
                .key('I', Items.IRON_INGOT)
                .key('W', Blocks.WHITE_CONCRETE)
                .setGroup("sink")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SINK_DARK.get())
                .patternLine("BIB")
                .patternLine("GGG")
                .patternLine(" G ")
                .key('B', Blocks.STONE_BUTTON)
                .key('I', Items.IRON_INGOT)
                .key('G', Blocks.GRAY_CONCRETE)
                .setGroup("sink")
                .build(consumer);

        //Toilet
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.TOILET_LIGHT.get())
                .patternLine("WG ")
                .patternLine("WWW")
                .patternLine(" W ")
                .key('W', Blocks.WHITE_CONCRETE)
                .key('G', Blocks.GRAY_CONCRETE)
                .setGroup("toilet")
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.TOILET_DARK.get())
                .patternLine("GW ")
                .patternLine("GGG")
                .patternLine(" G ")
                .key('W', Blocks.WHITE_CONCRETE)
                .key('G', Blocks.GRAY_CONCRETE)
                .setGroup("toilet")
                .build(consumer);
    }

    private static void table(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(table, 4)
                .patternLine("LLL")
                .patternLine(" P ")
                .patternLine(" P ")
                .key('L', log)
                .key('P', planks)
                .setGroup("table")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void chair(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider chair, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(chair, 4)
                .patternLine("L  ")
                .patternLine("LLL")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("chair")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void coffeeTable(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(table, 4)
                .patternLine("LLL")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("coffee_table")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void cabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(cabinet, 2)
                .patternLine("PPL")
                .patternLine("P L")
                .patternLine("PPL")
                .key('L', log)
                .key('P', planks)
                .setGroup("cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void bedsideCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(cabinet, 2)
                .patternLine("LLL")
                .patternLine("P P")
                .patternLine("PPP")
                .key('L', log)
                .key('P', planks)
                .setGroup("bedside_cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void desk(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(desk, 2)
                .patternLine("LLL")
                .patternLine("P P")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("desk")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void deskCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(desk, 2)
                .patternLine("LLL")
                .patternLine("PPP")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("desk_cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void sofa(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sofa, IItemProvider wool)
    {
        ShapedRecipeBuilder.shapedRecipe(sofa, 2)
                .patternLine("W  ")
                .patternLine("WWW")
                .patternLine("LLL")
                .key('W', wool)
                .key('L', ItemTags.LOGS)
                .setGroup("sofa")
                .addCriterion("has_wool", hasItem(wool))
                .build(recipeConsumer);
    }

    private static void modernKitchenCounter(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, ITag<Item> dye)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 8)
                .patternLine("CDC")
                .patternLine("SSS")
                .patternLine("SSS")
                .key('S', Blocks.STONE)
                .key('D', dye)
                .key('C', Blocks.WHITE_CONCRETE)
                .setGroup("kitchen_counter")
                .addCriterion("has_stone", hasItem(Blocks.STONE))
                .addCriterion("has_concrete", hasItem(Blocks.WHITE_CONCRETE))
                .build(recipeConsumer);
    }

    private static void modernKitchenDrawer(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, ITag<Item> dye)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 4)
                .patternLine("CDC")
                .patternLine("SBS")
                .patternLine("SSS")
                .key('S', Blocks.STONE)
                .key('D', dye)
                .key('C', Blocks.WHITE_CONCRETE)
                .key('B', Tags.Items.CHESTS_WOODEN)
                .setGroup("kitchen_drawer")
                .addCriterion("has_stone", hasItem(Blocks.STONE))
                .addCriterion("has_concrete", hasItem(Blocks.WHITE_CONCRETE))
                .addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))
                .build(recipeConsumer);
    }

    private static void modernKitchenSink(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sink, IItemProvider top)
    {
        ShapedRecipeBuilder.shapedRecipe(sink, 2)
                .patternLine("CIC")
                .patternLine("PBP")
                .patternLine("PPP")
                .key('C', top)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', Blocks.STONE)
                .key('B', Items.BUCKET)
                .setGroup("kitchen_sink")
                .addCriterion("has_top", hasItem(top))
                .addCriterion("has_andesite", hasItem(Blocks.POLISHED_ANDESITE))
                .addCriterion("has_bucket", hasItem(Items.BUCKET))
                .build(recipeConsumer);
    }

}