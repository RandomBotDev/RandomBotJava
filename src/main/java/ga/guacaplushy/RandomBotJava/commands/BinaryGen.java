package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class BinaryGen {
    public BinaryGen(MessageChannel channel, List<String> args) {
        int length = 20;
        try {
            length = Integer.parseInt(args.get(0));
        } catch (Exception ignored) {

        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int x = 0; x < 8; x++) {
                output.append((int) (Math.random() * 2));
            }
            output.append(" ");
        }
        try {
            Utils.sendMessage(channel, output.toString());
        } catch (IllegalArgumentException ex) {
            Utils.sendMessage(channel,"An error has appeared...");
        }
    }
}
