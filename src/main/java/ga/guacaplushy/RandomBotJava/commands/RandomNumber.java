package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class RandomNumber {
    public RandomNumber(MessageChannel channel, List<String> args) {
        int number = 1000000;
        try {
            number = Integer.parseInt(args.get(0));
        } catch (Exception ignored) {
        }
        Utils.sendMessage(channel, Integer.toString((int)(Math.random() * (number + 1))));
    }
}
