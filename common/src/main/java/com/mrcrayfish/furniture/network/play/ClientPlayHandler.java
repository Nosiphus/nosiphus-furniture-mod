package com.mrcrayfish.furniture.network.play;

import com.mrcrayfish.furniture.network.message.S2CMessageFlipGrill;
import com.mrcrayfish.furniture.world.level.block.entity.GrillBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class ClientPlayHandler {

    public static void handleFlipGrill(S2CMessageFlipGrill payload) {
        Level level = Minecraft.getInstance().level;
        if (level != null && level.getBlockEntity(payload.pos()) instanceof GrillBlockEntity grill) {
            grill.setFlipping(payload.position());
        }
    }
}