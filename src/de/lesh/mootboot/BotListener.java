package de.lesh.mootboot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.Color;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.user.userList;

public class BotListener extends ListenerAdapter {

    public static final Long mootLesh = 155704314638106624L;
    public static final Long mootCAnders = 141602927084044288L;
    public static final Long mootReiniee = 208999661262995457L;

    public static List<Long> idList = new ArrayList<>();

    public static Command[] commands = new Command[]{new CommandUser()};

    public void onReady(ReadyEvent e){
        idList.add(mootLesh);
        idList.add(mootCAnders);
        idList.add(mootReiniee);
    }

    public static Map<User, Integer> map = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //anyMessage
        for(Command c:commands){
            c.onMessageAnyReceived(event);
        }
        //Commands...
        if(!idList.contains(event.getAuthor().getIdLong())){
            return;
        }
        boolean succeed = false;
        for(Command c: commands) {
            if(event.getMessage().getRawContent().toLowerCase().startsWith(lib.prefix + c.getName())){
                succeed = true;
                c.execute(event.getMessage().getRawContent(),event.getMessage().getRawContent().split(" "), event);
            }
        }
        if(event.getMessage().getRawContent().startsWith(lib.prefix)&&!succeed){
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + ". I'm sorry. That's an unknown Command!").queue();
            return;
        }
        //This os old unused stuff. It's here for reference and to copy the old implementation into new Classes for them...
        // PING - PONG
        switch (event.getMessage().getRawContent().toLowerCase()) {
            case lib.prefix + "playPing" : {
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();
                break;
            }
            case lib.prefix + "help" : {
                event.getChannel().sendMessage(help.help).queue();
                break;
            }
            case lib.prefix + "github" : {
                event.getChannel().sendMessage(">> Source Code: <https://github.com/LeshDev/MOOTBoot/tree/master/src/de/lesh/mootboot>").queue();
                break;
            }
            case lib.prefix + "twitch lesh" : {
                event.getChannel().sendMessage(twitch.leshLive).queue();
                break;
            }
            case lib.prefix + "twitch noah" : {
                event.getChannel().sendMessage(twitch.noahLive).queue();
                break;
            }
            case lib.prefix + "twitch" : {
                event.getChannel().sendMessage(">> Der User ist nicht in der Livelist eingetragen").queue();
                break;
            }
            case lib.prefix + "lisst" : {
                event.getChannel().sendMessage(userList.allMoots).queue();
                break;
            }
            case lib.prefix + "game" : {
                //changeCurGame.changeGame("ewGame");
                break;
            }
            case lib.prefix + "time" : {
                event.getChannel().sendMessage(">> " + clock.currentTime()).queue();
                break;
            }
            case lib.prefix + "ping" : {
                long start = System.currentTimeMillis();
                event.getChannel().sendTyping().queue(typed -> event.getChannel().sendMessage(
                    new EmbedBuilder().addField("Ping:", "**Discord Bot:** " + event.getJDA().getPing()+"ms\n" +
                        "**You:** " + (System.currentTimeMillis() - start) + "ms", false).setColor(Color.WHITE)
                        .build()).queue());
                break;
            }
            case lib.prefix + "user" : {
                event.getChannel().sendMessage(new MessageBuilder().append("Generating infocard for: ").append(event.getAuthor().getName())
                    .setEmbed(new EmbedBuilder()
                        .setAuthor("Infocard for: " + event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl())
                        .addField("Member", event.getAuthor().getAsMention(), true)
                        .addBlankField(true)
                        .addField("Sent Messages",""+map.getOrDefault(event.getAuthor(),0), true)
                        .setColor(Color.GREEN)
                        .build())
                    .build()).queue();
                break;
            }
        }
    }
}
