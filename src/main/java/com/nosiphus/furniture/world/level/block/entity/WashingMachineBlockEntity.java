package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.network.protocol.common.ClientboundDishwasherSync;
import com.nosiphus.furniture.network.protocol.common.ClientboundWashingMachineSync;
import com.nosiphus.furniture.world.inventory.WashingMachineMenu;
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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WashingMachineBlockEntity extends BlockEntity implements MenuProvider {

    private boolean washing = false;

    public final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            markUpdated();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch(slot) {
                case 0, 1, 2, 3 -> stack.getItem() instanceof ArmorItem;
                case 4 -> stack.getCapability(Capabilities.FluidHandler.ITEM) != null;
                default -> true;
            };
        }
    };

    public final FluidTank fluidTank = new FluidTank(64000) {
        @Override
        protected void onContentsChanged() {
            markUpdated();
            syncToTracking();
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            return stack.is(ModFluids.SOAPY_WATER.get()) || stack.is(ModFluids.SUPER_SOAPY_WATER.get());
        }
    };

    public WashingMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.WASHING_MACHINE.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    private void syncToTracking() {
        if (this.level instanceof ServerLevel serverLevel) {
            PacketDistributor.sendToPlayersTrackingChunk(
                    serverLevel,
                    new ChunkPos(this.worldPosition),
                    new ClientboundWashingMachineSync(this.getFluidStack(), this.worldPosition, this.washing)
            );
        }
    }

    public IItemHandler getItemHandler() { return itemHandler; }
    public IFluidHandler getTank() { return fluidTank; }
    public FluidStack getFluidStack() { return fluidTank.getFluid(); }
    public boolean isWashing() { return washing; }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.washing_machine");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        syncToTracking();
        return new WashingMachineMenu(id, inventory, this);
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

    public static void tick(Level level, BlockPos pos, BlockState state, WashingMachineBlockEntity washingMachine) {
        if (level.isClientSide) return;

        if (!washingMachine.itemHandler.getStackInSlot(4).isEmpty()) {
            transferFluidFromItem(washingMachine);
        }

        boolean wasWashing = washingMachine.washing;
        washingMachine.washing = false;

        for (int i = 0; i < 4; i++) {
            if (shouldRepair(washingMachine, i)) {
                washingMachine.washing = true;
                performRepair(washingMachine, i);
            }
        }

        if (wasWashing != washingMachine.washing) {
            washingMachine.markUpdated();
            washingMachine.syncToTracking();
        }
    }

    private static void transferFluidFromItem(WashingMachineBlockEntity washingMachine) {
        ItemStack inputStack = washingMachine.itemHandler.getStackInSlot(4);
        var itemFluidHandler = inputStack.getCapability(Capabilities.FluidHandler.ITEM);

        if (itemFluidHandler != null) {
            int space = washingMachine.fluidTank.getSpace();
            FluidStack drained = itemFluidHandler.drain(space, IFluidHandler.FluidAction.SIMULATE);

            if (!drained.isEmpty() && washingMachine.fluidTank.isFluidValid(drained)) {
                drained = itemFluidHandler.drain(space, IFluidHandler.FluidAction.EXECUTE);
                washingMachine.fluidTank.fill(drained, IFluidHandler.FluidAction.EXECUTE);
                washingMachine.itemHandler.setStackInSlot(4, itemFluidHandler.getContainer());
            }
        }
    }

    private static boolean shouldRepair(WashingMachineBlockEntity washingMachine, int slot) {
        ItemStack stack = washingMachine.itemHandler.getStackInSlot(slot);
        if (stack.isEmpty() || !stack.isDamaged()) return false;

        int cost = washingMachine.fluidTank.getFluid().is(ModFluids.SUPER_SOAPY_WATER.get()) ? 10 : 20;
        return washingMachine.fluidTank.getFluidAmount() >= cost;
    }

    private static void performRepair(WashingMachineBlockEntity washingMachine, int slot) {
        ItemStack stack = washingMachine.itemHandler.getStackInSlot(slot);
        stack.setDamageValue(stack.getDamageValue() - 1);

        int cost = washingMachine.fluidTank.getFluid().is(ModFluids.SUPER_SOAPY_WATER.get()) ? 10 : 20;
        washingMachine.fluidTank.drain(cost, IFluidHandler.FluidAction.EXECUTE);
    }

    public void drops() {
        SimpleContainer container = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            container.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, container);
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