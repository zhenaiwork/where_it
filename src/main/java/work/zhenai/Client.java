package work.zhenai;

import net.minecraft.text.LiteralText;
import net.minecraft.entity.player.PlayerEntity;
import static net.minecraft.server.command.CommandManager.*;
import static net.minecraft.server.command.CommandManager.literal;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.main.Main;

import javax.swing.*;

import static work.zhenai.commands.whereCommand.where;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class Client implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> where(dispatcher)
        );
    }
}
