package com.nosiphus.furniture.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticleTypes {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, "nfm");

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHOWER = PARTICLE_TYPES.register("shower", () -> new SimpleParticleType(false));

}
