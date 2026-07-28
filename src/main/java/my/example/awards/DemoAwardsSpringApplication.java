package my.example.awards;

import my.example.awards.components.AwardsTransactionalService;
import my.example.awards.components.LicenseTransactionalService;
import my.example.awards.components.MyComponent;
import my.example.awards.components.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoAwardsSpringApplication implements CommandLineRunner {

    private final LicenseTransactionalService licenseTransactionalService;
    private final AwardsTransactionalService awardsTransactionalService;

    @Autowired
    public DemoAwardsSpringApplication(LicenseTransactionalService licenseTransactionalService, AwardsTransactionalService awardsTransactionalService){
        this.licenseTransactionalService = licenseTransactionalService;
        this.awardsTransactionalService = awardsTransactionalService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoAwardsSpringApplication.class, args);

        printURLs();
//        useComponent();
//        useService();
    }

    @Override
    public void run(String... args) throws Exception {
//        licenseTransactionalService.checkEntityStatesFlow();
//        licenseTransactionalService.checkTransactionPropagation();
//        awardsTransactionalService.checkAwardEntityStatesFlow();
    }

    public static void printURLs(){
        System.out.println("""
                Go to http://localhost:8080/hello
                http://localhost:8080/awards/
                http://localhost:8080/comp/
                http://localhost:8080/schools/all
                http://localhost:8080/license/transactions""");
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

}
