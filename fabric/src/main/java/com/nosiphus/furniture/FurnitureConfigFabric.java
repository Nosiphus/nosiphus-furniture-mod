package com.nosiphus.furniture;

import com.nosiphus.furniture.network.UrlValidator;
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

        String defaultOpString = String.valueOf(FurnitureConfig.DEFAULT_REQUIRE_OP_TO_SET_URLS);
        String defaultServersString = String.join(",", FurnitureConfig.DEFAULT_TRUSTED_SERVERS);
        String defaultUrlsString = String.join(",", FurnitureConfig.DEFAULT_TRUSTED_URLS);

        boolean requireOpToSetUrls = FurnitureConfig.DEFAULT_REQUIRE_OP_TO_SET_URLS;
        List<String> trustedServers = FurnitureConfig.DEFAULT_TRUSTED_SERVERS;
        List<String> trustedUrls = FurnitureConfig.DEFAULT_TRUSTED_URLS;

        if (Files.exists(configPath)) {
            boolean needsSave = false;
            try (InputStream in = Files.newInputStream(configPath)) {
                properties.load(in);

                if (!properties.containsKey("requireOpToSetUrls")) {
                    properties.setProperty("requireOpToSetUrls", defaultOpString);
                    needsSave = true;
                }
                if (!properties.containsKey("trustedServers")) {
                    properties.setProperty("trustedServers", defaultServersString);
                    needsSave = true;
                }
                if (!properties.containsKey("trustedUrls")) {
                    properties.setProperty("trustedUrls", defaultUrlsString);
                    needsSave = true;
                }

                String rawOp = properties.getProperty("requireOpToSetUrls", defaultOpString).trim();
                requireOpToSetUrls = !"false".equalsIgnoreCase(rawOp);

                String rawServers = properties.getProperty("trustedServers", defaultServersString);
                trustedServers = Arrays.stream(rawServers.split(","))
                        .map(String::trim)
                        .filter(r -> !r.isEmpty())
                        .filter(UrlValidator::isValidAddressFormat)
                        .toList();

                String rawUrls = properties.getProperty("trustedUrls", defaultUrlsString);
                trustedUrls = Arrays.stream(rawUrls.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .filter(UrlValidator::isValidUrlFormat)
                        .toList();
            } catch (Exception ignored) {}

            if (needsSave) {
                try (OutputStream out = Files.newOutputStream(configPath)) {
                    properties.store(out, "Nosiphus Furniture Mod Config");
                } catch (Exception ignored) {}
            }
        } else {
            try (OutputStream out = Files.newOutputStream(configPath)) {
                properties.setProperty("requireOpToSetUrls", defaultOpString);
                properties.setProperty("trustedServers", defaultServersString);
                properties.setProperty("trustedUrls", defaultUrlsString);
                properties.store(out, "Nosiphus Furniture Mod Config");
            } catch (Exception ignored) {}
        }

        final boolean finalOpRequired = requireOpToSetUrls;
        final List<String> finalTrustedServers = trustedServers;
        final List<String> finalUrls = trustedUrls;

        FurnitureConfig.setClientConfig(() -> finalTrustedServers);
        FurnitureConfig.setCommonConfig(() -> finalOpRequired, () -> finalUrls);
    }
}
