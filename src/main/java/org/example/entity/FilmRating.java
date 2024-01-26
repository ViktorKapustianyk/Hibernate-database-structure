package org.example.entity;

public enum FilmRating {
    PG("PG"),
    G("G"),
    NC_17("NC-17"),
    PG_13("PG-13"),
    R("R");

    private String value;

    FilmRating(String value) {
        this.value = value;
    }
}
