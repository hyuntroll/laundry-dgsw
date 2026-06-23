package com.dgsw.laundry.dto;

import com.dgsw.laundry.enums.MachineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineRequestDto {
    @NotBlank
    private String serialNumber;

    @NotNull
    private MachineType machineType;

    @NotNull
    private int floor;
}
