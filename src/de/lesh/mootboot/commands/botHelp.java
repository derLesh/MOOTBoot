package de.lesh.mootboot.commands;

import de.lesh.mootboot.lib;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class botHelp extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().startsWith("-help") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		EmbedBuilder eB = new EmbedBuilder();
		
		eB.setAuthor("Help Menu for " + lib.bot_name, null, lib.bot_image);
		eB.addField("*Bot Info*", "-info > Gives infos about the bot", true);
		eB.addField("*User info*", "-user <String> > Gives infos about the user", true);
		eB.addField("*Change Game*", "-game <String> > Change the 'Playing' status", true);
		eB.setColor(java.awt.Color.YELLOW);
		
		e.getChannel().sendMessage(eB.build()).queue();
	}
	
}
