package com.nosiphus.furniture.network;

import com.nosiphus.furniture.network.protocol.common.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class NetworkFabric {

    public static void register() {
        PayloadTypeRegistry.playS2C().register(ClientboundDishwasherSync.TYPE, ClientboundDishwasherSync.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(ClientboundWashingMachineSync.TYPE, ClientboundWashingMachineSync.STREAM_CODEC);

        PayloadTypeRegistry.playC2S().register(ServerboundBinEmpty.TYPE, ServerboundBinEmpty.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundTVChannelSync.TYPE, ServerboundTVChannelSync.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundTVURLSync.TYPE, ServerboundTVURLSync.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundBinEmpty.TYPE, (payload, context) -> {
            context.server().execute(() -> PacketHandlers.handleBinEmpty(payload, context.player()));
        });

        ServerPlayNetworking.registerGlobalReceiver(ServerboundTVChannelSync.TYPE, (payload, context) -> {
            context.server().execute(() -> PacketHandlers.handleTVChannelSync(payload, context.player()));
        });

        ServerPlayNetworking.registerGlobalReceiver(ServerboundTVURLSync.TYPE, (payload, context) -> {
            context.server().execute(() -> PacketHandlers.handleTVURLSync(payload, context.player()));
        });
    }

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(ClientboundDishwasherSync.TYPE, (payload, context) -> {
            context.client().execute(() -> PacketHandlers.handleDishwasherSync(payload));
        });

        ClientPlayNetworking.registerGlobalReceiver(ClientboundWashingMachineSync.TYPE, (payload, context) -> {
            context.client().execute(() -> PacketHandlers.handleWashingMachineSync(payload));
        });
    }

}