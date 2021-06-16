package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class RiskTest {
    public RiskTest(MessageChannel channel, List<String> args) {
        String toTest = String.join(" ", args);
        if (toTest.equals("")) {
            toTest = "Nothing";
        }
        Utils.sendMessage(channel, toTest + " is " + (int) (Math.random() * 101) + "% risky.");
    }
}
