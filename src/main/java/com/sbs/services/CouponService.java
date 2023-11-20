package com.sbs.services;

import com.sbs.models.Bet;
import com.sbs.models.Coupon;
import com.sbs.models.CouponStatus;
import com.sbs.repositories.CouponRepository;
import com.sbs.repositories.MatchRepository;
import com.sbs.utils.Exceptions.CouponInPlayException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sbs.models.CouponStatus.IN_PLAY;
import static com.sbs.models.CouponStatus.IN_PROGRESS;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    private final MatchRepository matchRepository;

    public CouponService(CouponRepository couponRepository, MatchRepository matchRepository) {
        this.couponRepository = couponRepository;
        this.matchRepository = matchRepository;
    }

    public Coupon addCoupon(Coupon coupon) {
        coupon.setTotalCourse(1F);
        coupon.setCouponStatus(CouponStatus.IN_PROGRESS);
        return couponRepository.addCoupon(coupon);
    }

    public List<Coupon> getCoupons() {
        return couponRepository.getCoupons();
    }

    public Optional<Coupon> addBet(Long couponId, Long matchId, String betName) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(couponId);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = matchRepository.findById(matchId).getOdds()
                    .stream()
                    .filter(bet -> bet.getName().equals(betName))
                    .map(Bet::getCourse)
                    .findFirst()
                    .orElse(null);
            Bet bet = new Bet(matchRepository.findById(matchId).getName(), betName, betCourse);
            couponRepository.addBet(coupon, bet);
            coupon.setTotalCourse(coupon.getTotalCourse() * betCourse);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> removeBet(Long couponId, Long matchId, String betName) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(couponId);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = matchRepository.findById(matchId).getOdds()
                    .stream()
                    .filter(bet -> bet.getName().equals(betName))
                    .map(Bet::getCourse)
                    .findFirst()
                    .orElse(null);
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
