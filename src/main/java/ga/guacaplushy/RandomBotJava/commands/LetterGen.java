package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterGen {
    public LetterGen(MessageChannel channel, List<String> args) {
        List<String> tempList = new ArrayList<>();
        StringBuilder letter = new StringBuilder();
        String[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        Collections.addAll(tempList, chars);
        letter.append(tempList.get((int) (Math.random() * (chars.length) * 1)));
        final String pass = letter.toString();
        try {
            Utils.sendMessage(channel, pass);
        } catch (Exception ex) {
            Utils.sendMessage(channel,"An error has appeared...");
        }
    }
}
