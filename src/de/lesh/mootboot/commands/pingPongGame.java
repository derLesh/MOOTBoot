package de.lesh.mootboot.commands;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class pingPongGame extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().startsWith("-pingGame") || bannedList.black.contains(e.getAuthor().getIdLong())){
			return;
		}
		if(!e.equals(e.getJDA().getSelfUser())){
			return;
		}

		e.getChannel().sendMessage("Pong").queue();
		
		if(!msg.getRawContent().startsWith("ping") || bannedList.black.contains(e.getAuthor().getIdLong()) || !e.equals(e.getJDA().getSelfUser())){
			e.getChannel().sendMessage("F*ck YEAH !!! Bot wins").queue();
		}

		e.getChannel().sendMessage("Ping").queue();
		
		if(!msg.getRawContent().startsWith("ping") || bannedList.black.contains(e.getAuthor().getIdLong()) || !e.equals(e.getJDA().getSelfUser())){
			e.getChannel().sendMessage("F*ck YEAH !!! Bot wins").queue();
		}
		
		e.getChannel().sendMessage("Pong").queue();
		
		if(!msg.getRawContent().startsWith("pong") || bannedList.black.contains(e.getAuthor().getIdLong()) || !e.equals(e.getJDA().getSelfUser())){
			e.getChannel().sendMessage("F*ck YEAH !!! Bot wins").queue();
		}
		
		e.getChannel().sendMessage(e.getAuthor().getAsMention() + " has won :(").queue();
		
	}
	
}
