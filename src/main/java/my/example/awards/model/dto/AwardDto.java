package my.example.awards.model.dto;

import my.example.awards.model.Award;

import java.io.Serializable;

/**
 * DTO for {@link Award}
 */
public record AwardDto(Integer id, Short year, String title) implements Serializable {
}