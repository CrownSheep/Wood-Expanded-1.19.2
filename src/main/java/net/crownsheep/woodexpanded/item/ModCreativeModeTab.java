package net.crownsheep.woodexpanded.item;

import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WOOD_TAB = new CreativeModeTab("woodexpanded") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BLANK_WOOD.get());
        }
    };
}
