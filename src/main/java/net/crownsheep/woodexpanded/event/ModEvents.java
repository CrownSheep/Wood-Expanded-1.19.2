package net.crownsheep.woodexpanded.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenCustomHashMap;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.villager.ModVillagers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = WoodExpended.MOD_ID)
public class ModEvents {
    static int i;

    @SubscribeEvent
    public static void addCustomVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.CARPENTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            java.util.Random random = new java.util.Random();
            int tmp = random.nextInt(10) + 7;
            i = tmp;
            ItemStack stack = new ItemStack(ModItems.PAINT_BRUSH.get(), 1); // sell
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer( // payment
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if (event.getType() == ModVillagers.CARPENTER.get()) {
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

        if (event.getType() == ModVillagers.CARPENTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUE_PAINT_BRUSH.get(), 1); // sell
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer( // payment
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02F));
        }
    }

    @SubscribeEvent
    public static void addCustomWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getRareTrades();
        java.util.Random random = new java.util.Random();
        int tmp = random.nextInt(10) + 7;
        i = tmp;

        trades.add((trader, rand) -> new MerchantOffer( // payment
                new ItemStack(Items.EMERALD, i - 6),
                new ItemStack(ModBlocks.OLD_WOOD.get(), i), 10, 2, 0.02F));
    }
}
