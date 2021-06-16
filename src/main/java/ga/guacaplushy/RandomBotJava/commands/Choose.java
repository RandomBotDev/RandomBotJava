package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Choose {
    public Choose(MessageChannel channel, List<String> args) {
        List<String> options = new ArrayList<>();
        String joined = String.join(" ", args);
        options.clear();
        Collections.addAll(options, joined.split(" \\+ "));
        int choice = (int)(Math.random() * (options.size() + 1));
        String chosen = options.get(choice);
        Utils.sendMessage(channel, chosen);
    }
}
