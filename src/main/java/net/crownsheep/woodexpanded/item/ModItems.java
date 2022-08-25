package net.crownsheep.woodexpanded.item;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WoodExpended.MOD_ID);

    public static final RegistryObject<Item> BLUE_PAINT_BRUSH = ITEMS.register("blue_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GREEN_PAINT_BRUSH = ITEMS.register("green_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> RED_PAINT_BRUSH = ITEMS.register("red_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> YELLOW_PAINT_BRUSH = ITEMS.register("yellow_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ORANGE_PAINT_BRUSH = ITEMS.register("orange_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> LIGHT_BLUE_PAINT_BRUSH = ITEMS.register("light_blue_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PINK_PAINT_BRUSH = ITEMS.register("pink_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PURPLE_PAINT_BRUSH = ITEMS.register("purple_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
