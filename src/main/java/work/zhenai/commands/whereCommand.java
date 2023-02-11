package work.zhenai.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import work.zhenai.io.config;

public class whereCommand {
    public static void where(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("where").executes( c -> help(c.getSource().getPlayer())));
        dispatcher.register(literal("where").then(literal("it_all").executes(c -> config.getconfig(c.getSource().getPlayer()))));
    }
    private static int help(PlayerEntity player){
        player.sendMessage(new LiteralText("it_all 查看所有坐标"), false);
        return 0;
    }

}
