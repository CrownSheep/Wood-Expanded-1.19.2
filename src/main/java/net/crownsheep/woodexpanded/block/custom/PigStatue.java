package net.crownsheep.woodexpanded.block.custom;

import net.crownsheep.woodexpanded.entity.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PigStatue extends HorizontalDirectionalBlock {

    public PigStatue(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    protected static final VoxelShape BODY = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape LEG1 = Block.box(1.0D, 0.0D, 1.0D, 3.0D, 12.0D, 3.0D);
    protected static final VoxelShape LEG2 = Block.box(1.0D, 0.0D, 13.0D, 3.0D, 12.0D, 15.0D);
    protected static final VoxelShape LEG3 = Block.box(13.0D, 0.0D, 13.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape LEG4 = Block.box(13.0D, 0.0D, 1.0D, 15.0D, 15.0D, 3.0D);
    protected static final VoxelShape SHAPE = Shapes.or(BODY, LEG1, LEG2, LEG3, LEG4);

    public VoxelShape getShape(BlockState p_152875_, BlockGetter p_152876_, BlockPos p_152877_, CollisionContext p_152878_) {
        return SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_57070_) {
        return this.defaultBlockState().setValue(FACING, p_57070_.getHorizontalDirection().getOpposite());
    }

    public boolean useShapeForLightOcclusion(BlockState p_57109_) {
        return true;
    }

    public RenderShape getRenderShape(BlockState p_57098_) {
        return RenderShape.MODEL;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57096_) {
        p_57096_.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!player.isShiftKeyDown()) {
            return SeatEntity.createForPlayer(level, pos, 0.57, player, state.getValue(FACING).getOpposite());
        } else {
            return InteractionResult.FAIL;
        }
    }

    public boolean isPathfindable(BlockState p_57078_, BlockGetter p_57079_, BlockPos p_57080_, PathComputationType p_57081_) {
        return false;
    }
}
