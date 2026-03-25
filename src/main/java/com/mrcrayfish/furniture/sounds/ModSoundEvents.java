package com.mrcrayfish.furniture.sounds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, "cfm");

    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BEDSIDE_CABINET_OPEN = SOUND_EVENTS.register("block.bedside_cabinet.open",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.bedside_cabinet.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BEDSIDE_CABINET_CLOSE = SOUND_EVENTS.register("block.bedside_cabinet.close",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.bedside_cabinet.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLINDS_OPEN = SOUND_EVENTS.register("block.blinds.open",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.blinds.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLINDS_CLOSE = SOUND_EVENTS.register("block.blinds.close",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.blinds.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CABINET_OPEN = SOUND_EVENTS.register("block.cabinet.open",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.cabinet.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CABINET_CLOSE = SOUND_EVENTS.register("block.cabinet.close",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.cabinet.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_DIVING_BOARD_BOUNCE = SOUND_EVENTS.register("block.diving_board.bounce",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.diving_board.bounce")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_FRIDGE_OPEN = SOUND_EVENTS.register("block.fridge.open",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.fridge.open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_FRIDGE_CLOSE = SOUND_EVENTS.register("block.fridge.close",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.fridge.close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_GRILL_FLIP = SOUND_EVENTS.register("block.grill.flip",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.grill.flip")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_GRILL_PLACE = SOUND_EVENTS.register("block.grill.place",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.grill.place")));
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TRAMPOLINE_BOUNCE = SOUND_EVENTS.register("block.trampoline.bounce",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("cfm", "block.trampoline.bounce")));

}
