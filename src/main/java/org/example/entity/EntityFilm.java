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

    @Enumerated(EnumType.STRING)
    @Column(name = "rating" , columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private FilmRating rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="film_actor",
            joinColumns= @JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns= @JoinColumn(name="actor_id", referencedColumnName="actor_id") )
    private Set<EntityActor> actors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="film_category",
            joinColumns= @JoinColumn(name="film_id", referencedColumnName="film_id"),
            inverseJoinColumns= @JoinColumn(name="category_id", referencedColumnName = "category_id") )
    private Set<EntityCategory> categories;

}
