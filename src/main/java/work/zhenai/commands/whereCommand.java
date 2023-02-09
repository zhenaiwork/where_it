package work.zhenai.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import static net.minecraft.server.command.CommandManager.literal;
import work.zhenai.io.config;

public class whereCommand {
    public static void where(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("where").requires( c -> c.hasPermissionLevel(0))
                .executes(c -> config.getconfig(0, c.getSource().getPlayer())));
    }
}
