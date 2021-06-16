package ga.guacaplushy.RandomBotJava;

import ga.guacaplushy.RandomBotJava.commands.*;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import java.util.List;

public class CommandHandler {
    private final Message message;
    private final MessageChannel channel;
    private final List<String> args;
    private final Guild server;
    public CommandHandler(Guild server, Message message, List<String> args) {
        this.message = message;
        this.channel = message.getChannel();
        this.args = args;
        this.server = server;
    }
    public void runCommands(String command) {
        if (command.equals("randomnumber")) new RandomNumber(channel, args);
        if (command.equals("luckynumber")) new LuckyNumber(channel);
        if (command.equals("yesorno")) new YesOrNo(channel);
        if (command.equals("flipcoin")) new FlipCoin(channel);
        if (command.equals("binarygen")) new BinaryGen(channel, args);
        if (command.equals("colorgen")) new ColorGen(channel);
        if (command.equals("passwordgen")) new PasswordGen(message, channel, args);
        if (command.equals("impostor")) new Impostor(channel);
        if (command.equals("cooltest")) new CoolTest(channel);
        if (command.equals("smarttest")) new SmartTest(channel);
        if (command.equals("shufflesentence")) new ShuffleSentence(channel, args);
        if (command.equals("shuffle")) new Shuffle(channel, args);
        if (command.equals("shufflebyword")) new ShuffleByWord(channel, args);
        if (command.equals("dice")) new Dice(channel, args);
        if (command.equals("risktest")) new RiskTest(channel, args);
        if (command.equals("rate")) new Rate(channel, args);
        if (command.equals("randomrange")) new RandomRange(channel, args);
        if (command.equals("lettergen")) new LetterGen(channel, args);
        if (command.equals("randomuser")) new RandomUser(server, channel, args);
        if (command.equals("giveaway")) new Giveaway(server, message, channel, args);
        if (command.equals("decide")) new Decide(channel, args);
        if (command.equals("choose")) new Choose(channel, args);
        if (command.equals("eject")) new Eject(message, channel, args);
        if (command.equals("help")) new Help(message, channel);
    }
}
