package com.dgsw.laundry.controller;

import com.dgsw.laundry.dto.MachineRequestDto;
import com.dgsw.laundry.entity.Machine;
import com.dgsw.laundry.service.MachineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MachineController {

    @Autowired
    MachineService machineService;

    @PostMapping("/machines")
    public Machine addMachine(@RequestBody @Valid MachineRequestDto request) {
        return machineService.registerMachine(request);
    }

    @GetMapping("/machines/floor")
    public List<Machine> getFloor(@RequestParam Integer floor) {
        return machineService.getMachinesByFloor(floor);
    }

    @GetMapping("/machines")
    public List<Machine> findAll() {
        return machineService.findAll();
    }

    @DeleteMapping("/machines/{id}")
    public String deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return "기기가 삭제되었습니다.";
    }
}


