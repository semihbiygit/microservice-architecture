package com.semih.repository.entity;


import com.semih.repository.enums.State;
import com.semih.repository.enums.CompetitionStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "competition_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long competitionOwnerUserId;
    String competitionTitle;
    String competitionDescription;
    String image;
    int numberOfWinner;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    CompetitionStatus competitionStatus = CompetitionStatus.ACTIVE_OPEN;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVAL;
    @Embedded
    TableAdd tableAdd;
    @Transient
    List<Questions> questionsList;

}
