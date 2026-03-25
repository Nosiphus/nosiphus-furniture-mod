package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.world.level.block.FreezerBlock;
import com.mrcrayfish.furniture.world.level.block.FridgeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FridgeItem extends BlockItem
{
    private final Block otherBlock;

    public FridgeItem(Block block, Block otherBlock, Properties properties)
    {
        super(block, properties);
        this.otherBlock = otherBlock;
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState state)
    {
        BlockPos abovePos = context.getClickedPos().above();
        if (!context.getLevel().getBlockState(abovePos).canBeReplaced(context))
        {
            return false;
        }
        return super.canPlace(context, state);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState state)
    {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockPos abovePos = pos.above();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        BlockState freezerState = this.otherBlock.defaultBlockState()
                .setValue(FreezerBlock.DIRECTION, state.getValue(FridgeBlock.DIRECTION));
        level.setBlock(pos, freezerState, 3);
        boolean placed = level.setBlock(abovePos, state, 3);

        if (placed && player != null)
        {
            this.otherBlock.setPlacedBy(level, pos, freezerState, player, stack);
            state.getBlock().setPlacedBy(level, abovePos, state, player, stack);
        }

        return placed;
    }
}