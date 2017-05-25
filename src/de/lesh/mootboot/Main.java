package de.lesh.mootboot;

import javax.security.auth.login.LoginException;
import javax.sound.midi.MidiDevice.Info;

import de.lesh.mootboot.info.userInfo;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Main {
	
	public static JDA jda;
	public static final String BOT_TOKEN ="MzE1NzYwMTAzMjA4Nzc5Nzc3.DALcLg.1zVjPHX2RzPvJouWCjrnTA1J9Ao";

	public static void main(String[] args){
		try { jda = (JDA) new JDABuilder(AccountType.BOT)
					.addEventListener(new BotListener())
					.addEventListener(new userInfo())
					.setToken(BOT_TOKEN)
					.setAutoReconnect(true)
					.setGame(Game.of("Moot Moot"))
					.buildBlocking().asBot();
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
	}
}
