package my.example.awards.repo;

import my.example.awards.diversity.id_types.UuidEntity;
import my.example.awards.diversity.id_types.UuidEntityRepository;
import my.example.awards.endpoints.QueryResultPrettier;
import my.example.awards.model.Competition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TestingService {
    private final CompetitionRepository competitionRepository;
    private final UuidEntityRepository uuidEntityRepository;

    public TestingService(CompetitionRepository competitionRepository, UuidEntityRepository uuidEntityRepository) {
        this.competitionRepository = competitionRepository;
        this.uuidEntityRepository = uuidEntityRepository;
    }

    public String testQuery() {
        Optional<UuidEntity> entity = uuidEntityRepository.findByUuidHql(UUID.fromString("aaaabbbb-1111-2222-3333-4444ffffaaaa"));
        if (entity.isPresent()) return entity.get().getName();
        return "nothing found";
    }

    public String testFun() {
        List<Competition> results = competitionRepository.findByLevel1();
        if (results == null) return "nothing";
        return QueryResultPrettier.concatenateObjects(results);
    }
}
