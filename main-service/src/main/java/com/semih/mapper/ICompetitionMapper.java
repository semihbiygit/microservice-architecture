package com.semih.mapper;

import com.semih.dto.request.CompetitionRequestDto;
import com.semih.repository.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionMapper {

    ICompetitionMapper INSTANCE = Mappers.getMapper(ICompetitionMapper.class);

    Competition toCompetition(CompetitionRequestDto dto);
}
