package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;
import java.util.Random;

public class RandomRange {
    public RandomRange(MessageChannel channel, List<String> args) {
        int min = Integer.parseInt(args.get(0)), max = Integer.parseInt(args.get(1));
        int randomNumber = new Random().ints(min, (max + 1)).findFirst().orElse(0);
        Utils.sendMessage(channel, Integer.toString(randomNumber));
    }
}
