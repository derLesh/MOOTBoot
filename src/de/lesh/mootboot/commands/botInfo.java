package de.lesh.mootboot.commands;

import de.lesh.mootboot.lib;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class botInfo extends ListenerAdapter {

	public void onMessageReceived(MessageReceivedEvent e) {
		Message msg = e.getMessage();
		EmbedBuilder eB = new EmbedBuilder();
		
		if(!msg.getRawContent().startsWith("-info") || bannedList.black.contains(e.getAuthor().getIdLong())){
			return;
		}
			
		if(e.equals(e.getJDA().getSelfUser())){
			return;
		}
		System.out.println(e.getAuthor()+ " used the following command: -info");
		
		
		eB.setAuthor(lib.bot_name, null, lib.bot_image);
		eB.addField("Creator", e.getAuthor().getAsMention(), true);
		eB.addField("GitHub", "[MOOTBooT](https://github.com/LeshDev/MOOTBoot/tree/master/src/de/lesh/mootboot)", false);
		eB.setThumbnail(lib.bot_image);
		
		
		eB.setColor(java.awt.Color.GREEN);		
		e.getChannel().sendMessage(eB.build()).queue();
	}
}
