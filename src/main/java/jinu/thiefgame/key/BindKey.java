package jinu.thiefgame.key;

import jinu.thiefgame.ThiefGame;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class BindKey {
    public static KeyBinding voteKey;
    public static KeyBinding abilityKey;

    public static void register() {
        voteKey = create("vote_key", KeyEvent.VK_V);
        abilityKey = create("ability_use_key", KeyEvent.VK_U);

        ClientRegistry.registerKeyBinding(voteKey);
        ClientRegistry.registerKeyBinding(abilityKey);
    }

    private static KeyBinding create(String name, int key) {
        return new KeyBinding("key." + ThiefGame.MOD_ID + "." + name, key, "key.categories." + ThiefGame.MOD_ID);
    }
}
