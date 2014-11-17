package kata;

import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class app {

	public static void main(String[] args) throws IOException {

		Client client = Client.create();
		WebResource webResource = client.resource("http://gateway.marvel.com:80/v1/public/comics?dateDescriptor=nextWeek&ts=987&apikey=97f295907072a970c5df30d73d1f3816&hash=abfa1c1d42a73a5eab042242335d805d");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
			JsonElement jelement = new JsonParser().parse(response.getEntity(String.class));
			
		    JsonObject  jobject = jelement.getAsJsonObject();
		    jobject = jobject.getAsJsonObject("data");
		    JsonArray jarray = jobject.getAsJsonArray("results");
		    
		    LinkedList<comic> list = new LinkedList<comic>();
		    
		    for(JsonElement j : jarray){
		    	//System.out.println(j.toString());
		    	list.add(new comic(j.getAsJsonObject()));
		    	
		    	
		    }

		
		System.out.println(list);

		
		 
		
	}

}
