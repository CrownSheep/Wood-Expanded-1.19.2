package net.crownsheep.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class QuickSandBlock extends Block implements net.minecraftforge.common.IForgeShearable {
    public QuickSandBlock(BlockBehaviour.Properties p_58178_) {
        super(p_58178_);
    }

    public void entityInside(BlockState state, Level level, BlockPos blockPos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3(0.25D, (double)0.04F, 0.25D));
    }


}
