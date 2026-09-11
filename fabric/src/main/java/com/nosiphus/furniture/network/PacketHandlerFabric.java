package com.nosiphus.furniture.network;

import com.nosiphus.furniture.network.message.C2SMessageEmptyBin;
import com.nosiphus.furniture.network.message.C2SMessageTVChannelSync;
import com.nosiphus.furniture.network.message.C2SMessageTVURLSync;
import com.nosiphus.furniture.network.play.ServerPlayHandler;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketHandlerFabric {

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(C2SMessageEmptyBin.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageEmptyBin msg = C2SMessageEmptyBin.decode(buf);
            server.execute(() -> ServerPlayHandler.handleEmptyBinMessage(player, msg));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageTVChannelSync.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageTVChannelSync msg = C2SMessageTVChannelSync.decode(buf);
            server.execute(() -> ServerPlayHandler.handleTVChannelSync(player, msg));
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SMessageTVURLSync.ID, (server, player, handler, buf, responseSender) -> {
            C2SMessageTVURLSync msg = C2SMessageTVURLSync.decode(buf);
            server.execute(() -> ServerPlayHandler.handleTVURLSync(player, msg));
        });
    }
}