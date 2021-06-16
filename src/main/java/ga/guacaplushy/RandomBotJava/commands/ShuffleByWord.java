package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleByWord {
    public ShuffleByWord(MessageChannel channel, List<String> args) {
        StringBuilder outStr = new StringBuilder();
        for (String temp : args) {
            List<String> tempList = new ArrayList<>();
            Collections.addAll(tempList, temp.split(""));
            Collections.shuffle(tempList);
            outStr.append(String.join("", tempList));
            outStr.append(" ");
        }
        Utils.sendMessage(channel, outStr.toString());
    }
}
