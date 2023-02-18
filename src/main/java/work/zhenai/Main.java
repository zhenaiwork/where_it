package work.zhenai;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import work.zhenai.commands.makeCommand;
import work.zhenai.commands.removecommand;
import work.zhenai.commands.whereCommand;

public class Main implements ModInitializer {
    //public static final Logger LOGGER = LoggerFactory.getLogger("zhenai_");

    @Override
    public void onInitialize() {
        // LOGGER.info("Hello Fabric world! ~~~~~~~~~~~~");
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> whereCommand.where(dispatcher)
        );

        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> makeCommand.make(dispatcher)
        );

        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> removecommand.remove(dispatcher)
        );

    }
}
