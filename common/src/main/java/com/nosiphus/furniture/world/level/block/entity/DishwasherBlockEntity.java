package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.nosiphus.furniture.world.inventory.DishwasherMenu;
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
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class DishwasherBlockEntity extends FluidHandlerSyncedBlockEntity implements WorldlyContainer, MenuProvider {

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(8, ItemStack.EMPTY);
    private boolean washing = false;

    public DishwasherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DISHWASHER.get(), pos, state, 64000);
    }

    public DishwasherBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {
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
            case 0 -> stack.getItem() instanceof PickaxeItem;
            case 1 -> stack.getItem() instanceof ShovelItem;
            case 2 -> stack.getItem() instanceof SwordItem;
            case 3 -> stack.getItem() instanceof AxeItem;
            case 4 -> stack.getItem() instanceof HoeItem;
            case 5 -> stack.getItem() instanceof ShieldItem;
            case 6 -> stack.is(Items.BUCKET) || stack.is(ModItems.SOAPY_WATER_BUCKET.get()) || stack.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get());
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
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
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
        return Component.translatable("container.nfm.dishwasher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new DishwasherMenu(id, inventory, this);
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

    public static void tick(Level level, BlockPos pos, BlockState state, DishwasherBlockEntity dishwasher) {
        if (level.isClientSide) return;

        ItemStack fluidItem = dishwasher.getItem(6);
        if (!fluidItem.isEmpty()) {
            Fluid inputFluid = Fluids.EMPTY;
            if (fluidItem.is(ModItems.SOAPY_WATER_BUCKET.get())) {
                inputFluid = ModFluids.SOAPY_WATER.get();
            } else if (fluidItem.is(ModItems.SUPER_SOAPY_WATER_BUCKET.get())) {
                inputFluid = ModFluids.SUPER_SOAPY_WATER.get();
            }

            if (inputFluid != Fluids.EMPTY) {
                if (dishwasher.canFill(inputFluid, 1000)) {
                    dishwasher.fill(inputFluid, 1000);
                    dishwasher.setItem(6, new ItemStack(Items.BUCKET));
                }
            }
        }

        boolean hasWorked = false;
        boolean currentlyRepairing = false;

        for (int i = 0; i < 6; i++) {
            ItemStack tool = dishwasher.getItem(i);
            if (tool.isDamaged() && dishwasher.getFluidAmount() > 0) {
                currentlyRepairing = true;
                int cost = dishwasher.getFluid() == ModFluids.SUPER_SOAPY_WATER.get() ? 10 : 20;

                if (dishwasher.getFluidAmount() >= cost) {
                    tool.setDamageValue(tool.getDamageValue() - 1);
                    dishwasher.drain(cost);
                    hasWorked = true;
                }
            }
        }

        if (dishwasher.washing != currentlyRepairing) {
            dishwasher.washing = currentlyRepairing;
            dishwasher.markUpdated();
        } else if (hasWorked) {
            dishwasher.markUpdated();
        }
    }
}