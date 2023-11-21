package com.sbs.controllers;

import com.sbs.utils.Exceptions.CouponInPlayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

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
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleHttpClientErrorException(HttpClientErrorException x) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "status 404, resource not found"));
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
