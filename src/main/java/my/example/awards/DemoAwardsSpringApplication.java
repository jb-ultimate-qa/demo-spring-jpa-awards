package my.example.awards;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAwardsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);
        System.out.println("Go to http://localhost:8080/hello\n" +
                "http://localhost:8080/awards/\n" +
                "http://localhost:8080/comp/\n");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

        };
    }

}
