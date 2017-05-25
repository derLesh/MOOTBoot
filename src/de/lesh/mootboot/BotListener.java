package de.lesh.mootboot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.user.userList;

public class BotListener extends ListenerAdapter{
	
	public static final Long mootLesh = 155704314638106624L;
	public static final Long mootCAnders = 141602927084044288L;
	public static final Long mootReiniee = 208999661262995457L;
	
	public static List<Long> idList = new ArrayList<>();
	
	public static Command[] commands = new Command(){
		new CommandUser()};
	
	public void onReady(ReadyEvent e){
		idList.add(mootLesh);
		idList.add(mootCAnders);
		idList.add(mootReiniee);	
	}
	
        public static Map<User, Integer> map = new HashMap<>();
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(idList.contains(event.getAuthor().getIdLong())){
			for(Command c: command) {
				if(event.getMessage().getRawContent().toLowerCase().startsWith(lib.prefix + c.getName())){
					c.execute(event.getMessage().getRawContent(),event.getMessage().getRawContent().split(" "), event);
				}
			}
			if(event.getMessage().getRawContent().startsWith(lib.prefix)){
				event.getChannel.sendMessage(event.getAuthor().getAsMention() + ". I'm sorry. That's an unknown Command!").queue();
			}
			return;
			//This os old unused stuff. It's here for reference and to copy the old implementation into new Classes for them...
			// PING - PONG
			if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "playPing")) {
				event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "help")){
				event.getChannel().sendMessage(help.help).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "twitch lesh")){
				event.getChannel().sendMessage(twitch.leshLive).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "twitch noah")){
				event.getChannel().sendMessage(twitch.noahLive).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix+"twitch")){
				event.getChannel().sendMessage(">> Der User ist nicht in der Livelist eingetragen");
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "list")){
				event.getChannel().sendMessage(userList.allMoots).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "game")){
				//changeCurGame.changeGame("ewGame");
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "time")){
				event.getChannel().sendMessage(">> " + clock.currentTime()).queue();
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "ping")){
				event.getChannel().sendMessage("Waiting for ping:")
				.queue(msg->event.getChannel().sendMessage(new EmbedBuilder()
						.addField("Ping:","**Discord Bot:** " + event.getJDA().getPing() + "ms\n" /*+ "**You:** " + String.valueOf((msg.getCreationTime().getNano() / 1000000) - (event.getMessage().getCreationTime().getNano() / 1000000)) +"ms"*/, true)
						.setColor(java.awt.Color.WHITE)
						.build())
						.queue());
			}else if(event.getMessage().getRawContent().equalsIgnoreCase(lib.prefix + "user")){
				event.getChannel().sendMessage("Generating Infocard for: " + event.getAuthor().getName())
						.queue(msg->event.getChannel().sendMessage(new EmbedBuilder()
									.setAuthor("Infocard for: " + event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl())
									.addField("Member", event.getAuthor().getAsMention(), true)
									.addBlankField(true)
									.addField("Sent Messages", String.valueOf(
										map.getOrDefault(event.getAuthor(),0))
										  , true)
									.setColor(java.awt.Color.GREEN)
									.build())
									.queue());
			}else {
				//if sent message wasn't a command:
			    User m = event.getAuthor();
				map.put(m, map.getOrDefault(m,0)+1);//increment message value
			}
		}else{
			User m = event.getAuthor();
			map.put(m, map.getOrDefault(m,0)+1);//increment message value
			//event.getChannel().sendMessage(event.getAuthor().getAsMention() + " >> Du hast keine Berechtigung dafür!").queue();
		}
	}
}
