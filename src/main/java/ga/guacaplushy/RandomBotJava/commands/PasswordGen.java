package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGen {
    public PasswordGen(Message message, MessageChannel channel, List<String> args) {
        int length = 20;
        List<String> tempList = new ArrayList<>();
        StringBuilder password = new StringBuilder();
        try {
            length = Integer.parseInt(args.get(0));
        } catch (Exception ignored) {

        }
        String[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*();,./':<>?\\[]}{-=+".split("");
        Collections.addAll(tempList, chars);
        for (int i = 0; i < length; i++) {
            password.append(tempList.get((int) (Math.random() * (chars.length) * 1)));
        }
        final String pass = password.toString();
        try {
            message.getAuthor().openPrivateChannel().queue(DM -> DM.sendMessage(pass).queue());
        } catch (Exception ex) {
            Utils.sendMessage(channel,"An error has appeared...");
        }
    }
}
