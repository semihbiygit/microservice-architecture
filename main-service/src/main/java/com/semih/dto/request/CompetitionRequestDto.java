package com.semih.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionRequestDto {
    String token;
    @NotNull
    Long competitionOwnerUserId;
    @NotNull
    String competitionTitle;
    @NotNull
    String competitionDescription;
    @NotNull
    String image;
    @NotNull
    int numberOfWinner;
}
