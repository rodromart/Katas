package kata;

import com.google.gson.JsonObject;

public class comic {

	String title;
	String price;
	String thumbnail;
	
	public comic(JsonObject j){

		title = j.get("title").toString();
		price = j.getAsJsonArray("prices").get(0).getAsJsonObject().get("price").toString();
		thumbnail = j.getAsJsonObject("thumbnail").get("path").toString();
	}
	
	public String toString() {
		
		return "Title: "+this.title+", Price: "+ this.price + ", ThumbailUrl: "+thumbnail+"\n";
	}
}
