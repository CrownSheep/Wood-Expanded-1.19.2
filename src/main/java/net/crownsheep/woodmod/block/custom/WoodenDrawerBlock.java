package net.crownsheep.woodmod.block.custom;

import net.crownsheep.woodmod.block.entity.WoodenDrawerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.awt.*;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

public class WoodenDrawerBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE_NORTH = Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 16.0D);
    protected static final VoxelShape TOP_NORTH = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHELF_TOP_NORTH = Block.box(0.2D, 8.0D, 0.0D, 15.8D, 14.0D, 1.0D);
    protected static final VoxelShape SHELF_BOTTOM_NORTH = Block.box(0.2D, 1.0D, 0.0D, 15.8D, 7.0D, 1.0D);

    protected static final VoxelShape BASE_SOUTH = Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 16.0D);
    protected static final VoxelShape TOP_SOUTH = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHELF_TOP_SOUTH = Block.box(0.0D, 8.0D, 0.2D, 15.8D, 14.0D, 15.8D);
    protected static final VoxelShape SHELF_BOTTOM_SOUTH = Block.box(0.2D, 1.0D, 0.0D, 15.8D, 7.0D, 1.0D);
    protected static final VoxelShape NORTH_AABB = Shapes.or(BASE_NORTH, TOP_NORTH, SHELF_TOP_NORTH, SHELF_BOTTOM_NORTH);

    protected static final VoxelShape SOUTH_AABB = Shapes.or(BASE_SOUTH, TOP_SOUTH, SHELF_TOP_SOUTH, SHELF_BOTTOM_SOUTH);
    public WoodenDrawerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_57070_) {
        return this.defaultBlockState().setValue(FACING, p_57070_.getHorizontalDirection().getOpposite());
    }

    public VoxelShape getShape(BlockState p_51569_, BlockGetter p_51570_, BlockPos p_51571_, CollisionContext p_51572_) {
                    return NORTH_AABB;
    }

    public BlockState rotate(BlockState p_57093_, Rotation p_57094_) {
        return p_57093_.setValue(FACING, p_57094_.rotate(p_57093_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_57090_, Mirror p_57091_) {
        return p_57090_.rotate(p_57091_.getRotation(p_57090_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57096_) {
        p_57096_.add(FACING);
    }

    public InteractionResult use(BlockState p_49069_, Level p_49070_, BlockPos p_49071_, Player p_49072_, InteractionHand p_49073_, BlockHitResult p_49074_) {
        if (p_49070_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = p_49070_.getBlockEntity(p_49071_);
            if (blockentity instanceof WoodenDrawerBlockEntity) {
                p_49072_.openMenu((WoodenDrawerBlockEntity)blockentity);
                PiglinAi.angerNearbyPiglins(p_49072_, true);
            }

            return InteractionResult.CONSUME;
        }
    }

    public void onRemove(BlockState p_49076_, Level p_49077_, BlockPos p_49078_, BlockState p_49079_, boolean p_49080_) {
        if (!p_49076_.is(p_49079_.getBlock())) {
            BlockEntity blockentity = p_49077_.getBlockEntity(p_49078_);
            if (blockentity instanceof WoodenDrawerBlockEntity) {
                Containers.dropContents(p_49077_, p_49078_, (WoodenDrawerBlockEntity)blockentity);
                p_49077_.updateNeighbourForOutputSignal(p_49078_, this);
            }

            super.onRemove(p_49076_, p_49077_, p_49078_, p_49079_, p_49080_);
        }
    }

    public void tick(BlockState p_220758_, ServerLevel p_220759_, BlockPos p_220760_, RandomSource p_220761_) {
        BlockEntity blockentity = p_220759_.getBlockEntity(p_220760_);
        if (blockentity instanceof WoodenDrawerBlockEntity) {
            ((WoodenDrawerBlockEntity)blockentity).recheckOpen();
        }

    }

    public void setPlacedBy(Level p_49052_, BlockPos p_49053_, BlockState p_49054_, @Nullable LivingEntity p_49055_, ItemStack p_49056_) {
        if (p_49056_.hasCustomHoverName()) {
            BlockEntity blockentity = p_49052_.getBlockEntity(p_49053_);
            if (blockentity instanceof WoodenDrawerBlockEntity) {
                ((WoodenDrawerBlockEntity)blockentity).setCustomName(p_49056_.getHoverName());
            }
        }

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos p_152102_, BlockState p_152103_) {
        return new WoodenDrawerBlockEntity(p_152102_, p_152103_);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }

    public boolean useShapeForLightOcclusion(BlockState p_53295_) {
        return true;
    }
}
