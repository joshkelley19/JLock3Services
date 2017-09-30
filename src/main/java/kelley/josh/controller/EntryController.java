package kelley.josh.controller;

import kelley.josh.model.Entry;
import kelley.josh.model.MyUserPrincipal;
import kelley.josh.model.User;
import kelley.josh.repository.EntryRepository;
import kelley.josh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by joshuakelley on 2/25/17.
 */
@RestController("/")
@CrossOrigin(allowedHeaders = "Authorization")
@EnableResourceServer
public class EntryController {
    @Autowired
    public EntryRepository entryRepo;

    @Autowired
    public UserRepository userRepo;


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userRepo.findOne(id);
    }

    @RequestMapping(value = "entry/add", method = RequestMethod.POST, headers = "authorization")
    public @ResponseBody List<Entry> addEntry(@RequestBody Entry entry) {
        entryRepo.save(entry);
        return entryRepo.findByClientAccountNumber(entry.getClientAccountNumber());
    }

    @RequestMapping(value = "entry/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Entry> getEntries(@PathVariable Long id) {
        return entryRepo.findByClientAccountNumber(id);
    }

    @RequestMapping(value = "entry/edit", method = RequestMethod.PUT)
    public @ResponseBody List<Entry> editEntry(@RequestBody Entry entry) {
        if (entryRepo.findOne(entry.getId()) != null) {
            entryRepo.save(entry);
            return entryRepo.findByClientAccountNumber(entry.getId());
        }
        return null;
    }

    @RequestMapping(value = "entry/delete", method = RequestMethod.DELETE)
    public @ResponseBody List<Entry> deleteEntry(@RequestBody Entry entry) {
        long id = entry.getClientAccountNumber();
        entryRepo.delete(entry);
        return getEntries(id);
    }

}
