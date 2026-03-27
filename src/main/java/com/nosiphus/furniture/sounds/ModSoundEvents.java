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
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_DOOR_BELL_RING = SOUND_EVENTS.register("block.door_bell.ring",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("nfm", "block.door_bell.ring")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_ELECTRIC_FENCE_ZAP = SOUND_EVENTS.register("block.electric_fence.zap",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("nfm", "block.electric_fence.zap")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_INFLATABLE_CASTLE_BOUNCE = SOUND_EVENTS.register("block.inflatable_castle.bounce",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("nfm", "block.inflatable_castle.bounce")));
}
