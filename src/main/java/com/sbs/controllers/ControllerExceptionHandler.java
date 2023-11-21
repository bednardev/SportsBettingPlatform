package com.sbs.controllers;

import com.sbs.utils.Exceptions.CouponInPlayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler (CouponInPlayException.class)
    public ResponseEntity<Map<String, String>> handleCouponInPlayException(CouponInPlayException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "status 400, Coupon in play cannot be edited"));
    }
}
