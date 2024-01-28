package org.example.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<FilmRating, String> {
    @Override
    public String convertToDatabaseColumn(FilmRating filmRating) {
        return filmRating.getValue();
    }

    @Override
    public FilmRating convertToEntityAttribute(String s) {
        FilmRating[] values = FilmRating.values();

        for (FilmRating rating : values) {
            if (rating.getValue().equals(s)){
                return rating;
            }
        }
        return null;
    }
}
