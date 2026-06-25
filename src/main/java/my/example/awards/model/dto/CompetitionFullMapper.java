package my.example.awards.model.dto;

import my.example.awards.model.Competition;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompetitionFullMapper {
    Competition toEntity(CompetitionFullDto competitionFullDto);

    CompetitionFullDto toDto(Competition competition);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Competition partialUpdate(CompetitionFullDto competitionFullDto, @MappingTarget Competition competition);
}