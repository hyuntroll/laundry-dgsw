package com.dgsw.laundry.dto;

import com.dgsw.laundry.enums.MachineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MachineResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String serialNumber;

    @NotNull
    private MachineType type;

    @NotNull
    private int floor;
}
