package swtest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@RestController
@RequestMapping("/math")
public class MathController {

    

    @RequestMapping("/add")
    public IntPair addGet(@RequestParam(value="n1") String n1, @RequestParam(value="n2") String n2) {

        try{
            return new IntPair(Integer.parseInt(n1),Integer.parseInt(n2)).add();
        }
        catch(java.lang.NumberFormatException e){
            throw new IllegalArgumentException("The parameters must not be null or empty, and must be integers");
        }
		

    }

    @RequestMapping(path="/add", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public IntPair addPost(@RequestParam Map<String, String> body) {
        try{
            return new IntPair(Integer.parseInt(body.get("n1")),Integer.parseInt(body.get("n2"))).add();
        }
        catch(java.lang.NumberFormatException e){
            throw new IllegalArgumentException("The parameters must not be null or empty, and must be integers");
        }
		

    }

    
}
