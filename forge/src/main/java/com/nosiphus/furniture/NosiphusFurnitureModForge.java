package com.nosiphus.furniture;

import com.mrcrayfish.furniture.platform.ForgeFluidHelper;
import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.client.gui.screens.inventory.*;
import com.nosiphus.furniture.client.particle.ModParticleTypes;
import com.nosiphus.furniture.client.particle.ShowerParticle;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.client.renderer.entity.SeatRenderer;
import com.nosiphus.furniture.network.PacketHandlerForge;
import com.nosiphus.furniture.platform.ForgeRegistryHelper;
import com.nosiphus.furniture.world.entity.ModEntityTypes;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModCreativeModeTabsForge;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluidTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(NosiphusFurnitureMod.MOD_ID)
public class NosiphusFurnitureModForge {

    private static final Logger LOGGER = LoggerFactory.getLogger(NosiphusFurnitureMod.MOD_NAME);

    public NosiphusFurnitureModForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        NosiphusFurnitureMod.init();

        ForgeRegistryHelper.BLOCKS.register(eventBus);
        ForgeRegistryHelper.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabsForge.CREATIVE_TABS.register(eventBus);
        ForgeRegistryHelper.ENTITY_TYPES.register(eventBus);
        ForgeRegistryHelper.FLUIDS.register(eventBus);
        ModFluidTypes.FLUID_TYPES.register(eventBus);
        ForgeRegistryHelper.ITEMS.register(eventBus);
        ForgeRegistryHelper.MENU_TYPES.register(eventBus);
        ForgeRegistryHelper.PARTICLE_TYPES.register(eventBus);
        ForgeRegistryHelper.RECIPE_SERIALIZERS.register(eventBus);
        ForgeRegistryHelper.RECIPE_TYPES.register(eventBus);
        ForgeRegistryHelper.SOUND_EVENTS.register(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FurnitureConfigForge.COMMON_SPEC);
        FurnitureConfigForge.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            registerBlockEntityRenderers();

            event.enqueueWork(() -> {
                MenuScreens.register(ModMenuTypes.BIN.get(), BinScreen::new);
                MenuScreens.register(ModMenuTypes.CATHODE_RAY_TUBE_TELEVISION.get(), CathodeRayTubeTelevisionScreen::new);
                MenuScreens.register(ModMenuTypes.DISHWASHER.get(), DishwasherScreen::new);
                MenuScreens.register(ModMenuTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), LiquidCrystalDisplayTelevisionScreen::new);
                MenuScreens.register(ModMenuTypes.MICROWAVE.get(), MicrowaveScreen::new);
                MenuScreens.register(ModMenuTypes.OVEN.get(), OvenScreen::new);
                MenuScreens.register(ModMenuTypes.PRINTER.get(), PrinterScreen::new);
                MenuScreens.register(ModMenuTypes.WALL_CABINET.get(), WallCabinetScreen::new);
                MenuScreens.register(ModMenuTypes.WASHING_MACHINE.get(), WashingMachineScreen::new);

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
    }

    @EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(PacketHandlerForge::init);
        }
    }

    @EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {

        private static final ResourceLocation FLUID_CAP_KEY = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "fluid_handler");

        @SubscribeEvent
        public static void attachCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
            BlockEntity be = event.getObject();

            if (be instanceof FluidHandlerSyncedBlockEntity fluidBe) {
                var type = be.getType();
                if (type == ModBlockEntityTypes.BATH.get()
                        || type == ModBlockEntityTypes.BIRD_BATH.get()
                        || type == ModBlockEntityTypes.DISHWASHER.get()
                        || type == ModBlockEntityTypes.SINK.get()
                        || type == ModBlockEntityTypes.TAP.get()
                        || type == ModBlockEntityTypes.TOILET.get()
                        || type == ModBlockEntityTypes.WASHING_MACHINE.get()
                        || type == ModBlockEntityTypes.WATER_TANK.get()) {

                    event.addCapability(FLUID_CAP_KEY, new ICapabilityProvider() {
                        private final LazyOptional<IFluidHandler> handler = LazyOptional.of(() -> ForgeFluidHelper.of(fluidBe));

                        @Override
                        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                            return cap == ForgeCapabilities.FLUID_HANDLER ? handler.cast() : LazyOptional.empty();
                        }
                    });
                }
            }
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
}