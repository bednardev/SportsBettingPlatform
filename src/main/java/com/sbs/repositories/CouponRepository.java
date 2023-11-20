package com.sbs.repositories;

import com.sbs.models.Coupon;

import java.util.*;

public interface CouponRepository {
    Coupon addBet(Coupon coupon, String betName, Float betCourse);

    Coupon removeBet(String betName);

    Coupon addCoupon(Coupon coupon);

    Coupon sendCoupon(Coupon coupon);

    List<Coupon> getCoupons();

    Coupon findById(Long id);

}
