package de.lesh.mootboot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.games.changeCurGame;
import de.lesh.mootboot.info.userInfo;
import de.lesh.mootboot.user.userList;

public class BotListener extends ListenerAdapter{
	
	public static final Long mootLesh = 155704314638106624L;
	public static final Long mootCAnders = 141602927084044288L;
	public static final Long mootReiniee = 208999661262995457L;
	
	public static List<Long> idList = new ArrayList<>();
	
	public void onReady(ReadyEvent e){
		idList.add(mootLesh);
		idList.add(mootCAnders);
		idList.add(mootReiniee);	
	}
	

	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(idList.contains(event.getAuthor().getIdLong())){
			
			// PING - PONG
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "playPing")) {
				event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();
			}
		
			// HELP Message
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "help")){
				event.getChannel().sendMessage(help.help).queue();
			}
			
			// TWTICH Message
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "twitch lesh")){
				event.getChannel().sendMessage(twitch.leshLive).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "twitch noah")){
				event.getChannel().sendMessage(twitch.noahLive).queue();
			}else{
				event.getChannel().sendMessage(">> Der User ist nicht in der Livelist eingetragen");
			}
			
			// AllMoots Message
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "list")){
				event.getChannel().sendMessage(userList.allMoots).queue();
			}
			
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "game")){
				//changeCurGame.changeGame("ewGame");
			}
			
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "time")){
				event.getChannel().sendMessage(">> " + clock.currentTime()).queue();
			}
			
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "ping")){
				event.getChannel().sendMessage("Waiting for ping:")
				.queue(msg->event.getChannel().sendMessage(new EmbedBuilder()
						.addField("Ping:","**Discord Bot:** " + event.getJDA().getPing() + "ms\n" /*+ "**You:** " + String.valueOf((msg.getCreationTime().getNano() / 1000000) - (event.getMessage().getCreationTime().getNano() / 1000000)) +"ms"*/, true)
						.setColor(java.awt.Color.WHITE)
						.build())
						.queue());
			}
			
			
			
			
			
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "user")){
				event.getChannel().sendMessage("Generating Infocard for: " + event.getAuthor().getName())
						.queue(msg->event.getChannel().sendMessage(new EmbedBuilder()
									.setAuthor("Infocard for: " + event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl())
									.addField("Member", event.getAuthor().getAsMention(), true)
									.addBlankField(true)
									.addField("Send Messages", String.valueOf(Main.sentMSG + 1), true)
									.setColor(java.awt.Color.GREEN)
									.build())
									.queue());
			}
		}else{
			//event.getChannel().sendMessage(event.getAuthor().getAsMention() + " >> Du hast keine Berechtigung daf�r!").queue();
		}
	}
}
