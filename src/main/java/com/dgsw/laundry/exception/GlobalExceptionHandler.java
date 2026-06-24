package com.dgsw.laundry.exception;

import com.dgsw.laundry.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidation(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(new ResponseDto("입력 오류 - " + errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGeneric(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(500).body(new ResponseDto("서버 오류"));
    }
}