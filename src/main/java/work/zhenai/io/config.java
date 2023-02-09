package work.zhenai.io;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class config {


    public static int getconfig(int a , PlayerEntity player){
        URL reader = config.class.getClassLoader().getResource("resources/config.json");
        String readerConfig = Files.readString(Paths.get(reader.toURI()));
        player.sendMessage(new LiteralText(readerConfig), false);
        System.out.println(readerConfig);
        return 0;
    }
}
