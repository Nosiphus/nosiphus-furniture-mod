package com.nosiphus.furniture.client.particle;

import com.nosiphus.furniture.platform.Services;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class ModParticleTypes {

    public static final Supplier<SimpleParticleType> SHOWER = Services.REGISTRY.registerParticleType("shower", () -> new SimpleParticleType(false));

    public static void init() {}
}