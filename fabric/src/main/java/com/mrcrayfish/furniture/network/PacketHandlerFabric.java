package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.network.message.*;
import com.mrcrayfish.furniture.network.play.ServerPlayHandler;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketHandlerFabric {

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(C2SMessageLockCrate.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageLockCrate msg = C2SMessageLockCrate.decode(buf);
            server.execute(() -> ServerPlayHandler.handleLockCrate(msg, player));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageOpenMailBox.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageOpenMailBox msg = C2SMessageOpenMailBox.decode(buf);
            server.execute(() -> ServerPlayHandler.handleOpenMailBox(msg, player));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageSendMail.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageSendMail msg = C2SMessageSendMail.decode(buf);
            server.execute(() -> ServerPlayHandler.handleSendMail(msg, player));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageSetDoorMat.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageSetDoorMat msg = C2SMessageSetDoorMat.decode(buf);
            server.execute(() -> ServerPlayHandler.handleSetDoorMat(msg, player));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageSetMailBoxName.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageSetMailBoxName msg = C2SMessageSetMailBoxName.decode(buf);
            server.execute(() -> ServerPlayHandler.handleSetMailBoxName(msg, player));
        });
    }

}
