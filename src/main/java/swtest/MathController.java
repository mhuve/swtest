package swtest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    

    @RequestMapping("/add")
    public Math add(@RequestParam(value="n1") String n1, @RequestParam(value="n2") String n2) {
        return new Math(Integer.parseInt(n1),Integer.parseInt(n2));
		

    }
}
