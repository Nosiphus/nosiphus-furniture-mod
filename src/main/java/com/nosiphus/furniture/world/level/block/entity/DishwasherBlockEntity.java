package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.network.protocol.common.ClientboundDishwasherSync;
import com.nosiphus.furniture.world.inventory.DishwasherMenu;
import com.nosiphus.furniture.world.level.material.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DishwasherBlockEntity extends BlockEntity implements MenuProvider {

    private boolean washing = false;

    private final ItemStackHandler itemHandler = new ItemStackHandler(8) {
        @Override
        protected void onContentsChanged(int slot) {
            markUpdated();
            syncToTracking();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getItem() instanceof PickaxeItem;
                case 1 -> stack.getItem() instanceof ShovelItem;
                case 2 -> stack.getItem() instanceof SwordItem;
                case 3 -> stack.getItem() instanceof AxeItem;
                case 4 -> stack.getItem() instanceof HoeItem;
                case 5 -> stack.getItem() instanceof ShieldItem;
                case 6 -> stack.getCapability(Capabilities.FluidHandler.ITEM) != null;
                default -> true;
            };
        }
    };

    private final FluidTank fluidTank = new FluidTank(64000) {
        @Override
        protected void onContentsChanged() {
            markUpdated();
            syncToTracking();
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            boolean isSoapy = stack.is(ModFluids.SOAPY_WATER.get()) ||
                    stack.is(ModFluids.SUPER_SOAPY_WATER.get());

            if (!isSoapy) return false;

            if (!this.getFluid().isEmpty()) {
                return this.getFluid().is(stack.getFluid());
            }

            return true;
        }
    };

    public DishwasherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DISHWASHER.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public void syncToTracking() {
        if (this.level instanceof ServerLevel serverLevel) {
            PacketDistributor.sendToPlayersTrackingChunk(
                    serverLevel,
                    new ChunkPos(this.worldPosition),
                    new ClientboundDishwasherSync(this.getFluidStack(), this.worldPosition, this.washing)
            );
        }
    }

    public IItemHandler getItemHandler() { return itemHandler; }
    public IFluidHandler getTank() { return fluidTank; }
    public FluidStack getFluidStack() { return fluidTank.getFluid(); }
    public boolean isWashing() { return washing; }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.dishwasher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        this.syncToTracking();
        return new DishwasherMenu(id, inventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.put("FluidTank", fluidTank.writeToNBT(registries, new CompoundTag()));
        tag.putBoolean("Washing", washing);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        fluidTank.readFromNBT(registries, tag.getCompound("FluidTank"));
        washing = tag.getBoolean("Washing");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DishwasherBlockEntity dishwasher) {
        if (level.isClientSide) return;

        ItemStack fluidItem = dishwasher.itemHandler.getStackInSlot(6);
        if (!fluidItem.isEmpty()) {
            IFluidHandler handler = fluidItem.getCapability(Capabilities.FluidHandler.ITEM);
            if (handler instanceof IFluidHandlerItem itemFluid) {
                FluidStack contained = itemFluid.getFluidInTank(0);
                if (!contained.isEmpty() && dishwasher.fluidTank.isFluidValid(contained)) {
                    int space = dishwasher.fluidTank.getSpace();
                    if (space > 0) {
                        FluidStack drained = itemFluid.drain(Math.min(space, 1000), IFluidHandler.FluidAction.EXECUTE);
                        dishwasher.fluidTank.fill(drained, IFluidHandler.FluidAction.EXECUTE);
                        dishwasher.itemHandler.setStackInSlot(6, itemFluid.getContainer());
                    }
                }
            }
        }

        boolean hasWorked = false;
        boolean currentlyRepairing = false;

        for (int i = 0; i < 6; i++) {
            ItemStack tool = dishwasher.itemHandler.getStackInSlot(i);
            if (tool.isDamaged() && dishwasher.fluidTank.getFluidAmount() > 0) {
                currentlyRepairing = true;
                int cost = dishwasher.fluidTank.getFluid().is(ModFluids.SUPER_SOAPY_WATER.get()) ? 10 : 20;

                if (dishwasher.fluidTank.getFluidAmount() >= cost) {
                    tool.setDamageValue(tool.getDamageValue() - 1);
                    dishwasher.fluidTank.drain(cost, IFluidHandler.FluidAction.EXECUTE);
                    hasWorked = true;
                }
            }
        }

        if (dishwasher.washing != currentlyRepairing) {
            dishwasher.washing = currentlyRepairing;
            dishwasher.markUpdated();
            dishwasher.syncToTracking();
        }

        if (hasWorked) {
            dishwasher.markUpdated();
            dishwasher.syncToTracking();
        }
    }

    public void setFluid(FluidStack stack) {
        this.fluidTank.setFluid(stack);
    }

    public void setWashing(boolean washing) {
        this.washing = washing;
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
}