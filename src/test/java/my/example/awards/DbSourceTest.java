package my.example.awards;

import my.example.awards.repo.AwardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
@ActiveProfiles("test")
class DbSourceTest {

    @DynamicPropertySource
    static void datasourceProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
                () -> "jdbc:mariadb://localhost:3307/demo_maria");
        registry.add("spring.datasource.username", () -> "root");
        registry.add("spring.datasource.password", () -> "");
        registry.add("spring.datasource.driver-class-name",
                () -> "org.mariadb.jdbc.Driver");
    }

    @Autowired
    private AwardRepository awardRepository;

    @Test
    void contextLoads() {
        awardRepository.findByWinner_RatingGreaterThan(1);
    }

}
