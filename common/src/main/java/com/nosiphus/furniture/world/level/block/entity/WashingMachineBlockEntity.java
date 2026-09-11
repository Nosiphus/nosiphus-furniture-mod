package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.world.inventory.WashingMachineMenu;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class WashingMachineBlockEntity extends FluidHandlerSyncedBlockEntity implements WorldlyContainer, MenuProvider {

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(6, ItemStack.EMPTY);
    private boolean washing = false;

    public WashingMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.WASHING_MACHINE.get(), pos, state, 64000);
    }

    public WashingMachineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {
        super(type, pos, state, capacity);
    }

    public boolean isWashing() {
        return washing;
    }

    public void setWashing(boolean washing) {
        this.washing = washing;
    }

    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.inventory.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack stack = ContainerHelper.removeItem(this.inventory, index, count);
        if (!stack.isEmpty()) {
            this.markUpdated();
        }
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.markUpdated();
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return switch (slot) {
            case 0, 1, 2, 3 -> stack.getItem() instanceof ArmorItem;
            case 4 -> stack.is(Items.BUCKET) || stack.is(ModItems.SOAPY_WATER_BUCKET.get()) || stack.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get());
            default -> true;
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
    public int[] getSlotsForFace(Direction side) {
        return new int[]{0, 1, 2, 3, 4, 5};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.washing_machine");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new WashingMachineMenu(id, inventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putBoolean("Washing", this.washing);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory);
        this.washing = tag.getBoolean("Washing");
    }

    public void drops() {
        if (this.level != null) {
            Containers.dropContents(this.level, this.worldPosition, this);
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, WashingMachineBlockEntity washingMachine) {
        if (level.isClientSide) return;

        ItemStack fluidItem = washingMachine.getItem(4);
        if (!fluidItem.isEmpty()) {
            Fluid inputFluid = Fluids.EMPTY;
            if (fluidItem.is(ModItems.SOAPY_WATER_BUCKET.get())) {
                inputFluid = ModFluids.SOAPY_WATER.get();
            } else if (fluidItem.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get())) {
                inputFluid = ModFluids.SUPER_SOAPY_WATER.get();
            }

            if (inputFluid != Fluids.EMPTY) {
                if (washingMachine.canFill(inputFluid, 1000)) {
                    washingMachine.fill(inputFluid, 1000);
                    washingMachine.setItem(4, new ItemStack(Items.BUCKET));
                }
            }
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
        }
    }

    private static boolean shouldRepair(WashingMachineBlockEntity washingMachine, int slot) {
        ItemStack stack = washingMachine.getItem(slot);
        if (stack.isEmpty() || !stack.isDamaged()) return false;

        int cost = washingMachine.getFluid() == ModFluids.SUPER_SOAPY_WATER.get() ? 10 : 20;
        return washingMachine.getFluidAmount() >= cost;
    }

    private static void performRepair(WashingMachineBlockEntity washingMachine, int slot) {
        ItemStack stack = washingMachine.getItem(slot);
        stack.setDamageValue(stack.getDamageValue() - 1);

        int cost = washingMachine.getFluid() == ModFluids.SUPER_SOAPY_WATER.get() ? 10 : 20;
        washingMachine.drain(cost);
    }
}