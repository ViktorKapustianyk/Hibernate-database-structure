package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "staff", schema = "movie")
public class EntityStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Byte id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private EntityAddress address;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] picture;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private EntityStore store;

    @Column(name = "active")
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean active;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
