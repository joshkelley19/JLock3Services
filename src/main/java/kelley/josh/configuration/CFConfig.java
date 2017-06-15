package kelley.josh.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.cloud.service.relational.MysqlDataSourceCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

/**
 * Created by joshuakelley on 2/25/17.
 */
@Configuration
//@ServiceScan
@Profile("cloud")
public class CFConfig extends AbstractCloudConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    Cloud getCloud(){
        return new CloudFactory().getCloud();
    }

    @Bean
    public DataSource dataSource(){
        return connectionFactory().dataSource("jlock3-entries");
    }

    @Bean
    public Properties cloudProperties() {
        return properties();
    }
}
