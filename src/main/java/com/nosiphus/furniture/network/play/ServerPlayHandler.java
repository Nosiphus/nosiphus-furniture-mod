package com.nosiphus.furniture.network.play;

import com.nosiphus.furniture.client.menu.BinMenu;
import com.nosiphus.furniture.network.message.C2SMessageEmptyBin;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class ServerPlayHandler {

    public static void handleEmptyBinMessage(ServerPlayer player, C2SMessageEmptyBin message) {

        if (player.containerMenu instanceof BinMenu binMenu) {
            binMenu.getSlot(37).set(ItemStack.EMPTY);
            binMenu.getSlot(38).set(ItemStack.EMPTY);
            binMenu.getSlot(39).set(ItemStack.EMPTY);
            binMenu.getSlot(40).set(ItemStack.EMPTY);
            binMenu.getSlot(41).set(ItemStack.EMPTY);
            binMenu.getSlot(42).set(ItemStack.EMPTY);
            binMenu.getSlot(43).set(ItemStack.EMPTY);
            binMenu.getSlot(44).set(ItemStack.EMPTY);
            binMenu.getSlot(45).set(ItemStack.EMPTY);
            binMenu.getSlot(46).set(ItemStack.EMPTY);
            binMenu.getSlot(47).set(ItemStack.EMPTY);
        }

    }

}
