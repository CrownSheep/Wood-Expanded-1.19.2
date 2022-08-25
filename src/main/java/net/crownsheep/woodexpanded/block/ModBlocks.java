package net.crownsheep.woodexpanded.block;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.custom.*;
import net.crownsheep.woodexpanded.item.ModCreativeModeTab;
import net.crownsheep.woodexpanded.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WoodExpended.MOD_ID);

    public static final RegistryObject<Block> OLD_WOOD = registerBlock("old_wood",
            () -> new OldWoodBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(1f)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BLANK_WOOD = registerBlock("blank_wood",
            () -> new BlankWoodBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BLUE_PLANKS = registerBlock("blue_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> GREEN_PLANKS = registerBlock("green_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> RED_PLANKS = registerBlock("red_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> YELLOW_PLANKS = registerBlock("yellow_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> ORANGE_PLANKS = registerBlock("orange_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> LIGHT_BLUE_PLANKS = registerBlock("light_blue_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> PINK_PLANKS = registerBlock("pink_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> PURPLE_PLANKS = registerBlock("purple_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> OAK_WOOD_LAYER = registerBlock("oak_wood_layer",
            () -> new WoodLayerBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BIRCH_WOOD_LAYER = registerBlock("birch_wood_layer",
            () -> new WoodLayerBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> SPRUCE_WOOD_LAYER = registerBlock("spruce_wood_layer",
            () -> new WoodLayerBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> OAK_TABLE = registerBlock("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BIRCH_TABLE = registerBlock("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> SPRUCE_TABLE = registerBlock("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> JUNGLE_TABLE = registerBlock("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> ACACIA_TABLE = registerBlock("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.TUTORIAL_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

