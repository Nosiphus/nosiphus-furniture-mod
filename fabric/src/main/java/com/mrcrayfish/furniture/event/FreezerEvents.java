package com.mrcrayfish.furniture.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class FreezerEvents {

    public static final Event<FreezerFuelTime> FREEZER_FUEL_TIME = EventFactory.createArrayBacked(FreezerFuelTime.class,
            listeners -> (stack, currentFuel) -> {
                int fuel = currentFuel;
                for (FreezerFuelTime listener : listeners) {
                    fuel = listener.getFuelTime(stack, fuel);
                }
                return fuel;
            });

    public static final Event<ItemSolidify> ITEM_SOLIDIFY = EventFactory.createArrayBacked(ItemSolidify.class,
            listeners -> (player, stack) -> {
                for (ItemSolidify listener : listeners) {
                    listener.onSolidify(player, stack);
                }
            });

    @FunctionalInterface
    public interface FreezerFuelTime {
        int getFuelTime(ItemStack stack, int currentFuel);
    }

    @FunctionalInterface
    public interface ItemSolidify {
        void onSolidify(Player player, ItemStack stack);
    }
}