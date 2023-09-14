package com.nosiphus.furniture.client.menu;

import com.nosiphus.furniture.blockentity.BinBlockEntity;
import com.nosiphus.furniture.core.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class BinMenu extends AbstractContainerMenu {

    public final BinBlockEntity binBlockEntity;
    private final Level level;
    private final ContainerData data;

    public BinMenu(int ID, Inventory inventory, FriendlyByteBuf extraData) {
        this(ID, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(0));
    }

    public BinMenu(int ID, Inventory inventory, BlockEntity blockEntity, ContainerData data) {

        super(ModMenuTypes.BIN_MENU.get(), ID);
        checkContainerSize(inventory, 12);
        binBlockEntity = (BinBlockEntity) blockEntity;
        this.level = inventory.player.level;
        this.data = data;

        binBlockEntity.startOpen(inventory.player);

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.binBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler,0, 62, 18));
            this.addSlot(new SlotItemHandler(iItemHandler,1, 80, 18));
            this.addSlot(new SlotItemHandler(iItemHandler, 2, 98, 18));
            this.addSlot(new SlotItemHandler(iItemHandler,3, 62, 36));
            this.addSlot(new SlotItemHandler(iItemHandler,4, 80, 36));
            this.addSlot(new SlotItemHandler(iItemHandler, 5, 98, 36));
            this.addSlot(new SlotItemHandler(iItemHandler,6, 62, 54));
            this.addSlot(new SlotItemHandler(iItemHandler,7, 80, 54));
            this.addSlot(new SlotItemHandler(iItemHandler, 8, 98, 54));
            this.addSlot(new SlotItemHandler(iItemHandler,9, 62, 72));
            this.addSlot(new SlotItemHandler(iItemHandler,10, 80, 72));
            this.addSlot(new SlotItemHandler(iItemHandler, 11, 98, 72));
        });

        addDataSlots(data);

    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.binBlockEntity.stillValid(player);
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, 115 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 173));
        }
    }

    @Override
    public void removed(Player player)
    {
        super.removed(player);
        this.binBlockEntity.stopOpen(player);
    }

}
