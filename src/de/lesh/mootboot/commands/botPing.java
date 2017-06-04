package de.lesh.mootboot.commands;

import de.lesh.mootboot.lib;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class botPing extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().startsWith("-ping") || bannedList.black.contains(e.getAuthor().getIdLong())) {
			return;
		}
		
		EmbedBuilder eB = new EmbedBuilder();
		long start = System.currentTimeMillis();
		
		eB.addField("**Ping**", "**Bot: **" + e.getJDA().getPing() + "ms\n" + "**User: **" + (System.currentTimeMillis() - start) + "ms", false);
		eB.setColor(java.awt.Color.MAGENTA);
		
		e.getChannel().sendMessage(eB.build()).queue();
	}
	
	
	public static long getPing(JDA jda){
		return jda.getPing();
	}
}
