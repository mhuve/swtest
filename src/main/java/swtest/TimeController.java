package swtest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/time")
public class TimeController {
  
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = {"/now", "/now/{airportCode}"})
    public String now(@PathVariable Optional<String> airportCode) {
    	String useAirportCode = "yyc";  
    	if (airportCode.isPresent()) {
        	useAirportCode = airportCode.get();  
    	}
		Map<String, String> env = System.getenv();
    	

    	RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-apiKey", env.get("xapikey"));
		HttpEntity entity = new HttpEntity(headers);

    	StringBuffer url=new StringBuffer();
    	url.append("https://waittime.api.aero/waittime/v1/current/").append(useAirportCode);
    	HttpEntity<String> response = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, String.class);
    	return response.getBody();      

    }
}
