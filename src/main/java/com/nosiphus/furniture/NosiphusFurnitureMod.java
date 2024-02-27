package com.nosiphus.furniture;

import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import com.nosiphus.furniture.client.gui.screen.inventory.BinScreen;
import com.nosiphus.furniture.client.gui.screen.inventory.DishwasherScreen;
import com.nosiphus.furniture.client.gui.screen.inventory.MicrowaveScreen;
import com.nosiphus.furniture.client.gui.screen.inventory.OvenScreen;
import com.nosiphus.furniture.client.renderer.blockentity.ModernKitchenSinkBlockEntityRenderer;
import com.nosiphus.furniture.client.renderer.blockentity.SinkBlockEntityRenderer;
import com.nosiphus.furniture.core.*;
import com.nosiphus.furniture.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("nfm")
public class NosiphusFurnitureMod {

    public static final Logger LOGGER = LogManager.getLogger("nfm");
    public static final CreativeModeTab GROUP = new NosiphusFurnitureModTab("nfm");
    public static final String MOD_ID = "nfm";

    public NosiphusFurnitureMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModContainers.CONTAINERS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModSounds.SOUNDS.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    @Mod.EventBusSubscriber(modid = "nfm", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientHandler {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModContainers.BIN.get(), BinScreen::new);
            MenuScreens.register(ModContainers.DISHWASHER.get(), DishwasherScreen::new);
            MenuScreens.register(ModContainers.MICROWAVE.get(), MicrowaveScreen::new);
            MenuScreens.register(ModContainers.OVEN.get(), OvenScreen::new);
            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());
        }

        @SubscribeEvent
        public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event) {
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
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.MODERN_KITCHEN_SINK.get(), ModernKitchenSinkBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.SINK.get(), SinkBlockEntityRenderer::new);
        }

    }

    @Mod.EventBusSubscriber(modid = "nfm", bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonHandler {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            PacketHandler.init();
        }

    }

}