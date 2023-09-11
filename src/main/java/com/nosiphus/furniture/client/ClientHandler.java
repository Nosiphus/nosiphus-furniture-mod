package com.nosiphus.furniture.client;

import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import com.nosiphus.furniture.client.menu.screen.*;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

public class ClientHandler {

    public static void setup() {

        registerBlockEntityRenderers();

        MenuScreens.register(ModMenuTypes.BIN_MENU.get(), BinMenuScreen::new);
        MenuScreens.register(ModMenuTypes.MICROWAVE_MENU.get(), MicrowaveMenuScreen::new);
        MenuScreens.register(ModMenuTypes.OVEN_MENU.get(), OvenMenuScreen::new);

        if(!ModList.get().isLoaded("filters")) {

            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());

        } else {

        }

    }

    private static void registerBlockEntityRenderers() {

        BlockEntityRenderers.register(ModBlockEntities.MODERN_KITCHEN_SINK.get(), ModernKitchenSinkBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.SINK.get(), SinkBlockEntityRenderer::new);

    }

}
