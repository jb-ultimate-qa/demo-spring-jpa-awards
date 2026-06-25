package my.example.awards.endpoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static my.example.awards.endpoints.helper.HtmlHelper.generateHtmlLinksForHello;

@RestController
@RequestMapping("/hello")
public class HelloEndpoints {

    @GetMapping(produces = "text/html")
    String hello(){
        return generateHtmlLinksForHello("awards", "comp", "schools/all");
    }
}
