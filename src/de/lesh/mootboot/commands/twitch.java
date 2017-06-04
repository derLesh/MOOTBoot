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
		twitch.setClientId(ids.TWITCH_TOKEN);
		twitch.channels().get(twitcher, new ChannelResponseHandler() {
			
			@Override
			public void onFailure(int statusCode, String statusMessage, String errorMessage) {
				System.out.println("[ERROR] >> " + statusCode + " - MESSAGE: " + statusMessage + " - ERROR " + errorMessage);
			}
			
			@Override
			public void onFailure(Throwable e) {
				System.out.println("[ERROR] >> Es gab einen Fehler " + e);
			}
			
			@Override
			public void onSuccess(Channel channel) {
				System.out.println(channel);
				
				EmbedBuilder eB = new EmbedBuilder();
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
				
				e.getChannel().sendMessage(eB.build()).queue();
			}
		});
	}
}
