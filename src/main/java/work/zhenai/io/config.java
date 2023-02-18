package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.system.CallbackI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class config {
    static String url =  "config/config.yml";

    public static int getconfig(int i, String name, PlayerEntity player){
        if (i == 0){
            int slot = 0;
            try {
                player.sendMessage(new LiteralText("---------------服务器所有坐标---------------"), false);

                File file = new File(url);
                int line = readLine.getTotalLines(file);
                while (slot < line) {
                    slot++;
                    String readSlot = readLine.readAppointedLineNumber(file, slot);
                    player.sendMessage(new LiteralText((readSlot)), false);
                }

            } catch (IOException e) {
                player.sendMessage(new LiteralText("获取文件失败 -- IOException"), false);
            }
        }
        if (i == 1){
            player.sendMessage(new LiteralText("---------------检索到 " + name + " 的相关内容---------------"),false);
            find.find(name, url, player);
        }
        return 0;
    }


    public static int writeconfig(String name, int dimension, int x , int z , PlayerEntity player) {
        if (dimension == 00) {
            String write = "00 " + name + ":\n    主世界: [" + x + ", 72, " + z + "]\n" +
                    "    下界: [" + x/8 + ", 128, " + z/8 + "]\n";
            write(write, player);
        }else if (dimension == -1) {
            String write = "-1 " + name + ":\n    下界: [" + x + ", 128, " + z + "]\n \n";
            write(write, player);
        }else if (dimension == 01) {
            String write = "01 " + name + ":\n    末地: [" + x + ", 64, " + z + "]\n \n";
            write(write, player);
        }else {
            player.sendMessage(new LiteralText("你 make 你妈呢！！！"), false);
        }
        return 0;
    }


    public static int remove(PlayerEntity player){
        try {
            for (int i = 0; i < 3; i++){
                removeLine.remove(url);
            }
            player.sendMessage(new LiteralText("---------------last已删除---------------"), false);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("删除失败 -- IOException"), false);
        }

        return 0;
    }

    private static int write(String write, PlayerEntity player){
        try {
            player.sendMessage(new LiteralText("---------------添加坐标成功---------------"), false);
            Files.writeString(Paths.get(url), write , StandardOpenOption.APPEND);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("写入失败 -- IOException"), false);
        }
        return 0;
    }
}


