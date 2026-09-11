package com.nosiphus.furniture.network.play;

import com.nosiphus.furniture.network.message.S2CMessageDishwasherSync;
import com.nosiphus.furniture.network.message.S2CMessageWashingMachineSync;
import com.nosiphus.furniture.world.level.block.entity.DishwasherBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.WashingMachineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class ClientPlayHandler {

    public static void handleDishwasherSync(S2CMessageDishwasherSync message) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(message.pos()) instanceof DishwasherBlockEntity dishwasher) {
            dishwasher.setFluid(message.fluid(), message.fluidAmount());
            dishwasher.setWashing(message.washing());
        }
    }

    public static void handleWashingMachineSync(S2CMessageWashingMachineSync message) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(message.pos()) instanceof WashingMachineBlockEntity washingMachine) {
            washingMachine.setFluid(message.fluid(), message.fluidAmount());
            washingMachine.setWashing(message.washing());
        }
    }
}