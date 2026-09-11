package com.nosiphus.furniture.network;

import com.google.common.net.InternetDomainName;
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
            List<String> allowedUrls = FurnitureConfig.getTrustedUrls();
            for (String allowed : allowedUrls) {
                String allowedHost = extractHost(allowed.trim().toLowerCase());
                if (allowedHost == null || allowedHost.isEmpty()) {
                    continue;
                }
                if (hostMatches(inputHost, allowedHost)) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }

    // Trust the host if it equals the allowed host or is a subdomain of it.
    // The previous code also accepted `allowedHost.endsWith("." + inputHost)`,
    // which let anyone register a two-label domain (e.g. `y.com`) whose name
    // was a suffix of an allowed host (`giphy.com`) and get in. Dropped.
    //
    // The old fallback used a naive last-two-labels root-domain check that
    // treated `co.uk` as a root and matched `evil.co.uk` against `bbc.co.uk`.
    // Replaced with Guava's Public Suffix List check via
    // `InternetDomainName.topPrivateDomain()` (Guava is already on the
    // NeoForge classpath).
    private static boolean hostMatches(String inputHost, String allowedHost) {
        if (inputHost.equals(allowedHost)) {
            return true;
        }
        if (inputHost.endsWith("." + allowedHost)) {
            return true;
        }
        String inputRoot = topPrivateDomainOrNull(inputHost);
        String allowedRoot = topPrivateDomainOrNull(allowedHost);
        return inputRoot != null && inputRoot.equals(allowedRoot);
    }

    private static String topPrivateDomainOrNull(String host) {
        try {
            InternetDomainName name = InternetDomainName.from(host);
            if (name.isUnderPublicSuffix()) {
                return name.topPrivateDomain().toString();
            }
            if (name.isPublicSuffix()) {
                return null;
            }
            return name.toString();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return null;
        }
    }

    private static String extractHost(String urlOrHost)
    {
        if (!urlOrHost.startsWith("http://") && !urlOrHost.startsWith("https://")) {
            urlOrHost = "https://" + urlOrHost;
        } try {
        URI uri = URI.create(urlOrHost);
        return uri.getHost() != null ? uri.getHost() : "";
        } catch (Exception e) {
            return "";
        }
    }
}
