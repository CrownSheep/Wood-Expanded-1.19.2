package net.crownsheep.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WoodcutterBlock extends Block {
    private static final Component CONTAINER_TITLE = Component.translatable("container.woodcutter");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    protected static final VoxelShape LEG1 = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 8.0D, 2.0D);
    protected static final VoxelShape LEG2 = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 8.0D, 2.0D);
    protected static final VoxelShape LEG3 = Block.box(0.0D, 0.0D, 14.0D, 2.0D, 8.0D, 16.0D);
    protected static final VoxelShape LEG4 = Block.box(14.0D, 0.0D, 14.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape SHAPE = Shapes.or(BASE, LEG1, LEG2 , LEG3, LEG4);

    public WoodcutterBlock(BlockBehaviour.Properties p_153129_) {
        super(p_153129_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public @NotNull InteractionResult use(BlockState p_57083_, Level p_57084_, BlockPos p_57085_, Player p_57086_, InteractionHand p_57087_, BlockHitResult p_57088_) {
        if (p_57084_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            p_57086_.openMenu(p_57083_.getMenuProvider(p_57084_, p_57085_));
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((p_57074_, p_57075_, p_57076_) -> new StonecutterMenu(p_57074_, p_57075_, ContainerLevelAccess.create(level, blockPos)), CONTAINER_TITLE);
    }

    public @NotNull VoxelShape getShape(BlockState p_57100_, BlockGetter p_57101_, BlockPos p_57102_, CollisionContext p_57103_) {
        return SHAPE;
    }

    public boolean useShapeForLightOcclusion(BlockState p_57109_) {
        return true;
    }

    public @NotNull RenderShape getRenderShape(BlockState p_57098_) {
        return RenderShape.MODEL;
    }

    public @NotNull BlockState rotate(BlockState p_57093_, Rotation p_57094_) {
        return p_57093_.setValue(FACING, p_57094_.rotate(p_57093_.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState p_57090_, Mirror p_57091_) {
        return p_57090_.rotate(p_57091_.getRotation(p_57090_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57096_) {
        p_57096_.add(FACING);
    }

    public boolean isPathfindable(BlockState p_57078_, BlockGetter p_57079_, BlockPos p_57080_, PathComputationType p_57081_) {
        return false;
    }


}