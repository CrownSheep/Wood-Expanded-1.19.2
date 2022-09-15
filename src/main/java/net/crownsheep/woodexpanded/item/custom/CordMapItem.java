package net.crownsheep.woodexpanded.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CordMapItem extends Item {
    int x;
    int y;
    int z;
    public CordMapItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        x = pEntity.blockPosition().getX();
        y = pEntity.blockPosition().getY();
        z = pEntity.blockPosition().getZ();
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        components.add(Component.literal(String.valueOf("X: " + x + "  Y: " + y + "  Z: " + z)).withStyle(ChatFormatting.WHITE));
        super.appendHoverText(pStack, pLevel, components, pIsAdvanced);
    }
}

