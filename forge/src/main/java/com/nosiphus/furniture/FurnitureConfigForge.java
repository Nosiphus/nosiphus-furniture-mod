package com.nosiphus.furniture;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.net.URI;
import java.util.List;

public class FurnitureConfigForge {

    public static class Common {
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> trustedUrls;
        public final ForgeConfigSpec.BooleanValue requireOpToSetUrls;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Television GIF security settings").push("trusted_urls");

            this.requireOpToSetUrls = builder
                    .comment("If enabled, on servers only operators will be able to set GIFs on TVs.")
                    .translation("configgui.nfm.requireOpToSetUrls")
                    .define("requireOpToSetUrls", true);

            this.trustedUrls = builder
                    .comment("GIFs on screens will only be permitted from the following URLs. HTTPS required.")
                    .translation("configgui.nfm.trustedUrls")
                    .defineListAllowEmpty(
                            List.of("allowed_urls"),
                            () -> List.of(
                                    "https://imgur.com/",
                                    "https://giphy.com/",
                                    "https://discordapp.com/"
                            ),
                            element -> element instanceof String && isValidUrlFormat((String) element)
                    );
            builder.pop();
        }

        private static boolean isValidUrlFormat(String url) {
            if (url == null || url.isBlank()) {
                return false;
            }

            try {
                URI uri = URI.create(url.trim());
                String scheme = uri.getScheme();
                return scheme != null && scheme.equalsIgnoreCase("https") && uri.getHost() != null;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        FurnitureConfig.setCommonConfig(
                COMMON.requireOpToSetUrls::get,
                () -> (List<String>) COMMON.trustedUrls.get()
        );
    }
}