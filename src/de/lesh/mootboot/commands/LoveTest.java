package de.lesh.mootboot.commands;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LoveTest extends ListenerAdapter{
	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		User u = e.getAuthor();
		if(!msg.getRawContent().startsWith("-love") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
	
		String[] words = e.getMessage().getRawContent().split("\\s+",3);
		EmbedBuilder eB = new EmbedBuilder();
		Random rdm = new Random();
		int prozent = rdm.nextInt(101);
		
		if(words.length == 2){
			eB.setAuthor("Dein Liebestest", null, u.getEffectiveAvatarUrl());
			eB.addField("User: " + Arrays.toString(words), prozent + "%", true);
			e.getChannel().sendMessage(eB.build()).queue();
		} else if(words.length == 3){
			eB.setAuthor("Der Liebestest", null, u.getEffectiveAvatarUrl());
			eB.addField(Arrays.toString(words), prozent + "%", true);
			e.getChannel().sendMessage(eB.build()).queue();
		} else{
			eB.setAuthor("ERROR >> Missing arguments", null, null);
			eB.addField("Es fehlen Argumente für -love", "" , false);
			eB.setColor(Color.RED);
			e.getChannel().sendMessage(eB.build()).queue();
		}
	}
}
