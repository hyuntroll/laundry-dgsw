package com.dgsw.laundry.entity;

import com.dgsw.laundry.enums.MachineType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private LocalDateTime reservationTime;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
