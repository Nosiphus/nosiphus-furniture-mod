package com.nosiphus.furniture;

import com.nosiphus.furniture.network.UrlValidator;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class FurnitureConfigNeoForge {

    public static class Client {
        public final ModConfigSpec.ConfigValue<List<? extends String>> trustedServers;

        Client(ModConfigSpec.Builder builder) {
            builder.comment("Television GIF security settings").push("trusted_urls");

            this.trustedServers = builder
                    .comment("Your client will only display GIFs from sources other than your approved list on these servers.")
                    .translation("configgui.nfm.trustedServers")
                    .defineListAllowEmpty(
                            List.of("allowed_servers"),
                            () -> FurnitureConfig.DEFAULT_TRUSTED_SERVERS,
                            element -> element instanceof String s && UrlValidator.isValidAddressFormat(s)
                    );
            builder.pop();
        }
    }

    public static class Common {
        public final ModConfigSpec.ConfigValue<List<? extends String>> trustedUrls;
        public final ModConfigSpec.BooleanValue requireOpToSetUrls;

        Common(ModConfigSpec.Builder builder) {
            builder.comment("Television GIF security settings").push("trusted_urls");

            this.requireOpToSetUrls = builder
                    .comment("If enabled, on servers only operators will be able to set GIFs on TVs.")
                    .translation("configgui.nfm.requireOpToSetUrls")
                    .define("requireOpToSetUrls", FurnitureConfig.DEFAULT_REQUIRE_OP_TO_SET_URLS);

            this.trustedUrls = builder
                    .comment("GIFs on screens will only be permitted from the following URLs. HTTPS required.")
                    .translation("configgui.nfm.trustedUrls")
                    .defineListAllowEmpty(
                            List.of("allowed_urls"),
                            () -> FurnitureConfig.DEFAULT_TRUSTED_URLS,
                            element -> element instanceof String s && UrlValidator.isValidUrlFormat(s)
                    );
            builder.pop();
        }
    }

    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Client, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();

        final Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        FurnitureConfig.setClientConfig(() -> (List<String>) CLIENT.trustedServers.get());
        FurnitureConfig.setCommonConfig(COMMON.requireOpToSetUrls::get, () -> (List<String>) COMMON.trustedUrls.get());
    }
}