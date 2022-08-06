package net.crownsheep.tutorialmod.client;

import net.crownsheep.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ThirstHudOverlay {
    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(TutorialMod.MOD_ID,
            "textures/thirst/filled_thirst.png");
    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(TutorialMod.MOD_ID,
            "textures/thirst/empty_thirst.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);
        if (!gui.getMinecraft().player.isCreative() && !gui.getMinecraft().player.isSpectator() && !gui.getMinecraft().player.isUnderWater()) {
            for (int i = 0; i < 10; i++) {
                GuiComponent.blit(poseStack, x + 7 + (i * 8), y - 54, 0, 0, 12, 12,
                        12, 12);
            }
        }

        RenderSystem.setShaderTexture(0, FILLED_THIRST);
        if (!gui.getMinecraft().player.isCreative() && !gui.getMinecraft().player.isSpectator() && !gui.getMinecraft().player.isUnderWater()) {
            for (int i = 0; i < 10; i++) {
                if (ClientThirstData.getPlayerThirst() > i) {
                    GuiComponent.blit(poseStack, x + 7 + (i * 8), y - 54, 0, 0, 12, 12,
                            12, 12);
                } else {
                    break;
                }
            }
        }
    });
}
