package com.SBS.Services;

import com.SBS.Models.Coupon;
import com.SBS.Repositories.CouponRepository;
import com.SBS.Repositories.MatchRepository;
import com.SBS.Utils.Exceptions.CouponInPlayException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.SBS.Models.CouponStatus.IN_PLAY;
import static com.SBS.Models.CouponStatus.IN_PROGRESS;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    private final MatchRepository matchRepository;

    public CouponService(CouponRepository couponRepository, MatchRepository matchRepository) {
        this.couponRepository = couponRepository;
        this.matchRepository = matchRepository;
    }

    public Coupon addCoupon(Coupon coupon) {
        return couponRepository.addCoupon(coupon);
    }

    public List<Coupon> getCoupons() {
        return couponRepository.getCoupons();
    }

    public Optional<Coupon> addBet(Long couponId, Long matchId, String betName) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(couponId);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = matchRepository.findById(matchId).getOdds().get(betName);
            couponRepository.addBet(coupon, betName, betCourse);
            coupon.setTotalCourse(coupon.getTotalCourse() * betCourse);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> removeBet(Long couponId, Long matchId, String betName) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(couponId);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = matchRepository.findById(matchId).getOdds().get(betName);
            couponRepository.removeBet(betName);
            coupon.setTotalCourse(coupon.getTotalCourse() / betCourse);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> sendCoupon(Long id) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(id);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            coupon.setCouponStatus(IN_PLAY);
            couponRepository.sendCoupon(coupon);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }
}
