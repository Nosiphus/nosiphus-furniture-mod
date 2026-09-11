package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.network.Message;
import com.nosiphus.furniture.platform.services.INetworkHelper;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;

public class FabricNetworkHelper implements INetworkHelper {

    @Override
    public void sendToServer(Message message) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        message.encode(buf);
        ClientPlayNetworking.send(message.getId(), buf);
    }

    @Override
    public void sendToPlayer(ServerPlayer player, Message message) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        message.encode(buf);
        ServerPlayNetworking.send(player, message.getId(), buf);
    }

    @Override
    public void sendToTracking(BlockEntity blockEntity, Message message) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        message.encode(buf);
        for (ServerPlayer player : PlayerLookup.tracking(blockEntity)) {
            ServerPlayNetworking.send(player, message.getId(), buf);
        }
    }
}