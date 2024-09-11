package my.example.awards.repo;

import my.example.awards.model.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award, Integer> {
  List<Award> findByWinner_RatingGreaterThan(Integer rating);

  @Query("select a from Award a where a.year = ?1")
  List<Award> findByYear(Short year);


}