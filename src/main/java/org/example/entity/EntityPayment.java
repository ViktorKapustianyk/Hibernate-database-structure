package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "payment", schema = "movie")
public class EntityPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Short id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private EntityCustomer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private EntityStaff staff;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private EntityRental rental;

    private BigDecimal amount;

    @Column(name = "payment_date")
    @CreationTimestamp
    private LocalDateTime paymentDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
