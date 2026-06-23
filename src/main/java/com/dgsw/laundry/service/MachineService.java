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
        if (machineRepository.existsMachineBySerialNumber(machineRequest.getSerialNumber())) {
            throw new RuntimeException("이미 존재하는 시리얼 번호입니다.");
        }

        Machine machine = new Machine();
        machine.setType(machineRequest.getMachineType());
        machine.setFloor(machineRequest.getFloor());
        machine.setSerialNumber(String.valueOf(machineRequest.getSerialNumber()));
        machineRepository.save(machine);
        return machine;
    }

    public List<Machine> getMachinesByFloor(Integer floor) {
        return machineRepository.findMachineByFloor(floor);
    }

    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    public void deleteMachine(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("기기를 찾을 수 없습니다."));
        machineRepository.delete(machine);
    }
}