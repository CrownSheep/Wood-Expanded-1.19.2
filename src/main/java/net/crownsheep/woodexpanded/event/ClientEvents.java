package net.crownsheep.woodexpanded.event;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.entity.ModBlockEntities;
import net.crownsheep.woodexpanded.client.renderer.CarvingStationBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = WoodExpended.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = WoodExpended.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.CARVING_STATION.get(),
                    CarvingStationBlockEntityRenderer::new);
        }
    }
}
