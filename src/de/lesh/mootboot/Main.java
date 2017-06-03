package de.lesh.mootboot;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.commands.info.*;
import de.lesh.mootboot.user.*;
import de.lesh.mootboot.gui.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;

import java.lang.Exception;

public class Main {
	
	public static JDA jda;
	public static JDABuilder jdaB = new JDABuilder(AccountType.BOT);
	public static MainFrame frame;
	public static int sentMSG = 0;
	
	public static void main(String[] args) throws Exception {
		
		jdaB.setToken(bot_token.BOT_TOKEN).setGame(Game.of("-help")).setAutoReconnect(true);
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
		
		jda = jdaB.buildBlocking();
		
		frame = new MainFrame(jda);
		
	}
	public static JDA getSetup(){
		return jda;
	}
	
	public static void onReady(ReadyEvent e){
		permittedList.perm.add(155704314638106624L);
	}
}
