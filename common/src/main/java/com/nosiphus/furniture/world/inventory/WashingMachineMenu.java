package com.nosiphus.furniture.world.inventory;

import com.mojang.datafixers.util.Pair;
import com.nosiphus.furniture.world.level.block.entity.WashingMachineBlockEntity;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class WashingMachineMenu extends AbstractContainerMenu {

    public static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    public static final ResourceLocation EMPTY_TOOL_SLOT_BUCKET = ResourceLocation.fromNamespaceAndPath("nfm", "item/empty_tool_slot_bucket");

    protected final WashingMachineBlockEntity blockEntity;

    public WashingMachineMenu(int id, Inventory inventory, RegistryFriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public WashingMachineMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.WASHING_MACHINE.get(), id);
        if (!(entity instanceof WashingMachineBlockEntity washingMachine)) {
            throw new IllegalStateException("This is not a washing machine.");
        }

        this.blockEntity = washingMachine;

        this.addSlot(new Slot(blockEntity, 0, 80, 44) {
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, EMPTY_ARMOR_SLOT_HELMET);
            }
        });
        this.addSlot(new Slot(blockEntity, 1, 64, 60) {
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, EMPTY_ARMOR_SLOT_CHESTPLATE);
            }
        });
        this.addSlot(new Slot(blockEntity, 2, 96, 60) {
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, EMPTY_ARMOR_SLOT_LEGGINGS);
            }
        });
        this.addSlot(new Slot(blockEntity, 3, 80, 76) {
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, EMPTY_ARMOR_SLOT_BOOTS);
            }
        });

        this.addSlot(new Slot(blockEntity, 4, 125, 7) {
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, EMPTY_TOOL_SLOT_BUCKET);
            }
        });

        this.addSlot(new Slot(blockEntity, 5, 125, 30));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; ++j) {
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

    public int getFluidType() {
        if (blockEntity.getFluid() == ModFluids.SOAPY_WATER.get()) {
            return 192;
        } else if (blockEntity.getFluid() == ModFluids.SUPER_SOAPY_WATER.get()) {
            return 212;
        }
        return 0;
    }

    public int getFluidRenderAmount() {
        int actualAmount = blockEntity.getFluidAmount();
        int maxAmount = blockEntity.getCapacity();
        int barHeight = 73;
        return actualAmount > 0 ? Math.max(1, actualAmount * barHeight / maxAmount) : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack clickedStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            clickedStack = slotStack.copy();

            if (index < 6) {
                if (!this.moveItemStackTo(slotStack, 6, 42, true)) {
                    return ItemStack.EMPTY;
                }
            }
            else {
                if (clickedStack.getItem() instanceof ArmorItem) {
                    if (!this.moveItemStackTo(slotStack, 0, 4, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (!this.moveItemStackTo(slotStack, 4, 5, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return clickedStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity.stillValid(player);
    }

    public WashingMachineBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}