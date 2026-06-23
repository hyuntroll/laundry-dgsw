package com.dgsw.laundry.controller;

import com.dgsw.laundry.dto.MachineRequestDto;
import com.dgsw.laundry.entity.Machine;
import com.dgsw.laundry.service.MachineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineConrtoller {
    @Autowired
    MachineService machineService;

    @PostMapping("/machine")
    public Machine addMachine(@RequestBody @Valid MachineRequestDto request) {
        return machineService.registerMachine(request);
    }

    @GetMapping("/floor")
    public List<Machine> getFloor(@RequestParam Integer floor) {
        return machineService.getMachinesByFloor(floor);
    }
}
