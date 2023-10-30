package com.SBS.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Coupon {
    private Long id;
    private List<Bet> couponBets;
    private float totalCourse;
    private CouponStatus couponStatus;
}
