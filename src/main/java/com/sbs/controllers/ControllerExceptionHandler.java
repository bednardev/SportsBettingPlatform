package com.sbs.controllers;

import com.sbs.utils.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(CouponInPlayException.class)
    public ResponseEntity<Map<String, String>> handleCouponInPlayException(CouponInPlayException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "status 400, Coupon in play cannot be edited"));
    }

    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCouponNotFoundException(CouponNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "status 404, coupon not found"));
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMatchNotFoundException(MatchNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "status 404, match not found"));
    }

    @ExceptionHandler(BetNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBetNotFoundException(BetNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "status 404, bet not found"));
    }

    @ExceptionHandler(MatchInProgressException.class)
    public ResponseEntity<Map<String, String>> handleMatchInProgressException(MatchInProgressException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "status 404, the coupon does not contain only not started games"));
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("status", "400", "errors", prepareMapFromValidationErrors(ex)));
    }

    private String prepareMapFromValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        return errorMap.toString();
    }
}
