package hello;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    	Map<String, String> flightData = new HashMap<>();
    	flightData.put("flightNumber", "AI123");
    	flightData.put("deptTime", "0800");
    	flightData.put("arrivalTime", "1200");
    	flightData.put("stops", "0");
    	
    	Map<String, String> flightData1 = new HashMap<>();
    	flightData1.put("flightNumber", "AI321");
    	flightData1.put("deptTime", "1200");
    	flightData1.put("arrivalTime", "1500");
    	flightData1.put("stops", "0");
    	
    	List<Map<String, String>> data = new ArrayList<>();
    	data.add(flightData);
    	data.add(flightData1);
        return new Response(template1+readJson, template1+readJson, data, new ArrayList<String>(), 
        		"MakeMyTrip");
    }
    
    /*@RequestMapping(method = RequestMethod.POST, value = "/bookFlight")
    public Response bookFlight() {
        return new Response(template2, template2, data, new ArrayList<String>(), 
        		"MakeMyTrip");
    }*/
    
    /*@RequestMapping("/welcome")
    public Response welcome() {
        return new Response("Welcome to Flights booking", "Welcome to Flights booking"
        		, new ArrayList<String>(), new ArrayList<String>(), "MakeMyTrip");
    }
    */
    public String readJson() {
    	String inline = "inline";
    	String jsonarr_2 = "action";
    	
    	return inline;
    }
}
