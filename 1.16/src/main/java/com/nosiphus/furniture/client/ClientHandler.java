package com.nosiphus.furniture.client;

import com.nosiphus.furniture.client.renderer.tileentity.OfficeChairTileEntityRenderer;
import com.nosiphus.furniture.client.renderer.tileentity.SinkTileEntityRenderer;
import com.nosiphus.furniture.core.ModBlocks;
import com.nosiphus.furniture.core.ModTileEntities;
import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Predicate;

/**
 * Author: MrCrayfish
 */
public class ClientHandler
{
    public static void setup()
    {
        registerTileEntityRenderers();
        registerLayers();

        if(!ModList.get().isLoaded("filters"))
        {
            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());
        }
        else
        {
            //Filters.get().register(FurnitureMod.GROUP, new ResourceLocation(Reference.MOD_ID, "general"), new ItemStack(ModBlocks.CHAIR_OAK));
            //Filters.get().register(FurnitureMod.GROUP, new ResourceLocation(Reference.MOD_ID, "storage"), new ItemStack(ModBlocks.CABINET_OAK));
            //Filters.get().register(FurnitureMod.GROUP, new ResourceLocation(Reference.MOD_ID, "bedroom"), new ItemStack(ModBlocks.DESK_OAK));
            //Filters.get().register(FurnitureMod.GROUP, new ResourceLocation(Reference.MOD_ID, "kitchen"), new ItemStack(ModBlocks.KITCHEN_COUNTER_CYAN));
            //Filters.get().register(FurnitureMod.GROUP, new ResourceLocation(Reference.MOD_ID, "bathroom"), new ItemStack(ModBlocks.TOILET_LIGHT));
        }
    }

    private static void registerTileEntityRenderers()
    {
        //ClientRegistry.bindTileEntityRenderer(ModTileEntities.OFFICE_CHAIR.get(), OfficeChairTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.SINK.get(), SinkTileEntityRenderer::new);
    }

    private static void registerLayers()
    {
        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.getCutout();
        RenderTypeLookup.setRenderLayer(ModBlocks.MICROWAVE_DARK.get(), cutoutPredicate);
        RenderTypeLookup.setRenderLayer(ModBlocks.MICROWAVE_LIGHT.get(), cutoutPredicate);
        RenderTypeLookup.setRenderLayer(ModBlocks.OVEN_DARK.get(), cutoutPredicate);
        RenderTypeLookup.setRenderLayer(ModBlocks.OVEN_LIGHT.get(), cutoutPredicate);
        RenderTypeLookup.setRenderLayer(ModBlocks.SHOWER_DARK.get(), cutoutPredicate);
        RenderTypeLookup.setRenderLayer(ModBlocks.SHOWER_LIGHT.get(), cutoutPredicate);
    }

}