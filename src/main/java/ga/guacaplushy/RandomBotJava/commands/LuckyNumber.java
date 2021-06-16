package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

public class LuckyNumber {
    public LuckyNumber(MessageChannel channel) {
        Utils.sendMessage(channel, Integer.toString((int)(Math.random() * 101)));
    }
}
