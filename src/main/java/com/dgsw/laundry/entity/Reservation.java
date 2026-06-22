package com.dgsw.laundry.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private LocalDateTime reservationStart;

    @Column
    private LocalDateTime reservationEnd;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @CreatedDate
    private LocalDateTime createdAt;
}
