package com.nosiphus.furniture.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "nfm");

    public static final RegistryObject<SoundEvent> BLOCK_MICROWAVE_FINISH = register("block.microwave.finish");
    public static final RegistryObject<SoundEvent> BLOCK_MICROWAVE_RUNNING = register("block.microwave.running");
    public static final RegistryObject<SoundEvent> BLOCK_SHOWER_RUNNING = register("block.shower.running");
    public static final RegistryObject<SoundEvent> BLOCK_TOILET_FART = register("block.toilet.fart");
    public static final RegistryObject<SoundEvent> BLOCK_TOILET_FLUSH = register("block.toilet.flush");

    private static RegistryObject<SoundEvent> register(String name)
    {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation("nfm", name)));
    }

}
