package com.nosiphus.furniture.network;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.network.message.*;
import com.nosiphus.furniture.network.play.ClientPlayHandler;
import com.nosiphus.furniture.network.play.ServerPlayHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandlerForge {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "network"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    private static int id = 0;

    public static void init() {
        CHANNEL.messageBuilder(C2SMessageEmptyBin.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageEmptyBin::encode)
                .decoder(C2SMessageEmptyBin::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleEmptyBinMessage(ctx.getSender(), msg));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageTVChannelSync.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageTVChannelSync::encode)
                .decoder(C2SMessageTVChannelSync::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleTVChannelSync(ctx.getSender(), msg));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageTVURLSync.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageTVURLSync::encode)
                .decoder(C2SMessageTVURLSync::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleTVURLSync(ctx.getSender(), msg));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(S2CMessageDishwasherSync.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CMessageDishwasherSync::encode)
                .decoder(S2CMessageDishwasherSync::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPlayHandler.handleDishwasherSync(msg)));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(S2CMessageWashingMachineSync.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CMessageWashingMachineSync::encode)
                .decoder(S2CMessageWashingMachineSync::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPlayHandler.handleWashingMachineSync(msg)));
                    ctx.setPacketHandled(true);
                }).add();
    }
}