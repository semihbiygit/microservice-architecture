package com.semih.mapper;

import com.semih.dto.request.CompetitionQuestionsRequestDto;
import com.semih.repository.entity.CompetitionQuestions;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionQuestionsMapper {
    ICompetitionQuestionsMapper INSTANCE = Mappers.getMapper(ICompetitionQuestionsMapper.class);

    CompetitionQuestions toCompetitionQuestions(CompetitionQuestionsRequestDto dto);
}
