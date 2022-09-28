package com.semih.repository.entity;


import com.semih.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "views_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Views {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long questionId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    TableAdd tableAdd;

}
