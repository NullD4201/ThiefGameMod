package jinu.thiefgame.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import jinu.thiefgame.gui.VoteGui;
import jinu.thiefgame.gui.VoteResult;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.entity.Entity;

public class ScreenCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> mbesayCommand = Commands.literal("voteresult")
            .requires((commandSource) -> commandSource.hasPermissionLevel(2))
            .executes(ScreenCommand::commandRun);

        dispatcher.register(mbesayCommand);
    }

    static int commandRun(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        Entity entity = commandContext.getSource().getEntity();
        Minecraft.getInstance().displayGuiScreen(new VoteResult(Minecraft.getInstance()));
        return 1;
    }
}