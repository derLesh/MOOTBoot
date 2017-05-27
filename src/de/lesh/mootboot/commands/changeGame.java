package de.lesh.mootboot.commands;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class changeGame extends ListenerAdapter {

	public void onMessageReceived(MessageReceivedEvent e) {
		
		Message msg = e.getMessage();
		
		if(!msg.getRawContent().startsWith("-game") || bannedList.black.contains(e.getAuthor().getIdLong())) {
			return;
		}
		
		String gameName = e.getMessage().getRawContent().split("\\s+",2)[1];
		
		// Current Problem => Gives no output
		
		// Main.jdaB.setGame(Game.of(gameName));
		e.getJDA().getPresence().setGame(Game.of(gameName));
		System.out.println("b");
	}
}
