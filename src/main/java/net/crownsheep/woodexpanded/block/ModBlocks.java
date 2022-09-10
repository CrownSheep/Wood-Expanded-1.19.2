package net.crownsheep.woodexpanded.block;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.custom.*;
import net.crownsheep.woodexpanded.block.entity.ModWoodTypes;
import net.crownsheep.woodexpanded.item.ModCreativeModeTab;
import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.world.feature.tree.PineTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> OLD_PLANKS = registerBlock("old_planks",
            () -> new OldPlanksBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(1f)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> BLANK_PLANKS = registerBlock("blank_planks",
            () -> new BlankPlanksBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> BLUE_PLANKS = registerBlock("blue_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> GREEN_PLANKS = registerBlock("green_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> RED_PLANKS = registerBlock("red_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> YELLOW_PLANKS = registerBlock("yellow_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> ORANGE_PLANKS = registerBlock("orange_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> LIGHT_BLUE_PLANKS = registerBlock("light_blue_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINK_PLANKS = registerBlock("pink_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PURPLE_PLANKS = registerBlock("purple_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> OAK_TABLE = registerBlock("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> BIRCH_TABLE = registerBlock("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> SPRUCE_TABLE = registerBlock("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> JUNGLE_TABLE = registerBlock("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> ACACIA_TABLE = registerBlock("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> MANGROVE_TABLE = registerBlock("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_TABLE = registerBlock("pine_table",
            () -> new TableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_SLAB = registerBlock("pine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.WOOD_TAB);


    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock(new PineTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new StairBlock(StairBlock.stateById(2) ,BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING ,BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_FENCE = registerBlock("pine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> PINE_WALL = registerBlock("pine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> OAK_WALL = registerBlock("oak_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> BIRCH_WALL = registerBlock("birch_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> SPRUCE_WALL = registerBlock("spruce_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> DARK_OAK_WALL = registerBlock("dark_oak_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> JUNGLE_WALL = registerBlock("jungle_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> ACACIA_WALL = registerBlock("acacia_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> MANGROVE_WALL = registerBlock("mangrove_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> CRIMSON_WALL = registerBlock("crimson_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> WARPED_WALL = registerBlock("warped_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> OAK_VERTICAL_SLAB = registerBlock("oak_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD_TAB);

    public static final RegistryObject<Block> OAK_FLOWER = registerBlock("oak_flower_pot",
            () -> new FlowerPotBlock(Blocks.SUNFLOWER, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

