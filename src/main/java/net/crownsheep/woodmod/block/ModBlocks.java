package net.crownsheep.woodmod.block;

import net.crownsheep.woodmod.WoodMod;
import net.crownsheep.woodmod.block.custom.*;
import net.crownsheep.woodmod.item.ModCreativeModeTab;
import net.crownsheep.woodmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
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
            DeferredRegister.create(ForgeRegistries.BLOCKS, WoodMod.MOD_ID);

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

    public static final RegistryObject<Block> WOOD_LAYER = registerBlock("wood_layer",
            () -> new WoodLayerBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
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

