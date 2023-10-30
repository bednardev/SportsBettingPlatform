package com.SBS.Repositories;

import com.SBS.Models.Bet;
import com.SBS.Models.Coupon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface CouponRepository {
    Coupon addBet(Bet bet);

    Coupon removeBet(Bet bet);

    Coupon saveCoupon();

    List<Coupon> getCoupons();

}
