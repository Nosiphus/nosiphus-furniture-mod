package com.nosiphus.furniture;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.net.URI;
import java.util.List;

public class FurnitureConfig {

    public static class Client
    {
        // nothing for now
    }

    public static class Common
    {
        public final ModConfigSpec.ConfigValue<List<? extends String>> trustedUrls;

        Common(ModConfigSpec.Builder builder)
        {
            builder.comment("Allowed URL configuration settings").push("trusted_urls");
            this.trustedUrls = builder
                    .comment("GIFs on screens will only permitted from the following URLs. HTTPS required.")
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

        private static boolean isValidUrlFormat(String url)
        {
            if (url == null || url.isBlank())
            {
                return false;
            }

            try
            {
                URI uri = URI.create(url.trim());
                String scheme = uri.getScheme();
                return scheme != null && scheme.equalsIgnoreCase("https") && uri.getHost() != null;
            }
            catch (Exception e)
            {
                return false;
            }
        }
    }

    /*
    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
     */

    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static
    {
        /*
        final Pair<Client, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
         */

        final Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

}
