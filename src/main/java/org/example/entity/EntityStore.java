package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "store", schema = "movie")
public class EntityStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Byte id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private EntityAddress address;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private EntityStaff staff;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
