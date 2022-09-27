package net.crownsheep.woodexpanded.screen.slot;

import net.crownsheep.woodexpanded.screen.CarvingStationMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class KnifeSlot extends SlotItemHandler {
    public KnifeSlot(CarvingStationMenu menu, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }


}
