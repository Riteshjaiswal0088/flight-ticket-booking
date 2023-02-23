package com.ritesh.flightticketbooking.exception;


import com.ritesh.flightticketbooking.dto.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandling {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> customerNotFoundExceptionHandler(CustomerNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),LocalDateTime.now());
        /* = ErrorResponse.builder().errorMessage(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .dateTime(LocalDateTime.now())
                .build();*/
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> addressNotFoundExceptionHandler(AddressNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
