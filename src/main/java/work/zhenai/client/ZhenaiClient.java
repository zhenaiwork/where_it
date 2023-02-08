package work.zhenai.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import static work.zhenai.commands.whereCommand.where;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class ZhenaiClient implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> where(dispatcher));

    }
}
