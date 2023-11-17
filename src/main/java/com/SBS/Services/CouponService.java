package com.SBS.Services;

import com.SBS.Models.Bet;
import com.SBS.Models.Coupon;
import com.SBS.Repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.SBS.Models.CouponStatus.IN_PLAY;
import static com.SBS.Models.CouponStatus.IN_PROGRESS;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    Optional<Coupon> addBet(Coupon coupon, Bet bet) {
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            couponRepository.addBet(bet);
            coupon.setTotalCourse(coupon.getTotalCourse() * bet.getCourse());
            return Optional.of(coupon);
        }
        return Optional.empty();
    }

    Optional<Coupon> removeBet(Coupon coupon, Bet bet) {
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            couponRepository.removeBet(bet);
            coupon.setTotalCourse(coupon.getTotalCourse() / bet.getCourse());
            return Optional.of(coupon);
        }
        return Optional.empty();
    }

    Optional<Coupon> sendCoupon(Coupon coupon) {
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            couponRepository.saveCoupon();
            coupon.setCouponStatus(IN_PLAY);
            return Optional.of(coupon);
        }
        return Optional.empty();
    }

    List<Coupon> getCoupons() {
        return couponRepository.getCoupons();
    }
}
