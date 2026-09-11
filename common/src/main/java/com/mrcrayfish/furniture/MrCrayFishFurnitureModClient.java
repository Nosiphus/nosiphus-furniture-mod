package com.mrcrayfish.furniture;

import com.mrcrayfish.furniture.client.gui.screens.DoorMatScreen;
import com.mrcrayfish.furniture.world.level.block.entity.DoorMatBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class MrCrayFishFurnitureModClient {

    public static void initClient() {

    }

    public static void showDoorMatScreen(Level level, BlockPos pos) {
        if (level.getBlockEntity(pos) instanceof DoorMatBlockEntity blockEntity) {
            Minecraft.getInstance().setScreen(new DoorMatScreen(blockEntity));
        }
    }

}
