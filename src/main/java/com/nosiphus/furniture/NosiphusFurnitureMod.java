package com.nosiphus.furniture;

import com.mojang.logging.LogUtils;
import com.nosiphus.furniture.client.gui.screens.inventory.BinScreen;
import com.nosiphus.furniture.client.gui.screens.inventory.WallCabinetScreen;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.client.renderer.entity.SeatRenderer;
import com.nosiphus.furniture.network.protocol.common.ServerboundEmptyBin;
import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.entity.ModEntityTypes;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModCreativeModeTabs;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.item.crafting.ModRecipeSerializers;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.material.ModFluidTypes;
import com.nosiphus.furniture.world.level.material.ModFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@Mod("nfm")
public class NosiphusFurnitureMod {

    private static final Logger LOGGER = LogUtils.getLogger();
    public NosiphusFurnitureMod(IEventBus eventBus, ModContainer container) {

        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabs.CREATIVE_TABS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModFluids.FLUIDS.register(eventBus);
        ModFluidTypes.FLUID_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(eventBus);
        ModRecipeTypes.RECIPE_TYPES.register(eventBus);
        ModSoundEvents.SOUND_EVENTS.register(eventBus);

    }

    @EventBusSubscriber(modid = "nfm", value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            registerBlockEntityRenderers();
            registerEntityRenderers();
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(),
                    ModBlocks.CHRISTMAS_TREE.get());
            event.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(),
                    ModBlocks.WREATH.get());
        }

        @SubscribeEvent
        public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
            event.register((stack, i) -> {
                BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
            }, ModBlocks.CHRISTMAS_TREE.get(), ModBlocks.WREATH.get());
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event)
        {
            event.register(ModMenuTypes.BIN.get(), BinScreen::new);
            event.register(ModMenuTypes.WALL_CABINET.get(), WallCabinetScreen::new);
        }

    }

    @EventBusSubscriber(modid = "nfm")
    public static class ModEvents {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerCapabilities(RegisterCapabilitiesEvent event)
        {
            event.registerBlockEntity(Capabilities.FluidHandler.BLOCK,
                    ModBlockEntityTypes.BATH.get(),(bath, side) -> bath.getTank());
            event.registerBlockEntity(Capabilities.FluidHandler.BLOCK,
                    ModBlockEntityTypes.BIRD_BATH.get(),(birdBath, side) -> birdBath.getTank());
            event.registerBlockEntity(Capabilities.FluidHandler.BLOCK,
                    ModBlockEntityTypes.WATER_TANK.get(),(waterTank, side) -> waterTank.getTank());
        }

        @SubscribeEvent
        public static void registerPackets(final RegisterPayloadHandlersEvent event)
        {
            final PayloadRegistrar registrar = event.registrar("nfm").versioned("1");

            /*
            registrar.playToClient(
                    ClientboundFlipGrill.TYPE,
                    ClientboundFlipGrill.STREAM_CODEC,
                    ClientboundFlipGrill::handle
            );

             */

            registrar.playToServer(
                    ServerboundEmptyBin.TYPE,
                    ServerboundEmptyBin.STREAM_CODEC,
                    ServerboundEmptyBin::handle
            );
        }

    }

    private static void registerBlockEntityRenderers()
    {
        BlockEntityRenderers.register(ModBlockEntityTypes.BATH.get(), BathBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.BIRD_BATH.get(), BirdBathBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.CHOPPING_BOARD.get(), ChoppingBoardBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.COOKIE_JAR.get(), CookieJarBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.DIGITAL_CLOCK.get(), DigitalClockBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.PLATE.get(), PlateBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.WATER_TANK.get(), WaterTankBlockEntityRenderer::new);
    }

    private static void registerEntityRenderers()
    {
        EntityRenderers.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
    }

}