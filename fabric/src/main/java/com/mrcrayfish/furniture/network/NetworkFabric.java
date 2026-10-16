package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.network.protocol.common.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class NetworkFabric {

    public static void register() {
        PayloadTypeRegistry.playS2C().register(ClientboundFlipGrill.TYPE, ClientboundFlipGrill.STREAM_CODEC);

        PayloadTypeRegistry.playC2S().register(ServerboundLockCrate.TYPE, ServerboundLockCrate.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundOpenMailBox.TYPE, ServerboundOpenMailBox.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSendMail.TYPE, ServerboundSendMail.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSetDoorMat.TYPE, ServerboundSetDoorMat.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSetMailBoxName.TYPE, ServerboundSetMailBoxName.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundLockCrate.TYPE, (payload, context) -> {
            context.server().execute(() -> ServerPacketHandlers.handleLockCrate(payload, context.player()));
        });
        ServerPlayNetworking.registerGlobalReceiver(ServerboundOpenMailBox.TYPE, (payload, context) -> {
            context.server().execute(() -> ServerPacketHandlers.handleOpenMailBox(payload, context.player()));
        });
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSendMail.TYPE, (payload, context) -> {
            context.server().execute(() -> ServerPacketHandlers.handleSendMail(payload, context.player()));
        });
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSetDoorMat.TYPE, (payload, context) -> {
            context.server().execute(() -> ServerPacketHandlers.handleSetDoorMat(payload, context.player()));
        });
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSetMailBoxName.TYPE, (payload, context) -> {
            context.server().execute(() -> ServerPacketHandlers.handleSetMailBoxName(payload, context.player()));
        });
    }

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(ClientboundFlipGrill.TYPE, (payload, context) -> {
            context.client().execute(() -> ClientPacketHandlers.handleFlipGrill(payload));
        });
    }
}