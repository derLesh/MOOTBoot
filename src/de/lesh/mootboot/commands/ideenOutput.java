package de.lesh.mootboot.commands;

import de.lesh.mootboot.ideen;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ideenOutput extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().toLowerCase().startsWith("-ideen") || bannedList.black.contains(e.getAuthor().getIdLong())){
			return;
		}
		
		for(String idea : ideen.ideas){
			e.getChannel().sendMessage(idea).queue();
		}
		
		String ideenVar = e.getMessage().getRawContent().split("\\s+",3)[2];
	    if(msg.getRawContent().toLowerCase().startsWith("-ideen add") && !bannedList.black.contains(e.getAuthor().getIdLong())){
	    	ideen.ideas.add(ideenVar);    
	    }
	}
}
