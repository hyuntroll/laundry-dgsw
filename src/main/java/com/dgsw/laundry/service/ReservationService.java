package com.dgsw.laundry.service;

import com.dgsw.laundry.dto.ReservationResponseDto;
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

    public List<ReservationResponseDto> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservation -> new ReservationResponseDto(
                        reservation.getId(),
                        reservation.getUsername(),
                        reservation.getMachine().getSerialNumber(),
                        reservation.getMachine().getType(),
                        reservation.getReservationStart(),
                        reservation.getReservationEnd()
                ))
                .toList();
    }

    public ReservationResponseDto reserve(
            String username,
            LocalDateTime reservationStart,
            LocalDateTime reservationEnd,
            Long machineId
    ) {
        if (!reservationStart.isBefore(reservationEnd)) {
            throw new IllegalArgumentException("예약 시작 시간은 종료 시간보다 빨라야 합니다.");
        }

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

        return new ReservationResponseDto(
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
