package com.nosiphus.furniture.client;

import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import com.nosiphus.furniture.client.renderer.blockentity.SinkBlockEntityRenderer;
import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

import java.util.function.Predicate;

public class ClientHandler {

    public static void setup() {

        registerBlockEntityRenderers();
        registerLayers();

        if(!ModList.get().isLoaded("filters")) {

            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());

        } else {

        }

    }

    private static void registerBlockEntityRenderers() {

        //BlockEntityRenderers.register(ModBlockEntities.OFFICE_CHAIR.get(), OfficeChairBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.SINK.get(), SinkBlockEntityRenderer::new);

    }

    private static void registerLayers() {

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROWAVE_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROWAVE_LIGHT.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OVEN_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OVEN_LIGHT.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHOWER_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHOWER_LIGHT.get(), cutoutPredicate);

    }

}
