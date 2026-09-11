package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.platform.services.INetworkHelper;
import com.nosiphus.furniture.platform.services.IPlatformHelper;
import com.nosiphus.furniture.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class Services {

    public static final INetworkHelper NETWORK = load(INetworkHelper.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        NosiphusFurnitureMod.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}