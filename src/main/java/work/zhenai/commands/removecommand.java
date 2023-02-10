package work.zhenai.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import work.zhenai.io.config;
public class removecommand {
    public static void remove(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("remove").requires(c -> c.hasPermissionLevel(4)).executes(c -> help(c.getSource().getPlayer())));
        dispatcher.register(literal("remove").requires(c -> c.hasPermissionLevel(4))
                .then(argument("slot", IntegerArgumentType.integer())
                        .executes(c -> config.remove(IntegerArgumentType.getInteger(c, "slot"), c.getSource().getPlayer()))
                ));
    }

    private static int help(PlayerEntity player){
        player.sendMessage(new LiteralText("remove slot 删除slot位置的标记"), false);
        return 0;
    }
}
