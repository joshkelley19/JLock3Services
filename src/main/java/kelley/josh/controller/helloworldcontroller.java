package kelley.josh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joshuakelley on 2/25/17.
 */
@RestController
public class helloworldcontroller {

    @RequestMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
