package com.nosiphus.furniture;

import com.nosiphus.furniture.client.ClientHandler;
import com.nosiphus.furniture.core.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("nfm")
public class NosiphusFurnitureMod {

    public static final Logger LOGGER = LogManager.getLogger("nfm");
    public static final String MOD_ID = "nfm";

    public NosiphusFurnitureMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModCreativeTabs.CREATIVE_TABS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModSounds.SOUNDS.register(eventBus);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::onDataSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(ClientHandler::setup);

    }

    private void onDataSetup(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();

    }

}