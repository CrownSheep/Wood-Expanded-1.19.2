package net.crownsheep.tutorialmod.painting;

import net.crownsheep.tutorialmod.TutorialMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TutorialMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> PLANT = PAINTING_VARIANT.register("plant",
            () -> new PaintingVariant(16,16));
public static final RegistryObject<PaintingVariant> WANDERER = PAINTING_VARIANT.register("wanderer",
            () -> new PaintingVariant(16,32));
public static final RegistryObject<PaintingVariant> SUNSET = PAINTING_VARIANT.register("sunset",
            () -> new PaintingVariant(32,16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANT.register(eventBus);
    }
}
