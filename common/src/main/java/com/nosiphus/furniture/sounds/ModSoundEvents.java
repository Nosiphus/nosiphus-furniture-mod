package com.nosiphus.furniture.sounds;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSoundEvents {

    public static void init() {

    }

    private static Supplier<SoundEvent> register(String name) {
        return Services.REGISTRY.registerSoundEvent(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(NosiphusFurnitureMod.MOD_ID, name)));
    }

    public static final Supplier<SoundEvent> BLOCK_BIN_OPEN = register("block.bin.open");
    public static final Supplier<SoundEvent> BLOCK_BIN_CLOSE = register("block.bin.close");
    public static final Supplier<SoundEvent> BLOCK_CHOPPING_BOARD_KNIFE_CHOP = register("block.chopping_board.knife_chop");
    public static final Supplier<SoundEvent> BLOCK_DOOR_BELL_RING = register("block.door_bell.ring");
    public static final Supplier<SoundEvent> BLOCK_ELECTRIC_FENCE_ZAP = register("block.electric_fence.zap");
    public static final Supplier<SoundEvent> BLOCK_FIRE_ALARM_BEEP = register("block.fire_alarm.beep");
    public static final Supplier<SoundEvent> BLOCK_INFLATABLE_CASTLE_BOUNCE = register("block.inflatable_castle.bounce");
    public static final Supplier<SoundEvent> BLOCK_MICROWAVE_FINISH = register("block.microwave.finish");
    public static final Supplier<SoundEvent> BLOCK_MICROWAVE_RUNNING = register("block.microwave.running");
    public static final Supplier<SoundEvent> BLOCK_SHOWER_RUNNING = register("block.shower.running");
    public static final Supplier<SoundEvent> BLOCK_TAP_RUNNING = register("block.tap.running");

}