package com.nosiphus.furniture.core;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "nfm");

    public static final RegistryObject<SimpleParticleType> SHOWER_PARTICLE = PARTICLES.register("shower_particle",
            () -> new SimpleParticleType(true));

}
