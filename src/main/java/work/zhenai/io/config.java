package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.system.CallbackI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class config {
    static String url =  "config/config.yml";

    public static int getconfig(int slot , PlayerEntity player){
        if (slot < 0){
            player.sendMessage(new LiteralText("你看你妈呢！！！"),false);
        }if (slot == 0) {
            try {
                String read = Files.readString(Paths.get(url.toString()));
                player.sendMessage(new LiteralText(read), false);

            } catch (IOException e) {
                player.sendMessage(new LiteralText("获取文件失败 -- IOException"), false);
            }
        }if (slot > 0){
            try {
                String list = String.valueOf(Files.readAllLines(Paths.get(url.toString())));
                player.sendMessage(new LiteralText(list),false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            player.sendMessage(new LiteralText(String.valueOf(slot)), false);
        }
        return 0;
    }


    public static int writeconfig(String name, int x ,int z , PlayerEntity player){
        String write = "\n" + name + ": {" + String.valueOf(x) + ", " + String.valueOf(z)+ "}";
        try {
           Files.writeString(Paths.get(url), write , StandardOpenOption.APPEND);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("写入失败 -- IOException"), false);
        }
        return 0;
    }
    public static int remove(int slot, PlayerEntity player){
        player.sendMessage(new LiteralText("不做了"), false);

        return 0;
    }
}
