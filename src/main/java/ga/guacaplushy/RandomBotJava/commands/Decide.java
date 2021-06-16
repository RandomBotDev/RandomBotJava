package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decide {
    public Decide(MessageChannel channel, List<String> args) {
        try {
            args.get(0);
            return;
        } catch (Exception ex) {
            Utils.sendMessage(channel, "What do I decide on?");
        }
        List<String> choices = new ArrayList<>();
        Collections.addAll(choices, "Yes.", "For sure!", "Maybe.", "I don't know.", "No.", "Definently not.", "Definently!");
        int choice = (int)(Math.random() * (choices.size() + 1));
        String chosen = choices.get(choice);
        Utils.sendMessage(channel, chosen);
    }
}
