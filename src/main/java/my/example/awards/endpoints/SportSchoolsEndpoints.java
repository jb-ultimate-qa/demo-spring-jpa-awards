package my.example.awards.endpoints;

import lombok.AllArgsConstructor;
import my.example.awards.endpoints.helper.QueryResultPrettier;
import my.example.awards.model.SportSchool;
import my.example.awards.repo.SportSchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static my.example.awards.endpoints.helper.HtmlHelper.generateHtmlLinks;

@AllArgsConstructor
@RestController
@RequestMapping("/schools")
public class SportSchoolsEndpoints {

    private final SportSchoolRepository sportSchoolRepository;

    @GetMapping(value = "/", produces = "text/html")
    String getLinks(){
        return generateHtmlLinks("schools", "all");
    }

    @GetMapping(value = "all", produces = "text/plain")
    String getAll(){
        Iterable<SportSchool> result = sportSchoolRepository.findAll();
        return QueryResultPrettier.concatenateObjects(result);
    }

}
