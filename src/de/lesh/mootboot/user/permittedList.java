package de.lesh.mootboot.user;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class permittedList extends ListenerAdapter{

	public static List<Long> perm = new ArrayList<>();
	
	public void onReady(ReadyEvent e){
		perm.add(155704314638106624L);
	}
	
}
