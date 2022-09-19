package net.crownsheep.woodexpanded.block.entity;

import com.ibm.icu.impl.ValidIdentifiers;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WoodExpended.MOD_ID);

    public static final RegistryObject<BlockEntityType<CreateBlockEntity>> CREATE =
            BLOCK_ENTITIES.register("create", () ->
                    BlockEntityType.Builder.of(CreateBlockEntity::new,
                            ModBlocks.CREATE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
