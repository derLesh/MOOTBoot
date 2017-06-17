package de.lesh.mootboot.commands;

import java.util.Random;

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
		
		if(!msg.getRawContent().startsWith("-revolver") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		Random shots = new Random();
		String split = e.getMessage().getRawContent().split("\\s+", 2)[1];
		int drehen = Integer.parseInt(split);
		int bullets = shots.nextInt(drehen);
		int saveBullets = bullets;
		
		for (int i = drehen; i < 0; i--) {
			Random hit = new Random(2);
			int hitting = hit.nextInt();
			if(!(bullets == 0) && hitting == 1){
				drehen = 0;
				System.out.println("Du bist gestorben");
			}
			System.out.println("Es wurde gedreht");
		}
		
		eB.setAuthor(">> Revolver Game", null, null);
		eB.addField("Vorhandene Kugeln", "" + saveBullets, true);
		
		System.out.println("Kugeln: " + bullets);
	}
}
