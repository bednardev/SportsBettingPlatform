package com.sbs.repositories;

import com.sbs.models.Bet;
import com.sbs.models.Coupon;

import java.util.*;

public interface CouponRepository {
    Coupon addCoupon(Coupon coupon);

    void removeCoupon(Long id);

    Coupon addBet(Coupon coupon, Bet bet, Long matchId);

    Coupon removeBet(Coupon coupon, Long matchId);

    Coupon sendCoupon(Coupon coupon);

    List<Coupon> getCoupons();

    Optional<Coupon> findById(Long id);

}
