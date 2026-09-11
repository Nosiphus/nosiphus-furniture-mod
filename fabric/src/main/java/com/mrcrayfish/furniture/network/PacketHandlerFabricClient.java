package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.network.message.S2CMessageFlipGrill;
import com.mrcrayfish.furniture.network.play.ClientPlayHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PacketHandlerFabricClient {

    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(S2CMessageFlipGrill.ID, (client, handler, buf, responseSender) -> {
            S2CMessageFlipGrill msg = S2CMessageFlipGrill.decode(buf);
            client.execute(() -> ClientPlayHandler.handleFlipGrill(msg));
        });
    }

}
