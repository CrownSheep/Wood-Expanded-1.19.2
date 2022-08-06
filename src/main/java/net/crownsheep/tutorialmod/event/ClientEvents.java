package net.crownsheep.tutorialmod.event;

import net.crownsheep.tutorialmod.TutorialMod;
import net.crownsheep.tutorialmod.client.ThirstHudOverlay;
import net.crownsheep.tutorialmod.networking.ModMessages;
import net.crownsheep.tutorialmod.networking.packet.DrinkWaterC2SPacket;
import net.crownsheep.tutorialmod.networking.packet.ExampleC2SPacket;
import net.crownsheep.tutorialmod.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            {
                if (KeyBinding.DRINKING_KEY.consumeClick()) {
                    ModMessages.sendToServer(new DrinkWaterC2SPacket());
                }
            }
        }

        @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event) {
                event.register(KeyBinding.DRINKING_KEY);
            }

            @SubscribeEvent
            public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
                event.registerBelowAll("thirst", ThirstHudOverlay.HUD_THIRST);
            }
        }
    }
}
