package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.inventory.MicrowaveMenu;
import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MicrowaveBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int soundTimer = 0;

    public MicrowaveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.MICROWAVE.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MicrowaveBlockEntity.this.progress;
                    case 1 -> MicrowaveBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MicrowaveBlockEntity.this.progress = value;
                    case 1 -> MicrowaveBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.microwave");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new MicrowaveMenu(id, inventory, this, this.data);
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
    public int getMaxStackSize() {
        return 1;
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
    public int[] getSlotsForFace(Direction side) { return new int[]{0}; }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) { return true; }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) { return true; }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.inventory, registries);
        tag.putInt("microwave.progress", this.progress);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.inventory.clear();
        ContainerHelper.loadAllItems(tag, this.inventory, registries);
        this.progress = tag.getInt("microwave.progress");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void drops() {
        if (this.level != null) {
            Containers.dropContents(this.level, this.worldPosition, this);
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MicrowaveBlockEntity be) {
        ItemStack inputStack = be.getItem(0);
        if (inputStack.isEmpty()) {
            if (be.progress > 0) {
                be.progress = 0;
                be.soundTimer = 0;
                be.markUpdated();
            }
            return;
        }

        SingleRecipeInput input = new SingleRecipeInput(inputStack);
        Optional<RecipeHolder<CookingRecipe>> recipe = level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.COOKING.get(), input, level);

        if (recipe.isPresent()) {
            if (level.isClientSide) {
                if (level.random.nextInt(5) == 0) {
                    double posX = (double) pos.getX() + 0.35D + (level.random.nextDouble() / 3);
                    double posZ = (double) pos.getZ() + 0.35D + (level.random.nextDouble() / 3);
                    level.addParticle(ParticleTypes.SMOKE, posX, pos.getY() + 0.065D, posZ, 0.0D, 0.0D, 0.0D);
                }
            } else {
                be.progress++;

                if (be.soundTimer % 20 == 0) {
                    level.playSound(null, pos, ModSoundEvents.BLOCK_MICROWAVE_RUNNING.get(), SoundSource.BLOCKS, 0.75F, 1.0F);
                }
                be.soundTimer++;

                if (be.progress >= be.maxProgress) {
                    be.craftItem(recipe.get().value(), level.registryAccess());
                    level.playSound(null, pos, ModSoundEvents.BLOCK_MICROWAVE_FINISH.get(), SoundSource.BLOCKS, 0.75F, 1.0F);
                    be.progress = 0;
                    be.soundTimer = 0;
                }
                be.setChanged();
            }
        } else {
            if (be.progress > 0) {
                be.progress = 0;
                be.soundTimer = 0;
                be.markUpdated();
            }
        }
    }

    private void craftItem(CookingRecipe recipe, HolderLookup.Provider registries) {
        ItemStack result = recipe.getResultItem(registries);
        this.setItem(0, result.copy());
    }
}