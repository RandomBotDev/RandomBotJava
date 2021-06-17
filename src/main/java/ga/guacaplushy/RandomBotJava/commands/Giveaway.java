package ga.guacaplushy.RandomBotJava.commands;

import ga.guacaplushy.RandomBotJava.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Giveaway {
    Message message;
    MessageChannel channel;
    int time;
    Message gwemb;
    int gtime = 0;
    String gprize = "";
    TextChannel gchannel;

    private List<String> GetTime(int time) {
        int d = (int)Math.floor(time / (float)(3600*24));
        int h = (int)Math.floor(time % (3600*24) / (float)3600);
        int m = (int)Math.floor(time % 3600 / (float)60);
        int s = (int)Math.floor(time % 60);

        String dDisplay = d > 0 ? d + (d == 1 ? " day, " : " days, ") : "";
        String hDisplay = h > 0 ? h + (h == 1 ? " hour, " : " hours, ") : "";
        String mDisplay = m > 0 ? m + (m == 1 ? " minute, " : " minutes, ") : "";
        String sDisplay = s > 0 ? s + (s == 1 ? " second" : " seconds") : "";
        List<String> times = new ArrayList<>(Collections.emptyList());
        times.add(dDisplay);
        times.add(hDisplay);
        times.add(mDisplay);
        times.add(sDisplay);
        return times;
    }

    class GiveawayLoop implements Runnable {
        @Override
        public void run() {
            final String[] timeStrLst = {""};
            GetTime(time).forEach(dhms -> timeStrLst[0] = timeStrLst[0] + dhms);
            String timeStr = timeStrLst[0];
            if (time <= 0 || timeStr.equals("")) {
                List<String> reactors = new ArrayList<>();
                Message gwMsg;
                gwMsg = channel.retrieveMessageById(gwemb.getId()).complete();
                gwMsg.getReactions().forEach(r -> {
                    if (r.getReactionEmote().getEmoji().equals("\uD83C\uDF89")) {
                        r.retrieveUsers().forEach(user -> {
                            if (!user.getId().equals(r.getJDA().getSelfUser().getId())) reactors.add(user.getAsTag());
                        });
                    }
                });
                Collections.shuffle(reactors);
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(reactors.stream().findAny().map(Object::toString).orElse("Nobody") + " won the " + gprize + " giveaway!");
                gwMsg.editMessageEmbeds(embed.build()).queue();
                return;
            }
            time = time - 10;
            EmbedBuilder nembed = new EmbedBuilder();
            nembed.addField("Prize", gprize, false);
            nembed.addField("Time", timeStr, false);
            nembed.addField("Host", message.getAuthor().getAsTag(), false);
            gwemb.editMessageEmbeds(nembed.build()).queue();
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

            executorService.schedule(this, 10, TimeUnit.SECONDS);
    }}

    public Giveaway(Guild guild, Message message, MessageChannel channel, List<String> args) {
        try {
            String gci = args.get(0).replace("#", "");
            gchannel = guild.getTextChannelsByName(gci, false).get(0);
            gtime = Integer.parseInt(args.get(1));
            gprize = args.get(2);
        } catch (Exception ex) {
            Utils.sendMessage(channel, "Missing param/error!");
        }
        this.message = message;
        this.channel = channel;
        this.time = gtime;
        final String[] timeStrLst = {""};
        this.GetTime(time).forEach(dhms -> timeStrLst[0] = timeStrLst[0] + dhms);
        String timeStr = timeStrLst[0];
        EmbedBuilder embed = new EmbedBuilder();
        embed.addField("Prize", gprize, false);
        embed.addField("Time", timeStr, false);
        embed.addField("Host", message.getAuthor().getAsTag(), false);
        gchannel.sendMessageEmbeds(embed.build()).queue(message1 -> {
            message1.addReaction("\uD83C\uDF89").queue();
            gwemb = message1;
            new GiveawayLoop().run();
        });
    }
}
