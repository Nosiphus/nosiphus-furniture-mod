package com.nosiphus.furniture.world.inventory;

import com.mojang.datafixers.util.Pair;
import com.nosiphus.furniture.world.level.block.entity.DishwasherBlockEntity;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DishwasherMenu extends AbstractContainerMenu {

    public static final ResourceLocation EMPTY_TOOL_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    public static final ResourceLocation EMPTY_TOOL_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    public static final ResourceLocation EMPTY_TOOL_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    public static final ResourceLocation EMPTY_TOOL_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    public static final ResourceLocation EMPTY_TOOL_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_SHIELD = new ResourceLocation("item/empty_armor_slot_shield");
    public static final ResourceLocation EMPTY_TOOL_SLOT_BUCKET = new ResourceLocation("nfm", "item/empty_tool_slot_bucket");

    protected final DishwasherBlockEntity blockEntity;

    public DishwasherMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public DishwasherMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.DISHWASHER.get(), id);
        if (!(entity instanceof DishwasherBlockEntity dishwasher)) {
            throw new IllegalStateException("This block entity is not a dishwasher.");
        }

        this.blockEntity = dishwasher;

        this.addSlot(new ToolSlot(blockEntity, 0, 56, 43, EMPTY_TOOL_SLOT_PICKAXE));
        this.addSlot(new ToolSlot(blockEntity, 1, 80, 43, EMPTY_TOOL_SLOT_SHOVEL));
        this.addSlot(new ToolSlot(blockEntity, 2, 104, 43, EMPTY_TOOL_SLOT_SWORD));
        this.addSlot(new ToolSlot(blockEntity, 3, 56, 74, EMPTY_TOOL_SLOT_AXE));
        this.addSlot(new ToolSlot(blockEntity, 4, 80, 74, EMPTY_TOOL_SLOT_HOE));
        this.addSlot(new ToolSlot(blockEntity, 5, 104, 74, EMPTY_ARMOR_SLOT_SHIELD));

        this.addSlot(new ToolSlot(blockEntity, 6, 125, 7, EMPTY_TOOL_SLOT_BUCKET));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 146));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, i * 18 + 8, 204));
        }
    }

    public int getFluidAmount() {
        return blockEntity.getFluidAmount();
    }

    public boolean getWashing() {
        return blockEntity.isWashing();
    }

    public int getFluidTypeYOffset() {
        if (blockEntity.getFluid() == ModFluids.SOAPY_WATER.get()) return 185;
        if (blockEntity.getFluid() == ModFluids.SUPER_SOAPY_WATER.get()) return 199;
        return 0;
    }

    public int getFluidRenderHeight() {
        return (int) (blockEntity.getFluidAmount() * 55L / 64000L);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();
            if (index < 7) {
                if (!this.moveItemStackTo(slotStack, 7, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, 7, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity.stillValid(player);
    }

    public DishwasherBlockEntity getBlockEntity() { return blockEntity; }

    private static class ToolSlot extends Slot {
        private final ResourceLocation icon;

        public ToolSlot(Container container, int index, int x, int y, ResourceLocation icon) {
            super(container, index, x, y);
            this.icon = icon;
        }

        @Override
        public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
            return Pair.of(InventoryMenu.BLOCK_ATLAS, icon);
        }
    }
}