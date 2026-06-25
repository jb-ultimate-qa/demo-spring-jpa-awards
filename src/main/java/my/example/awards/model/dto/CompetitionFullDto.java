package my.example.awards.model.dto;

import my.example.awards.model.Competition;
import my.example.awards.model.notentity.CompetitionLevel;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Competition}
 */
public class CompetitionFullDto implements Serializable {
    private final Long id;
    private final String title;
    private final CompetitionLevel competitionLevel;
    private final String locationCity;
    private final String locationStadium;
    private final String refereeFullName;
    private final String firstPlayerFullName;
    private final String secondPlayerFullName;

    public CompetitionFullDto(Long id, String title, CompetitionLevel competitionLevel, String locationCity, String locationStadium, String refereeFullName, String firstPlayerFullName, String secondPlayerFullName) {
        this.id = id;
        this.title = title;
        this.competitionLevel = competitionLevel;
        this.locationCity = locationCity;
        this.locationStadium = locationStadium;
        this.refereeFullName = refereeFullName;
        this.firstPlayerFullName = firstPlayerFullName;
        this.secondPlayerFullName = secondPlayerFullName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CompetitionLevel getCompetitionLevel() {
        return competitionLevel;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationStadium() {
        return locationStadium;
    }

    public String getRefereeFullName() {
        return refereeFullName;
    }

    public String getFirstPlayerFullName() {
        return firstPlayerFullName;
    }

    public String getSecondPlayerFullName() {
        return secondPlayerFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionFullDto entity = (CompetitionFullDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.competitionLevel, entity.competitionLevel) &&
                Objects.equals(this.locationCity, entity.locationCity) &&
                Objects.equals(this.locationStadium, entity.locationStadium) &&
                Objects.equals(this.refereeFullName, entity.refereeFullName) &&
                Objects.equals(this.firstPlayerFullName, entity.firstPlayerFullName) &&
                Objects.equals(this.secondPlayerFullName, entity.secondPlayerFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, competitionLevel, locationCity, locationStadium, refereeFullName, firstPlayerFullName, secondPlayerFullName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "competitionLevel = " + competitionLevel + ", " +
                "locationCity = " + locationCity + ", " +
                "locationStadium = " + locationStadium + ", " +
                "refereeFullName = " + refereeFullName + ", " +
                "firstPlayerFullName = " + firstPlayerFullName + ", " +
                "secondPlayerFullName = " + secondPlayerFullName + ")";
    }
}