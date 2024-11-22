package my.example.awards.endpoints;

import lombok.AllArgsConstructor;
import my.example.awards.model.Competition;
import my.example.awards.repo.CompetitionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comp")
public class CompetitionEndpoints {

    private final CompetitionRepository competitionRepository;

    @GetMapping(value = "/", produces = "text/html")
    String getLinks(){
        return "Try this URL:</br></br>" +
                "<a href=\"by-num-level/1\">by-num-level/1</a></br>" +
                "<a href=\"by-num-level/2\">by-num-level/2</a></br>" +
                "<a href=\"by-num-level/3\">by-num-level/3</a></br>" +
                "<a href=\"by-num-level/4\">by-num-level/4</a></br>" +
                "<a href=\"by-num-level/5\">by-num-level/5</a></br>" +
                "<a href=\"by-num-level/6\">by-num-level/6</a></br>" +
                "<a href=\"by-num-level/7\">by-num-level/7</a></br>" +
                "<a href=\"by-num-level/8\">by-num-level/8</a></br>";
    }

    @GetMapping(value = "by-num-level/{lev}", produces = "text/plain")
    String getByNumericLevel(@PathVariable String lev){
        List<Competition> results = switch (lev) {
            case "1" -> competitionRepository.findByLevel1();
            case "2" -> competitionRepository.findByLevel2();
            case "3" -> competitionRepository.findByLevel3();
            case "4" -> competitionRepository.findByLevel4();
            case "5" -> competitionRepository.findByLevel5();
            case "6" -> competitionRepository.findByLevel6();
            case "7" -> competitionRepository.findByLevel7();
            case "8" -> competitionRepository.findByLevel8();
            default -> null;
        };
        if (results == null) return "nothing";
        return QueryResultPrettier.concatenateObjects(results);
    }

}
