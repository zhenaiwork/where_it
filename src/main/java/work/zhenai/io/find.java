package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;

import java.io.File;
import java.io.IOException;

public class find {
    public static int find(String name, String url, PlayerEntity player){
        int slot = 0;
        try {
            File file = new File(url);
            int line = readLine.getTotalLines(file);
            while (slot < line) {
                slot++;
                String read = readLine.readAppointedLineNumber(file, slot);
                /*boolean d = read.matches("(.*)" + name + "(.*)");
                player.sendMessage(new LiteralText(String.valueOf(d)), false);
                System.out.println(d);*/
                if (read.matches("(.*)" + name + "(.*)")){
                    for (int x = 0;x < 3; x++){
                        String readSlot = readLine.readAppointedLineNumber(file, slot + x);
                        player.sendMessage(new LiteralText(readSlot), false);
                    }
                }
            }

        } catch (IOException e) {
        player.sendMessage(new LiteralText("IOException"), false);
        }
        return 0;
    }
}
