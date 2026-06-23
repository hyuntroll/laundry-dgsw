package com.dgsw.laundry.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
    @NotBlank
    private String username;

    @NotNull
    private LocalDateTime reservationStart;

    @NotNull
    private LocalDateTime reservationEnd;

    @NotNull
    private Long machineId;
}
