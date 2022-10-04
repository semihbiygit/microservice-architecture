package com.semih.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionQuestionsRequestDto {
    String token;
    Long questionId;
    Long competitionId;
    Long time;
    int rankNumber;
}
