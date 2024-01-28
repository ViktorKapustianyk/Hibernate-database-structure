package org.example.entity;

import lombok.Getter;
import lombok.Setter;

public enum FilmRating {
    PG("PG"),
    G("G"),
    NC_17("NC-17"),
    PG_13("PG-13"),
    R("R");

    private final String value;

    FilmRating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
