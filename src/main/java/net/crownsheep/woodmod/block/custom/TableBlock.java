package net.crownsheep.woodmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TableBlock extends Block {
    public TableBlock(Properties properties) {
        super(properties);
    }

    protected static final VoxelShape BASE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape LEG1 = Block.box(1.0D, 0.0D, 1.0D, 3.0D, 12.0D, 3.0D);
    protected static final VoxelShape LEG2 = Block.box(1.0D, 0.0D, 13.0D, 3.0D, 12.0D, 15.0D);
    protected static final VoxelShape LEG3 = Block.box(13.0D, 0.0D, 13.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape LEG4 = Block.box(13.0D, 0.0D, 1.0D, 15.0D, 15.0D, 3.0D);
    protected static final VoxelShape SHAPE = Shapes.or(BASE, LEG1, LEG2, LEG3, LEG4);

    public VoxelShape getShape(BlockState p_152875_, BlockGetter p_152876_, BlockPos p_152877_, CollisionContext p_152878_) {
        return SHAPE;
    }

    public boolean isPathfindable(BlockState p_152870_, BlockGetter p_152871_, BlockPos p_152872_, PathComputationType p_152873_) {
        return false;
    }
}
