package my.example.awards;

import my.example.awards.config.TestDbConfiguration;
import my.example.awards.repo.AwardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Import(TestDbConfiguration.class)
@ActiveProfiles("test")
class DbConfigTest {

    @Autowired
    private AwardRepository awardRepository;

    @Test
    void contextLoads() {
        awardRepository.findByWinner_RatingGreaterThan(1);
    }

}
