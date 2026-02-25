package my.example.awards.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class TestDbConfiguration {

    @Bean
    DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mariadb://localhost:3307/demo_maria")
                .username("root")
                .password("")
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }

}
