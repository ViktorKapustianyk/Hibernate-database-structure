package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "address", schema = "movie")
public class EntityAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private EntityCity city;

    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone")
    private String phone;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
