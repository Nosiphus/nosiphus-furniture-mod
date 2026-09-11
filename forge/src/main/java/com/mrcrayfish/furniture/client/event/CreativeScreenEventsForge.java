package com.mrcrayfish.furniture.client.event;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.nosiphus.furniture.client.renderer.blockentity.GifFrameCache;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = MrCrayFishFurnitureMod.MOD_ID, value = Dist.CLIENT)
public class CreativeScreenEventsForge {

    private static final CreativeScreenEvents HANDLER = new CreativeScreenEvents();

    @SubscribeEvent
    public static void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        HANDLER.onPlayerLogout();
        GifFrameCache.getInstance().clearAll();
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