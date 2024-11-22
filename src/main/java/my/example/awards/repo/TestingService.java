package my.example.awards.repo;

import lombok.AllArgsConstructor;
import my.example.awards.endpoints.QueryResultPrettier;
import my.example.awards.model.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestingService {
    private final CompetitionRepository competitionRepository;

    String testFun() {
        List<Competition> results = competitionRepository.findByLevel1();
        if (results == null) return "nothing";
        return QueryResultPrettier.concatenateObjects(results);
    }
}
