package com.mrcrayfish.furniture;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

public class FurnitureConfig {

    private static BooleanSupplier drawCollisionShapes = () -> false;
    private static IntSupplier maxMailQueue = () -> 20;
    private static IntSupplier pullMailInterval = () -> 20;

    public static void setClientConfig(BooleanSupplier drawCollisionShapes) {
        FurnitureConfig.drawCollisionShapes = drawCollisionShapes;
    }

    public static void setCommonConfig(IntSupplier maxMailQueue, IntSupplier pullMailInterval) {
        FurnitureConfig.maxMailQueue = maxMailQueue;
        FurnitureConfig.pullMailInterval = pullMailInterval;
    }

    public static boolean shouldDrawCollisionShapes() {
        return drawCollisionShapes.getAsBoolean();
    }

    public static int getMaxMailQueue() {
        return maxMailQueue.getAsInt();
    }

    public static int getPullMailInterval() {
        return pullMailInterval.getAsInt();
    }
}