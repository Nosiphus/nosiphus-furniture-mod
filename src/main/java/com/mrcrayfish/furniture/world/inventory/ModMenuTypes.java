package com.mrcrayfish.furniture.world.inventory;

import com.mrcrayfish.furniture.client.mail.MailBoxEntry;
import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.FreezerBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, "cfm");

    public static final DeferredHolder<MenuType<?>, MenuType<CrateMenu>> CRATE = MENU_TYPES.register("crate",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                CrateBlockEntity crate = (CrateBlockEntity) inv.player.level().getBlockEntity(pos);
                boolean isLocked = crate != null && crate.isLocked();
                return new CrateMenu(windowId, inv, crate, isLocked);
            })
    );

    public static final DeferredHolder<MenuType<?>, MenuType<FreezerMenu>> FREEZER = MENU_TYPES.register("freezer",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                if (inv.player.level().getBlockEntity(pos) instanceof FreezerBlockEntity freezer) {
                    return new FreezerMenu(windowId, inv, freezer);
                }
                return null;
            })
    );

    public static final DeferredHolder<MenuType<?>, MenuType<MailBoxMenu>> MAIL_BOX = MENU_TYPES.register("mail_box",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                if (inv.player.level().getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox) {
                    return new MailBoxMenu(windowId, inv, mailBox);
                }
                return null;
            })
    );

    public static final DeferredHolder<MenuType<?>, MenuType<PostBoxMenu>> POST_BOX = MENU_TYPES.register("post_box",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                CompoundTag compound = data.readNbt();
                List<MailBoxEntry> entries = new ArrayList<>();
                if (compound != null && compound.contains("MailBoxes", Tag.TAG_LIST))
                {
                    ListTag mailBoxList = compound.getList("MailBoxes", Tag.TAG_COMPOUND);
                    for (int i = 0; i < mailBoxList.size(); i++)
                    {
                        entries.add(new MailBoxEntry(mailBoxList.getCompound(i)));
                    }
                }
                return new PostBoxMenu(windowId, inv, entries);
            })
    );

}
