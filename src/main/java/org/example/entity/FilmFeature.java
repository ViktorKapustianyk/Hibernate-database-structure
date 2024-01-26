package org.example.entity;

import lombok.Data;

import static java.util.Objects.isNull;


public enum FilmFeature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private String value;

    FilmFeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FilmFeature getFilmFeatureByValue(String value){
        if (isNull(value) || value.isEmpty()){
            return null;
        }

        FilmFeature[] features = FilmFeature.values();
        for (FilmFeature feature : features) {
            if (feature.value.equals(value)){
                return feature;
            }
        }
        return null;
    }
}
