package de.lesh.mootboot.commands.info;

import de.lesh.mootboot.lib;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Region;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class serverInfo extends ListenerAdapter{
	
	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		EmbedBuilder eB = new EmbedBuilder();
		
		if(!msg.getRawContent().startsWith("-server") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()){
			return;
		}
		
		eB.setAuthor("Server Infos", null, lib.bot_image);
		eB.addField("**Owner**", "" + e.getGuild().getOwner().getEffectiveName(), true);
		eB.addField("Name", "" + e.getGuild().getName(), true);
		eB.addField("**Region**", e.getGuild().getRegion().getName(), true);
		eB.setColor(java.awt.Color.RED);
		
		e.getChannel().sendMessage(eB.build()).queue();
		
	}
	
}
