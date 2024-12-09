package ru.iFellow.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum CharacterStatus {

    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("");

    final String status;
}
