package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

public class FlipCoin {
    public FlipCoin(MessageChannel channel) {
        int num = (int)(Math.random() * 2);
        String Side = "";
        if (num == 0) Side = "Heads";
        if (num == 1) Side = "Tails";
        Utils.sendMessage(channel, Side + "!");
    }
}
