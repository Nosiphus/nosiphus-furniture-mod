package com.mrcrayfish.furniture.platform.services;

import com.mrcrayfish.furniture.network.Message;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface INetworkHelper {
    void sendToServer(Message message);
    void sendToPlayer(ServerPlayer player, Message message);
    void sendToTracking(BlockEntity blockEntity, Message message);
}