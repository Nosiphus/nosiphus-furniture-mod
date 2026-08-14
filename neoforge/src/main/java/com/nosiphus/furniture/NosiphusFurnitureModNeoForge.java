package com.nosiphus.furniture;

import com.mrcrayfish.furniture.platform.NeoForgeFluidHelper;
import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.client.gui.screens.inventory.*;
import com.nosiphus.furniture.client.particle.ModParticleTypes;
import com.nosiphus.furniture.client.particle.ShowerParticle;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.client.renderer.entity.SeatRenderer;
import com.nosiphus.furniture.network.PacketHandlers;
import com.nosiphus.furniture.network.protocol.common.*;
import com.nosiphus.furniture.platform.NeoForgeRegistryHelper;
import com.nosiphus.furniture.world.entity.ModEntityTypes;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModCreativeModeTabsNeoForge;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluidTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

@Mod(NosiphusFurnitureMod.MOD_ID)
public class NosiphusFurnitureModNeoForge {

    private static final Logger LOGGER = LoggerFactory.getLogger(NosiphusFurnitureMod.MOD_NAME);

    public NosiphusFurnitureModNeoForge(IEventBus eventBus, ModContainer container) {
        NosiphusFurnitureMod.init();

        NeoForgeRegistryHelper.BLOCKS.register(eventBus);
        NeoForgeRegistryHelper.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabsNeoForge.CREATIVE_TABS.register(eventBus);
        NeoForgeRegistryHelper.ENTITY_TYPES.register(eventBus);
        NeoForgeRegistryHelper.FLUIDS.register(eventBus);
        ModFluidTypes.FLUID_TYPES.register(eventBus);
        NeoForgeRegistryHelper.ITEMS.register(eventBus);
        NeoForgeRegistryHelper.MENU_TYPES.register(eventBus);
        NeoForgeRegistryHelper.PARTICLE_TYPES.register(eventBus);
        NeoForgeRegistryHelper.RECIPE_SERIALIZERS.register(eventBus);
        NeoForgeRegistryHelper.RECIPE_TYPES.register(eventBus);
        NeoForgeRegistryHelper.SOUND_EVENTS.register(eventBus);

        container.registerConfig(ModConfig.Type.COMMON, FurnitureConfigNeoForge.COMMON_SPEC);
        FurnitureConfigNeoForge.init();

        NeoForge.EVENT_BUS.addListener(this::onLoggingOut);
    }

    private void onLoggingOut(ClientPlayerNetworkEvent.LoggingOut event) {
        GifFrameCache.getInstance().clearAll();
    }

    @EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            registerBlockEntityRenderers();

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOAPY_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOAPY_WATER_FLOWING.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOAPY_WATER.get(), RenderType.translucent());

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SUPER_SOAPY_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SUPER_SOAPY_WATER_FLOWING.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.SUPER_SOAPY_WATER.get(), RenderType.translucent());
            });
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntityTypes.SEAT.get(), SeatRenderer::new);
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            if (ModBlocks.CHRISTMAS_TREE != null && ModBlocks.CHRISTMAS_TREE.get() != null) {
                event.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(), ModBlocks.CHRISTMAS_TREE.get());
            }
            if (ModBlocks.WREATH != null && ModBlocks.WREATH.get() != null) {
                event.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(), ModBlocks.WREATH.get());
            }
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            if (ModBlocks.CHRISTMAS_TREE != null && ModBlocks.CHRISTMAS_TREE.get() != null && ModBlocks.WREATH != null && ModBlocks.WREATH.get() != null) {
                event.register((stack, i) -> {
                    BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
                    return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
                }, ModBlocks.CHRISTMAS_TREE.get(), ModBlocks.WREATH.get());
            }
        }

        @SubscribeEvent
        public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticleTypes.SHOWER.get(), ShowerParticle.Provider::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.BIN.get(), BinScreen::new);
            event.register(ModMenuTypes.CATHODE_RAY_TUBE_TELEVISION.get(), CathodeRayTubeTelevisionScreen::new);
            event.register(ModMenuTypes.DISHWASHER.get(), DishwasherScreen::new);
            event.register(ModMenuTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), LiquidCrystalDisplayTelevisionScreen::new);
            event.register(ModMenuTypes.MICROWAVE.get(), MicrowaveScreen::new);
            event.register(ModMenuTypes.OVEN.get(), OvenScreen::new);
            event.register(ModMenuTypes.PRINTER.get(), PrinterScreen::new);
            event.register(ModMenuTypes.WALL_CABINET.get(), WallCabinetScreen::new);
            event.register(ModMenuTypes.WASHING_MACHINE.get(), WashingMachineScreen::new);
        }
    }

    @EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        @SubscribeEvent
        public static void registerCapabilities(RegisterCapabilitiesEvent event) {
            registerFluidCapability(event, ModBlockEntityTypes.BATH);
            registerFluidCapability(event, ModBlockEntityTypes.BIRD_BATH);
            registerFluidCapability(event, ModBlockEntityTypes.DISHWASHER);
            registerFluidCapability(event, ModBlockEntityTypes.SINK);
            registerFluidCapability(event, ModBlockEntityTypes.TAP);
            registerFluidCapability(event, ModBlockEntityTypes.TOILET);
            registerFluidCapability(event, ModBlockEntityTypes.WASHING_MACHINE);
            registerFluidCapability(event, ModBlockEntityTypes.WATER_TANK);
        }

        private static <T extends BlockEntity> void registerFluidCapability(RegisterCapabilitiesEvent event, Supplier<BlockEntityType<T>> typeSupplier) {
            if (typeSupplier != null && typeSupplier.get() != null) {
                event.registerBlockEntity(
                        Capabilities.FluidHandler.BLOCK,
                        typeSupplier.get(),
                        (be, side) -> be instanceof FluidHandlerSyncedBlockEntity fluidBe ? NeoForgeFluidHelper.of(fluidBe) : null
                );
            }
        }

        @SubscribeEvent
        public static void registerPackets(final RegisterPayloadHandlersEvent event) {
            PayloadRegistrar registrar = event.registrar(NosiphusFurnitureMod.MOD_ID).versioned("1");

            registrar.playToClient(
                    ClientboundDishwasherSync.TYPE,
                    ClientboundDishwasherSync.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleDishwasherSync(payload))
            );
            registrar.playToClient(
                    ClientboundWashingMachineSync.TYPE,
                    ClientboundWashingMachineSync.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleWashingMachineSync(payload))
            );
            registrar.playToServer(
                    ServerboundBinEmpty.TYPE,
                    ServerboundBinEmpty.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleBinEmpty(payload, (ServerPlayer) context.player()))
            );
            registrar.playToServer(
                    ServerboundTVChannelSync.TYPE,
                    ServerboundTVChannelSync.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleTVChannelSync(payload, (ServerPlayer) context.player()))
            );
            registrar.playToServer(
                    ServerboundTVURLSync.TYPE,
                    ServerboundTVURLSync.STREAM_CODEC,
                    (payload, context) -> context.enqueueWork(() -> PacketHandlers.handleTVURLSync(payload, (ServerPlayer) context.player()))
            );
        }
    }

    private static void registerBlockEntityRenderers() {
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