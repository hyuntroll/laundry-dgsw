package com.dgsw.laundry.entity;

import com.dgsw.laundry.enums.MachineType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private MachineType type;

    @Column
    private int floor;

    @Column
    private boolean reserved;
}
