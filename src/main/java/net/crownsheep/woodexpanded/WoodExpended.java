package net.crownsheep.woodexpanded;

import com.mojang.logging.LogUtils;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.block.entity.ModBlockEntities;
import net.crownsheep.woodexpanded.effect.ModEffects;
import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.screen.ModMenuTypes;
import net.crownsheep.woodexpanded.screen.WoodcutterScreen;
import net.crownsheep.woodexpanded.sound.ModSounds;
import net.crownsheep.woodexpanded.villager.ModVillagers;
import net.crownsheep.woodexpanded.world.biomemods.ModBiomeModifiers;
import net.crownsheep.woodexpanded.world.feature.ModConfiguredFeatures;
import net.crownsheep.woodexpanded.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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

        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModEffects.register(modEventBus);



        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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
        }
    }
}
