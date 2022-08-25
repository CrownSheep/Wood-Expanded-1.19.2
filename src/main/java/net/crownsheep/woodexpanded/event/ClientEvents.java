package net.crownsheep.woodexpanded.event;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = WoodExpended.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
