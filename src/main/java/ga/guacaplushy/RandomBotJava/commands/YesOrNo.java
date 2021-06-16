package ga.guacaplushy.RandomBotJava.commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import ga.guacaplushy.RandomBotJava.Utils;

public class YesOrNo {
    public YesOrNo(MessageChannel channel) {
        int num = (int)(Math.random() * 2);
        String YoN = "";
        if (num == 0) YoN = "No";
        if (num == 1) YoN = "Yes";
        Utils.sendMessage(channel, YoN + "!");
    }
}
