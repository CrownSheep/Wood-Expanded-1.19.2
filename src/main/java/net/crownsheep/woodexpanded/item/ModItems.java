package net.crownsheep.woodexpanded.item;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WoodExpended.MOD_ID);

    public static final RegistryObject<Item> BLUE_PAINT_BRUSH = ITEMS.register("blue_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GREEN_PAINT_BRUSH = ITEMS.register("green_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> RED_PAINT_BRUSH = ITEMS.register("red_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> YELLOW_PAINT_BRUSH = ITEMS.register("yellow_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ORANGE_PAINT_BRUSH = ITEMS.register("orange_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> LIGHT_BLUE_PAINT_BRUSH = ITEMS.register("light_blue_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PINK_PAINT_BRUSH = ITEMS.register("pink_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PURPLE_PAINT_BRUSH = ITEMS.register("purple_paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> OAK_HELMET = ITEMS.register("oak_helmet",
            () -> new ArmorItem(ModArmorMaterials.OAK_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> OAK_CHESTPLATE = ITEMS.register("oak_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OAK_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> OAK_LEGGINGS = ITEMS.register("oak_leggings",
            () -> new ArmorItem(ModArmorMaterials.OAK_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> OAK_BOOTS = ITEMS.register("oak_boots",
            () -> new ArmorItem(ModArmorMaterials.OAK_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> BIRCH_HELMET = ITEMS.register("birch_helmet",
            () -> new ArmorItem(ModArmorMaterials.BIRCH_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> BIRCH_CHESTPLATE = ITEMS.register("birch_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BIRCH_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> BIRCH_LEGGINGS = ITEMS.register("birch_leggings",
            () -> new ArmorItem(ModArmorMaterials.BIRCH_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> BIRCH_BOOTS = ITEMS.register("birch_boots",
            () -> new ArmorItem(ModArmorMaterials.BIRCH_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> SPRUCE_HELMET = ITEMS.register("spruce_helmet",
            () -> new ArmorItem(ModArmorMaterials.SPRUCE_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> SPRUCE_CHESTPLATE = ITEMS.register("spruce_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SPRUCE_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> SPRUCE_LEGGINGS = ITEMS.register("spruce_leggings",
            () -> new ArmorItem(ModArmorMaterials.SPRUCE_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> SPRUCE_BOOTS = ITEMS.register("spruce_boots",
            () -> new ArmorItem(ModArmorMaterials.SPRUCE_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> DARK_OAK_HELMET = ITEMS.register("dark_oak_helmet",
            () -> new ArmorItem(ModArmorMaterials.DARK_OAK_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> DARK_OAK_CHESTPLATE = ITEMS.register("dark_oak_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DARK_OAK_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> DARK_OAK_LEGGINGS = ITEMS.register("dark_oak_leggings",
            () -> new ArmorItem(ModArmorMaterials.DARK_OAK_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> DARK_OAK_BOOTS = ITEMS.register("dark_oak_boots",
            () -> new ArmorItem(ModArmorMaterials.DARK_OAK_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> JUNGLE_HELMET = ITEMS.register("jungle_helmet",
            () -> new ArmorItem(ModArmorMaterials.JUNGLE_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> JUNGLE_CHESTPLATE = ITEMS.register("jungle_chestplate",
            () -> new ArmorItem(ModArmorMaterials.JUNGLE_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> JUNGLE_LEGGINGS = ITEMS.register("jungle_leggings",
            () -> new ArmorItem(ModArmorMaterials.JUNGLE_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> JUNGLE_BOOTS = ITEMS.register("jungle_boots",
            () -> new ArmorItem(ModArmorMaterials.JUNGLE_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> ACACIA_HELMET = ITEMS.register("acacia_helmet",
            () -> new ArmorItem(ModArmorMaterials.ACACIA_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> ACACIA_CHESTPLATE = ITEMS.register("acacia_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ACACIA_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> ACACIA_LEGGINGS = ITEMS.register("acacia_leggings",
            () -> new ArmorItem(ModArmorMaterials.ACACIA_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> ACACIA_BOOTS = ITEMS.register("acacia_boots",
            () -> new ArmorItem(ModArmorMaterials.ACACIA_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> MANGROVE_HELMET = ITEMS.register("mangrove_helmet",
            () -> new ArmorItem(ModArmorMaterials.MANGROVE_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> MANGROVE_CHESTPLATE = ITEMS.register("mangrove_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MANGROVE_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> MANGROVE_LEGGINGS = ITEMS.register("mangrove_leggings",
            () -> new ArmorItem(ModArmorMaterials.MANGROVE_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> MANGROVE_BOOTS = ITEMS.register("mangrove_boots",
            () -> new ArmorItem(ModArmorMaterials.MANGROVE_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> PINE_HELMET = ITEMS.register("pine_helmet",
            () -> new ArmorItem(ModArmorMaterials.PINE_WOOD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> PINE_CHESTPLATE = ITEMS.register("pine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PINE_WOOD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> PINE_LEGGINGS = ITEMS.register("pine_leggings",
            () -> new ArmorItem(ModArmorMaterials.PINE_WOOD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));
    public static final RegistryObject<Item> PINE_BOOTS = ITEMS.register("pine_boots",
            () -> new ArmorItem(ModArmorMaterials.PINE_WOOD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));

    public static final RegistryObject<Item> WOODEN_MINECART = ITEMS.register("wooden_minecart",
            () -> new MinecartItem(AbstractMinecart.Type.RIDEABLE, new Item.Properties().tab(ModCreativeModeTab.WOOD_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
