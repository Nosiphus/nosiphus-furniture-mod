package com.mrcrayfish.furniture;

import com.mrcrayfish.furniture.integration.everycomp.EveryCompatAddon;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.entity.ModEntityTypes;
import com.mrcrayfish.furniture.world.inventory.ModMenuTypes;
import com.mrcrayfish.furniture.world.item.ModItems;
import com.mrcrayfish.furniture.world.item.crafting.ModRecipeSerializers;
import com.mrcrayfish.furniture.world.item.crafting.ModRecipeTypes;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MrCrayFishFurnitureMod {

    public static final String MOD_ID = "cfm";
    public static final String MOD_NAME = "MrCrayFish's Furniture Mod";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModEntityTypes.init();
        ModItems.init();
        ModMenuTypes.init();
        ModRecipeSerializers.init();
        ModRecipeTypes.init();
        ModSoundEvents.init();

        if(Services.PLATFORM.isModLoaded("everycomp")) {
            EveryCompatAddon.init();
        }
    }
}