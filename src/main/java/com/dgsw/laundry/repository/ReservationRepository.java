package com.dgsw.laundry.repository;

import com.dgsw.laundry.entity.Machine;
import com.dgsw.laundry.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByMachineId(Long machineId);
}
