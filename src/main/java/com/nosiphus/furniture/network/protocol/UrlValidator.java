package com.nosiphus.furniture.network.protocol;

import com.nosiphus.furniture.FurnitureConfig;

import java.net.URI;
import java.util.List;

public class UrlValidator {

    public static boolean isTrustedUrl(String urlString) {
        if (urlString == null || urlString.isBlank()) {
            return false;
        }
        String trimmed = urlString.trim();
        if (trimmed.toLowerCase().startsWith("http://")) {
            return false;
        }
        if (!trimmed.toLowerCase().startsWith("https://")) {
            trimmed = "https://" + trimmed;
        }
        try {
            URI uri = URI.create(trimmed);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (scheme == null || !scheme.equalsIgnoreCase("https") || host == null) {
                return false;
            }

            String normalizedInputUrl = uri.toString().toLowerCase();

            List<? extends String> allowedUrls = FurnitureConfig.COMMON.trustedUrls.get();
            for (String allowed : allowedUrls) {
                String allowedTrimmed = allowed.trim().toLowerCase();
                if (normalizedInputUrl.startsWith(allowedTrimmed) || host.endsWith(allowedTrimmed)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }
}