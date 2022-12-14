package net.crownsheep.woodexpanded.screen;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, WoodExpended.MOD_ID);

    public static final RegistryObject<MenuType<WoodcutterMenu>> WOODCUTTER_MENU =
            registerMenuType(WoodcutterMenu::new, "woodcutter_menu");

    public static final RegistryObject<MenuType<CarvingStationMenu>> CARVING_STATION_MENU =
            registerMenuType(CarvingStationMenu::new, "carving_station_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
