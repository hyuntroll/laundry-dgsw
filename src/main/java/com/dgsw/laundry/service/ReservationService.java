package com.dgsw.laundry.service;

import com.dgsw.laundry.dto.ReservationResponse;
import com.dgsw.laundry.entity.Machine;
import com.dgsw.laundry.entity.Reservation;
import com.dgsw.laundry.repository.MachineRepository;
import com.dgsw.laundry.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final MachineRepository machineRepository;

    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservation -> new ReservationResponse(
                        reservation.getId(),
                        reservation.getUsername(),
                        reservation.getMachine().getSerialNumber(),
                        reservation.getMachine().getType(),
                        reservation.getReservationStart(),
                        reservation.getReservationEnd()
                ))
                .toList();
    }

    public ReservationResponse reserve(
            String username,
            LocalDateTime reservationStart,
            LocalDateTime reservationEnd,
            Long machineId
    ) {
        Machine machine = machineRepository.findById(machineId)
                .orElseThrow(IllegalArgumentException::new);
        List<Reservation> reservations = reservationRepository.findAllByMachineId(machineId);

        for (Reservation reservation : reservations) {
            if (reservation.getReservationEnd().isAfter(reservationStart)
                    && reservation.getReservationStart().isBefore(reservationEnd)) {
                throw new IllegalStateException("이미 예약된 시간입니다.");
            }
        }

        Reservation reservation = reservationRepository.save(
                createReservation(username, reservationStart, reservationEnd, machine)
        );

        return new ReservationResponse(
                reservation.getId(),
                reservation.getUsername(),
                machine.getSerialNumber(),
                machine.getType(),
                reservation.getReservationStart(),
                reservation.getReservationEnd()
        );
    }

    private Reservation createReservation(
            String username,
            LocalDateTime reservationStart,
            LocalDateTime reservationEnd,
            Machine machine
    ) {
        Reservation reservation = new Reservation();
        reservation.setUsername(username);
        reservation.setReservationStart(reservationStart);
        reservation.setReservationEnd(reservationEnd);
        reservation.setMachine(machine);

        return reservation;
    }
}
