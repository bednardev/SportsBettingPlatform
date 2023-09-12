package Coupon;

import Coupon.CouponRepository;

public class CouponService {
    CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
}
