package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

@Data
@EqualsAndHashCode
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
