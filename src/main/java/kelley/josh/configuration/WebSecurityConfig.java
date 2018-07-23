package kelley.josh.configuration;

import kelley.josh.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by joshuakelley on 4/27/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends ResourceServerConfigurerAdapter {

    @Value("${origin}")
    private String origin;

    @Autowired
    public MyUserDetailsService myUserDetailsService;
//    @Autowired
//    private BasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("authentication provider");
        auth
                .authenticationProvider(authenticationProvider());
//                .inMemoryAuthentication()
//                .withUser("youngfred").password("test").roles("USER");
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        System.out.println("cors filter" + origin);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin(origin);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                disables cors, temp
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS).permitAll();
//                .antMatchers(HttpMethod.DELETE).permitAll()
//                .antMatchers(HttpMethod.POST).permitAll()
//                .antMatchers(HttpMethod.PUT).permitAll()
//                .antMatchers(HttpMethod.GET).permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().fullyAuthenticated();
//                .and()
//                .httpBasic();
//                .authenticationEntryPoint(authenticationEntryPoint);

//        httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated();
        System.out.println("http security");
        httpSecurity
//                allows user endpoint usage for all
//                .authorizeRequests().antMatchers("/user").permitAll().and()
                .authorizeRequests().anyRequest().hasRole("USER")
//                .and().authorizeRequests().antMatchers(HttpMethod.POST,"/user/add").permitAll();
                .and().authorizeRequests().antMatchers(HttpMethod.POST,"/user/add").anonymous().anyRequest().permitAll();
//        httpSecurity.
//        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
//        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
