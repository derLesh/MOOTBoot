package de.lesh.mootboot.commands;

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
		
		String twitcher = e.getMessage().getRawContent().split("\\s+",2)[1];
		
		Twitch twitch = new Twitch();
		String chLogo = new Channel().getLogo();
		String chStatus = new Channel().getStatus();
		twitch.setClientId(ids.TWITCH_TOKEN);
		twitch.channels().get(twitcher, new ChannelResponseHandler() {
			
			@Override
			public void onFailure(int statusCode, String statusMessage, String errorMessage) {
				// TODO Auto-generated method stub
				System.out.println("[ERROR] >> " + statusCode + " - MESSAGE: " + statusMessage + " - ERROR " + errorMessage);
			}
			
			@Override
			public void onFailure(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("[ERROR] >> Es gab einen Fehler");
			}
			
			@Override
			public void onSuccess(Channel channel) {
				System.out.println(channel);
				
			}
		});
		
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
		
		
		System.out.println("Derzeitiger Title: ");
	}
}
