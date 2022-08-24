package net.crownsheep.woodmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.crownsheep.woodmod.WoodMod;
import net.crownsheep.woodmod.block.ModBlocks;
import net.crownsheep.woodmod.item.ModItems;
import net.crownsheep.woodmod.villager.ModVillagers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Mod.EventBusSubscriber(modid = WoodMod.MOD_ID)
public class ModEvents {
    static int i;

    @SubscribeEvent
    public static void addCustomVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.CARPENTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
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
    }

    @SubscribeEvent
    public static void addCustomWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getRareTrades();
        java.util.Random random = new java.util.Random();
        int tmp = random.nextInt(10) + 7;
        ModEvents.i = tmp;

        trades.add((trader, rand) -> new MerchantOffer( // payment
                new ItemStack(Items.EMERALD, i - 6),
                new ItemStack(ModBlocks.OLD_WOOD.get(), i), 10, 2, 0.02F));
    }


}
