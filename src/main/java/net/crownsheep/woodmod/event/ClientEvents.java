package net.crownsheep.woodmod.event;

import net.crownsheep.woodmod.WoodMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = WoodMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
