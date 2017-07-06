package kelley.josh.controller;

import kelley.josh.model.PasswordConfig;
import kelley.josh.utility.SchemeGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by joshuakelley on 6/16/17.
 */
@RestController
public class PasswordController {
//    todo make api call to password randomizer via service

    @CrossOrigin
    @RequestMapping(value = "/any", method = RequestMethod.POST)
    public String randomize(@RequestBody PasswordConfig passwordConfig) {
        RestTemplate restTemplate = new RestTemplate();
        String scheme = new SchemeGenerator(passwordConfig).randomizeScheme();
        return restTemplate.getForObject("http://www.passwordrandom.com/query?command=password&count=1&scheme="+scheme,String.class);
    }
}
