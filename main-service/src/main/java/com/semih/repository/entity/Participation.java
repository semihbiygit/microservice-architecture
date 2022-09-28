package com.semih.repository.entity;


import com.semih.repository.enums.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "participation_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long competitionId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    ParticipationStatus participationStatus = ParticipationStatus.APPROVED;
    @Embedded
    TableAdd tableAdd;
}
