package de.lesh.mootboot.commands;

import java.util.ArrayList;
import java.util.List;

import de.lesh.mootboot.user.bannedList;
import de.lesh.mootboot.user.permittedList;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class changeGame extends ListenerAdapter {

	public static List<Long> perm = new ArrayList<>();
	
	public void onReady(ReadyEvent e){
		perm.add(155704314638106624L);
	}
	
	public void onMessageReceived(MessageReceivedEvent e) {
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().startsWith("-game") || e.getAuthor().isBot() || bannedList.black.contains(e.getAuthor().getIdLong()) || !permittedList.perm.contains(e.getAuthor().getIdLong())) {
			return;
		}

		String gameName = e.getMessage().getRawContent().split("\\s+",2)[1];
		e.getJDA().getPresence().setGame(Game.of(gameName));
		System.out.println("[SUCCESS] >> Change game to: " + gameName + " - Command performed by: " + e.getAuthor().getName());
	}
}
