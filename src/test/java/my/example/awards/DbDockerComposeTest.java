package my.example.awards;

import my.example.awards.repo.AwardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DbDockerComposeTest {

    @Autowired
    private AwardRepository awardRepository;

    @Test
    void contextLoads() {
        awardRepository.findByWinner_RatingGreaterThan(1);
    }

}
