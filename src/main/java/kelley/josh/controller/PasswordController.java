package kelley.josh.controller;

import kelley.josh.model.PasswordConfig;
import kelley.josh.utility.SchemeGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by joshuakelley on 6/16/17.
 */
@RestController("/randomizer")
public class PasswordController {
//    todo make api call to password randomizer via service

    @RequestMapping("")
    private String randomize(@RequestParam PasswordConfig passwordConfig){
        return new SchemeGenerator(passwordConfig).randomizeScheme();
    }
}
