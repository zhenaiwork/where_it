package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import work.zhenai.io.removeLine;



public class config {
    static String url =  "config/config.yml";

    public static int getconfig(PlayerEntity player){

            try {
                String read = Files.readString(Paths.get(url.toString()));
                player.sendMessage(new LiteralText(read), false);

            } catch (IOException e) {
                player.sendMessage(new LiteralText("获取文件失败 -- IOException"), false);
            }

        return 0;
    }


    public static int writeconfig(String name, int x ,int z , PlayerEntity player){
        String write = name + ": [" + String.valueOf(x) + ", 128, " + String.valueOf(z)+ "]\n";
        try {
           Files.writeString(Paths.get(url), write , StandardOpenOption.APPEND);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("写入失败 -- IOException"), false);
        }
        return 0;
    }
    public static int remove(PlayerEntity player){
        try {
            removeLine.remove(url);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("删除失败 -- IOException"), false);
        }

        return 0;
    }
}
