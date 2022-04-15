package com.nosiphus.furniture;

import com.mrcrayfish.furniture.datagen.BlockTagGen;
import com.mrcrayfish.furniture.datagen.ItemTagGen;
import com.mrcrayfish.furniture.datagen.LootTableGen;
import com.mrcrayfish.furniture.datagen.RecipeGen;
import com.nosiphus.furniture.client.ClientHandler;
import com.nosiphus.furniture.core.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("nfm")
public class NosiphusFurnitureMod {

    public static final Logger LOGGER = LogManager.getLogger("nfm");
    public static final CreativeModeTab GROUP = new NosiphusFurnitureModTab("nfm");

    public NosiphusFurnitureMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModParticles.PARTICLES.register(eventBus);
        ModSounds.SOUNDS.register(eventBus);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::onDataSetup);

    }

    private void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(ClientHandler::setup);

    }

    private void onDataSetup(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        BlockTagGen blockTagGen = new BlockTagGen(generator, existingFileHelper);
        generator.addProvider(new RecipeGen(generator));
        generator.addProvider(new LootTableGen(generator));
        generator.addProvider(blockTagGen);
        generator.addProvider(new ItemTagGen(generator, blockTagGen, existingFileHelper));

    }

}