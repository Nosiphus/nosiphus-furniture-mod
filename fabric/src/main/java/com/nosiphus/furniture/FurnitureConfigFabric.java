package com.nosiphus.furniture;

import net.fabricmc.loader.api.FabricLoader;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FurnitureConfigFabric {

    public static void init() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("nfm.properties");
        Properties properties = new Properties();

        boolean requireOpToSetUrls = true;
        List<String> trustedUrls = List.of(
                "https://imgur.com/",
                "https://giphy.com/",
                "https://discordapp.com/"
        );

        if (Files.exists(configPath)) {
            try (InputStream in = Files.newInputStream(configPath)) {
                properties.load(in);
                requireOpToSetUrls = Boolean.parseBoolean(properties.getProperty("requireOpToSetUrls", "true"));
                String rawUrls = properties.getProperty("trustedUrls", "https://imgur.com/,https://giphy.com/,https://discordapp.com/");
                trustedUrls = Arrays.stream(rawUrls.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .toList();
            } catch (Exception ignored) {}
        } else {
            try (OutputStream out = Files.newOutputStream(configPath)) {
                properties.setProperty("requireOpToSetUrls", "true");
                properties.setProperty("trustedUrls", "https://imgur.com/,https://giphy.com/,https://discordapp.com/");
                properties.store(out, "Nosiphus Furniture Mod Config");
            } catch (Exception ignored) {}
        }

        final boolean finalOpRequired = requireOpToSetUrls;
        final List<String> finalUrls = trustedUrls;

        FurnitureConfig.setCommonConfig(() -> finalOpRequired, () -> finalUrls);
    }
}