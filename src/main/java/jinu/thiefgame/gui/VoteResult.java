package jinu.thiefgame.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import static jinu.thiefgame.gui.VoteGui.VOTE_FACE1;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE2;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE3;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE4;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE5;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE6;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE7;
import static jinu.thiefgame.gui.VoteGui.VOTE_FACE8;

public class VoteResult extends Screen {
    private final Minecraft minecraft;
    private static final ResourceLocation VOTE_RESULT = new ResourceLocation("thiefgame:textures/gui/voteresult.png");

    public VoteResult(Minecraft minecraft) {
        super(new TranslationTextComponent("gui.vote.result"));
        this.minecraft = minecraft;
    }

    @Override
    public boolean isPauseScreen() { return false; }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        this.minecraft.getTextureManager().bindTexture(VOTE_RESULT);
        blit(matrixStack, this.width / 2 - 106, this.height / 2 - 106, 0, 0, 212, 208, 212, 208);

        renderFaces(matrixStack, VOTE_FACE1, -79, -62, 17);
        renderFaces(matrixStack, VOTE_FACE2, -79, -39, 17);
        renderFaces(matrixStack, VOTE_FACE3, -79, -16, 17);
        renderFaces(matrixStack, VOTE_FACE4, -79, 7, 17);
        renderFaces(matrixStack, VOTE_FACE5, 6, -62, 17);
        renderFaces(matrixStack, VOTE_FACE6, 6, -39, 17);
        renderFaces(matrixStack, VOTE_FACE7, 6, -16, 17);
        renderFaces(matrixStack, VOTE_FACE8, 6, 7, 17);
        RenderSystem.disableBlend();
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    private void renderFaces(MatrixStack matrixStack, ResourceLocation resourceLocation, int offsetX, int offsetY, int whSize) {
        this.minecraft.getTextureManager().bindTexture(resourceLocation);
        blit(matrixStack, this.width / 2 + offsetX, this.height / 2 + offsetY, 0, 0, whSize, whSize, whSize, whSize);
    }
}
