package net.crownsheep.woodexpanded.item;

import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static int index = 0;
    public static final CreativeModeTab WOOD_TAB = new CreativeModeTab("woodexpanded") {
        @Override
        public ItemStack makeIcon() {
            index = 0;
            return new ItemStack(ModBlocks.BLANK_PLANKS.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> items) {
            super.fillItemList(items);
            index = 0;
            items.set(index, new ItemStack(ModBlocks.BLANK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.RED_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.BLUE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.GREEN_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.ORANGE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.LIGHT_BLUE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PURPLE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.YELLOW_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.OLD_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.OAK_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.BIRCH_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.SPRUCE_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.DARK_OAK_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.JUNGLE_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.ACACIA_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MANGROVE_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_TABLE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_LOG.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_WOOD.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.STRIPPED_PINE_LOG.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.STRIPPED_PINE_WOOD.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_LEAVES.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_SAPLING.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.RED_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BLUE_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.GREEN_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ORANGE_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.LIGHT_BLUE_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINK_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PURPLE_PAINT_BRUSH.get()));
            index++;
            items.set(index, new ItemStack(ModItems.YELLOW_PAINT_BRUSH.get()));

            //apply sort logic here
        }
    };
}
