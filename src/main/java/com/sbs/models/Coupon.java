package com.sbs.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Coupon {
    public Coupon() {
    }

    private Long id;
    private Map<Long, Bet> couponBets = new LinkedHashMap<>();
    private Float totalCourse;
    private Float stake;
    private Float winning;
    private CouponStatus couponStatus;
    private Long userId;

    public boolean checkIfMatchNotStarted() {
        return getCouponBets()
                .values()
                .stream()
                .allMatch(bet -> BetStatus.NOT_STARTED.equals(bet.getBetStatus()));
    }

    public boolean checkIfWon() {
        return getCouponBets()
                .values()
                .stream()
                .allMatch(bet -> BetStatus.WON.equals(bet.getBetStatus()));
    }
}
