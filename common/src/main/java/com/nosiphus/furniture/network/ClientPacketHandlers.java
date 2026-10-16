package com.nosiphus.furniture.network;

import com.nosiphus.furniture.network.protocol.common.ClientboundDishwasherSync;
import com.nosiphus.furniture.network.protocol.common.ClientboundWashingMachineSync;
import com.nosiphus.furniture.world.level.block.entity.DishwasherBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.WashingMachineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class ClientPacketHandlers {

    public static void handleDishwasherSync(ClientboundDishwasherSync payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof DishwasherBlockEntity dishwasher) {
            dishwasher.setFluid(payload.fluid(), payload.fluidAmount());
            dishwasher.setWashing(payload.washing());
        }
    }

    public static void handleWashingMachineSync(ClientboundWashingMachineSync payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof WashingMachineBlockEntity washingMachine) {
            washingMachine.setFluid(payload.fluid(), payload.fluidAmount());
            washingMachine.setWashing(payload.washing());
        }
    }
}