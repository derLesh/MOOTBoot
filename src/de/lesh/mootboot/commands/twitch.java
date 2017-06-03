package de.lesh.mootboot.commands;

import de.lesh.mootboot.twtich.twitch_api;
import de.lesh.mootboot.twtich.twitch_stream;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class twitch extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		if(!msg.getRawContent().startsWith("-twitch") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		twitch_stream streamer = twitch_api.getStream("LeshDE");
		
		//String twitcher = e.getMessage().getRawContent().split("\\s+",2)[1];
		System.out.println("Derzeitiger Title: " + streamer.getUsername());
	}
}
