package com.nosiphus.furniture;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FurnitureConfig {

    private static BooleanSupplier requireOpToSetUrls = () -> true;
    private static Supplier<List<String>> trustedUrls = () -> List.of(
            "https://imgur.com/",
            "https://giphy.com/",
            "https://discordapp.com/"
    );

    public static void setCommonConfig(BooleanSupplier requireOpToSetUrls, Supplier<List<String>> trustedUrls) {
        FurnitureConfig.requireOpToSetUrls = requireOpToSetUrls;
        FurnitureConfig.trustedUrls = trustedUrls;
    }

    public static boolean isRequireOpToSetUrls() {
        return requireOpToSetUrls.getAsBoolean();
    }

    public static List<String> getTrustedUrls() {
        return trustedUrls.get();
    }
}