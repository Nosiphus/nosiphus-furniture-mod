package com.nosiphus.furniture.world.entity;

import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.entity.decoration.SeatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntityTypes {

    public static void init() {

    }

    private static <T extends EntityType<?>> Supplier<T> register(String name, Supplier<T> entityTypeSupplier) {
        return Services.REGISTRY.registerEntityType(name, entityTypeSupplier);
    }

    public static final Supplier<EntityType<SeatEntity>> SEAT = register("seat",
            () -> EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
                    .sized(0.0F, 0.0F)
                    .noSave()
                    .noSummon()
                    .build("seat"));

}