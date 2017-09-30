package kelley.josh.services;

import kelley.josh.model.MyUserPrincipal;
import kelley.josh.model.User;
import kelley.josh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException(userName);
        }
        System.out.println("Found User " + user.getUserName());
        return new MyUserPrincipal(user);
    }
}
