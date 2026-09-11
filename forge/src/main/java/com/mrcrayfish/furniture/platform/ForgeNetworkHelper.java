package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.network.Message;
import com.mrcrayfish.furniture.network.PacketHandlerForge;
import com.mrcrayfish.furniture.platform.services.INetworkHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.PacketDistributor;

public class ForgeNetworkHelper implements INetworkHelper {

    @Override
    public void sendToServer(Message message) {
        PacketHandlerForge.CHANNEL.sendToServer(message);
    }

    @Override
    public void sendToPlayer(ServerPlayer player, Message message) {
        PacketHandlerForge.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    @Override
    public void sendToTracking(BlockEntity blockEntity, Message message) {
        PacketHandlerForge.CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> blockEntity.getLevel().getChunkAt(blockEntity.getBlockPos())), message);
    }
}