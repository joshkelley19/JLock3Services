package kelley.josh.configuration;


import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by joshuakelley on 2/25/17.
 */
@Configuration
@Profile("cloud")
public class CFConfig extends AbstractCloudConfig {

    @Bean
    Cloud getCloud(){
        return new CloudFactory().getCloud();
    }

    @Bean
    public DataSource dataSource(){
        return connectionFactory().dataSource();
    }
}
