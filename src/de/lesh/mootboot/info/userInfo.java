package de.lesh.mootboot.info;

import de.lesh.mootboot.lib;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
//import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class userInfo extends ListenerAdapter {
	
	public void onMessageRecieved(MessageReceivedEvent e){
		
		if(e.getAuthor().isBot()){
			return;
		}
		
		if(!e.getMessage().getContent().equalsIgnoreCase(lib.prefix + "user")){
			return;
		}
		
		
		EmbedBuilder eb = new EmbedBuilder();
		MessageBuilder mb = new MessageBuilder();
		
		eb.setAuthor(e.getJDA().getSelfUser().getName(), null, e.getJDA().getSelfUser().getAvatarUrl());
		
		
	}
	
}
