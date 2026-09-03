package my.example.awards;

import my.example.awards.diversity.precision.bean.TimestampService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAwardsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);
        printURLs();
    }

    public static void printURLs(){
        System.out.println("""
                Go to http://localhost:8080/hello
                http://localhost:8080/awards/
                http://localhost:8080/comp/
                http://localhost:8080/schools/all""");
    }

    @Bean
    CommandLineRunner runner(TimestampService timestampService) {
        return args -> {
            timestampService.createTestData();
            timestampService.checkHqlSyntax();
        };
    }

}
