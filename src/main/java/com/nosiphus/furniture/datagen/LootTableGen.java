package com.nosiphus.furniture.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrcrayfish.furniture.Reference;
import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.block.ModernCoffeeTableBlock;
import com.nosiphus.furniture.core.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGen extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = ImmutableList.of(Pair.of(BlockProvider::new, LootContextParamSets.BLOCK));

    public LootTableGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    public List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables()
    {
        return this.tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {}

    private static class BlockProvider extends BlockLoot
    {
        @Override
        protected void addTables()
        {

            // Tables
            this.dropSelf(ModBlocks.TABLE_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_LIME_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_PINK_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_RED_MODERN.get());
            this.dropSelf(ModBlocks.TABLE_BLACK_MODERN.get());

            // Chairs
            this.dropSelf(ModBlocks.CHAIR_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_LIME_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_PINK_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_RED_MODERN.get());
            this.dropSelf(ModBlocks.CHAIR_BLACK_MODERN.get());

            // Coffee Tables
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_WHITE_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_ORANGE_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_MAGENTA_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_LIGHT_BLUE_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_YELLOW_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_LIME_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_PINK_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_GRAY_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_LIGHT_GRAY_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_CYAN_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_PURPLE_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_BLUE_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_BROWN_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_GREEN_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_RED_MODERN.get());
            this.registerCoffeeTable(ModBlocks.COFFEE_TABLE_BLACK_MODERN.get());

            // Cabinets
            this.dropSelf(ModBlocks.CABINET_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_LIME_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_PINK_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_RED_MODERN.get());
            this.dropSelf(ModBlocks.CABINET_BLACK_MODERN.get());

            // Bedside Cabinets
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_RED_MODERN.get());
            this.dropSelf(ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get());

            // Desks
            this.dropSelf(ModBlocks.DESK_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.DESK_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.DESK_LIME_MODERN.get());
            this.dropSelf(ModBlocks.DESK_PINK_MODERN.get());
            this.dropSelf(ModBlocks.DESK_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.DESK_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_RED_MODERN.get());
            this.dropSelf(ModBlocks.DESK_BLACK_MODERN.get());

            // Desk Cabinets
            this.dropSelf(ModBlocks.DESK_CABINET_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_LIME_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_PINK_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_RED_MODERN.get());
            this.dropSelf(ModBlocks.DESK_CABINET_BLACK_MODERN.get());

            // Sofa
            this.dropSelf(ModBlocks.SOFA_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_LIME_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_PINK_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_RED_MODERN.get());
            this.dropSelf(ModBlocks.SOFA_BLACK_MODERN.get());

            // Kitchen Counters
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_LIME_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_PINK_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_RED_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_COUNTER_BLACK_MODERN.get());

            // Kitchen Drawers
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_RED_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get());

            // Kitchen Sinks
            this.dropSelf(ModBlocks.KITCHEN_SINK_WHITE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_LIME_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_PINK_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_CYAN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_BLUE_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_BROWN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_GREEN_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_RED_MODERN.get());
            this.dropSelf(ModBlocks.KITCHEN_SINK_BLACK_MODERN.get());

            // Bar Stools
            this.dropSelf(ModBlocks.BAR_STOOL_WHITE.get());
            this.dropSelf(ModBlocks.BAR_STOOL_ORANGE.get());
            this.dropSelf(ModBlocks.BAR_STOOL_MAGENTA.get());
            this.dropSelf(ModBlocks.BAR_STOOL_LIGHT_BLUE.get());
            this.dropSelf(ModBlocks.BAR_STOOL_YELLOW.get());
            this.dropSelf(ModBlocks.BAR_STOOL_LIME.get());
            this.dropSelf(ModBlocks.BAR_STOOL_PINK.get());
            this.dropSelf(ModBlocks.BAR_STOOL_GRAY.get());
            this.dropSelf(ModBlocks.BAR_STOOL_LIGHT_GRAY.get());
            this.dropSelf(ModBlocks.BAR_STOOL_CYAN.get());
            this.dropSelf(ModBlocks.BAR_STOOL_PURPLE.get());
            this.dropSelf(ModBlocks.BAR_STOOL_BLUE.get());
            this.dropSelf(ModBlocks.BAR_STOOL_BROWN.get());
            this.dropSelf(ModBlocks.BAR_STOOL_GREEN.get());
            this.dropSelf(ModBlocks.BAR_STOOL_RED.get());
            this.dropSelf(ModBlocks.BAR_STOOL_BLACK.get());

            // Appliances
            this.dropSelf(ModBlocks.MICROWAVE_LIGHT.get());
            this.dropSelf(ModBlocks.MICROWAVE_DARK.get());
            this.dropSelf(ModBlocks.OVEN_LIGHT.get());
            this.dropSelf(ModBlocks.OVEN_DARK.get());
            this.dropSelf(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get());
            this.dropSelf(ModBlocks.OVEN_RANGE_HOOD_DARK.get());
            this.dropSelf(ModBlocks.SINK_LIGHT.get());
            this.dropSelf(ModBlocks.SINK_DARK.get());
            this.dropSelf(ModBlocks.SHOWER_LIGHT.get());
            this.dropSelf(ModBlocks.SHOWER_DARK.get());
            this.dropSelf(ModBlocks.SHOWER_HEAD_LIGHT.get());
            this.dropSelf(ModBlocks.SHOWER_HEAD_DARK.get());
            this.dropSelf(ModBlocks.TOILET_LIGHT.get());
            this.dropSelf(ModBlocks.TOILET_DARK.get());
            
        }

        public void registerCoffeeTable(Block block)
        {
            this.add(block, coffeeTable -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(applyExplosionCondition(block, LootItem.lootTableItem(coffeeTable).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(coffeeTable).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModernCoffeeTableBlock.TALL, true))))))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> NosiphusFurnitureMod.MOD_ID.equals(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getNamespace())).collect(Collectors.toSet());
        }
    }
}