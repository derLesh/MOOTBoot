package de.lesh.mootboot.twtich;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class twitch_api {
	public static Gson gson = new Gson();

	public static twitch_stream getStream(String channelname){
		try{
			String json = api.readJsonFromUrl("http://api.justin.tv/api/stream/list.json?channel="+channelname);
			twitch_stream stream = new twitch_stream();
			if(json.equalsIgnoreCase("[]")){
				stream.setOnline(false);
				return stream;
			}
			JsonArray jb = gson.fromJson(json, JsonArray.class);
			JsonObject jo = (JsonObject) jb.get(0);
			stream.setOnline(true);
			stream.load(jo);
			return stream;
		} catch (Exception error){
			error.printStackTrace();
		}
		return null;
	}
}
