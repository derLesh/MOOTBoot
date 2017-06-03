package de.lesh.mootboot.commands;

import de.lesh.mootboot.misc.ideen;
import de.lesh.mootboot.user.bannedList;
import de.lesh.mootboot.user.permittedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ideenOutput extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().toLowerCase().startsWith("-ideen") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()){
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(String idea : ideen.ideas){
			sb.append(idea+"\n");
		}
		e.getChannel().sendMessage(sb.toString()).queue();
		
		String ideens = e.getMessage().getRawContent().split("\\s+",3)[2];
	   	if (ideens.equalsIgnoreCase("add") && permittedList.perm.contains(e.getAuthor().getIdLong())) {
			ideen.ideas.add(ideens); 
		}
	}
	
	public String getLog(MessageReceivedEvent e){
		return "[SUCCESS] >> Used the command -ideen - Command performed by: " + e.getAuthor().getName(); 
	}
}
