package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"film"})
@Entity
@Table(name = "film_text", schema = "movie")
public class EntityFilmText {
    @Id
    @Column(name = "film_id")
    private Short id;

    @OneToOne
    @JoinColumn(name = "film_id")
    private EntityFilm film;

    private String title;

    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    private String description;
}
