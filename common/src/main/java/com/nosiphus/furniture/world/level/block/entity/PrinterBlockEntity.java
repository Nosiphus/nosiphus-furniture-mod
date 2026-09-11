package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.PrinterMenu;
import com.nosiphus.furniture.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PrinterBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 1000;

    public PrinterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.PRINTER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PrinterBlockEntity.this.progress;
                    case 1 -> PrinterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PrinterBlockEntity.this.progress = value;
                    case 1 -> PrinterBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() { return 2; }
        };
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public Component getDisplayName() { return Component.translatable("container.nfm.printer"); }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new PrinterMenu(id, inventory, this, this.data);
    }

    @Override
    public int getContainerSize() { return this.inventory.size(); }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) { return this.inventory.get(index); }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack stack = ContainerHelper.removeItem(this.inventory, index, count);
        if (!stack.isEmpty()) this.markUpdated();
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (stack.getCount() > this.getMaxStackSize()) stack.setCount(this.getMaxStackSize());
        this.markUpdated();
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return switch (slot) {
            case 0 -> stack.is(ModItems.INK_CARTRIDGE.get());
            case 1 -> isPrintableBook(stack);
            default -> false;
        };
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
        this.markUpdated();
    }

    @Override
    public int[] getSlotsForFace(Direction side) { return new int[]{0, 1, 2}; }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return index == 2;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putInt("printer.progress", this.progress);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory);
        this.progress = tag.getInt("printer.progress");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void drops() {
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, this);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PrinterBlockEntity printer) {
        if (level.isClientSide) return;

        if (printer.canCopy()) {
            if (printer.progress == 0) {
                int charCount = printer.getBookCharacterCount(printer.getItem(1));
                printer.maxProgress = Math.max(40, charCount / 10);
            }

            printer.progress++;
            if (printer.progress >= printer.maxProgress) {
                printer.copyBook();
                printer.progress = 0;
            }
            printer.setChanged();
        } else {
            if (printer.progress > 0) {
                printer.progress = 0;
                printer.markUpdated();
            }
        }
    }

    public static boolean isPrintableBook(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(Items.WRITABLE_BOOK) || stack.is(Items.WRITTEN_BOOK);
    }

    private int getBookCharacterCount(ItemStack stack) {
        if (stack.isEmpty() || !stack.hasTag()) return 0;

        CompoundTag tag = stack.getTag();
        if (tag == null || !tag.contains("pages", Tag.TAG_LIST)) return 0;

        int count = 0;
        ListTag pages = tag.getList("pages", Tag.TAG_STRING);

        if (stack.is(Items.WRITTEN_BOOK)) {
            for (int i = 0; i < pages.size(); i++) {
                try {
                    Component comp = Component.Serializer.fromJson(pages.getString(i));
                    if (comp != null) count += comp.getString().length();
                } catch (Exception ignored) {
                    count += pages.getString(i).length();
                }
            }
        } else {
            for (int i = 0; i < pages.size(); i++) {
                count += pages.getString(i).length();
            }
        }

        return count;
    }

    private void copyBook() {
        ItemStack input = getItem(1);
        ItemStack output = getItem(2);

        int inkCost = Math.max(1, getBookCharacterCount(input));

        ItemStack inkStack = getItem(0);
        if (!inkStack.isEmpty() && this.level != null) {
            inkStack.hurt(inkCost, this.level.random, null);
        }

        ItemStack copy = input.copy();
        copy.setCount(1);

        if (output.isEmpty()) {
            setItem(2, copy);
        } else {
            output.grow(1);
        }

        this.progress = 0;
        this.markUpdated();
    }

    private boolean canCopy() {
        ItemStack ink = getItem(0);
        ItemStack input = getItem(1);
        ItemStack output = getItem(2);

        if (input.isEmpty() || !isPrintableBook(input) || ink.isEmpty() || !ink.is(ModItems.INK_CARTRIDGE.get())) {
            return false;
        }

        int charCount = Math.max(1, getBookCharacterCount(input));
        int remainingInk = ink.getMaxDamage() - ink.getDamageValue();
        if (remainingInk < charCount) {
            return false;
        }

        if (output.isEmpty()) return true;
        return ItemStack.isSameItem(input, output) &&
                ItemStack.matches(input, output) &&
                output.getCount() < output.getMaxStackSize();
    }
}