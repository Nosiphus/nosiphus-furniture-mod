package com.nosiphus.furniture;

import com.nosiphus.furniture.client.ClientHandler;
import com.nosiphus.furniture.core.*;
import com.nosiphus.furniture.datagen.LootTableGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Author: MrCrayfish, Nosiphus
 */
@Mod(Reference.MOD_ID)
public class NosiphusFurnitureMod
{
    public static final ItemGroup GROUP = new ItemGroup(Reference.MOD_ID)
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.CHAIR_WHITE_MODERN.get());
        }
    };

    public NosiphusFurnitureMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.REGISTER.register(eventBus);
        ModItems.REGISTER.register(eventBus);
        ModParticles.REGISTER.register(eventBus);
        ModSounds.REGISTER.register(eventBus);
        ModTileEntities.REGISTER.register(eventBus);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::onDataSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {
        ClientHandler.setup();
    }

    private void onDataSetup(GatherDataEvent event)
    {
        DataGenerator dataGenerator = event.getGenerator();
        dataGenerator.addProvider(new LootTableGen(dataGenerator));
    }
}
