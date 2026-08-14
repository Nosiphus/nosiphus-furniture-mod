package com.mrcrayfish.furniture;

import com.mrcrayfish.furniture.client.event.CreativeScreenEventsFabric;
import com.mrcrayfish.furniture.client.gui.screens.inventory.CrateScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.FreezerScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.MailBoxScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.PostBoxScreen;
import com.mrcrayfish.furniture.client.renderer.blockentity.DoorMatBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.blockentity.GrillBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.blockentity.KitchenSinkBlockEntityRenderer;
import com.mrcrayfish.furniture.client.renderer.entity.SeatRenderer;
import com.mrcrayfish.furniture.network.NetworkFabric;
import com.mrcrayfish.furniture.world.entity.ModEntityTypes;
import com.mrcrayfish.furniture.world.inventory.ModMenuTypes;
import com.mrcrayfish.furniture.world.item.ModCreativeModeTabsFabric;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class MrCrayFishFurnitureModFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MrCrayFishFurnitureModClient.initClient();
        CreativeScreenEventsFabric.register();
        ModCreativeModeTabsFabric.register();
        NetworkFabric.registerClient();

        registerBlockEntityRenderers();
        registerEntityRenderers();
        registerScreens();
        registerColorHandlers();

        List<Block> cutoutMippedBlocks = new ArrayList<>();

        // Hedges
        addIfPresent(cutoutMippedBlocks, ModBlocks.OAK_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.SPRUCE_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BIRCH_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.JUNGLE_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.ACACIA_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.DARK_OAK_HEDGE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.MANGROVE_HEDGE);

        // Grills
        addIfPresent(cutoutMippedBlocks, ModBlocks.WHITE_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIGHT_GRAY_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.GRAY_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BLACK_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BROWN_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.RED_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.ORANGE_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BEIGE_GRILL); // Optional YogMod variant
        addIfPresent(cutoutMippedBlocks, ModBlocks.YELLOW_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIME_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.GREEN_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.CYAN_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIGHT_BLUE_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BLUE_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.PURPLE_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.MAGENTA_GRILL);
        addIfPresent(cutoutMippedBlocks, ModBlocks.PINK_GRILL);

        // Trampolines
        addIfPresent(cutoutMippedBlocks, ModBlocks.WHITE_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIGHT_GRAY_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.GRAY_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BLACK_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BROWN_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.RED_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.ORANGE_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BEIGE_TRAMPOLINE); // Optional YogMod variant
        addIfPresent(cutoutMippedBlocks, ModBlocks.YELLOW_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIME_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.GREEN_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.CYAN_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.LIGHT_BLUE_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.BLUE_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.PURPLE_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.MAGENTA_TRAMPOLINE);
        addIfPresent(cutoutMippedBlocks, ModBlocks.PINK_TRAMPOLINE);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(), cutoutMippedBlocks.toArray(new Block[0]));
    }

    private void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(ModBlockEntityTypes.DOOR_MAT.get(), DoorMatBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.GRILL.get(), GrillBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.KITCHEN_SINK.get(), KitchenSinkBlockEntityRenderer::new);
    }

    private void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
    }

    private void registerScreens() {
        MenuScreens.register(ModMenuTypes.CRATE.get(), CrateScreen::new);
        MenuScreens.register(ModMenuTypes.FREEZER.get(), FreezerScreen::new);
        MenuScreens.register(ModMenuTypes.MAIL_BOX.get(), MailBoxScreen::new);
        MenuScreens.register(ModMenuTypes.POST_BOX.get(), PostBoxScreen::new);
    }

    private void registerColorHandlers() {
        // Picket Fences, Gates & Post Boxes
        List<Block> picketBlocks = new ArrayList<>();
        addIfPresent(picketBlocks, ModBlocks.WHITE_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.LIGHT_GRAY_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.GRAY_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.BLACK_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.BROWN_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.RED_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.ORANGE_PICKET_FENCE);
        addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_FENCE); // Optional
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
        addIfPresent(picketBlocks, ModBlocks.BEIGE_PICKET_GATE); // Optional
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
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> i == 1 ? 0xFFCCCCCC : 0xFFFFFFFF, picketBlocks.toArray(new Block[0]));
            ColorProviderRegistry.ITEM.register((stack, i) -> i == 1 ? 0xFFCCCCCC : 0xFFFFFFFF, picketBlocks.toArray(new Block[0]));
        }

        // Stripped Crates, Counters, Drawers, and Sinks
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
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF, strippedBlocks.toArray(new Block[0]));
            ColorProviderRegistry.ITEM.register((stack, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF, strippedBlocks.toArray(new Block[0]));
        }

        // Stripped Park Benches
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
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF, benchBlocks.toArray(new Block[0]));
            ColorProviderRegistry.ITEM.register((stack, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF, benchBlocks.toArray(new Block[0]));
        }

        // Fridges & Freezers
        List<Block> applianceBlocks = new ArrayList<>();
        addIfPresent(applianceBlocks, ModBlocks.FRIDGE_LIGHT);
        addIfPresent(applianceBlocks, ModBlocks.FREEZER_LIGHT);
        addIfPresent(applianceBlocks, ModBlocks.FRIDGE_DARK);
        addIfPresent(applianceBlocks, ModBlocks.FREEZER_DARK);

        if (!applianceBlocks.isEmpty()) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF, applianceBlocks.toArray(new Block[0]));
            ColorProviderRegistry.ITEM.register((stack, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF, applianceBlocks.toArray(new Block[0]));
        }

        // Hedges
        List<Block> averageFoliageHedges = new ArrayList<>();
        addIfPresent(averageFoliageHedges, ModBlocks.OAK_HEDGE);
        addIfPresent(averageFoliageHedges, ModBlocks.JUNGLE_HEDGE);
        addIfPresent(averageFoliageHedges, ModBlocks.ACACIA_HEDGE);
        addIfPresent(averageFoliageHedges, ModBlocks.DARK_OAK_HEDGE);

        if (ModBlocks.SPRUCE_HEDGE != null && ModBlocks.SPRUCE_HEDGE.get() != null) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(), ModBlocks.SPRUCE_HEDGE.get());
        }
        if (ModBlocks.BIRCH_HEDGE != null && ModBlocks.BIRCH_HEDGE.get() != null) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> FoliageColor.getBirchColor(), ModBlocks.BIRCH_HEDGE.get());
        }
        if (!averageFoliageHedges.isEmpty()) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(), averageFoliageHedges.toArray(new Block[0]));
        }
        if (ModBlocks.MANGROVE_HEDGE != null && ModBlocks.MANGROVE_HEDGE.get() != null) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> FoliageColor.getMangroveColor(), ModBlocks.MANGROVE_HEDGE.get());
        }

        // Hedge Item Colors
        List<Block> allHedges = new ArrayList<>();
        addIfPresent(allHedges, ModBlocks.OAK_HEDGE);
        addIfPresent(allHedges, ModBlocks.SPRUCE_HEDGE);
        addIfPresent(allHedges, ModBlocks.BIRCH_HEDGE);
        addIfPresent(allHedges, ModBlocks.JUNGLE_HEDGE);
        addIfPresent(allHedges, ModBlocks.ACACIA_HEDGE);
        addIfPresent(allHedges, ModBlocks.DARK_OAK_HEDGE);
        addIfPresent(allHedges, ModBlocks.MANGROVE_HEDGE);

        if (!allHedges.isEmpty()) {
            ColorProviderRegistry.ITEM.register((stack, i) -> {
                BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
                return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
            }, allHedges.toArray(new Block[0]));
        }
    }

    private static void addIfPresent(List<Block> list, java.util.function.Supplier<? extends Block> supplier) {
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