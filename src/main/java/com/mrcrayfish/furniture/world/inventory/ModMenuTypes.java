package com.mrcrayfish.furniture.world.inventory;

import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, "cfm");

    public static final DeferredHolder<MenuType<?>, MenuType<CrateMenu>> CRATE = MENU_TYPES.register("crate",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                CrateBlockEntity crate = (CrateBlockEntity) inv.player.level().getBlockEntity(pos);
                boolean isLocked = crate != null && crate.isLocked();
                return new CrateMenu(windowId, inv, crate, isLocked);
            })
    );

}
