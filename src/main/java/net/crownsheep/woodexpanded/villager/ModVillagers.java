package net.crownsheep.woodexpanded.villager;

import com.google.common.collect.ImmutableSet;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, WoodExpended.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, WoodExpended.MOD_ID);

    public static final RegistryObject<PoiType> WOODCUTTER_POI = POI_TYPES.register("woodcutter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.WOODCUTTER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CARPENTER = VILLAGER_PROFESSIONS.register("carpenter",
            () -> new VillagerProfession("carpenter", x -> x.get() == WOODCUTTER_POI.get(),
                    x -> x.get() == WOODCUTTER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.UI_WOODCUTTER_TAKE_RESULT.get()));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, WOODCUTTER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
