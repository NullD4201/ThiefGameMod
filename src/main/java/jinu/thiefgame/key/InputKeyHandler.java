package jinu.thiefgame.key;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class InputKeyHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (BindKey.voteKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("vote");
        } else if (BindKey.abilityKey.isPressed()) {
            Minecraft.getInstance().player.sendChatMessage("ability");
        }
    }
}
