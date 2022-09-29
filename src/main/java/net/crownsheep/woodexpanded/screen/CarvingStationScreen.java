package net.crownsheep.woodexpanded.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.block.entity.CarvingStationBlockEntity;
import net.crownsheep.woodexpanded.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CarvingStationScreen extends AbstractContainerScreen<CarvingStationMenu> {
    public static ItemStack[] statues = {new ItemStack(ModBlocks.COW_STATUE.get()), new ItemStack(ModBlocks.PIG_STATUE.get()), new ItemStack(ModBlocks.CHICKEN_STATUE.get()), new ItemStack(ModBlocks.CREEPER_STATUE.get()), new ItemStack(ModBlocks.OLD_PLANKS.get()), new ItemStack(ModBlocks.PINE_LEAVES.get())};
    public static int countsta = 0;

    private final CarvingStationBlockEntity blockEntity;
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(WoodExpended.MOD_ID, "textures/gui/carving_station_gui.png");
    public final TextureManager textureManager;

    public CarvingStationScreen(CarvingStationMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        blockEntity = menu.blockEntity;
        textureManager = new TextureManager(ResourceManager.Empty.INSTANCE);
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(new Button(285, 80, 16, 16, Component.literal(">"), (n) -> {
            rightButtonClick();
        }));
        this.addRenderableWidget(new Button(180, 80, 16, 16, Component.literal("<"), (n) -> {
            leftButtonClick();
        }));
        this.addRenderableWidget(new Button(258, 117, 60, 16, Component.literal("Carve"), (n) -> {
            carve();
        }));
    }

    void rightButtonClick() {
        if (countsta < statues.length - 1) {
            countsta++;
        } else {
            countsta = 0;
        }
    }

    void leftButtonClick() {
        if (countsta > 0) {
            countsta--;
        } else {
            countsta = statues.length - 1;
        }
    }

    void carve() {
        if (minecraft.player.getInventory().contains(Blocks.OAK_PLANKS.asItem().getDefaultInstance())) {
            minecraft.player.level.playLocalSound(blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ(), ModSounds.CARVING_WOOD.get(), SoundSource.BLOCKS, 1, 1, true);
            if (countsta == 0) {
                CarvingStationBlockEntity.carve = true;
                CarvingStationBlockEntity.mayPickup = true;
                CarvingStationBlockEntity.slotStack = new ItemStack(ModBlocks.COW_STATUE.get());
            }
        }
        if (minecraft.player.getInventory().contains(Blocks.OAK_PLANKS.asItem().getDefaultInstance())) {
            minecraft.player.level.playLocalSound(blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ(), ModSounds.CARVING_WOOD.get(), SoundSource.BLOCKS, 1, 1, true);
            if (countsta == 1) {
                CarvingStationBlockEntity.carve = true;
                CarvingStationBlockEntity.mayPickup = true;
                CarvingStationBlockEntity.slotStack = new ItemStack(ModBlocks.PIG_STATUE.get());
            }
        }
        if (minecraft.player.getInventory().contains(Blocks.OAK_PLANKS.asItem().getDefaultInstance())) {
            minecraft.player.level.playLocalSound(blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ(), ModSounds.CARVING_WOOD.get(), SoundSource.BLOCKS, 1, 1, true);
            if (countsta == 2) {
                CarvingStationBlockEntity.carve = true;
                CarvingStationBlockEntity.mayPickup = true;
                CarvingStationBlockEntity.slotStack = new ItemStack(ModBlocks.CHICKEN_STATUE.get());
            }
        }
    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        Minecraft.getInstance().font.draw(pPoseStack, Component.translatable(""), 170, 90, 4210752);
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        renderGuiItem(statues[countsta], 232, 80, 38.0F, 38.0F, 38.0F);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }

    public void renderGuiItem(ItemStack pStack, int pX, int pY, float sX, float sY, float sZ) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        this.renderGuiItem(pStack, pX, pY, sX, sY, sZ, itemRenderer.getModel(pStack, (Level) null, (LivingEntity) null, 0));
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
        posestack.translate((double) pX, (double) pY, (double) (100.0F + itemRenderer.blitOffset));
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
