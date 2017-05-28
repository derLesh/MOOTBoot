package de.lesh.mootboot.commands;

import de.lesh.mootboot.ideen;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ideenOutput extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().equalsIgnoreCase("-ideen") || bannedList.black.contains(e.getAuthor().getIdLong())){
			return;
		}
		
		for(String idea : ideen.ideas){
			e.getChannel().sendMessage(idea).queue();
		}
		
		String ideenVar = e.getMessage().getRawContent().split("\\s+",2)[2];
		switch(ideenVar){
			case "add" : {
				ideen.ideas.add(ideenVar);
			}
		}
	}
}
