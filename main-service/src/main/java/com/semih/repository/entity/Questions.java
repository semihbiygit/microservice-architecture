package com.semih.repository.entity;


import com.semih.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "question_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 1000)
    String question;
    int time;
    Long ownerId;
    int answerCount;
    String groupName;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVAL;
    @Embedded
    TableAdd tableAdd;

}
