package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Collections;
import java.util.List;

public class ShuffleSentence {
    public ShuffleSentence(MessageChannel channel, List<String> args) {
        Collections.shuffle(args);
        String outStr = String.join(" ", args);
        Utils.sendMessage(channel, outStr);
    }
}
