package net.crownsheep.woodexpanded.block.entity;

import com.ibm.icu.impl.ValidIdentifiers;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WoodExpended.MOD_ID);

    public static final RegistryObject<BlockEntityType<CarvingStationBlockEntity>> CARVING_STATION =
            BLOCK_ENTITIES.register("carving_station", () ->
                    BlockEntityType.Builder.of(CarvingStationBlockEntity::new,
                            ModBlocks.CARVING_STATION.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
