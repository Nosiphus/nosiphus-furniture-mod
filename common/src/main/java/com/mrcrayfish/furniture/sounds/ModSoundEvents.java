package com.mrcrayfish.furniture.sounds;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSoundEvents {

    public static void init() {

    }

    public static final Supplier<SoundEvent> BLOCK_BEDSIDE_CABINET_OPEN = register("block.bedside_cabinet.open");
    public static final Supplier<SoundEvent> BLOCK_BEDSIDE_CABINET_CLOSE = register("block.bedside_cabinet.close");
    public static final Supplier<SoundEvent> BLOCK_BLINDS_OPEN = register("block.blinds.open");
    public static final Supplier<SoundEvent> BLOCK_BLINDS_CLOSE = register("block.blinds.close");
    public static final Supplier<SoundEvent> BLOCK_CABINET_OPEN = register("block.cabinet.open");
    public static final Supplier<SoundEvent> BLOCK_CABINET_CLOSE = register("block.cabinet.close");
    public static final Supplier<SoundEvent> BLOCK_DIVING_BOARD_BOUNCE = register("block.diving_board.bounce");
    public static final Supplier<SoundEvent> BLOCK_FRIDGE_OPEN = register("block.fridge.open");
    public static final Supplier<SoundEvent> BLOCK_FRIDGE_CLOSE = register("block.fridge.close");
    public static final Supplier<SoundEvent> BLOCK_GRILL_FLIP = register("block.grill.flip");
    public static final Supplier<SoundEvent> BLOCK_GRILL_PLACE = register("block.grill.place");
    public static final Supplier<SoundEvent> BLOCK_TRAMPOLINE_BOUNCE = register("block.trampoline.bounce");

    private static Supplier<SoundEvent> register(String name) {
        return Services.REGISTRY.registerSoundEvent(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, name)));
    }

}