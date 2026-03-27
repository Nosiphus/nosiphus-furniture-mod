package com.nosiphus.furniture.sounds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, "nfm");

    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CHOPPING_BOARD_KNIFE_CHOP = SOUND_EVENTS.register("block.chopping_board.knife_chop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("nfm", "block.chopping_board.knife_chop")));
}
