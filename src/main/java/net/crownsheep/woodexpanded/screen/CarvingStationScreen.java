package net.crownsheep.woodexpanded.screen;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.block.entity.CarvingStationBlockEntity;
import net.crownsheep.woodexpanded.renderer.CarvingStationBlockEntityRenderer;
import net.minecraft.advancements.FrameType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class CarvingStationScreen extends AbstractContainerScreen<CarvingStationMenu> {

    public static ItemStack[] statues = {new ItemStack(ModBlocks.COW_STATUE.get()), new ItemStack(ModBlocks.PIG_STATUE.get())};
    public static int countsta = 0;
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(WoodExpended.MOD_ID ,"textures/gui/carving_station_gui.png");
    public final TextureManager textureManager;

    public CarvingStationScreen(CarvingStationMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        textureManager = new TextureManager(ResourceManager.Empty.INSTANCE);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        Minecraft.getInstance().font.draw(pPoseStack, Component.translatable("blockentity.woodexpanded.carving_station"), 170, 90, 5592405);

        renderProgressArrow(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 91, y + 32, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        renderGuiItem(statues[countsta], 230, 80, 38.0F, 38.0F, 38.0F);
        if(countsta == 0) {
            itemRenderer.renderGuiItem(new ItemStack(Blocks.OAK_PLANKS), 232, 119);
            itemRenderer.renderGuiItemDecorations(Minecraft.getInstance().font, new ItemStack(Blocks.OAK_PLANKS), 232, 119, "1");
        }
        if(countsta == 1) {
            itemRenderer.renderGuiItem(new ItemStack(Blocks.OAK_PLANKS), 232, 119);
            itemRenderer.renderGuiItemDecorations(Minecraft.getInstance().font, new ItemStack(Blocks.OAK_PLANKS), 232, 119, "1");
        }
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }

    public void renderGuiItem(ItemStack pStack, int pX, int pY, float sX, float sY, float sZ) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        this.renderGuiItem(pStack, pX, pY, sX, sY, sZ, itemRenderer.getModel(pStack, (Level)null, (LivingEntity)null, 0));
    }

    protected void renderGuiItem(ItemStack pStack, int pX, int pY, float sX, float sY, float sZ, BakedModel pBakedModel) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        this.textureManager.getTexture(TextureAtlas.LOCATION_BLOCKS).setFilter(false, false);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_BLOCKS);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.pushPose();
        posestack.translate((double)pX, (double)pY, (double)(100.0F + itemRenderer.blitOffset));
        posestack.translate(8.0D, 8.0D, 0.0D);
        posestack.scale(1.0F, -1.0F, 1.0F);
        posestack.scale(sX, sY, sZ);
        RenderSystem.applyModelViewMatrix();
        PoseStack posestack1 = new PoseStack();
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        boolean flag = !pBakedModel.usesBlockLight();
        if (flag) {
            Lighting.setupForFlatItems();
        }

        itemRenderer.render(pStack, ItemTransforms.TransformType.GUI, false, posestack1, multibuffersource$buffersource, 15728880, OverlayTexture.NO_OVERLAY, pBakedModel);
        multibuffersource$buffersource.endBatch();
        RenderSystem.enableDepthTest();
        if (flag) {
            Lighting.setupFor3DItems();
        }

        posestack.popPose();
        RenderSystem.applyModelViewMatrix();
    }
}
