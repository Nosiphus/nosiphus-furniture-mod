package com.nosiphus.furniture.network;

import com.nosiphus.furniture.network.message.S2CMessageDishwasherSync;
import com.nosiphus.furniture.network.message.S2CMessageWashingMachineSync;
import com.nosiphus.furniture.network.play.ClientPlayHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PacketHandlerFabricClient {

    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(S2CMessageDishwasherSync.ID, (client, handler, buf, responseSender) -> {
            S2CMessageDishwasherSync msg = S2CMessageDishwasherSync.decode(buf);
            client.execute(() -> ClientPlayHandler.handleDishwasherSync(msg));
        });

        ClientPlayNetworking.registerGlobalReceiver(S2CMessageWashingMachineSync.ID, (client, handler, buf, responseSender) -> {
            S2CMessageWashingMachineSync msg = S2CMessageWashingMachineSync.decode(buf);
            client.execute(() -> ClientPlayHandler.handleWashingMachineSync(msg));
        });
    }
}