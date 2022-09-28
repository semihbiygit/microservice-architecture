package com.semih.repository.entity;


import com.semih.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "competition_questions_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompetitionQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long questionId;
    Long competitionId;
    Long time;
    int rankNumber;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    TableAdd tableAdd;
}
