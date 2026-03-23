package com.mrcrayfish.furniture;

import com.mojang.logging.LogUtils;
import com.mrcrayfish.furniture.client.gui.screens.inventory.CrateScreen;
import com.mrcrayfish.furniture.client.renderer.entity.SeatRenderer;
import com.mrcrayfish.furniture.network.protocol.common.ServerboundLockCrate;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.entity.ModEntityTypes;
import com.mrcrayfish.furniture.world.inventory.ModMenuTypes;
import com.mrcrayfish.furniture.world.item.ModCreativeModeTabs;
import com.mrcrayfish.furniture.world.item.ModItems;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@Mod("cfm")
public class MrCrayFishFurnitureMod {

    private static final Logger LOGGER = LogUtils.getLogger();
    public MrCrayFishFurnitureMod(IEventBus eventBus, ModContainer container) {

        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabs.CREATIVE_TABS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModSoundEvents.SOUND_EVENTS.register(eventBus);

    }

    @EventBusSubscriber(modid = "cfm", value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            registerBlockEntityRenderers();
            registerEntityRenderers();
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.CRATE.get(), CrateScreen::new);
        }

    }

    @EventBusSubscriber(modid = "cfm")
    public static class ModEvents {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerPackets(final RegisterPayloadHandlersEvent event) {
            final PayloadRegistrar registrar = event.registrar("cfm").versioned("1");

            registrar.playToServer(
                    ServerboundLockCrate.TYPE,
                    ServerboundLockCrate.STREAM_CODEC,
                    ServerboundLockCrate::handle
            );
        }

    }

    private static void registerBlockEntityRenderers() {

    }

    private static void registerEntityRenderers() {
        EntityRenderers.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
    }

}