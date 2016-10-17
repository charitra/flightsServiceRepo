package hello;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template1 = "BA51 BLR-DEL 21OCT16 10:00";
    private static final String template2 = "Your Booking is confirmed on BA51, Happy Journey !";
    
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.POST, value = "/SearchFlight")
    public Response SearchFlight(JSONObject inputObject) {
    	String object = (String)inputObject.get("action");
        return new Response(template1+object, template1+object, new ArrayList<String>(), new ArrayList<String>(), 
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
}
