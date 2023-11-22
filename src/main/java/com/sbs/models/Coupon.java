package com.sbs.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class Coupon {
    public Coupon(){}
    private Long id;
    private List<Bet> couponBets = new LinkedList<>();
    private Float totalCourse;
    private Float stake;
    private Float winning;
    private CouponStatus couponStatus;
}
