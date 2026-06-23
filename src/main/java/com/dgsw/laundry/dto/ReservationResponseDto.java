package com.dgsw.laundry.dto;

import com.dgsw.laundry.enums.MachineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReservationResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String machineSerialNumber;

    @NotNull
    private MachineType machineType;

    @NotNull
    private LocalDateTime reservationStart;

    @NotNull
    private LocalDateTime reservationEnd;
}
