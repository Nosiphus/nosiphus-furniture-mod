package com.nosiphus.furniture.client.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;

public class CreativeScreenEventsFabric {

    private static final CreativeScreenEvents HANDLER = new CreativeScreenEvents();

    public static void register() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> HANDLER.onPlayerLogout());

        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof CreativeModeInventoryScreen creativeScreen) {
                HANDLER.onScreenInit(creativeScreen, widget -> Screens.getButtons(screen).add(widget));
            }
        });

        ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof CreativeModeInventoryScreen) {
                ScreenEvents.afterRender(screen).register((renderedScreen, drawContext, mouseX, mouseY, tickDelta) -> {
                    if (renderedScreen instanceof CreativeModeInventoryScreen creativeScreen) {
                        HANDLER.onScreenRenderPost(creativeScreen);
                    }
                });
            }
        });
    }
}