package de.lesh.mootboot.commands.steam;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.appnews.GetNewsForApp;
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
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder(ids.STEAM_KEY).build();
		GetNewsForAppRequest request = SteamWebApiRequestFactory.createGetNewsForAppRequest(70);
		GetNewsForApp getNewsForApp = null;
		try {
			getNewsForApp = client.<GetNewsForApp> processRequest(request);
		} catch (SteamApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(!msg.getRawContent().startsWith("-prize") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		System.out.println(getNewsForApp);
		
		
	}	
}
