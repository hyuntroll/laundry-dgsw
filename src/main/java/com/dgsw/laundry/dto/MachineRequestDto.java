package com.dgsw.laundry.dto;

import com.dgsw.laundry.enums.MachineType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineRequestDto {
    private String serialNumber;
    private MachineType machineType;
    private int floor;
}
