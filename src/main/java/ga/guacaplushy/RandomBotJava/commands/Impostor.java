package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Impostor {
    public Impostor(MessageChannel channel) {
        int inum = (int)(Math.random() * 6);
        if (inum == 0) {
            Utils.sendMessage(channel, "Impostor.");
        }
        if (inum != 0) {
            Utils.sendMessage(channel, "Crewmate.");
        }
    }
}
