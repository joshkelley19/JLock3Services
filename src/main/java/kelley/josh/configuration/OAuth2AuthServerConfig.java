package kelley.josh.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory()
                .withClient("josh")
                .secret("joshsecret")
                .authorizedGrantTypes("password")
                .scopes("read", "write")
                .authorities("USER")
                .accessTokenValiditySeconds(600);
    }

    @Override
    public void configure(
            AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {

//        endpoints.addInterceptor(new HandlerInterceptorAdapter() {
//            @Override
//            public boolean preHandle(HttpServletRequest hsr, HttpServletResponse rs, Object o) throws Exception {
//                rs.setHeader("Access-Control-Allow-Origin", "*");
//                rs.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
//                rs.setHeader("Access-Control-Max-Age", "3600");
//                rs.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
//                return true;
//            }
//        });

        endpoints
                .tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource());
        return new InMemoryTokenStore();
    }
}
