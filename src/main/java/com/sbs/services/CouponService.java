package com.sbs.services;

import com.sbs.models.*;
import com.sbs.repositories.CouponRepository;
import com.sbs.repositories.MatchRepository;
import com.sbs.utils.Exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sbs.models.CouponStatus.*;
import static com.sbs.models.MatchResult.NOT_STARTED;

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

    public void removeCoupon(Long id) {
        couponRepository.removeCoupon(id);
    }
    public Optional<Coupon> findById(Long id) {
        return couponRepository.findById(id);
    }
    public Optional<Coupon> addBet(Long couponId, Long matchId, String betName) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(CouponNotFoundException::new);
        Match match = matchRepository.findById(matchId)
                .orElseThrow(MatchNotFoundException::new);
        if (IN_PROGRESS == coupon.getCouponStatus() && NOT_STARTED == match.getResult()) {
            Bet bet = match.findBetByName(betName)
                    .orElseThrow((BetNotFoundException::new));
            couponRepository.addBet(coupon, bet, matchId);
            coupon.setTotalCourse(coupon.getTotalCourse() * bet.getCourse());
            return Optional.of(coupon);
        } else if (IN_PROGRESS == coupon.getCouponStatus()) {
            throw new MatchInProgressException();
        } else {
            throw new CouponInPlayException();
        }
    }

    public Optional<Coupon> removeBet(Long couponId, Long matchId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(CouponNotFoundException::new);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = coupon.getCouponBets()
                    .get(matchId)
                    .getCourse();
            couponRepository.removeBet(coupon, matchId);
            coupon.setTotalCourse(coupon.getTotalCourse() / betCourse);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> setStake(Float stake, Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(CouponNotFoundException::new);
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            coupon.setStake(stake);
            coupon.setWinning(stake * coupon.getTotalCourse());
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }


    //to be replaced by EventListener:
    public void settleCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(CouponNotFoundException::new);
        if (IN_PLAY == coupon.getCouponStatus()) {
            if (coupon.checkIfWon()) {
                coupon.setCouponStatus(WON);
            } else {
                coupon.setCouponStatus(LOST);
            }
        }
    }
}