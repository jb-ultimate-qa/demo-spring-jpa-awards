package my.example.awards.repo;

import my.example.awards.model.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer> {
    List<Award> findByWinner_RatingGreaterThan(Integer rating);

    @Query("select a from Award a where a.year = ?1")
    List<Award> findByYear(Short year);

    @Transactional
    @Modifying
    @Query("delete from Award a where a.title = ?1")
    int deleteByTitle(String title);

    @Modifying
    @Query("update Award a set a.year = ?1 where a.title = ?2")
    int updateYearByTitle(Short year, String title);

    @Query("select (count(a) > 0) from Award a where a.winner.rating = ?1")
    boolean existsByWinner_Rating(Integer rating);

    @Query("select count(a) from Award a where a.winner.rating = ?1")
    long countByWinner_Rating(Integer rating);

    @Query("select a from Award a where a.winner.rating = ?1")
    List<Award> findByWinner_Rating(Integer rating);
}