package com.mrcrayfish.furniture;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FurnitureConfigFabric {

    public static void init() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("cfm.properties");
        Properties properties = new Properties();

        boolean drawCollisionShapes = false;
        int maxMailQueue = 20;
        int pullMailInterval = 20;

        if (Files.exists(configPath)) {
            try (InputStream in = Files.newInputStream(configPath)) {
                properties.load(in);
                drawCollisionShapes = Boolean.parseBoolean(properties.getProperty("drawCollisionShapes", "false"));
                maxMailQueue = Integer.parseInt(properties.getProperty("maxMailQueue", "20"));
                pullMailInterval = Integer.parseInt(properties.getProperty("pullMailInterval", "20"));
            } catch (Exception ignored) {}
        } else {
            try (OutputStream out = Files.newOutputStream(configPath)) {
                properties.setProperty("drawCollisionShapes", "false");
                properties.setProperty("maxMailQueue", "20");
                properties.setProperty("pullMailInterval", "20");
                properties.store(out, "MrCrayFish Furniture Mod Config");
            } catch (Exception ignored) {}
        }

        final boolean finalDraw = drawCollisionShapes;
        final int finalMax = maxMailQueue;
        final int finalPull = pullMailInterval;

        FurnitureConfig.setClientConfig(() -> finalDraw);
        FurnitureConfig.setCommonConfig(() -> finalMax, () -> finalPull);
    }
}