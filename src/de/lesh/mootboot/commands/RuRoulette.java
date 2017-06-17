package de.lesh.mootboot.commands;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RuRoulette extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		User user = e.getAuthor();
		Member member = e.getMember();
		EmbedBuilder eB = new EmbedBuilder();
		String status = ""; 
		
		if(!msg.getRawContent().startsWith("-revolver") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		e.getMessage().delete().queueAfter(5, TimeUnit.SECONDS);
		
		Random shots = new Random();
		String split = e.getMessage().getRawContent().split("\\s+", 2)[1];
		int drehen = Integer.parseInt(split);
		int bullets = shots.nextInt(drehen);
		int saveBullets = bullets;
		int gedrehteRunden = 0;
		
		for (int i = drehen; i > 0; i--) {
			Random hit = new Random();
			int hitting = hit.nextInt(2);
			if(bullets != 0 && hitting == 1){
				status = "Deine Seele verschwindet";
				System.out.println("Du bist gestorben");
				break;
			}else{
				status = "Dein Leben verläuft normal";
			}
			gedrehteRunden++;
			System.out.println("Es wird ein weiteres Mal gedreht");
		}
		
		eB.setAuthor(">> Revolver Game", null, null);
		eB.addField("Name", user.getName(), true);
		eB.addField("Vorhandene Kugeln", "" + saveBullets, true);
		eB.addField("Gesamte Drehungen", "" + Integer.parseInt(split), false);
		eB.addField("Drehungen", "" + gedrehteRunden, true);
		eB.addField("Status", status, true);
		e.getChannel().sendMessage(eB.build()).queue();
		System.out.println("Kugeln: " + bullets);
	}
}
