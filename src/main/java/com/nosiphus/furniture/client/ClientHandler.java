package com.nosiphus.furniture.client;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import com.nosiphus.furniture.client.menu.screen.*;
import com.nosiphus.furniture.client.renderer.blockentity.*;
import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModBlocks;
import com.nosiphus.furniture.core.ModItems;
import com.nosiphus.furniture.core.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;

import java.util.function.Predicate;

public class ClientHandler {

    public static void setup() {

        registerBlockEntityRenderers();
        registerLayers();

        MenuScreens.register(ModMenuTypes.MICROWAVE_MENU.get(), MicrowaveMenuScreen::new);
        MenuScreens.register(ModMenuTypes.OVEN_MENU.get(), OvenMenuScreen::new);

        if(!ModList.get().isLoaded("filters")) {

            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());

        } else {

        }

    }

    private static void registerBlockEntityRenderers() {

        BlockEntityRenderers.register(ModBlockEntities.MODERN_KITCHEN_SINK.get(), ModernKitchenSinkBlockEntityRenderer::new);
        //BlockEntityRenderers.register(ModBlockEntities.OFFICE_CHAIR.get(), OfficeChairBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.SINK.get(), SinkBlockEntityRenderer::new);

    }

    private static void registerLayers() {

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLENDER_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLENDER_LIGHT.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROWAVE_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MICROWAVE_LIGHT.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OVEN_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OVEN_LIGHT.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHOWER_DARK.get(), cutoutPredicate);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHOWER_LIGHT.get(), cutoutPredicate);

    }

    public static void onRegisterCreativeTab(CreativeModeTabEvent.Register event) {

        event.registerCreativeModeTab(new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "cfm"), builder -> {
            builder.title(Component.translatable("itemGroup." + NosiphusFurnitureMod.MOD_ID));
            builder.icon(() -> new ItemStack(ModBlocks.CHAIR_WHITE_MODERN.get()));
            builder.displayItems((flags, output, permission) -> ModItems.ITEMS.getEntries().forEach(registryObject -> output.accept(registryObject.get())));
        });

    }

}
