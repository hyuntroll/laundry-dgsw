package com.dgsw.laundry.repository;

import com.dgsw.laundry.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
    List<Machine> findMachineByFloor(Integer floor);
}
