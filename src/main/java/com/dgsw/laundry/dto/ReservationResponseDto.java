package com.dgsw.laundry.dto;

import com.dgsw.laundry.enums.MachineType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReservationResponseDto {
    private Long id;
    private String username;
    private String machineSerialNumber;
    private MachineType machineType;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
}
