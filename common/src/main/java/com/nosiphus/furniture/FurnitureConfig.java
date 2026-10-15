package com.nosiphus.furniture;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FurnitureConfig {

    public static final boolean DEFAULT_REQUIRE_OP_TO_SET_URLS = true;

    public static final List<String> DEFAULT_TRUSTED_SERVERS = List.of(
            "vi.nosiphus.com"
    );

    public static final List<String> DEFAULT_TRUSTED_URLS = List.of(
            "https://imgur.com/",
            "https://giphy.com/",
            "https://discordapp.com/",
            "https://klipy.com/"
    );

    private static Supplier<List<String>> trustedServersSupplier = () -> DEFAULT_TRUSTED_SERVERS;
    private static BooleanSupplier requireOpToSetUrlsSupplier = () -> DEFAULT_REQUIRE_OP_TO_SET_URLS;
    private static Supplier<List<String>> trustedUrlsSupplier = () -> DEFAULT_TRUSTED_URLS;

    public static void setClientConfig(Supplier<List<String>> trustedServers) {
        trustedServersSupplier = trustedServers;
    }

    public static void setCommonConfig(BooleanSupplier requireOpToSetUrls, Supplier<List<String>> trustedUrls) {
        requireOpToSetUrlsSupplier = requireOpToSetUrls;
        trustedUrlsSupplier = trustedUrls;
    }

    public static List<String> getTrustedServers() {
        return trustedServersSupplier.get();
    }

    public static boolean requireOpToSetUrls() {
        return requireOpToSetUrlsSupplier.getAsBoolean();
    }

    public static List<String> getTrustedUrls() {
        return trustedUrlsSupplier.get();
    }
}
