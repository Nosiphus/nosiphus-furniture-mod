package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.network.protocol.common.ClientboundFlipGrill;
import com.mrcrayfish.furniture.world.level.block.entity.GrillBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class ClientPacketHandlers {

    public static void handleFlipGrill(ClientboundFlipGrill payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof GrillBlockEntity grill) {
            grill.setFlipping(payload.position());
        }
    }
}