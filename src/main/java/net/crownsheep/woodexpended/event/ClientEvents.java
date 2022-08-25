package net.crownsheep.woodexpended.event;

import net.crownsheep.woodexpended.WoodExpended;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = WoodExpended.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
