package com.nosiphus.furniture.network.play;

import com.nosiphus.furniture.blockentity.BinBlockEntity;
import com.nosiphus.furniture.client.menu.BinMenu;
import com.nosiphus.furniture.network.message.C2SMessageEmptyBin;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class ServerPlayHandler {

    public static void handleEmptyBinMessage(ServerPlayer player, C2SMessageEmptyBin message) {

        if (player.containerMenu instanceof BinMenu binMenu) {
            BinBlockEntity.emptyBin(binMenu);
        }

    }

}
