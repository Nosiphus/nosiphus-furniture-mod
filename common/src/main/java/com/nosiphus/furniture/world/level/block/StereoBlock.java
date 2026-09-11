package com.nosiphus.furniture.world.level.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.world.phys.shapes.VoxelShapeHelper;
import com.nosiphus.furniture.world.level.block.entity.StereoBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StereoBlock extends FurnitureHorizontalBlock implements EntityBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    private static List<RecordItem> musicDiscs = null;

    public StereoBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.EAST).setValue(POWERED, false));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] CORE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.5, 0.0, 0.5, 10.5, 7.0, 15.5), Direction.EAST));
        final VoxelShape[] SCREEN = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.4, 3.0, 5.6, 5.5, 6.0, 10.6), Direction.EAST));
        final VoxelShape[] ANTENNA_BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7.0, 7.0, 6.2, 9.0, 7.5, 9.8), Direction.EAST));
        final VoxelShape[] POWER_BUTTON = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.1, 1.0, 6.0, 5.5, 2.0, 7.0), Direction.EAST));
        final VoxelShape[] BUTTON_1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.1, 1.0, 7.5, 5.5, 2.0, 8.5), Direction.EAST));
        final VoxelShape[] BUTTON_2 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.1, 1.0, 9.0, 5.5, 2.0, 10.0), Direction.EAST));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(CORE[direction.get2DDataValue()]);
            shapes.add(SCREEN[direction.get2DDataValue()]);
            shapes.add(ANTENNA_BASE[direction.get2DDataValue()]);
            shapes.add(POWER_BUTTON[direction.get2DDataValue()]);
            shapes.add(BUTTON_1[direction.get2DDataValue()]);
            shapes.add(BUTTON_2[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return SHAPES.get(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StereoBlockEntity(pos, state);
    }

    private static List<RecordItem> getMusicDiscs() {
        if (musicDiscs == null) {
            musicDiscs = BuiltInRegistries.ITEM.stream()
                    .filter(item -> item instanceof RecordItem)
                    .map(item -> (RecordItem) item)
                    .collect(Collectors.toList());
        }
        return musicDiscs;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof StereoBlockEntity stereo) {
            List<RecordItem> discs = getMusicDiscs();
            if (discs.isEmpty()) return InteractionResult.PASS;

            stopMusic(level);

            if (player.isCrouching()) {
                if (state.getValue(POWERED)) {
                    level.setBlock(pos, state.setValue(POWERED, false), 3);
                }
            } else {
                int nextIndex = (stereo.getTrackIndex() + 1) % discs.size();
                stereo.setTrackIndex(nextIndex);

                RecordItem disc = discs.get(nextIndex);
                SoundEvent sound = disc.getSound();

                level.setBlock(pos, state.setValue(POWERED, true), 3);

                if (!level.isClientSide) {
                    level.playSound(null, pos, sound, SoundSource.RECORDS, 0.75F, 1.0F);
                    Component songName = disc.getDisplayName().copy().withStyle(ChatFormatting.AQUA);
                    player.displayClientMessage(Component.translatable("record.nowPlaying", songName), true);
                }
            }
            stereo.markUpdated();
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    private void stopMusic(Level level) {
        if (!level.isClientSide) {
            ClientboundStopSoundPacket packet = new ClientboundStopSoundPacket(null, SoundSource.RECORDS);
            for (Player player : level.players()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    serverPlayer.connection.send(packet);
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            this.stopMusic(level);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}