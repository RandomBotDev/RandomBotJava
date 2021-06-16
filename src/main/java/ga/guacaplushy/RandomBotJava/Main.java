package ga.guacaplushy.RandomBotJava;

import com.google.gson.Gson;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main extends ListenerAdapter {
    private static final Reader reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/config.json")));
    private static final BotConfig config = new Gson().fromJson(reader, BotConfig.class);

    private final String prefix = config.getPrefix();

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createDefault(
                config.getToken(),
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGES
        );
        builder.setActivity(Activity.playing("rbjava.help | RandomBot in Java"));
        builder.addEventListeners(new Main());
        builder.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE);
        JDA jda = builder.build();
        jda.awaitReady();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        List<String> args = new ArrayList<>();
        String tempMsg = event.getMessage().getContentDisplay();
        Collections.addAll(args, tempMsg.split(" "));
        String command = args.remove(0).replace(prefix, "");
        CommandHandler cmdHandler = new CommandHandler(event.getGuild(), event.getMessage(), args);
        cmdHandler.runCommands(command);
    }
}
