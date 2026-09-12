package com.nosiphus.furniture.integration.everycomp;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class EveryCompatAddon {

    public static void init() {
        EveryCompatAPI.registerModule(new EveryCompatModule(NosiphusFurnitureMod.MOD_ID));
    }

}
