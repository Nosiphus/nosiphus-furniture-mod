package com.nosiphus.furniture.network.protocol;

import com.nosiphus.furniture.FurnitureConfig;

import java.net.URI;
import java.util.List;

public class UrlValidator {
    public static boolean isTrustedUrl(String urlString)
    {
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
            String inputHost = host.toLowerCase();
            List<? extends String> allowedUrls = FurnitureConfig.COMMON.trustedUrls.get();
            for (String allowed : allowedUrls) {
                String allowedHost = extractHost(allowed.trim().toLowerCase());
                if (allowedHost == null || allowedHost.isEmpty()) {
                    continue;
                }
                if (inputHost.equals(allowedHost) || inputHost.endsWith("." + allowedHost) || allowedHost.endsWith("." + inputHost)) {
                    return true;
                }
                String inputRoot = getRootDomain(inputHost);
                String allowedRoot = getRootDomain(allowedHost);
                if (!inputRoot.isEmpty() && inputRoot.equalsIgnoreCase(allowedRoot)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }

    private static String extractHost(String urlOrHost)
    {
        if (!urlOrHost.startsWith("http://") && !urlOrHost.startsWith("https://")) {
            urlOrHost = "https://" + urlOrHost;
        } try {
            URI uri = URI.create(urlOrHost);
            return uri.getHost() != null ? uri.getHost() : "";
        }
        catch (Exception e) {
            return "";
        }
    }

    private static String getRootDomain(String host) {
        if (host == null || host.isEmpty()) return "";
        String[] parts = host.split("\\.");
        if (parts.length >= 2) {
            return parts[parts.length - 2] + "." + parts[parts.length - 1];
        }
        return host;
    }
}