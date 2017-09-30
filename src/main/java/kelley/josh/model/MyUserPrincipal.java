package kelley.josh.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyUserPrincipal implements UserDetails {
    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;

    }

    public MyUserPrincipal() {
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
//        List<UserRole> roles = null;
//        if(user!=null){
//            roles = user.getRoles();
//        }
//
//        if(roles!=null){
//            for (UserRole role: roles){
                grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
//            }
//        }

        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
//        todo create expiration qualifications
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        todo create locking qualifications
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//      todo create credential expiration qualifications
        return true;
    }

    @Override
    public boolean isEnabled() {
//      todo create enabled qualifications
        return true;
    }

    public User getUser(){
        return user;
    }

    @Override
    public String toString(){
        return String.format("User: %s %s", user.getFirstName(), user.getLastName());
    }
}
