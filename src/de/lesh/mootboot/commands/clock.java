package de.lesh.mootboot.commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.entities.Message;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import de.lesh.mootboot.lib;
import de.lesh.mootboot.user.bannedList;
import de.lesh.mootboot.user.permittedList;

import static java.util.concurrent.TimeUnit.SECONDS;

public class clock extends ListenerAdapter{
	
	public static String currentTime(){
		return OffsetDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm | KK:mm:ss a"));
	}
	
	public static String getDescription(){
		return "Zeigt die aktuelle Zeit an";
	}
	
	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		if(!msg.getRawContent().toLowerCase().startsWith("-clock") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot() || !permittedList.perm.contains(e.getAuthor().getIdLong())){
			return;
		}
		EmbedBuilder eB = new EmbedBuilder();
		eB.setTitle("Time");
		eB.setColor(lib.randomColor());
		eB.setDescription(currentTime());
		e.getChannel().sendMessage(eB.build()).queue(sentMsg -> {
            		if (msg.getRawContent().contains("temp")){
            			sentMsg.delete().queueAfter(5, SECONDS);
            			msg.delete().queue();
            		}
        });
	}
	
}
