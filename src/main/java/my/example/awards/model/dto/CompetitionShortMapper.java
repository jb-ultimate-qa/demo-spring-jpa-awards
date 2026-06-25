package my.example.awards.model.dto;

import my.example.awards.model.Competition;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompetitionShortMapper {
    Competition toEntity(CompetitionShortDto competitionShortDto);

    CompetitionShortDto toDto(Competition competition);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Competition partialUpdate(CompetitionShortDto competitionShortDto, @MappingTarget Competition competition);

    List<CompetitionShortDto> toDto(List<Competition> competition);
}