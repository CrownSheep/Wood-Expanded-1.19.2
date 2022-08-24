package net.crownsheep.woodmod.event;

import net.crownsheep.woodmod.WoodMod;
import net.crownsheep.woodmod.block.ModBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = WoodMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
