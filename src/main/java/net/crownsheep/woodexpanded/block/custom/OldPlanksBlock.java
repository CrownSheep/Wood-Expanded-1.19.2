package net.crownsheep.woodexpanded.block.custom;

import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class OldPlanksBlock extends Block {

    public OldPlanksBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        level.destroyBlock(pos, false);
        level.gameEvent(null, GameEvent.BLOCK_DESTROY, pos);
        level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.WITHER_BREAK_BLOCK, SoundSource.BLOCKS,1 ,1.5f, true);
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof Arrow || entity instanceof SpectralArrow) {
            level.destroyBlock(pos, false);
            level.gameEvent(null, GameEvent.BLOCK_DESTROY, pos);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return true;
    }
}
