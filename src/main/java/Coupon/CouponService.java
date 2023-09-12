package Coupon;

import Coupon.CouponRepository;

 class CouponService {
    CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
}
