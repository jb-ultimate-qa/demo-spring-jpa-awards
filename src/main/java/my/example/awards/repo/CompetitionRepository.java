package my.example.awards.repo;

import my.example.awards.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import my.example.awards.model.CompetitionLevel;

import java.util.Collection;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    @Query("select c from Competition c where " +
            "c.competitionLevel = my.example.awards.model.CompetitionLevel.DISTRICT or " +
            "c.competitionLevel = my.example.awards.model.CompetitionLevel.REGIONAL")
    List<Competition> findByLevel1();

    @Query("select c from Competition c where c.competitionLevel = CompetitionLevel.DOMESTIC")
    List<Competition> findByLevel2();

    @Query("select c from Competition c where c.competitionLevel = INTERNATIONAL")
    List<Competition> findByLevel3();

    @Query("select c from Competition c where c.competitionLevel = 1")
    List<Competition> findByLevel4();

    @Query("select c from Competition c where c.competitionLevel in (" +
            "my.example.awards.model.CompetitionLevel.DISTRICT, " +
            "my.example.awards.model.CompetitionLevel.REGIONAL)")
    List<Competition> findByLevel5();

    @Query("select c from Competition c where c.competitionLevel in (CompetitionLevel.DOMESTIC, CompetitionLevel.INTERNATIONAL)")
    List<Competition> findByLevel6();

    @Query("select c from Competition c where c.competitionLevel in (INTERNATIONAL, DISTRICT)")
    List<Competition> findByLevel7();

    @Query("select c from Competition c where c.competitionLevel in (0, 1)")
    List<Competition> findByLevel8();

    @Query("select c from Competition c where c.competitionLevel in ?1")
    List<Competition> findByLevelInCollection(Collection<CompetitionLevel> competitionLevels);

//    // not compilable - Cannot compare left expression of type 'my.example.awards.model.CompetitionLevel' with right expression of type 'java.lang.String'
//    @Query("select c from Competition c where c.competitionLevel in ('DISTRICT', 'REGIONAL')")
//    List<Competition> findByLevelWrongIn();
//
//    // not compilable - Cannot compare left expression of type 'my.example.awards.model.CompetitionLevel' with right expression of type 'java.lang.String'
//    @Query("select c from Competition c where c.competitionLevel = 'INTERNATIONAL'")
//    List<Competition> findByLevelWrongEq();

}
