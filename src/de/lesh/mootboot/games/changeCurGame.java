package de.lesh.mootboot.games;

import de.lesh.mootboot.BotListener;
import de.lesh.mootboot.lib;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class changeCurGame extends ListenerAdapter{
	
	public static void changeGame(MessageReceivedEvent e){
		String game = e.getMessage().getRawContent();
		if(game.toLowerCase().startsWith(lib.prefix + "game")){
			String newGame = game.split("")[1];
		}
	}
}
