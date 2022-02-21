package jinu.thiefgame.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;

public class ThiefGameGroup {
    public static final ItemGroup THIEFGAME_GROUP = new ItemGroup("ThiefGame") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(VoteItemInit.VOTE_PAPER.get());
        }
    };
}
