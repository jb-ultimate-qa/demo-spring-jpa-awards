package my.example.awards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAwardsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);
        System.out.println("Go to http://localhost:8080/hello\nhttp://localhost:8080/awards/all\n");
    }

}
