package ga.guacaplushy.RandomBotJava.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Eject {
    public Eject(Message message, MessageChannel channel, List<String> args) {
        int inum = (int)(Math.random() * 6);
        String impostor = "";
        if (inum == 0) {
            impostor = "true";
        }
        if (inum != 0) {
            impostor = "false";
        }
        List<String> colors = new ArrayList<>();
        Collections.addAll(colors, "black", "blue", "brown", "cyan", "darkgreen", "lime", "orange", "pink", "purple", "red", "white", "yellow");
        int userNumber = (int)(Math.random() * (colors.size() + 1));
        String color = colors.get(userNumber);
        String username;
        try {
            username = String.join(" ", args);
        } catch (Exception ex) {
            username = message.getAuthor().getName();
        }
        String encname;
        try {
            encname = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
        String url = "https://vacefron.nl/api/ejected?name=" + encname + "&impostor=" + impostor + "&crewmate=" + color;
        EmbedBuilder embed = new EmbedBuilder();
        embed.setImage(url);
        channel.sendMessageEmbeds(embed.build()).queue();
    }
}
