package my.example.awards;

import my.example.awards.repo.MyComponent;
import my.example.awards.repo.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAwardsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);

        printURLs();
        useComponent();
        useService();
    }

    public static void printURLs(){
        System.out.println("Go to http://localhost:8080/hello\n" +
                "http://localhost:8080/awards/\n" +
                "http://localhost:8080/comp/\n");
    }

    public static void useComponent(){
        // Annotation based spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("my.example.awards.repo");
        context.refresh();

        // Getting the Bean from the component class
        MyComponent component = context.getBean(MyComponent.class);
        component.demoFunction();

        // Closing the context
        context.close();
    }

    public static void useService(){
        // Annotation based spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("my.example.awards.repo");
        context.refresh();

        // Getting the Bean from the component class
        MyService service = context.getBean(MyService.class);
        service.testComponent();

        // Closing the context
        context.close();
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

        };
    }

}
