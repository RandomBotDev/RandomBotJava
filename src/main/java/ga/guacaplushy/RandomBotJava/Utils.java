package ga.guacaplushy.RandomBotJava;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Utils {
    public static void sendMessage(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
