package com.nosiphus.furniture;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nosiphus.furniture.client.ModFluidRenderers;
import com.nosiphus.furniture.client.event.CreativeScreenEventsFabric;
import com.nosiphus.furniture.client.gui.screens.inventory.*;
import com.nosiphus.furniture.client.particle.ModParticleTypes;
import com.nosiphus.furniture.client.particle.ShowerParticle;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.client.renderer.entity.SeatRenderer;
import com.nosiphus.furniture.network.NetworkFabric;
import com.nosiphus.furniture.world.entity.ModEntityTypes;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModCreativeModeTabsFabric;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.ArrayList;
import java.util.List;

public class NosiphusFurnitureModFabricClient implements ClientModInitializer {

    private static final ResourceLocation SOAP_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/soapy_water.png");
    private static final ResourceLocation SUPER_SOAP_SCREEN = ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, "textures/misc/super_soapy_water.png");

    @Override
    public void onInitializeClient() {
        NosiphusFurnitureModClient.initClient();
        CreativeScreenEventsFabric.register();
        ModCreativeModeTabsFabric.register();
        NetworkFabric.registerClient();
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.SHOWER.get(), ShowerParticle.Provider::new);
        ModFluidRenderers.register();

        registerBlockEntityRenderers();
        registerEntityRenderers();
        registerScreens();
        registerColorHandlers();
        registerRenderLayers();

        HudRenderCallback.EVENT.register((guiGraphics, deltaTracker) -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player == null || client.gameRenderer.getMainCamera() == null) return;

            BlockPos pos = client.gameRenderer.getMainCamera().getBlockPosition();
            FluidState state = client.player.level().getFluidState(pos);

            ResourceLocation overlay = null;
            if (state.is(ModFluids.SOAPY_WATER.get()) || state.is(ModFluids.SOAPY_WATER_FLOWING.get())) {
                overlay = SOAP_SCREEN;
            } else if (state.is(ModFluids.SUPER_SOAPY_WATER.get()) || state.is(ModFluids.SUPER_SOAPY_WATER_FLOWING.get())) {
                overlay = SUPER_SOAP_SCREEN;
            }

            if (overlay != null) {
                int width = guiGraphics.guiWidth();
                int height = guiGraphics.guiHeight();
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                guiGraphics.setColor(1.0F, 1.0F, 1.0F, 0.1F);
                guiGraphics.blit(overlay, 0, 0, 0.0F, 0.0F, width, height, width, height);
                guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableBlend();
            }
        });

        List<Block> translucentBlocks = new ArrayList<>();
        List<Block> cutoutMippedBlocks = new ArrayList<>();

        // Cookie Jar
        addIfPresent(translucentBlocks, ModBlocks.COOKIE_JAR);

        // Cups
        addIfPresent(translucentBlocks, ModBlocks.WHITE_CUP);
        addIfPresent(translucentBlocks, ModBlocks.LIGHT_GRAY_CUP);
        addIfPresent(translucentBlocks, ModBlocks.GRAY_CUP);
        addIfPresent(translucentBlocks, ModBlocks.BLACK_CUP);
        addIfPresent(translucentBlocks, ModBlocks.BROWN_CUP);
        addIfPresent(translucentBlocks, ModBlocks.RED_CUP);
        addIfPresent(translucentBlocks, ModBlocks.ORANGE_CUP);
        addIfPresent(translucentBlocks, ModBlocks.BEIGE_CUP); // Optional YogMod variant
        addIfPresent(translucentBlocks, ModBlocks.YELLOW_CUP);
        addIfPresent(translucentBlocks, ModBlocks.LIME_CUP);
        addIfPresent(translucentBlocks, ModBlocks.GREEN_CUP);
        addIfPresent(translucentBlocks, ModBlocks.CYAN_CUP);
        addIfPresent(translucentBlocks, ModBlocks.LIGHT_BLUE_CUP);
        addIfPresent(translucentBlocks, ModBlocks.BLUE_CUP);
        addIfPresent(translucentBlocks, ModBlocks.PURPLE_CUP);
        addIfPresent(translucentBlocks, ModBlocks.MAGENTA_CUP);
        addIfPresent(translucentBlocks, ModBlocks.PINK_CUP);

        // Appliances
        addIfPresent(translucentBlocks, ModBlocks.BLENDER_LIGHT);
        addIfPresent(translucentBlocks, ModBlocks.BLENDER_DARK);
        addIfPresent(translucentBlocks, ModBlocks.MICROWAVE_LIGHT);
        addIfPresent(translucentBlocks, ModBlocks.MICROWAVE_DARK);
        addIfPresent(translucentBlocks, ModBlocks.OVEN_LIGHT);
        addIfPresent(translucentBlocks, ModBlocks.OVEN_DARK);
        addIfPresent(cutoutMippedBlocks, ModBlocks.SHOWER_LIGHT);
        addIfPresent(cutoutMippedBlocks, ModBlocks.SHOWER_DARK);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(), translucentBlocks.toArray(new Block[0]));
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(), cutoutMippedBlocks.toArray(new Block[0]));
    }

    private static void registerBlockEntityRenderers()
    {
        BlockEntityRenderers.register(ModBlockEntityTypes.BATH.get(), BathBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.BIRD_BATH.get(), BirdBathBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.CATHODE_RAY_TUBE_TELEVISION.get(), CathodeRayTubeTelevisionBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.CHOPPING_BOARD.get(), ChoppingBoardBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.COOKIE_JAR.get(), CookieJarBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.DIGITAL_CLOCK.get(), DigitalClockBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), LiquidCrystalDisplayTelevisionBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.PLATE.get(), PlateBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.SINK.get(), SinkBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.TOASTER.get(), ToasterBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.TOILET.get(), ToiletBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.WATER_TANK.get(), WaterTankBlockEntityRenderer::new);
    }

    private static void registerEntityRenderers()
    {
        EntityRendererRegistry.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
    }

    private static void registerScreens() {
        MenuScreens.register(ModMenuTypes.BIN.get(), BinScreen::new);
        MenuScreens.register(ModMenuTypes.CATHODE_RAY_TUBE_TELEVISION.get(), CathodeRayTubeTelevisionScreen::new);
        MenuScreens.register(ModMenuTypes.DISHWASHER.get(), DishwasherScreen::new);
        MenuScreens.register(ModMenuTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), LiquidCrystalDisplayTelevisionScreen::new);
        MenuScreens.register(ModMenuTypes.MICROWAVE.get(), MicrowaveScreen::new);
        MenuScreens.register(ModMenuTypes.OVEN.get(), OvenScreen::new);
        MenuScreens.register(ModMenuTypes.PRINTER.get(), PrinterScreen::new);
        MenuScreens.register(ModMenuTypes.WALL_CABINET.get(), WallCabinetScreen::new);
        MenuScreens.register(ModMenuTypes.WASHING_MACHINE.get(), WashingMachineScreen::new);
    }

    private static void registerColorHandlers() {
        if (ModBlocks.CHRISTMAS_TREE != null && ModBlocks.CHRISTMAS_TREE.get() != null) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(), ModBlocks.CHRISTMAS_TREE.get());
        }
        if (ModBlocks.WREATH != null && ModBlocks.WREATH.get() != null) {
            ColorProviderRegistry.BLOCK.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(), ModBlocks.WREATH.get());
        }

        List<Block> festiveBlocks = new ArrayList<>();
        addIfPresent(festiveBlocks, ModBlocks.CHRISTMAS_TREE);
        addIfPresent(festiveBlocks, ModBlocks.WREATH);

        if (!festiveBlocks.isEmpty()) {
            ColorProviderRegistry.ITEM.register((stack, i) -> {
                BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
                return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
            }, festiveBlocks.toArray(new Block[0]));
        }
    }

    private static void registerRenderLayers() {
        List<Block> cutoutBlocks = new ArrayList<>();
        addIfPresent(cutoutBlocks, ModBlocks.CHRISTMAS_TREE);
        addIfPresent(cutoutBlocks, ModBlocks.WREATH);
        addIfPresent(cutoutBlocks, ModBlocks.CANDLE);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), cutoutBlocks.toArray(new Block[0]));
    }

    private static void addIfPresent(List<Block> list, java.util.function.Supplier<? extends Block> supplier) {
        if (supplier != null) {
            try {
                Block block = supplier.get();
                if (block != null) {
                    list.add(block);
                }
            } catch (Exception ignored) {}
        }
    }
}
