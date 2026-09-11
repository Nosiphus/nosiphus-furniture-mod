package com.mrcrayfish.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.mrcrayfish.furniture.world.mail.Mail;
import com.mrcrayfish.furniture.world.mail.PostOffice;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class MailBoxBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public MailBoxBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] POST = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(6.5, 0, 6.5, 9.5, 13, 9.5), Direction.SOUTH));
        final VoxelShape[] BOX = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(4, 13, 2, 12, 22, 14), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(POST[direction.get2DDataValue()]);
            shapes.add(BOX[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return SHAPES.get(state);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack)
    {
        if(entity instanceof ServerPlayer serverPlayer)
        {
            if(level.getBlockEntity(pos) instanceof MailBoxBlockEntity blockEntity)
            {
                blockEntity.setId(UUID.randomUUID());
                blockEntity.setOwner(serverPlayer);
                blockEntity.setMailBoxName("Mail Box");
                PostOffice.registerMailBox(serverPlayer, blockEntity.getId(), "Mail Box", pos);
                blockEntity.markUpdated();
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if(!level.isClientSide() && level.getServer() != null)
        {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if(tileEntity instanceof MailBoxBlockEntity mailBox)
            {
                if(mailBox.getId() != null && mailBox.getOwnerId() != null)
                {
                    Supplier<Mail> supplier = PostOffice.getMailForPlayerMailBox(level.getServer(), mailBox.getOwnerId(), mailBox.getId());
                    while(true)
                    {
                        Mail mail = supplier.get();
                        if(mail == null) break;
                        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), mail.getStack());
                    }

                    PostOffice.unregisterMailBox(level.getServer(), mailBox.getOwnerId(), mailBox.getId());
                }
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer)
        {
            if (level.getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox)
            {
                mailBox.updateIdAndAttemptClaim(serverPlayer);
                mailBox.updateOwnerName(serverPlayer);

                mailBox.markUpdated();

                Services.PLATFORM.openMenu(serverPlayer, mailBox, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new MailBoxBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
    {
        return createMailBoxTicker(level, type, ModBlockEntityTypes.MAIL_BOX.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createMailBoxTicker(Level level, BlockEntityType<T> blockEntityType, BlockEntityType<? extends MailBoxBlockEntity> mailBoxBlockEntityType)
    {
        return level.isClientSide() ? null : createTickerHelper(blockEntityType, mailBoxBlockEntityType, MailBoxBlockEntity::serverTick);
    }
}