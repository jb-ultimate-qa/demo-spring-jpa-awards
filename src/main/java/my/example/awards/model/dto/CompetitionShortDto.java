package my.example.awards.model.dto;

import my.example.awards.model.Competition;
import my.example.awards.model.notentity.CompetitionLevel;

import java.io.Serializable;

/**
 * DTO for {@link Competition}
 */
public record CompetitionShortDto(Long id, String title, CompetitionLevel competitionLevel, String locationCity,
                                  String locationStadium) implements Serializable {
}