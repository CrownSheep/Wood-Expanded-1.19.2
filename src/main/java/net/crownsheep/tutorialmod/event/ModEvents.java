package net.crownsheep.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.crownsheep.tutorialmod.TutorialMod;
import net.crownsheep.tutorialmod.item.ModItems;
import net.crownsheep.tutorialmod.networking.ModMessages;
import net.crownsheep.tutorialmod.networking.packet.ThirstDataSyncS2CPacket;
import net.crownsheep.tutorialmod.thirst.PlayerThirst;
import net.crownsheep.tutorialmod.thirst.PlayerThirstProvider;
import net.crownsheep.tutorialmod.villager.ModVillagers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {

    static int i = 0;

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EIGHT_BALL.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if (event.getType() == ModVillagers.JUMP_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUEBERRY.get(), 15);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02F));
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerThirstProvider.PLAYER_THIRST).isPresent()) {
                event.addCapability(new ResourceLocation(TutorialMod.MOD_ID, "properties"), new PlayerThirstProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerThirst.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                Player player = event.player;

                if (thirst.getThirst() > 0 && player.getRandom().nextFloat() < 0.002f && player.isSprinting() && !player.isCreative() && !player.isSpectator()) {
                    thirst.subThirst(1);
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), (ServerPlayer) player);
                }

                if (thirst.getThirst() > 0 && player.getRandom().nextFloat() < 0.00068f && !player.isSprinting() && !player.isCreative() && !player.isSpectator()) {
                    thirst.subThirst(1);
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), (ServerPlayer) player);
                }

                if (thirst.getThirst() <= 1 && !player.isCreative() && !player.isSpectator()) {
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, false, false));
                }

                if (!player.isCreative() && !player.isSpectator()) {
                    if (thirst.getThirst() == 0) {
                        if (i >= 85) {
                            if (player.getHealth() <= 10f) {
                                player.hurt(DamageSource.GENERIC, 2f);
                                i = 0;
                            }
                            if (player.getHealth() > 10f) {
                                player.hurt(DamageSource.GENERIC, 1f);
                                i = 0;
                            }
                        }
                    }
                    i++;
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                });
            }
        }
    }
}
