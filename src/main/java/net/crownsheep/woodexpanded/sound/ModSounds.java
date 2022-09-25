package net.crownsheep.woodexpanded.sound;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WoodExpended.MOD_ID);

    public static final RegistryObject<SoundEvent> UI_WOODCUTTER_TAKE_RESULT =
            registerSoundEvent("ui_woodcutter_take_result");

    public static final RegistryObject<SoundEvent> CARVING_WOOD =
            registerSoundEvent("carving_wood");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(WoodExpended.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
