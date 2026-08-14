package com.mrcrayfish.furniture;

import com.mojang.logging.LogUtils;
import com.mrcrayfish.furniture.client.gui.screens.inventory.CrateScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.FreezerScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.MailBoxScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.PostBoxScreen;
import com.mrcrayfish.furniture.client.model.HedgeModel;
import com.mrcrayfish.furniture.client.renderer.blockentity.DoorMatBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.blockentity.GrillBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.blockentity.KitchenSinkBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.entity.SeatRenderer;
import com.mrcrayfish.furniture.network.PacketHandlers;
import com.mrcrayfish.furniture.network.protocol.common.*;
import com.mrcrayfish.furniture.platform.NeoForgeFluidHelper;
import com.mrcrayfish.furniture.platform.NeoForgeRegistryHelper;
import com.mrcrayfish.furniture.world.entity.ModEntityTypes;
import com.mrcrayfish.furniture.world.inventory.ModMenuTypes;
import com.mrcrayfish.furniture.world.item.ModCreativeModeTabsNeoForge;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mod(MrCrayFishFurnitureMod.MOD_ID)
public class MrCrayFishFurnitureModNeoForge {

    private static final Logger LOGGER = LogUtils.getLogger();

    public MrCrayFishFurnitureModNeoForge(IEventBus eventBus, ModContainer container) {
        MrCrayFishFurnitureMod.init();

        NeoForgeRegistryHelper.BLOCKS.register(eventBus);
        NeoForgeRegistryHelper.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabsNeoForge.CREATIVE_TABS.register(eventBus);
        NeoForgeRegistryHelper.ENTITY_TYPES.register(eventBus);
        NeoForgeRegistryHelper.ITEMS.register(eventBus);
        NeoForgeRegistryHelper.MENU_TYPES.register(eventBus);
        NeoForgeRegistryHelper.RECIPE_SERIALIZERS.register(eventBus);
        NeoForgeRegistryHelper.RECIPE_TYPES.register(eventBus);
        NeoForgeRegistryHelper.SOUND_EVENTS.register(eventBus);

        container.registerConfig(ModConfig.Type.CLIENT, FurnitureConfigNeoForge.CLIENT_SPEC);
        container.registerConfig(ModConfig.Type.COMMON, FurnitureConfigNeoForge.COMMON_SPEC);
        FurnitureConfigNeoForge.init();
    }

    @EventBusSubscriber(modid = MrCrayFishFurnitureMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            registerBlockEntityRenderers();
        }

        @SubscribeEvent
        public static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
            Map<ModelResourceLocation, BakedModel> models = event.getModels();
            List<ModelResourceLocation> hedgeKeys = new ArrayList<>();
            for (ModelResourceLocation location : models.keySet()) {
                if (location.id().getNamespace().equals(MrCrayFishFurnitureMod.MOD_ID) && location.id().getPath().contains("hedge")) {
                    hedgeKeys.add(location);
                }
            }
            for (ModelResourceLocation location : hedgeKeys) {
                BakedModel originalModel = models.get(location);
                if (originalModel != null && !(originalModel instanceof HedgeModel)) {
                    models.put(location, new HedgeModel(originalModel));
                }
            }
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            // 1. Picket Fences, Gates & Post Box
            List<Block> picketBlocks = new ArrayList<>();
            addIfPresent(picketBlocks, ModBlocks.WHITE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_GRAY_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.GRAY_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BLACK_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BROWN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.RED_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.ORANGE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.YELLOW_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIME_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.GREEN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.CYAN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_BLUE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BLUE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.PURPLE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.MAGENTA_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.PINK_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.WHITE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_GRAY_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.GRAY_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BLACK_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BROWN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.RED_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.ORANGE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.YELLOW_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIME_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.GREEN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.CYAN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_BLUE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BLUE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.PURPLE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.MAGENTA_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.PINK_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.POST_BOX);

            if (!picketBlocks.isEmpty()) {
                event.register((state, reader, pos, i) -> i == 1 ? 0xFFCCCCCC : 0xFFFFFFFF, picketBlocks.toArray(new Block[0]));
            }

            // 2. Stripped Crates, Counters, Drawers, and Sinks
            List<Block> strippedBlocks = new ArrayList<>();
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK);

            if (!strippedBlocks.isEmpty()) {
                event.register((state, reader, pos, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF, strippedBlocks.toArray(new Block[0]));
            }

            // 3. Park Benches
            List<Block> benchBlocks = new ArrayList<>();
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_OAK_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_SPRUCE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_BIRCH_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_JUNGLE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_ACACIA_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_MANGROVE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_CHERRY_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_CRIMSON_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_WARPED_PARK_BENCH);

            if (!benchBlocks.isEmpty()) {
                event.register((state, reader, pos, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF, benchBlocks.toArray(new Block[0]));
            }

            // 4. Fridges & Freezers
            List<Block> applianceBlocks = new ArrayList<>();
            addIfPresent(applianceBlocks, ModBlocks.FRIDGE_LIGHT);
            addIfPresent(applianceBlocks, ModBlocks.FREEZER_LIGHT);
            addIfPresent(applianceBlocks, ModBlocks.FRIDGE_DARK);
            addIfPresent(applianceBlocks, ModBlocks.FREEZER_DARK);

            if (!applianceBlocks.isEmpty()) {
                event.register((state, reader, pos, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF, applianceBlocks.toArray(new Block[0]));
            }

            // 5. Hedges
            List<Block> averageFoliageHedges = new ArrayList<>();
            addIfPresent(averageFoliageHedges, ModBlocks.OAK_HEDGE);
            addIfPresent(averageFoliageHedges, ModBlocks.JUNGLE_HEDGE);
            addIfPresent(averageFoliageHedges, ModBlocks.ACACIA_HEDGE);
            addIfPresent(averageFoliageHedges, ModBlocks.DARK_OAK_HEDGE);

            if (ModBlocks.SPRUCE_HEDGE != null && ModBlocks.SPRUCE_HEDGE.get() != null) {
                event.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(), ModBlocks.SPRUCE_HEDGE.get());
            }
            if (ModBlocks.BIRCH_HEDGE != null && ModBlocks.BIRCH_HEDGE.get() != null) {
                event.register((state, reader, pos, i) -> FoliageColor.getBirchColor(), ModBlocks.BIRCH_HEDGE.get());
            }
            if (!averageFoliageHedges.isEmpty()) {
                event.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(), averageFoliageHedges.toArray(new Block[0]));
            }
            if (ModBlocks.MANGROVE_HEDGE != null && ModBlocks.MANGROVE_HEDGE.get() != null) {
                event.register((state, reader, pos, i) -> FoliageColor.getMangroveColor(), ModBlocks.MANGROVE_HEDGE.get());
            }
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntityTypes.SEAT.get(), SeatRenderer::new);
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            // 1. Picket Fences, Gates & Post Box
            List<Block> picketBlocks = new ArrayList<>();
            addIfPresent(picketBlocks, ModBlocks.WHITE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_GRAY_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.GRAY_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BLACK_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BROWN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.RED_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.ORANGE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.YELLOW_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIME_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.GREEN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.CYAN_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_BLUE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.BLUE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.PURPLE_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.MAGENTA_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.PINK_PICKET_FENCE);
            addIfPresent(picketBlocks, ModBlocks.WHITE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_GRAY_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.GRAY_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BLACK_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BROWN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.RED_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.ORANGE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.YELLOW_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIME_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.GREEN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.CYAN_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.LIGHT_BLUE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.BLUE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.PURPLE_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.MAGENTA_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.PINK_PICKET_GATE);
            addIfPresent(picketBlocks, ModBlocks.POST_BOX);

            if (!picketBlocks.isEmpty()) {
                event.register((stack, i) -> i == 1 ? 0xFFCCCCCC : 0xFFFFFFFF, picketBlocks.toArray(new Block[0]));
            }

            // 2. Stripped Crates, Counters, Drawers, and Sinks
            List<Block> strippedBlocks = new ArrayList<>();
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_CRATE);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_COUNTER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK);
            addIfPresent(strippedBlocks, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK);

            if (!strippedBlocks.isEmpty()) {
                event.register((stack, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF, strippedBlocks.toArray(new Block[0]));
            }

            // 3. Park Benches
            List<Block> benchBlocks = new ArrayList<>();
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_OAK_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_SPRUCE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_BIRCH_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_JUNGLE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_ACACIA_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_MANGROVE_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_CHERRY_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_CRIMSON_PARK_BENCH);
            addIfPresent(benchBlocks, ModBlocks.STRIPPED_WARPED_PARK_BENCH);

            if (!benchBlocks.isEmpty()) {
                event.register((stack, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF, benchBlocks.toArray(new Block[0]));
            }

            // 4. Fridges & Freezers
            List<Block> applianceBlocks = new ArrayList<>();
            addIfPresent(applianceBlocks, ModBlocks.FRIDGE_LIGHT);
            addIfPresent(applianceBlocks, ModBlocks.FREEZER_LIGHT);
            addIfPresent(applianceBlocks, ModBlocks.FRIDGE_DARK);
            addIfPresent(applianceBlocks, ModBlocks.FREEZER_DARK);

            if (!applianceBlocks.isEmpty()) {
                event.register((stack, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF, applianceBlocks.toArray(new Block[0]));
            }

            // 5. Hedge Items
            List<Block> allHedges = new ArrayList<>();
            addIfPresent(allHedges, ModBlocks.OAK_HEDGE);
            addIfPresent(allHedges, ModBlocks.SPRUCE_HEDGE);
            addIfPresent(allHedges, ModBlocks.BIRCH_HEDGE);
            addIfPresent(allHedges, ModBlocks.JUNGLE_HEDGE);
            addIfPresent(allHedges, ModBlocks.ACACIA_HEDGE);
            addIfPresent(allHedges, ModBlocks.DARK_OAK_HEDGE);
            addIfPresent(allHedges, ModBlocks.MANGROVE_HEDGE);

            if (!allHedges.isEmpty()) {
                event.register((stack, i) -> {
                    BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
                    return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
                }, allHedges.toArray(new Block[0]));
            }
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.CRATE.get(), CrateScreen::new);
            event.register(ModMenuTypes.FREEZER.get(), FreezerScreen::new);
            event.register(ModMenuTypes.MAIL_BOX.get(), MailBoxScreen::new);
            event.register(ModMenuTypes.POST_BOX.get(), PostBoxScreen::new);
        }

    }

    @EventBusSubscriber(modid = MrCrayFishFurnitureMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerCapabilities(RegisterCapabilitiesEvent event) {
            event.registerBlockEntity(
                    Capabilities.FluidHandler.BLOCK,
                    ModBlockEntityTypes.KITCHEN_SINK.get(),
                    (be, side) -> be instanceof FluidHandlerSyncedBlockEntity fluidBe ? NeoForgeFluidHelper.of(fluidBe) : null
            );
        }

        @SubscribeEvent
        public static void registerPackets(final RegisterPayloadHandlersEvent event) {
            final PayloadRegistrar registrar = event.registrar(MrCrayFishFurnitureMod.MOD_ID).versioned("1");

            registrar.playToClient(
                    ClientboundFlipGrill.TYPE,
                    ClientboundFlipGrill.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleFlipGrill(payload))
            );

            registrar.playToServer(
                    ServerboundLockCrate.TYPE,
                    ServerboundLockCrate.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleLockCrate(payload, (ServerPlayer) context.player()))
            );

            registrar.playToServer(
                    ServerboundOpenMailBox.TYPE,
                    ServerboundOpenMailBox.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleOpenMailBox(payload, (ServerPlayer) context.player()))
            );

            registrar.playToServer(
                    ServerboundSendMail.TYPE,
                    ServerboundSendMail.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleSendMail(payload, (ServerPlayer) context.player()))
            );

            registrar.playToServer(
                    ServerboundSetDoorMat.TYPE,
                    ServerboundSetDoorMat.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleSetDoorMat(payload, (ServerPlayer) context.player()))
            );

            registrar.playToServer(
                    ServerboundSetMailBoxName.TYPE,
                    ServerboundSetMailBoxName.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleSetMailBoxName(payload, (ServerPlayer) context.player()))
            );
        }

    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(ModBlockEntityTypes.DOOR_MAT.get(), DoorMatBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.GRILL.get(), GrillBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.KITCHEN_SINK.get(), KitchenSinkBlockEntityRenderer::new);
    }

    private static void addIfPresent(List<Block> list, Supplier<? extends Block> supplier) {
        if (supplier != null) {
            try {
                Block block = supplier.get();
                if (block != null) {
                    list.add(block);
                }
            } catch (Exception ignored) {
            }
        }
    }
}