package my.example.awards.endpoints;

import my.example.awards.model.Award;
import my.example.awards.repo.AwardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardsEndpoints {
    private final AwardRepository awardRepository;

    public AwardsEndpoints(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @GetMapping(value = "/", produces = "text/html")
    String getLinks(){
        return "Try this URL:</br></br>" +
                "<a href=\"all\">all</a></br>" +
                "<a href=\"high-rating\">high-rating</a></br>" +
                "<a href=\"2022\">2022</a></br>";
    }


    @GetMapping(value = "all", produces = "text/plain")
    String getAll(){
        List<Award> awardsList = awardRepository.findAll();
        return QueryResultPrettier.concatenateObjects(awardsList);
    }

    @GetMapping(value = "high-rating", produces = "text/plain")
    String getAllAwardsByWinnerWithHighRating(){
        List<Award> awardsList = awardRepository.findByWinner_RatingGreaterThan(1200);
        return QueryResultPrettier.concatenateObjects(awardsList);
    }

    @GetMapping(value = "2022", produces = "text/plain")
    String getAllAwards2022(){
        List<Award> awardsList = awardRepository.findByYear((short) 2022);
        return QueryResultPrettier.concatenateObjects(awardsList);
    }

}
