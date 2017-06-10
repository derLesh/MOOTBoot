package de.lesh.mootboot.commands.steam;

import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetNewsForAppRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

import de.lesh.mootboot.misc.ids;
import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class steamPrize extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		if(!msg.getRawContent().startsWith("-prize") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder(ids.STEAM_KEY).build();
		GetNewsForAppRequest request = SteamWebApiRequestFactory.createGetNewsForAppRequest(70);
		//GetNewsForApp getNewsForApp = client.<GetNewsForApp> processRequest(request);
		
		//System.out.println(getNewsForApp);
	}	
}
