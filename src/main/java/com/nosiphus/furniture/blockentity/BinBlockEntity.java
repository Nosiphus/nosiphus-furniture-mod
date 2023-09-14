package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.tileentity.BasicLootBlockEntity;
import com.nosiphus.furniture.block.BinBlock;
import com.nosiphus.furniture.client.menu.BinMenu;
import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BinBlockEntity extends BasicLootBlockEntity implements MenuProvider {

    private final ItemStackHandler itemStackHandler = new ItemStackHandler(12) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyOptional = LazyOptional.empty();

    protected final ContainerData data;

    public BinBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BIN.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get (int index) {
                return 0;
            }

            @Override
            public void set(int index, int value) {  }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public Component getDefaultName()
    {
        return Component.translatable("container.nfm.bin");
    }

    @Override
    protected AbstractContainerMenu createMenu(int ID, Inventory inventory) {
        return new BinMenu(ID, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyOptional = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.put("inventory", itemStackHandler.serializeNBT());
        super.saveAdditional(compoundTag);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        itemStackHandler.deserializeNBT(compoundTag.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BinBlockEntity blockEntity) {
        if(level.isClientSide()) {
            return;
        }
    }

    @Override
    public void onOpen(Level level, BlockPos pos, BlockState state)
    {
        this.playBinSound(state, ModSounds.BLOCK_BIN_OPEN.get());
        this.setBinState(state, true);
    }

    @Override
    public void onClose(Level level, BlockPos pos, BlockState state)
    {
        this.playBinSound(state, ModSounds.BLOCK_BIN_CLOSE.get());
        this.setBinState(state, false);
    }

    private void playBinSound(BlockState state, SoundEvent event)
    {
        Vec3i directionVec = state.getValue(BinBlock.DIRECTION).getOpposite().getNormal();
        double x = this.worldPosition.getX() + 0.5D + directionVec.getX() / 2.0D;
        double y = this.worldPosition.getY() + 0.5D + directionVec.getY() / 2.0D;
        double z = this.worldPosition.getZ() + 0.5D + directionVec.getZ() / 2.0D;
        Level level = this.getLevel();
        if(level != null)
        {
            level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    private void setBinState(BlockState state, boolean open)
    {
        Level level = this.getLevel();
        if(level != null)
        {
            level.setBlock(this.getBlockPos(), state.setValue(BinBlock.OPEN, open), 3);
        }
    }

}
