package net.crownsheep.woodexpanded.effect;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.effect.custom.WoodChipsEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects{

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WoodExpended.MOD_ID);

    public static final RegistryObject<MobEffect> WOOD_CHIPS = EFFECTS.register("wood_chips", () ->
            new WoodChipsEffect(MobEffectCategory.HARMFUL, 0x36ebab));


    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
