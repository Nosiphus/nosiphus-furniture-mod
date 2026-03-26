package com.nosiphus.furniture;

import com.mojang.logging.LogUtils;
import com.mrcrayfish.furniture.client.gui.screens.inventory.CrateScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.FreezerScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.MailBoxScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.PostBoxScreen;
import com.nosiphus.furniture.client.gui.screens.inventory.WallCabinetScreen;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModCreativeModeTabs;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

@Mod("nfm")
public class NosiphusFurnitureMod {

    private static final Logger LOGGER = LogUtils.getLogger();
    public NosiphusFurnitureMod(IEventBus eventBus, ModContainer container) {

        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabs.CREATIVE_TABS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);

    }

    @EventBusSubscriber(modid = "nfm", value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event)
        {
            event.register(ModMenuTypes.WALL_CABINET.get(), WallCabinetScreen::new);
        }

    }

    @EventBusSubscriber(modid = "nfm")
    public static class ModEvents {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {

        }

    }

}