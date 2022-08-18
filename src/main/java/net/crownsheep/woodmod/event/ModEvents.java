package net.crownsheep.woodmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.crownsheep.woodmod.WoodMod;
import net.crownsheep.woodmod.block.ModBlocks;
import net.crownsheep.woodmod.item.ModItems;
import net.crownsheep.woodmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Mod.EventBusSubscriber(modid = WoodMod.MOD_ID)
public class ModEvents {
    static int min = 10;
    static int max = 16;
    public static int i;

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.CARPENTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.PAINT_BRUSH.get(), 1); // sell
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer( // payment
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if (event.getType() == ModVillagers.CARPENTER.get()) {
            i = (int) (Math.random()*(max-min+1)+min);
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, i - 6); // sell
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer( // payment
                    new ItemStack(ModBlocks.BLANK_WOOD.get(), i),
                    stack, 10, 1, 0.02F));
        }

        if (event.getType() == ModVillagers.CARPENTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUE_PAINT_BRUSH.get(), 1); // sell
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer( // payment
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02F));
        }
    }
}
