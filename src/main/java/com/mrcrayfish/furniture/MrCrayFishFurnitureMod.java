package com.mrcrayfish.furniture;

import com.mojang.logging.LogUtils;
import com.mrcrayfish.furniture.client.gui.screens.inventory.CrateScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.MailBoxScreen;
import com.mrcrayfish.furniture.client.gui.screens.inventory.PostBoxScreen;
import com.mrcrayfish.furniture.client.model.HedgeModel;
import com.mrcrayfish.furniture.client.renderer.entity.SeatRenderer;
import com.mrcrayfish.furniture.network.protocol.common.ServerboundLockCrate;
import com.mrcrayfish.furniture.network.protocol.common.ServerboundOpenMailBox;
import com.mrcrayfish.furniture.network.protocol.common.ServerboundSendMail;
import com.mrcrayfish.furniture.network.protocol.common.ServerboundSetMailBoxName;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.entity.ModEntityTypes;
import com.mrcrayfish.furniture.world.inventory.ModMenuTypes;
import com.mrcrayfish.furniture.world.item.ModCreativeModeTabs;
import com.mrcrayfish.furniture.world.item.ModItems;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod("cfm")
public class MrCrayFishFurnitureMod
{

    private static final Logger LOGGER = LogUtils.getLogger();
    public MrCrayFishFurnitureMod(IEventBus eventBus, ModContainer container)
    {

        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModCreativeModeTabs.CREATIVE_TABS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModSoundEvents.SOUND_EVENTS.register(eventBus);

        container.registerConfig(ModConfig.Type.CLIENT, FurnitureConfig.CLIENT_SPEC);
        container.registerConfig(ModConfig.Type.COMMON, FurnitureConfig.COMMON_SPEC);

    }

    @EventBusSubscriber(modid = "cfm", value = Dist.CLIENT)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            registerBlockEntityRenderers();
            registerEntityRenderers();
        }

        @SubscribeEvent
        public static void onModifyBakingResult(ModelEvent.ModifyBakingResult event)
        {
            Map<ModelResourceLocation, BakedModel> models = event.getModels();
            List<ModelResourceLocation> hedgeKeys = new ArrayList<>();
            for (ModelResourceLocation location : models.keySet())
            {
                if (location.id().getNamespace().equals("cfm") && location.id().getPath().contains("hedge"))
                {
                    hedgeKeys.add(location);
                }
            }
            for (ModelResourceLocation location : hedgeKeys)
            {
                BakedModel originalModel = models.get(location);
                if (originalModel != null && !(originalModel instanceof HedgeModel))
                {
                    models.put(location, new HedgeModel(originalModel));
                }
            }
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register((state, reader, pos, i) -> i == 1 ? 0xFFCCCCCC : 0xFFFFFFFF,
                    ModBlocks.WHITE_PICKET_FENCE.get(),
                    ModBlocks.LIGHT_GRAY_PICKET_FENCE.get(),
                    ModBlocks.GRAY_PICKET_FENCE.get(),
                    ModBlocks.BLACK_PICKET_FENCE.get(),
                    ModBlocks.BROWN_PICKET_FENCE.get(),
                    ModBlocks.RED_PICKET_FENCE.get(),
                    ModBlocks.ORANGE_PICKET_FENCE.get(),
                    ModBlocks.YELLOW_PICKET_FENCE.get(),
                    ModBlocks.LIME_PICKET_FENCE.get(),
                    ModBlocks.GREEN_PICKET_FENCE.get(),
                    ModBlocks.CYAN_PICKET_FENCE.get(),
                    ModBlocks.LIGHT_BLUE_PICKET_FENCE.get(),
                    ModBlocks.BLUE_PICKET_FENCE.get(),
                    ModBlocks.PURPLE_PICKET_FENCE.get(),
                    ModBlocks.MAGENTA_PICKET_FENCE.get(),
                    ModBlocks.PINK_PICKET_FENCE.get(),
                    ModBlocks.WHITE_PICKET_GATE.get(),
                    ModBlocks.LIGHT_GRAY_PICKET_GATE.get(),
                    ModBlocks.GRAY_PICKET_GATE.get(),
                    ModBlocks.BLACK_PICKET_GATE.get(),
                    ModBlocks.BROWN_PICKET_GATE.get(),
                    ModBlocks.RED_PICKET_GATE.get(),
                    ModBlocks.ORANGE_PICKET_GATE.get(),
                    ModBlocks.YELLOW_PICKET_GATE.get(),
                    ModBlocks.LIME_PICKET_GATE.get(),
                    ModBlocks.GREEN_PICKET_GATE.get(),
                    ModBlocks.CYAN_PICKET_GATE.get(),
                    ModBlocks.LIGHT_BLUE_PICKET_GATE.get(),
                    ModBlocks.BLUE_PICKET_GATE.get(),
                    ModBlocks.PURPLE_PICKET_GATE.get(),
                    ModBlocks.MAGENTA_PICKET_GATE.get(),
                    ModBlocks.PINK_PICKET_GATE.get(),
                    ModBlocks.POST_BOX.get()
            );

            event.register((state, reader, pos, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF,
                    ModBlocks.STRIPPED_OAK_CRATE.get(),
                    ModBlocks.STRIPPED_SPRUCE_CRATE.get(),
                    ModBlocks.STRIPPED_BIRCH_CRATE.get(),
                    ModBlocks.STRIPPED_JUNGLE_CRATE.get(),
                    ModBlocks.STRIPPED_ACACIA_CRATE.get(),
                    ModBlocks.STRIPPED_DARK_OAK_CRATE.get(),
                    ModBlocks.STRIPPED_MANGROVE_CRATE.get(),
                    ModBlocks.STRIPPED_CHERRY_CRATE.get(),
                    ModBlocks.STRIPPED_CRIMSON_CRATE.get(),
                    ModBlocks.STRIPPED_WARPED_CRATE.get()

                    /*
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_MANGROVE.get()
                     */
            );

            event.register((state, reader, pos, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF,
                    ModBlocks.STRIPPED_OAK_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_SPRUCE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_BIRCH_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_JUNGLE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_ACACIA_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_MANGROVE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_CHERRY_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_CRIMSON_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_WARPED_PARK_BENCH.get()
            );

            /*
            event.register((state, reader, pos, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF,
                    ModBlocks.FRIDGE_LIGHT.get(),
                    ModBlocks.FREEZER_LIGHT.get(),
                    ModBlocks.FRIDGE_DARK.get(),
                    ModBlocks.FREEZER_DARK.get()
            );
             */

            event.register((state, reader, pos, i) -> FoliageColor.getEvergreenColor(),
                    ModBlocks.SPRUCE_HEDGE.get());

            event.register((state, reader, pos, i) -> FoliageColor.getBirchColor(),
                    ModBlocks.BIRCH_HEDGE.get());

            event.register((state, reader, pos, i) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(),
                    ModBlocks.OAK_HEDGE.get(),
                    ModBlocks.JUNGLE_HEDGE.get(),
                    ModBlocks.ACACIA_HEDGE.get(),
                    ModBlocks.DARK_OAK_HEDGE.get());

            event.register((state, reader, pos, i) -> FoliageColor.getMangroveColor(),
                    ModBlocks.MANGROVE_HEDGE.get());
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event)
        {
            event.register((stack, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF,
                    ModBlocks.WHITE_PICKET_FENCE.get(),
                    ModBlocks.LIGHT_GRAY_PICKET_FENCE.get(),
                    ModBlocks.GRAY_PICKET_FENCE.get(),
                    ModBlocks.BLACK_PICKET_FENCE.get(),
                    ModBlocks.BROWN_PICKET_FENCE.get(),
                    ModBlocks.RED_PICKET_FENCE.get(),
                    ModBlocks.ORANGE_PICKET_FENCE.get(),
                    ModBlocks.YELLOW_PICKET_FENCE.get(),
                    ModBlocks.LIME_PICKET_FENCE.get(),
                    ModBlocks.GREEN_PICKET_FENCE.get(),
                    ModBlocks.CYAN_PICKET_FENCE.get(),
                    ModBlocks.LIGHT_BLUE_PICKET_FENCE.get(),
                    ModBlocks.BLUE_PICKET_FENCE.get(),
                    ModBlocks.PURPLE_PICKET_FENCE.get(),
                    ModBlocks.MAGENTA_PICKET_FENCE.get(),
                    ModBlocks.PINK_PICKET_FENCE.get(),
                    ModBlocks.WHITE_PICKET_GATE.get(),
                    ModBlocks.LIGHT_GRAY_PICKET_GATE.get(),
                    ModBlocks.GRAY_PICKET_GATE.get(),
                    ModBlocks.BLACK_PICKET_GATE.get(),
                    ModBlocks.BROWN_PICKET_GATE.get(),
                    ModBlocks.RED_PICKET_GATE.get(),
                    ModBlocks.ORANGE_PICKET_GATE.get(),
                    ModBlocks.YELLOW_PICKET_GATE.get(),
                    ModBlocks.LIME_PICKET_GATE.get(),
                    ModBlocks.GREEN_PICKET_GATE.get(),
                    ModBlocks.CYAN_PICKET_GATE.get(),
                    ModBlocks.LIGHT_BLUE_PICKET_GATE.get(),
                    ModBlocks.BLUE_PICKET_GATE.get(),
                    ModBlocks.PURPLE_PICKET_GATE.get(),
                    ModBlocks.MAGENTA_PICKET_GATE.get(),
                    ModBlocks.PINK_PICKET_GATE.get(),
                    ModBlocks.POST_BOX.get()
            );

            event.register((stack, i) -> i == 1 ? 0xBBBBBB : 0xFFFFFFFF,
                    ModBlocks.STRIPPED_OAK_CRATE.get(),
                    ModBlocks.STRIPPED_SPRUCE_CRATE.get(),
                    ModBlocks.STRIPPED_BIRCH_CRATE.get(),
                    ModBlocks.STRIPPED_JUNGLE_CRATE.get(),
                    ModBlocks.STRIPPED_ACACIA_CRATE.get(),
                    ModBlocks.STRIPPED_DARK_OAK_CRATE.get(),
                    ModBlocks.STRIPPED_MANGROVE_CRATE.get(),
                    ModBlocks.STRIPPED_CHERRY_CRATE.get(),
                    ModBlocks.STRIPPED_CRIMSON_CRATE.get(),
                    ModBlocks.STRIPPED_WARPED_CRATE.get()

                    /*
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_COUNTER_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_DRAWER_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_SINK_LIGHT_STRIPPED_MANGROVE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_OAK.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_SPRUCE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_BIRCH.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_JUNGLE.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_ACACIA.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_DARK_OAK.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_CRIMSON.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_WARPED.get(),
                    ModBlocks.KITCHEN_SINK_DARK_STRIPPED_MANGROVE.get()
                     */
            );

            event.register((stack, i) -> i == 1 ? 0x999999 : 0xFFFFFFFF,
                    ModBlocks.STRIPPED_OAK_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_SPRUCE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_BIRCH_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_JUNGLE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_ACACIA_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_MANGROVE_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_CHERRY_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_CRIMSON_PARK_BENCH.get(),
                    ModBlocks.STRIPPED_WARPED_PARK_BENCH.get()
            );

            /*
            event.register((stack, i) -> i == 1 ? 0xCCCCCC : 0xFFFFFFFF,
                    ModBlocks.FRIDGE_LIGHT.get(),
                    ModBlocks.FREEZER_LIGHT.get(),
                    ModBlocks.FRIDGE_DARK.get(),
                    ModBlocks.FREEZER_DARK.get()
            );
             */

            event.register((stack, i) -> {
                BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i); },
                    ModBlocks.OAK_HEDGE.get(),
                    ModBlocks.SPRUCE_HEDGE.get(),
                    ModBlocks.BIRCH_HEDGE.get(),
                    ModBlocks.JUNGLE_HEDGE.get(),
                    ModBlocks.ACACIA_HEDGE.get(),
                    ModBlocks.DARK_OAK_HEDGE.get(),
                    ModBlocks.MANGROVE_HEDGE.get()
            );
        }



        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event)
        {
            event.register(ModMenuTypes.CRATE.get(), CrateScreen::new);
            event.register(ModMenuTypes.MAIL_BOX.get(), MailBoxScreen::new);
            event.register(ModMenuTypes.POST_BOX.get(), PostBoxScreen::new);
        }

    }

    @EventBusSubscriber(modid = "cfm")
    public static class ModEvents
    {

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerPackets(final RegisterPayloadHandlersEvent event)
        {
            final PayloadRegistrar registrar = event.registrar("cfm").versioned("1");

            registrar.playToServer(
                    ServerboundLockCrate.TYPE,
                    ServerboundLockCrate.STREAM_CODEC,
                    ServerboundLockCrate::handle
            );

            registrar.playToServer(
                    ServerboundOpenMailBox.TYPE,
                    ServerboundOpenMailBox.STREAM_CODEC,
                    ServerboundOpenMailBox::handle
            );

            registrar.playToServer(
                    ServerboundSendMail.TYPE,
                    ServerboundSendMail.STREAM_CODEC,
                    ServerboundSendMail::handle
            );

            registrar.playToServer(
                    ServerboundSetMailBoxName.TYPE,
                    ServerboundSetMailBoxName.STREAM_CODEC,
                    ServerboundSetMailBoxName::handle
            );
        }

    }

    private static void registerBlockEntityRenderers()
    {

    }

    private static void registerEntityRenderers()
    {
        EntityRenderers.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
    }

}