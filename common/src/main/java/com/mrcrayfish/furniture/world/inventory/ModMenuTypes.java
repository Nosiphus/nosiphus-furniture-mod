package com.mrcrayfish.furniture.world.inventory;

import com.mrcrayfish.furniture.client.mail.MailBoxEntry;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.FreezerBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.inventory.MenuType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModMenuTypes {

    public static void init() {}

    private static <T extends MenuType<?>> Supplier<T> register(String name, Supplier<T> menuTypeSupplier) {
        return Services.REGISTRY.registerMenuType(name, menuTypeSupplier);
    }

    public static final Supplier<MenuType<CrateMenu>> CRATE = register("crate", () ->
            Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                CrateBlockEntity crate = (CrateBlockEntity) inv.player.level().getBlockEntity(pos);
                boolean isLocked = crate != null && crate.isLocked();
                return new CrateMenu(windowId, inv, crate, isLocked);
            })
    );

    public static final Supplier<MenuType<FreezerMenu>> FREEZER = register("freezer", () ->
            Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                if (inv.player.level().getBlockEntity(pos) instanceof FreezerBlockEntity freezer) {
                    return new FreezerMenu(windowId, inv, freezer);
                }
                return null;
            })
    );

    public static final Supplier<MenuType<MailBoxMenu>> MAIL_BOX = register("mail_box", () ->
            Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                if (inv.player.level().getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox) {
                    return new MailBoxMenu(windowId, inv, mailBox);
                }
                return null;
            })
    );

    public static final Supplier<MenuType<PostBoxMenu>> POST_BOX = register("post_box", () ->
            Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                CompoundTag compound = data.readNbt();
                List<MailBoxEntry> entries = new ArrayList<>();
                if (compound != null && compound.contains("MailBoxes", Tag.TAG_LIST)) {
                    ListTag mailBoxList = compound.getList("MailBoxes", Tag.TAG_COMPOUND);
                    for (int i = 0; i < mailBoxList.size(); i++) {
                        entries.add(new MailBoxEntry(mailBoxList.getCompound(i)));
                    }
                }
                return new PostBoxMenu(windowId, inv, entries);
            })
    );
}