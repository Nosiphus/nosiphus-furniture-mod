package com.nosiphus.furniture;

import com.nosiphus.furniture.client.particle.ModParticleTypes;
import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.entity.ModEntityTypes;
import com.nosiphus.furniture.world.inventory.ModMenuTypes;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.item.crafting.ModRecipeSerializers;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NosiphusFurnitureMod {

    public static final String MOD_ID = "nfm";
    public static final String MOD_NAME = "Nosiphus Furniture Mod";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModEntityTypes.init();
        ModFluids.init();
        ModItems.init();
        ModMenuTypes.init();
        ModParticleTypes.init();
        ModRecipeSerializers.init();
        ModRecipeTypes.init();
        ModSoundEvents.init();
    }

}
