package de.lesh.mootboot;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.commands.info.*;
import de.lesh.mootboot.commands.stats.*;
import de.lesh.mootboot.misc.ids;
import de.lesh.mootboot.misc.ideen;
import de.lesh.mootboot.user.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;

import java.lang.Exception;

public class Main {
	
	public static JDA jda;
	public static JDABuilder jdaB = new JDABuilder(AccountType.BOT);
	//public static MainFrame frame;
	public static int sentMSG = 0;
	
	public static void main(String[] args) throws Exception {
		System.out.println("[BOOT] >> Launching MOOTBoot");
		System.out.println("[BOOT] >> Version: " + lib.version);
		
		jdaB.setToken(ids.BOT_TOKEN).setGame(Game.of("-help")).setAutoReconnect(true);
		jdaB.addEventListener(new botInfo());
		jdaB.addEventListener(new userInfo());
		jdaB.addEventListener(new serverInfo());
		jdaB.addEventListener(new ideen());
		jdaB.addEventListener(new permittedList());
		jdaB.addEventListener(new bannedList());
		jdaB.addEventListener(new pingPongGame());
		jdaB.addEventListener(new changeGame());
		jdaB.addEventListener(new botPing());
		jdaB.addEventListener(new ideenOutput());
		jdaB.addEventListener(new botHelp());
		jdaB.addEventListener(new clock());
		jdaB.addEventListener(new twitch());
		jdaB.addEventListener(new LoveTest());
		jdaB.addEventListener(new Stats());
		
		System.out.println("[SUCCESSFUL] >> Added all EventListeners");
		
		jda = jdaB.buildBlocking();
		//frame = new MainFrame(jda);
		System.out.println("[SUCCESSFUL] >> Activating MOOTBoot");
		
	}
	public static JDA getSetup(){
		return jda;
	}
	
	public static void onReady(ReadyEvent e){
		permittedList.perm.add(155704314638106624L);
	}
}
