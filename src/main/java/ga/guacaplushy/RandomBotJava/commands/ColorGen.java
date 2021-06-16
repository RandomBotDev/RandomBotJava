package ga.guacaplushy.RandomBotJava.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;

public class ColorGen {
    public ColorGen(MessageChannel channel) {
        int r = (int)(Math.random() * 256), g = (int)(Math.random() * 256), b = (int)(Math.random() * 256);
        EmbedBuilder embed = new EmbedBuilder();
        Color col = new Color(r, g, b);
        embed.setColor(col);
        String colhex = "#" + Integer.toHexString(col.getRGB()).substring(2);
        embed.setTitle(colhex+" (" + r + ", " + g + ", " + b +")");
        channel.sendMessageEmbeds(embed.build()).queue();
    }
}
