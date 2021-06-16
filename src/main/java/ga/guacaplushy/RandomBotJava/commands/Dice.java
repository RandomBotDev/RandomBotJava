package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class Dice {
    public Dice(MessageChannel channel, List<String> args) {
        int amt = 2, sides = 6;
        StringBuilder out = new StringBuilder();
        try {
            amt = Integer.parseInt(args.get(0));
            sides = Integer.parseInt(args.get(1));
        } catch (Exception ignored) {

        }
        for (int i = 0; i < amt; i++) {
            out.append((int) (Math.random() * (sides + 1)));
            if (i != amt-1) {
                out.append(", ");
            }
        }
        Utils.sendMessage(channel, out.toString());
    }
}
