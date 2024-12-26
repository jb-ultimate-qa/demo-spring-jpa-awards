package my.example.awards.endpoints;

import my.example.awards.model.SportSchool;
import my.example.awards.repo.SportSchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
public class SportSchoolsEndpoints {

    private final SportSchoolRepository sportSchoolRepository;

    public SportSchoolsEndpoints(SportSchoolRepository sportSchoolRepo) {
        this.sportSchoolRepository = sportSchoolRepo;
    }

    @GetMapping(value = "all", produces = "text/plain")
    String getAll(){
        Iterable<SportSchool> result = sportSchoolRepository.findAll();
        return QueryResultPrettier.concatenateObjects(result);
    }

}
