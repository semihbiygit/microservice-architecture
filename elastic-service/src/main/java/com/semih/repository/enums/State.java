package com.semih.repository.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum State {
    PASSIVE(0),
    APPROVAL(1),
    APPROVED(2),
    DELETED(3),
    BLOCKED(4);

    private int value;

}
