package net.crownsheep.woodexpanded.entity;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WoodExpended.MOD_ID);

    public static final RegistryObject<EntityType<Entity>> SEAT =
            ENTITY_TYPES.register("seat",
                    () -> EntityType.Builder.of(SeatEntity::new, MobCategory.MONSTER)
                            .sized(0.0f, 0.0f)
                            .build(new ResourceLocation(WoodExpended.MOD_ID, "seat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
