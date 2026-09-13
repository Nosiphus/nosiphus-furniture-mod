package com.mrcrayfish.furniture.integration.everycomp;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class EveryCompatAddon {
    public static void init() {
        EveryCompatAPI.registerOptionalModule(MrCrayFishFurnitureMod.MOD_ID, () -> EveryCompatModule.class);
    }
}
