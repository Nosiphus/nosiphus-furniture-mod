package com.nosiphus.furniture.network;

import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;
import com.nosiphus.furniture.FurnitureConfig;

import java.net.URI;
import java.util.List;
import java.util.Locale;

public class UrlValidator {

    /**
     * Validates a URL entry in the Common config (used by both Forge and Fabric configs).
     * Requires a valid HTTPS URI with a non-null host.
     */
    public static boolean isValidUrlFormat(String url) {
        if (url == null || url.isBlank()) {
            return false;
        }
        try {
            URI uri = URI.create(url.trim());
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return scheme != null && scheme.equalsIgnoreCase("https") && host != null && !host.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates a server address entry in the Client config (used by both Forge and Fabric configs).
     * Accepts:
     *  - IPv4 or IPv4:port (e.g. "192.168.1.1" or "192.168.1.1:25565")
     *  - Bracketed IPv6 or [IPv6]:port (e.g. "[::1]" or "[::1]:25565")
     *  - DNS domain or domain:port (e.g. "vi.nosiphus.com" or "server.example.com:25565")
     */
    public static boolean isValidAddressFormat(String address) {
        if (address == null || address.isBlank()) {
            return false;
        }
        String trimmed = address.trim();
        if (trimmed.contains("://") || trimmed.contains("/")) {
            return false;
        }

        try {
            HostAndPort parsed = HostAndPort.fromString(trimmed);
            String host = parsed.getHost();
            if (host.isEmpty()) {
                return false;
            }

            if (parsed.hasPort()) {
                int port = parsed.getPort();
                if (port < 1 || port > 65535) {
                    return false;
                }
            }

            if (InetAddresses.isInetAddress(host)) {
                return true;
            }

            return InternetDomainName.isValid(host) && !host.endsWith(".");
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Normalizes raw user input from the GUI or network packet BEFORE saving it to the BlockEntity.
     */
    public static String normalizeUrl(String rawUrl) {
        if (rawUrl == null || rawUrl.isBlank()) {
            return "";
        }
        String trimmed = rawUrl.trim();
        String lower = trimmed.toLowerCase(Locale.ROOT);
        if (lower.startsWith("http://")) {
            return "";
        }
        if (!lower.startsWith("https://")) {
            trimmed = "https://" + trimmed;
        }
        try {
            URI uri = URI.create(trimmed);
            if (uri.getScheme() == null || !uri.getScheme().equalsIgnoreCase("https") || uri.getHost() == null) {
                return "";
            }
            if (uri.getRawFragment() != null) {
                uri = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), uri.getQuery(), null);
            }
            return uri.toASCIIString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Called on the SERVER when a player sets a TV URL (or on the client when not exempt).
     */
    public static boolean isTrustedUrl(String urlString) {
        String inputHost = parseAndValidateGifHost(urlString);
        if (inputHost == null) {
            return false;
        }
        return matchesAnyUrlInList(inputHost, FurnitureConfig.getTrustedUrls());
    }

    /**
     * Called on the CLIENT by GifFrameCache before downloading a GIF.
     *
     * @param urlString       The normalized HTTPS URL of the GIF.
     * @param currentServerIp The address string from Minecraft.getInstance().getCurrentServer().ip (may be null in Singleplayer).
     */
    public static boolean isClientTrustedUrl(String urlString, String currentServerIp) {
        String inputHost = parseAndValidateGifHost(urlString);
        if (inputHost == null) {
            return false;
        }

        // If connected to a server on the client's trustedServers allowlist, exempt from the domain check
        if (isServerTrusted(currentServerIp)) {
            return true;
        }

        return matchesAnyUrlInList(inputHost, FurnitureConfig.getTrustedUrls());
    }

    /**
     * Checks if the given server address matches an entry in the client's trustedServers config.
     * Does not assume port 25565 when no port is specified.
     */
    public static boolean isServerTrusted(String currentServerIp) {
        if (currentServerIp == null || currentServerIp.isBlank()) {
            return false;
        }

        List<String> trustedServers = FurnitureConfig.getTrustedServers();
        if (trustedServers == null || trustedServers.isEmpty()) {
            return false;
        }

        HostAndPort currentServer;
        try {
            currentServer = HostAndPort.fromString(currentServerIp.trim());
        } catch (IllegalArgumentException e) {
            return false;
        }

        String currentHost = currentServer.getHost().toLowerCase(Locale.ROOT);

        for (String entry : trustedServers) {
            if (entry == null || entry.isBlank()) {
                continue;
            }
            String trimmedEntry = entry.trim();
            if (!isValidAddressFormat(trimmedEntry)) {
                continue;
            }

            try {
                HostAndPort allowed = HostAndPort.fromString(trimmedEntry);
                String allowedHost = allowed.getHost().toLowerCase(Locale.ROOT);

                // If the config entry specifies a port, require an exact port match.
                // If the config entry has NO port, match any port on that host.
                if (allowed.hasPort()) {
                    if (!currentServer.hasPort() || currentServer.getPort() != allowed.getPort()) {
                        continue;
                    }
                }

                if (serverHostMatches(currentHost, allowedHost)) {
                    return true;
                }
            } catch (IllegalArgumentException ignored) {}
        }

        return false;
    }

    private static boolean serverHostMatches(String currentHost, String allowedHost) {
        if (currentHost.equals(allowedHost)) {
            return true;
        }
        if (InetAddresses.isInetAddress(currentHost) && InetAddresses.isInetAddress(allowedHost)) {
            return InetAddresses.forString(currentHost).equals(InetAddresses.forString(allowedHost));
        }
        if (!InetAddresses.isInetAddress(currentHost) && !InetAddresses.isInetAddress(allowedHost)) {
            try {
                InternetDomainName domain = InternetDomainName.from(allowedHost);
                if (domain.isUnderPublicSuffix() && currentHost.endsWith("." + allowedHost)) {
                    return true;
                }
            } catch (IllegalArgumentException ignored) {}
        }
        return false;
    }

    private static String parseAndValidateGifHost(String urlString) {
        if (urlString == null || urlString.isBlank() || !urlString.equals(urlString.trim())) {
            return null;
        }
        try {
            URI uri = URI.create(urlString);
            String scheme = uri.getScheme();
            String host = uri.getHost();

            if (scheme == null || !scheme.equalsIgnoreCase("https") || host == null || host.isEmpty()) {
                return null;
            }
            if (uri.getUserInfo() != null
                    || (uri.getPort() != -1 && uri.getPort() != 443)
                    || host.endsWith(".")
                    || uri.getRawFragment() != null) {
                return null;
            }
            return host.toLowerCase(Locale.ROOT);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean matchesAnyUrlInList(String inputHost, List<? extends String> allowedUrls) {
        if (allowedUrls == null) {
            return false;
        }
        for (String allowed : allowedUrls) {
            if (allowed == null || allowed.isBlank()) {
                continue;
            }
            String allowedHost = extractHost(allowed.trim().toLowerCase(Locale.ROOT));
            if (!allowedHost.isEmpty() && gifHostMatches(inputHost, allowedHost)) {
                return true;
            }
        }
        return false;
    }

    private static boolean gifHostMatches(String inputHost, String allowedHost) {
        try {
            InternetDomainName allowedDomain = InternetDomainName.from(allowedHost);
            if (allowedDomain.isPublicSuffix() || !allowedDomain.isUnderPublicSuffix()) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return inputHost.equals(allowedHost) || inputHost.endsWith("." + allowedHost);
    }

    private static String extractHost(String urlOrHost) {
        if (!urlOrHost.startsWith("http://") && !urlOrHost.startsWith("https://")) {
            urlOrHost = "https://" + urlOrHost;
        }
        try {
            URI uri = URI.create(urlOrHost);
            String host = uri.getHost();
            if (host == null) {
                return "";
            }
            return host.startsWith("www.") ? host.substring(4) : host;
        } catch (Exception e) {
            return "";
        }
    }
}
