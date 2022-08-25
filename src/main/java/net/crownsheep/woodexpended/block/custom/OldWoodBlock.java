package net.crownsheep.woodexpended.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class OldWoodBlock extends Block {
    public OldWoodBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        level.destroyBlock(pos, false);

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return true;
    }
}
