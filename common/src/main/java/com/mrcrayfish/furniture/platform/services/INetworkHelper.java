package com.mrcrayfish.furniture.platform.services;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface INetworkHelper {
    void sendToServer(CustomPacketPayload payload);
}