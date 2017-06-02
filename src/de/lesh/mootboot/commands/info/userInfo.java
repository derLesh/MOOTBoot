package de.lesh.mootboot.commands.info;


import java.util.stream.Collectors;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class userInfo extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		
		//List<Role>.stream().map(Role::getName).collect(Collectors.join(", "))
		
		if(!msg.getRawContent().startsWith("-user") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		if(e.getMessage().getMentionedUsers().size()>0){
			for(User u:e.getMessage().getMentionedUsers()){
				sendInfo(e.getGuild().getMember(u),e.getTextChannel());
			}
		} else {
			sendInfo(e.getMember(), (TextChannel) e.getChannel());
		}
	}
	
	private static final int MESSAGE_LOOKBACK_COUNT = 100;
	
    	public static void sendInfo(Member member, TextChannel channel){
        	EmbedBuilder eB = new EmbedBuilder();
        	User u = member.getUser();
        	eB.setAuthor("Infocard >> " + u.getName(), null, u.getEffectiveAvatarUrl());
        	eB.addField("**User**:", u.getAsMention(), true);
        	eB.addField("**ID**:", "" + u.getIdLong(), true);
       		eB.addField("**Message Frequency**:", channel.getHistory().retrievePast(MESSAGE_LOOKBACK_COUNT).complete().stream().filter(e->e.getAuthor().equals(u)).count()/((double)MESSAGE_LOOKBACK_COUNT), true);
        	eB.addField("**Created**:", "" + u.getCreationTime(), true);
        	eB.addField("**Roles**:", ""+member.getRoles().stream().map(Role::getName).collect(Collectors.joining(" - ")), true);
        	eB.setThumbnail(u.getEffectiveAvatarUrl());
        	eB.setColor(java.awt.Color.CYAN);
        	channel.sendMessage(eB.build()).queue();
    	}
	
}
