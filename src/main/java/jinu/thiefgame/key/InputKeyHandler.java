package jinu.thiefgame.key;

import jinu.thiefgame.common.VoteItemInit;
import jinu.thiefgame.gui.VoteGui;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class InputKeyHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (BindKey.voteKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("vote");
            if (!Minecraft.getInstance().player.inventory.hasItemStack(VoteItemInit.VOTE_PAPER.get().getDefaultInstance()))
                    Minecraft.getInstance().player.inventory.addItemStackToInventory(VoteItemInit.VOTE_PAPER.get().getDefaultInstance());
            Minecraft.getInstance().displayGuiScreen(new VoteGui(Minecraft.getInstance()));
        } else if (BindKey.abilityKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("ability");
        }
    }
}
