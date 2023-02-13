package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class config {
    static String url =  "config/config.yml";

    public static int getconfig(PlayerEntity player){
        int slot = 0;
        try {
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
            removeLine.remove(url);
            removeLine.remove(url);
            removeLine.remove(url);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("删除失败 -- IOException"), false);
        }

        return 0;
    }

    private static int write(String write, PlayerEntity player){
        try {
            Files.writeString(Paths.get(url), write , StandardOpenOption.APPEND);
        } catch (IOException e) {
            player.sendMessage(new LiteralText("写入失败 -- IOException"), false);
        }
        return 0;
    }
}


