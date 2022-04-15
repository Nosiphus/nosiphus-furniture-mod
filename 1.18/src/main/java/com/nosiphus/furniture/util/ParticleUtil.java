package com.nosiphus.furniture.util;

import com.nosiphus.furniture.core.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "nfm", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleUtil
{
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(ParticleFactoryRegisterEvent event)
    {
        Minecraft.getInstance().particles.registerFactory(ModParticles.SHOWER_PARTICLE.get(), ShowerParticle.Factory::new);
    }
}