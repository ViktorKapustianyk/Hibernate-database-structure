package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "film", schema = "movie")
public class EntityFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;

    private String title;

    @Column(columnDefinition = "text")
    @Type(type = "text")
    private String description;

    @Column(columnDefinition = "year", name = "release_year")
    @Convert(converter = YearAttributeConverter.class)
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private EntityLanguage language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private EntityLanguage originalLanguage;

    @Column(name = "rental_duration")
    private Byte rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    private Short length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating" , columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    private FilmRating rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name="film_actor",
            joinColumns= @JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns= @JoinColumn(name="actor_id", referencedColumnName="actor_id") )
    private Set<EntityActor> actors;

    @ManyToMany
    @JoinTable(name="film_category",
            joinColumns= @JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns= @JoinColumn(name="category_id", referencedColumnName = "category_id") )
    private Set<EntityCategory> categories;


    public Set<FilmFeature> getSpecialFeatures() {
        if (isNull(specialFeatures) || specialFeatures.isEmpty()){
            return null;
        }

        Set<FilmFeature> result = new HashSet<>();
        String[] features = specialFeatures.split(",");

        for (String feature : features) {
            result.add(FilmFeature.getFilmFeatureByValue(feature));
        }
        result.remove(null);
        return result;
    }

    public void setSpecialFeatures(Set<FilmFeature> specialFeatures) {
        if (isNull(specialFeatures)){
            specialFeatures = null;
        } else {
            specialFeatures.stream().map(FilmFeature::getValue).collect(Collectors.joining(","));
        }
    }
}
