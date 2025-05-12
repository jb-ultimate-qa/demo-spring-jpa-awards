package my.example.awards;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("db2")
public class DemoAwardsSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);
        printURLs();
    }

    public static void printURLs(){
        System.out.println("Go to http://localhost:8080/hello\n" +
                "http://localhost:8080/awards/\n" +
                "http://localhost:8080/comp/\n" +
                "http://localhost:8080/schools/all");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

        };
    }

}
