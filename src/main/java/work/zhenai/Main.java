package work.zhenai;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.zhenai.commands.whereCommand;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main implements ModInitializer {
    //public static final Logger LOGGER = LoggerFactory.getLogger("zhenai_");

    @Override
    public void onInitialize() {
        //LOGGER.info("Hello Fabric world! ~~~~~~~~~~~~");
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> whereCommand.where(dispatcher)
        );

    }
}
