package net.crownsheep.woodmod.item;

import net.crownsheep.woodmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("woodmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BLANK_WOOD.get());
        }
    };
}
