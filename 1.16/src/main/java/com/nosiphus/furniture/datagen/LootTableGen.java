package com.nosiphus.furniture.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.nosiphus.furniture.Reference;
import com.nosiphus.furniture.block.ModernCoffeeTableBlock;
import com.nosiphus.furniture.core.ModBlocks;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.data.loot.GiftLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.PiglinBarteringAddition;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Ocelot, Nosiphus
 */
public class LootTableGen extends ForgeLootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = ImmutableList.of(Pair.of(FishingProvider::new, LootParameterSets.FISHING), Pair.of(ChestProvider::new, LootParameterSets.CHEST), Pair.of(EntityProvider::new, LootParameterSets.ENTITY), Pair.of(BlockProvider::new, LootParameterSets.BLOCK), Pair.of(PiglinBarteringProvider::new, LootParameterSets.field_237453_h_), Pair.of(GiftProvider::new, LootParameterSets.GIFT));

    public LootTableGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return tables;
    }

    private static class FishingProvider extends FishingLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class ChestProvider extends ChestLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class EntityProvider extends EntityLootTables
    {
        @Override
        protected void addTables()
        {
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities()
        {
            return ForgeRegistries.ENTITIES.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && Reference.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

    private static class BlockProvider extends BlockLootTables
    {
        @Override
        protected void addTables()
        {
            // Tables
            this.registerDropSelfLootTable(ModBlocks.TABLE_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.TABLE_BLACK_MODERN.get());

            // Chairs
            this.registerDropSelfLootTable(ModBlocks.CHAIR_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CHAIR_BLACK_MODERN.get());

            // Coffee Tables
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.COFFEE_TABLE_BLACK_MODERN.get());

            // Cabinets
            this.registerDropSelfLootTable(ModBlocks.CABINET_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.CABINET_BLACK_MODERN.get());

            // Bedside Cabinets
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get());

            // Desks
            this.registerDropSelfLootTable(ModBlocks.DESK_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_BLACK_MODERN.get());

            // Desk Cabinets
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.DESK_CABINET_BLACK_MODERN.get());

            // Sofa
            this.registerDropSelfLootTable(ModBlocks.SOFA_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.SOFA_BLACK_MODERN.get());

            // Kitchen Counters
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_COUNTER_BLACK_MODERN.get());

            // Kitchen Drawers
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get());

            // Kitchen Sinks
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_WHITE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_LIME_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_PINK_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_CYAN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_BLUE_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_BROWN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_GREEN_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_RED_MODERN.get());
            this.registerDropSelfLootTable(ModBlocks.KITCHEN_SINK_BLACK_MODERN.get());

            // Appliances
            this.registerDropSelfLootTable(ModBlocks.MICROWAVE_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.MICROWAVE_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.OVEN_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.OVEN_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.OVEN_RANGE_HOOD_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.SINK_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.SINK_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.SHOWER_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.SHOWER_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.SHOWER_HEAD_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.SHOWER_HEAD_DARK.get());
            this.registerDropSelfLootTable(ModBlocks.TOILET_LIGHT.get());
            this.registerDropSelfLootTable(ModBlocks.TOILET_DARK.get());
        }

        public void registerCoffeeTable(Block block)
        {
            this.registerLootTable(block, coffeeTable -> LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(withSurvivesExplosion(block, ItemLootEntry.builder(coffeeTable).acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(coffeeTable).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withBoolProp(ModernCoffeeTableBlock.TALL, true))))))));
        }

        public void registerTrampoline(Block block)
        {
            this.registerLootTable(block, trampoline -> LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(trampoline).acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY)).acceptFunction(CopyNbt.builder(CopyNbt.Source.BLOCK_ENTITY).replaceOperation("BlockEntityTag.Count", "")))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && Reference.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

    private static class PiglinBarteringProvider extends PiglinBarteringAddition
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class GiftProvider extends GiftLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }
}