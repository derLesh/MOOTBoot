package de.lesh.mootboot.commands;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class botPing extends ListenerAdapter{

	public static long getPing(JDA jda){
		return jda.getPing();
	}
}
