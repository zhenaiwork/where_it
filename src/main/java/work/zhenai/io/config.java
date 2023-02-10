package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.system.CallbackI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class config {

    public static int getconfig(int slot , PlayerEntity player){
        if (slot < 0){
            player.sendMessage(new LiteralText("你看你妈呢！！！"),false);
        }if (slot == 0){
            //URL read =
        }
        return 0;
    }
    public static int writeconfig(String name, int x ,int z , PlayerEntity player){
        player.sendMessage(new LiteralText(name + x + z), false);
        return 0;
    }
    public static int remove(int slot, PlayerEntity player){
        player.sendMessage(new LiteralText(String.valueOf(slot)), false);

        return 0;
    }
}
