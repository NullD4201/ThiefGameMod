package jinu.thiefgame.common;

import jinu.thiefgame.ThiefGame;
import net.minecraft.item.Item;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VoteItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThiefGame.MOD_ID);

    public static final RegistryObject<Item> VOTE_PAPER = ITEMS.register("votepaper",
            () -> new Item(new Item.Properties().group(ThiefGameGroup.THIEFGAME_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
