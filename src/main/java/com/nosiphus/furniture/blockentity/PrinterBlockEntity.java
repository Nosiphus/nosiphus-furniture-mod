package com.nosiphus.furniture.blockentity;

import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModItems;
import com.nosiphus.furniture.inventory.container.PrinterMenu;
import com.nosiphus.furniture.item.crafting.PrintingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PrinterBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    public PrinterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PRINTER.get(), pos, state);
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
            public int getCount() {
                return 2;
            }
        };
    }

    public int getContainerSize() {
        return 3;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.printer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new PrinterMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("printer.progress", this.progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("printer.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PrinterBlockEntity blockEntity) {
        if(level != null) {
            if(level.isClientSide()) {
                return;
            }

            if(canCopy(blockEntity, 1, 2)) {
                blockEntity.progress++;
                setChanged(level, pos, state);
                if(blockEntity.progress >= blockEntity.maxProgress) {
                    copyBook(blockEntity, 1, 2);
                }
            } else {
                blockEntity.resetProgress();
                setChanged(level, pos, state);
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void copyBook(PrinterBlockEntity blockEntity, int inputSlot, int outputSlot) {
        if (canCopy(blockEntity, inputSlot, outputSlot)) {
            ItemStack inputStack = blockEntity.itemHandler.getStackInSlot(inputSlot);
            ItemStack outputStack = blockEntity.itemHandler.getStackInSlot(outputSlot);
            ItemStack newOutputStack = new ItemStack(inputStack.getItem(), outputStack.getCount() + 1);
            newOutputStack.setTag(inputStack.getTag());
            blockEntity.itemHandler.setStackInSlot(outputSlot, newOutputStack);
            blockEntity.resetProgress();
        }
    }

    private static boolean canCopy(PrinterBlockEntity blockEntity, int inputSlot, int outputSlot) {
        ItemStack inputStack = blockEntity.itemHandler.getStackInSlot(inputSlot);
        ItemStack outputStack = blockEntity.itemHandler.getStackInSlot(outputSlot);
        ItemStack inkStack = blockEntity.itemHandler.getStackInSlot(0);

        boolean hasInkCartridge = !inkStack.isEmpty() && inkStack.getItem() == ModItems.INK_CARTRIDGE.get();
        boolean canStackInOutput = outputStack.isEmpty() ||
                (ItemStack.isSameItemSameTags(inputStack, outputStack) && outputStack.getCount() < outputStack.getMaxStackSize());

        return !inputStack.isEmpty() && hasInkCartridge && canStackInOutput;
    }

    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return !(player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) > 64.0D);
        }
    }

}
