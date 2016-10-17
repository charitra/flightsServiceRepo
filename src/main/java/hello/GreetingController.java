package hello;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template1 = "BA51 BLR-DEL 21OCT16 10:00";
    private static final String template2 = "Your Booking is confirmed on BA51, Happy Journey !";
    
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.POST, value = "/SearchFlight")
    public Response SearchFlight() {
    	String readJson = readJson();
        return new Response(template1+readJson, template1+readJson, new ArrayList<String>(), new ArrayList<String>(), 
        		"MakeMyTrip");
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/bookFlight")
    public Response bookFlight() {
        return new Response(template2, template2, new ArrayList<String>(), new ArrayList<String>(), 
        		"MakeMyTrip");
    }
    
    @RequestMapping("/welcome")
    public Response welcome() {
        return new Response("Welcome to Flights booking", "Welcome to Flights booking"
        		, new ArrayList<String>(), new ArrayList<String>(), "MakeMyTrip");
    }
    
    public String readJson() {
    	String inline = "";
    	String jsonarr_2 = "action";
    	try
		{
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
			//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("POST");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			//Iterating condition to if response code is not 200 then throw a runtime exception
			//else continue the actual process of getting the JSON data
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format"); 
				System.out.println(inline);
				//Close the stream when reading the data has been finished
				sc.close();
			}
			
			//JSONParser reads the data from string object and break each data into key value pairs
			JSONParser parse = new JSONParser();
			//Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject)parse.parse(inline);
			//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("result");
			//Get data for Results array
			for(int i=0;i<jsonarr_1.size();i++)
			{
				//Store the JSON objects in an array
				//Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				jsonarr_2 = (String) jsonobj_1.get("action");
				
			}
			//Disconnect the HttpURLConnection stream
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	return jsonarr_2;
    }
}
