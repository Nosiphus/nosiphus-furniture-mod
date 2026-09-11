package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.message.*;
import com.mrcrayfish.furniture.network.play.ClientPlayHandler;
import com.mrcrayfish.furniture.network.play.ServerPlayHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandlerForge {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "network"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    private static int id = 0;

    public static void init() {
        CHANNEL.messageBuilder(S2CMessageFlipGrill.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CMessageFlipGrill::encode)
                .decoder(S2CMessageFlipGrill::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPlayHandler.handleFlipGrill(msg)));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageLockCrate.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageLockCrate::encode)
                .decoder(C2SMessageLockCrate::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleLockCrate(msg, ctx.getSender()));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageOpenMailBox.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageOpenMailBox::encode)
                .decoder(C2SMessageOpenMailBox::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleOpenMailBox(msg, ctx.getSender()));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageSendMail.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageSendMail::encode)
                .decoder(C2SMessageSendMail::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleSendMail(msg, ctx.getSender()));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageSetDoorMat.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageSetDoorMat::encode)
                .decoder(C2SMessageSetDoorMat::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleSetDoorMat(msg, ctx.getSender()));
                    ctx.setPacketHandled(true);
                }).add();

        CHANNEL.messageBuilder(C2SMessageSetMailBoxName.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageSetMailBoxName::encode)
                .decoder(C2SMessageSetMailBoxName::decode)
                .consumerNetworkThread((msg, ctxSupplier) -> {
                    var ctx = ctxSupplier.get();
                    ctx.enqueueWork(() -> ServerPlayHandler.handleSetMailBoxName(msg, ctx.getSender()));
                    ctx.setPacketHandled(true);
                }).add();
    }
}