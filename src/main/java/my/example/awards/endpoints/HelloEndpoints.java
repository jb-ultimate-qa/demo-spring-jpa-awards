package my.example.awards.endpoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloEndpoints {

    @GetMapping(produces = "text/plain")
    String hello(){
        return "Hello, User";
    }
}
