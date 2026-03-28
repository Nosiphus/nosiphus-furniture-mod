package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.inventory.MicrowaveMenu;
import com.nosiphus.furniture.world.item.crafting.CookingRecipe;
import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
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
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MicrowaveBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            markUpdated();
        }
    };

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

    public IItemHandler getItemHandler() {
        return itemHandler;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("microwave.progress", this.progress);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        this.progress = tag.getInt("microwave.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        if (this.level != null) {
            Containers.dropContents(this.level, this.worldPosition, inventory);
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MicrowaveBlockEntity be) {
        SingleRecipeInput input = new SingleRecipeInput(be.itemHandler.getStackInSlot(1));
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
                    be.craftItem(recipe.get().value(), registries(level));
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
        this.itemHandler.extractItem(1, 1, false);
        ItemStack currentOutput = this.itemHandler.getStackInSlot(1);
        if (currentOutput.isEmpty()) {
            this.itemHandler.setStackInSlot(1, result.copy());
        } else if (ItemStack.isSameItemSameComponents(currentOutput, result)) {
            currentOutput.grow(result.getCount());
        }
    }

    private static HolderLookup.Provider registries(Level level) {
        return level.registryAccess();
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
}