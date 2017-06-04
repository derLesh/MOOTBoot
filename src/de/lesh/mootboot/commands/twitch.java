package de.lesh.mootboot.commands;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.ChannelResponseHandler;
import com.mb3364.twitch.api.models.Channel;

import de.lesh.mootboot.misc.ids;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class twitch extends ListenerAdapter{
	
	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		if(!msg.getRawContent().startsWith("-twitch") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		String[] parts = e.getMessage().getRawContent().split("\\s+",2);
		
		
		EmbedBuilder eB = new EmbedBuilder();
		
		if(parts.length<2) {
			eB.setAuthor("STREAM INFO", null, null);
			eB.addField("**ERROR**", "No channel was mentioned. Use `-twitch <twitch-name>`!", true);
			eB.setColor(Color.RED);
			e.getChannel().sendMessage(eB.build()).queue();
			return;
		}
		String twitcher = parts[1];
		Twitch twitch = new Twitch();
		twitch.setClientId(ids.TWITCH_TOKEN);
		twitch.channels().get(twitcher, new ChannelResponseHandler() {
			
			@Override
			public void onFailure(int statusCode, String statusMessage, String errorMessage) {
				System.out.println("[ERROR] >> " + statusCode + " - MESSAGE: " + statusMessage + " - ERROR " + errorMessage);
				eB.setAuthor("STREAM INFO", null, null);
				eB.addField("**ERROR**", statusCode + " - MESSAGE: " + statusMessage + " - ERROR " + errorMessage, true);
				eB.setColor(Color.RED);
				e.getChannel().sendMessage(eB.build()).queue();
			}
			
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("[ERROR] >> Es gab einen Fehler " + ex);
				eB.setAuthor("STREAM INFO", null, null);
				eB.addField("**ERROR**", "" + ex, true);
				eB.setColor(Color.RED);
				e.getChannel().sendMessage(eB.build()).queue();
			}
			
			@Override
			public void onSuccess(Channel channel) {
				System.out.println(channel);
				eB.setAuthor("STREAM INFO", channel.getUrl(), channel.getLogo());
				eB.addField("**Streamer**", channel.getDisplayName(), true);
				eB.addField("**Live**", "__***Coming soon***__", true);//TODO
				eB.addField("**Titel**", "" + channel.getStatus(), true);
				eB.addField("**Game**", channel.getGame(), true);
				eB.addField("**Sprache**", channel.getLanguage(), true);
				eB.addField("**Follower**", ""+channel.getFollowers(), true);
				eB.addField("**Views**", ""+channel.getViews(), true);
				eB.addField("**Partner**", ""+channel.isPartner(), true);
				eB.setThumbnail(channel.getLogo());
				eB.setColor(Color.MAGENTA);
				e.getChannel().sendMessage(eB.build()).queue();
			}
		});
		/*
		EmbedBuilder eB = new EmbedBuilder();
		eB.setAuthor("STREAM INFO", null, chLogo);
		eB.addField("**Streamer**", twitcher, true);
		eB.addField("**Live**", "" + chStatus, true);
		eB.addField("**Titel**", "", true);
		eB.addField("**Game**", "", true);
		eB.addField("**Sprache**", "", true);
		eB.addField("**Follower**", "", true);
		eB.addField("**Views**", "", true);
		eB.addField("**Partner**", "", true);
		eB.setThumbnail(chLogo);
		
		e.getChannel().sendMessage(eB.build()).queue();
		
		
		System.out.println("Derzeitiger Title: ");*/
	}
}
