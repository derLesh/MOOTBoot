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
		eB.addField("**Bot Info**", "-info > Gives infos about the bot", true);
		eB.addField("**User Info**", "-user <@User> > Gives infos about the user", true);
		eB.addField("**Change Game**", "-game <String> > Change the 'Playing' status", true);
		eB.addField("**Server Info**", "-server > Gives infos about the server", true);
		eB.addField("**Ideen**", "-ideen / -ideen add > Shows Ideas list / Add new ideas", true);
		eB.addField("**Ping**", "-ping > Shows ping from user and bot", true);
		eB.addField("**Clock**", "-clock > Shows current time", true);
		eB.addField("**Twitch**", "-twitch <String> > Gives infos about a streamer", true);
		eB.addField("**LoveTest**", "-love <String (String)> - Shos the love between you and something else", true);
		eB.addField("**Stats**", "-stats > Gives stats about you", true);
		eB.setColor(java.awt.Color.YELLOW);
		
		e.getChannel().sendMessage(eB.build()).queue();
	}	
}
