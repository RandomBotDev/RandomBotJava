package ga.guacaplushy.RandomBotJava.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.Color;

public class Help {
    public Help(Message message, MessageChannel channel) {
        int r = (int)(Math.random() * 256), g = (int)(Math.random() * 256), b = (int)(Math.random() * 256);
        EmbedBuilder embed = new EmbedBuilder();
        Color col = new Color(r, g, b);
        embed.setColor(col);
        embed.setTitle("RandomBot Java Help", "https://github.com/RandomBotDev/RandomBotJava");
        embed.addField("binarygen", "Generate a random binary sequence.",true);
        embed.addField("choose", "Seperate choices with ` + `", true);
        embed.addField("colorgen", "Generate a random hex color (with RGB).", true);
        embed.addField("cooltest", "How cool are you?", true);
        embed.addField("decide", "Decide on something.", true);
        embed.addField("dice", "Rolls dice.", true);
        embed.addField("eject", "Eject an user.", true);
        embed.addField("flipcoin", "Flip a coin.", true);
        embed.addField("giveaway", "Start a giveaway.", true);
        embed.addField("help", "RandomBot Java help.", true);
        embed.addField("impostor", "Are you an impostor?", true);
        embed.addField("luckynumber", "Generates a lucky number.", true);
        embed.addField("passwordgen", "Generate a random password.", true);
        embed.addField("randomnumber", "Generates a random number.", true);
        embed.addField("rate", "Rates a thing.", true);
        embed.addField("risktest", "How risky is something?", true);
        embed.addField("shuffle", "Shuffle letters to make a random word.", true);
        embed.addField("shufflebyword", "Shuffle every word in a sentence.", true);
        embed.addField("shufflesentence", "Shuffle words to make a random sentence.", true);
        embed.addField("smarttest", "How smart are you?", true);
        embed.addField("yesorno", "Randomly choose yes or no.", true);
        String nick = message.getMember().getNickname()!=null?message.getMember().getNickname():message.getAuthor().getName();
        if (nick.equals(message.getAuthor().getName())) {
            embed.setFooter("Requested by " + message.getAuthor().getAsTag(), message.getAuthor().getEffectiveAvatarUrl());
        } else {
            embed.setFooter("Requested by " + message.getMember().getNickname() + " " + "(" + message.getAuthor().getAsTag() + ")", message.getAuthor().getEffectiveAvatarUrl());
        }
        channel.sendMessageEmbeds(embed.build()).queue();
    }
}
