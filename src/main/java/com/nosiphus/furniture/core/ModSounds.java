package com.nosiphus.furniture.core;

import com.nosiphus.furniture.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: MrCrayfish, Nosiphus
 */
public class ModSounds
{
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

    public static final RegistryObject<SoundEvent> BLOCK_MICROWAVE_FINISH = register("block.microwave.finish");
    public static final RegistryObject<SoundEvent> BLOCK_MICROWAVE_RUNNING = register("block.microwave.running");
    public static final RegistryObject<SoundEvent> BLOCK_SHOWER_RUNNING = register("block.shower.running");
    public static final RegistryObject<SoundEvent> BLOCK_TOILET_FART = register("block.toilet.fart");
    public static final RegistryObject<SoundEvent> BLOCK_TOILET_FLUSH = register("block.toilet.flush");

    private static RegistryObject<SoundEvent> register(String name)
    {
        return REGISTER.register(name, () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, name)));
    }
}