package com.dgsw.laundry.service;

import com.dgsw.laundry.dto.MachineRequestDto;
import com.dgsw.laundry.entity.Machine;
import com.dgsw.laundry.repository.MachineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MachineService {

    @Autowired
    MachineRepository machineRepository;

    public Machine registerMachine(MachineRequestDto machineRequest) {
        Machine machine = new Machine();
        machine.setType(machineRequest.getMachineType());
        machine.setFloor(machineRequest.getFloor());
        machine.setReserved(false);
        machineRepository.save(machine);
        return machine;
    }

    public List<Machine> getMachinesByFloor(Integer floor) {
        return machineRepository.findMachineByFloor(floor);
    }
}
