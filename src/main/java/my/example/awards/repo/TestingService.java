package my.example.awards.repo;

import my.example.awards.endpoints.QueryResultPrettier;
import my.example.awards.model.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestingService {
    private final CompetitionRepository competitionRepository;

    public TestingService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    String testFun() {
        List<Competition> results = competitionRepository.findByLevel1();
        if (results == null) return "nothing";
        return QueryResultPrettier.concatenateObjects(results);
    }
}
