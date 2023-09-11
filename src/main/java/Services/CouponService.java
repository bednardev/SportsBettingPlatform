package Services;

import Repositories.CouponRepository;

public class CouponService {
    CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
}
