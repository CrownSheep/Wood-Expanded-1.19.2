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
            items.set(index, new ItemStack(ModBlocks.PINE_STAIRS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_PRESSURE_PLATE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_FENCE.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_LEAVES.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_SAPLING.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.OAK_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.BIRCH_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.SPRUCE_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.DARK_OAK_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.JUNGLE_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.ACACIA_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MANGROVE_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRIMSON_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.WARPED_WALL.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.OAK_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.BIRCH_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.SPRUCE_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.DARK_OAK_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.JUNGLE_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.ACACIA_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MANGROVE_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRIMSON_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.WARPED_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.PINE_VERTICAL_SLAB.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_OAK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_BIRCH_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_SPRUCE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_DARK_OAK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_JUNGLE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_ACACIA_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_MANGROVE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_CRIMSON_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_WARPED_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.MOSSY_PINE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_OAK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_BIRCH_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_SPRUCE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_DARK_OAK_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_JUNGLE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_ACACIA_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_MANGROVE_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_CRIMSON_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_WARPED_PLANKS.get()));
            index++;
            items.set(index, new ItemStack(ModBlocks.CRACKED_PINE_PLANKS.get()));
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
            index++;
            items.set(index, new ItemStack(ModItems.OAK_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.OAK_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.OAK_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.OAK_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BIRCH_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BIRCH_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BIRCH_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BIRCH_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.SPRUCE_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.SPRUCE_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.SPRUCE_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.SPRUCE_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.DARK_OAK_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.DARK_OAK_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.DARK_OAK_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.DARK_OAK_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.JUNGLE_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.JUNGLE_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.JUNGLE_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.JUNGLE_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ACACIA_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ACACIA_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ACACIA_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ACACIA_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.MANGROVE_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.MANGROVE_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.MANGROVE_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.MANGROVE_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.CRIMSON_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.CRIMSON_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.CRIMSON_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.CRIMSON_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.WARPED_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.WARPED_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.WARPED_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.WARPED_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINE_HELMET.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINE_CHESTPLATE.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINE_LEGGINGS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINE_BOOTS.get()));
            index++;
            items.set(index, new ItemStack(ModItems.OAK_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.BIRCH_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.SPRUCE_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.DARK_OAK_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.JUNGLE_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.ACACIA_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.MANGROVE_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.CRIMSON_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.WARPED_HORSE_ARMOR.get()));
            index++;
            items.set(index, new ItemStack(ModItems.PINE_HORSE_ARMOR.get()));
            //apply sort logic here
        }
    };
}
