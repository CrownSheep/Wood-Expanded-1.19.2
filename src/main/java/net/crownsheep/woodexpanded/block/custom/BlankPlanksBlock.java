package net.crownsheep.woodexpanded.block.custom;

import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;

public class BlankPlanksBlock extends Block {
    public BlankPlanksBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item;
        if (!itemstack.is(ModItems.BLUE_PAINT_BRUSH.get()) && !itemstack.is(ModItems.GREEN_PAINT_BRUSH.get()) && !itemstack.is(ModItems.RED_PAINT_BRUSH.get())
            && !itemstack.is(ModItems.YELLOW_PAINT_BRUSH.get()) && !itemstack.is(ModItems.ORANGE_PAINT_BRUSH.get()) && !itemstack.is(ModItems.LIGHT_BLUE_PAINT_BRUSH.get())
                && !itemstack.is(ModItems.PINK_PAINT_BRUSH.get()) && !itemstack.is(ModItems.PURPLE_PAINT_BRUSH.get())) {
            return super.use(state, level, blockPos, player, hand, hitResult);
        } else {
            if(itemstack.is(ModItems.BLUE_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.BLUE_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.BLUE_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.GREEN_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.GREEN_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.GREEN_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.RED_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.RED_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.RED_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.YELLOW_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.YELLOW_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.YELLOW_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.ORANGE_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.ORANGE_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.ORANGE_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.LIGHT_BLUE_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.LIGHT_BLUE_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.LIGHT_BLUE_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.PINK_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.PINK_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.PINK_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            if(itemstack.is(ModItems.PURPLE_PAINT_BRUSH.get())) {
                level.setBlock(blockPos, ModBlocks.PURPLE_PLANKS.get().defaultBlockState(), 11);
                level.playSound(player, player, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1, 1);
                item = itemstack.getItem();
                if (!player.isCreative()) {
                    if (itemstack.is(ModItems.PURPLE_PAINT_BRUSH.get())) {
                        player.setItemInHand(hand, new ItemStack(ModItems.PAINT_BRUSH.get()));
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return null;
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return true;
    }
}
