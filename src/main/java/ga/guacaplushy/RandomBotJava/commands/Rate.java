package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.math.BigDecimal;
import java.util.List;

public class Rate {
    public Rate(MessageChannel channel, List<String> args) {
        String toRate = String.join(" ", args);
        String rRated;
        if (toRate.equals("")) {
            toRate = "Nothing";
        }
        BigDecimal rated = BigDecimal.valueOf(Math.random() * 5).setScale(1, BigDecimal.ROUND_HALF_UP);
        if (rated.toString().endsWith(".0")) {
            rRated = rated.toString().replace(".0", "");
        } else {
            rRated = rated.toString();
        }
        Utils.sendMessage(channel, "I rate " + toRate + " " + rRated + " out of 5 stars.");
    }
}
