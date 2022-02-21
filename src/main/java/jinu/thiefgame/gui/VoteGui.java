package jinu.thiefgame.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import jinu.thiefgame.ThiefGame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.net.URL;

@OnlyIn(Dist.CLIENT)
//public class VoteGui extends IngameMenuScreen {
public class VoteGui extends Screen {
    public static final ResourceLocation VOTE_CLICK = new ResourceLocation("thiefgame:textures/gui/voteclick.png");
    public static final ResourceLocation VOTE_SKIP = new ResourceLocation("thiefgame:textures/gui/voteskip.png");
    public static final ResourceLocation VOTE_FACE1 = new ResourceLocation("thiefgame:textures/gui/face1.png");
    public static final ResourceLocation VOTE_FACE2 = new ResourceLocation("thiefgame:textures/gui/face2.png");
    public static final ResourceLocation VOTE_FACE3 = new ResourceLocation("thiefgame:textures/gui/face3.png");
    public static final ResourceLocation VOTE_FACE4 = new ResourceLocation("thiefgame:textures/gui/face4.png");
    public static final ResourceLocation VOTE_FACE5 = new ResourceLocation("thiefgame:textures/gui/face5.png");
    public static final ResourceLocation VOTE_FACE6 = new ResourceLocation("thiefgame:textures/gui/face6.png");
    public static final ResourceLocation VOTE_FACE7 = new ResourceLocation("thiefgame:textures/gui/face7.png");
    public static final ResourceLocation VOTE_FACE8 = new ResourceLocation("thiefgame:textures/gui/face8.png");
    private final Minecraft minecraft;

    public VoteGui(Minecraft minecraft) {
        super(new TranslationTextComponent("gui.vote.click"));
        this.minecraft = minecraft;
    }

    @Override
    protected void init() {
        try {
            URL voteURL = new URL("http://localhost:3000/users/get");
            this.addButtons();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int whSize = 21;
    private void addButtons() {
        SoundHandler handler = Minecraft.getInstance().getSoundHandler();

        this.addButton(new ImageButton(this.width / 2 - 92, this.height / 2 - 45, whSize, whSize, 0, 0, 0,
                VOTE_FACE1, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 - 37, this.height / 2 - 45, whSize, whSize, 0, 0, 0,
                VOTE_FACE2, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 + 16, this.height / 2 - 45, whSize, whSize, 0, 0, 0,
                VOTE_FACE3, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 + 71, this.height / 2 - 45, whSize, whSize, 0, 0, 0,
                VOTE_FACE4, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 - 92, this.height / 2 + 10, whSize, whSize, 0, 0, 0,
                VOTE_FACE5, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 - 38, this.height / 2 + 10, whSize, whSize, 0, 0, 0,
                VOTE_FACE6, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 + 16, this.height / 2 + 10, whSize, whSize, 0, 0, 0,
                VOTE_FACE7, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 + 71, this.height / 2 + 10, whSize, whSize, 0, 0, 0,
                VOTE_FACE8, whSize, whSize,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.face"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.face")));
        this.addButton(new ImageButton(this.width / 2 - 36, this.height / 2 + 57, 72, 21, 0, 0, 0,
                VOTE_SKIP, 72, 21,
                (button) -> {
                    handler.stop();
                    handler.play(SimpleSound.master(SoundEvents.ENTITY_ITEM_BREAK, 1.0F));

        }, (button, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, minecraft.fontRenderer.trimStringToWidth(new TranslationTextComponent("gui.vote.skip"), Math.max(this.width / 2 - 43, 170)), mouseX, mouseY);
        }, new TranslationTextComponent("gui.vote.skip")));
    }

    @Override
    public boolean isPauseScreen() {return false;}

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        this.minecraft.getTextureManager().bindTexture(VOTE_CLICK);
        blit(matrixStack, this.width / 2 - 126, this.height / 4 * 2 + -105, 0, 0, 252, 210, 252, 210);
        RenderSystem.disableBlend();
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    private void drawWindowToolTips(MatrixStack matrixStack, int mouseX, int mouseY, int offsetX, int offsetY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);;
    }
}
