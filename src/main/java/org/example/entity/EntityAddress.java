package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@EqualsAndHashCode
@Entity
@Table(name = "address", schema = "movie")
public class EntityAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short id;

    private String address;

    private String address2;

    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private EntityCity city;

    @Column(name = "postal_code")
    private String postalCode;

    private String phone;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
