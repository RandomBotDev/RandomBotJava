package ga.guacaplushy.RandomBotJava.commands;


import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Collections;
import java.util.List;

public class Shuffle {
    public Shuffle(MessageChannel channel, List<String> args) {
        String tjArgs = String.join(" ", args);
        args.clear();
        Collections.addAll(args, tjArgs.split(""));
        Collections.shuffle(args);
        String outStr = String.join("", args);
        Utils.sendMessage(channel, outStr);
    }
}
