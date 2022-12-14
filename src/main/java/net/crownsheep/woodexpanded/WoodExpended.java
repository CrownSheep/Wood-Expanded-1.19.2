package net.crownsheep.woodexpanded;

import com.mojang.logging.LogUtils;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.block.entity.ModBlockEntities;
import net.crownsheep.woodexpanded.client.renderer.SeatRenderer;
import net.crownsheep.woodexpanded.entity.ModEntityTypes;
import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.networking.ModMessages;
import net.crownsheep.woodexpanded.recipe.ModRecipes;
import net.crownsheep.woodexpanded.screen.CarvingStationScreen;
import net.crownsheep.woodexpanded.screen.ModMenuTypes;
import net.crownsheep.woodexpanded.sound.ModSounds;
import net.crownsheep.woodexpanded.villager.ModVillagers;
import net.crownsheep.woodexpanded.world.feature.ModConfiguredFeatures;
import net.crownsheep.woodexpanded.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WoodExpended.MOD_ID)
public class WoodExpended
{
    public static final String MOD_ID = "woodexpanded";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public WoodExpended() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
            ModVillagers.registerPOIs();
        });
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINE_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINE_SAPLING.get(), RenderType.cutout());

            MenuScreens.register(ModMenuTypes.CARVING_STATION_MENU.get(), CarvingStationScreen::new);
            EntityRenderers.register(ModEntityTypes.SEAT.get(), SeatRenderer::new);
        }
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid=WoodExpended.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ClientHandler
    {

        private static final ColorResolver COLOR_RESOLVER = (biome, x, z) -> biome.getFoliageColor();

        @SubscribeEvent
        static void registerColorResolver(RegisterColorHandlersEvent.ColorResolvers event)
        {
            event.register(COLOR_RESOLVER);
        }

        @SubscribeEvent
        static void registerBlockColor(RegisterColorHandlersEvent.Block event)
        {
            event.register(((state, btGetter, pos, tintIndex) -> btGetter == null || pos == null ? 0 : btGetter.getBlockTint(pos, COLOR_RESOLVER)), ModBlocks.PINE_LEAVES.get());
        }


        @SubscribeEvent
        static void registerItemColor(RegisterColorHandlersEvent.Item event)
        {
            event.register((itemColor, item) -> {
                BlockState blockstate = ((BlockItem)itemColor.getItem()).getBlock().defaultBlockState();
                return FoliageColor.getEvergreenColor();
            }, ModBlocks.PINE_LEAVES.get());
        }
    }
}
