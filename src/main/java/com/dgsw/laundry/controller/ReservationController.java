package com.dgsw.laundry.controller;

import com.dgsw.laundry.dto.ReservationRequest;
import com.dgsw.laundry.dto.ReservationResponse;
import com.dgsw.laundry.entity.Reservation;
import com.dgsw.laundry.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> findall() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> reserve(@RequestBody @Valid ReservationRequest request) {
        return ResponseEntity.status(201)
                .body(reservationService.reserve(
                        request.getUsername(),
                        request.getReservationStart(),
                        request.getReservationEnd(),
                        request.getMachineId()
                ));
    }
}
