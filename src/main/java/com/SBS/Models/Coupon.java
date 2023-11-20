package com.SBS.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class Coupon {
    public Coupon(){};
    private Long id;
    private Map<String,Float> couponBets = new HashMap<>();
    private float totalCourse = 1;
    private CouponStatus couponStatus;
}
