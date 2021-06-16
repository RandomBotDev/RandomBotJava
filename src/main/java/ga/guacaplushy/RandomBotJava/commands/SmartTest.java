package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

public class SmartTest {
    public SmartTest(MessageChannel channel) {
        Utils.sendMessage(channel, "You are " + (int) (Math.random() * 101) + "smart.");
    }
}
