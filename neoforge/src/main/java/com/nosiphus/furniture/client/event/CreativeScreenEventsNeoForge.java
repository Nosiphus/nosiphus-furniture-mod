package com.nosiphus.furniture.client.event;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(modid = NosiphusFurnitureMod.MOD_ID, value = Dist.CLIENT)
public class CreativeScreenEventsNeoForge {

    private static final CreativeScreenEvents HANDLER = new CreativeScreenEvents();

    @SubscribeEvent
    public static void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        HANDLER.onPlayerLogout();
    }

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen) {
            HANDLER.onScreenInit(creativeScreen, event::addListener);
        }
    }

    @SubscribeEvent
    public static void onScreenDrawPost(ScreenEvent.Render.Post event) {
        if (event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen) {
            HANDLER.onScreenRenderPost(creativeScreen);
        }
    }
}