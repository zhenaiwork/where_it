package work.zhenai.commands;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import work.zhenai.io.config;
public class makeCommand {
    public static void make(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("make").executes(c -> help(c.getSource().getPlayer())));

        dispatcher.register(literal("make").requires(c -> c.hasPermissionLevel(4))
                .then(argument("name", StringArgumentType.string())
                        .then(argument("dimension", IntegerArgumentType.integer())
                        .then(argument("x", IntegerArgumentType.integer())
                        .then(argument("z", IntegerArgumentType.integer())
                                .executes(c -> config.writeconfig(StringArgumentType.getString(c, "name"),
                        IntegerArgumentType.getInteger(c, "dimension"),
                        IntegerArgumentType.getInteger(c, "x"),
                        IntegerArgumentType.getInteger(c, "z"), c.getSource().getPlayer()))
        )))));
    }

    private static int help(PlayerEntity player){
        player.sendMessage(new LiteralText("make \"name\" dimension x z \n dimension为维度，00主世界，-1下界，01末地"), false);
        return 0;
    }
}
