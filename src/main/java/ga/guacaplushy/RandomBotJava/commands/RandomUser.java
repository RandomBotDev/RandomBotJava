package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Member;

import java.util.Collections;
import java.util.List;

public class RandomUser {
    public RandomUser(Guild server, MessageChannel channel, List<String> args) {
        List<Member> members = new java.util.ArrayList<>(Collections.emptyList());
        if (args.get(0).equals("bot")) {
             server.getMembers().forEach(member -> {
                 if (member.getUser().isBot()) members.add(member);
             });
        }
        if (args.get(0).equals("user")) {
            server.getMembers().forEach(member -> {
                if (!member.getUser().isBot()) members.add(member);
            });
        }
        if (!args.get(0).equals("user") && !args.get(0).equals("bot")) {
            members.addAll(server.getMembers());
        }
        int userNumber = (int)(Math.random() * (members.size() + 1));
        Member chosenMember = members.get(userNumber);
        Utils.sendMessage(channel, "I choose " + chosenMember.getUser().getAsTag());
    }
}
