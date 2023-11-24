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


    public Optional<Coupon> addBet(Long couponId, Long matchId, String betName) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException());
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new MatchNotFoundException());
        if (IN_PROGRESS == coupon.getCouponStatus() && NOT_STARTED == match.getResult()) {
            Bet bet = match.getOdds()
                    .stream()
                    .filter(b -> b.getName().equals(betName))
                    .findFirst()
                    .orElseThrow((() -> new BetNotFoundException()));
            couponRepository.addBet(coupon, bet, matchId);
            coupon.setTotalCourse(coupon.getTotalCourse() * bet.getCourse());
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> removeBet(Long couponId, Long matchId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException());
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
                .orElseThrow(() -> new CouponNotFoundException());
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            coupon.setStake(stake);
            coupon.setWinning(stake * coupon.getTotalCourse());
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> sendCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException());
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            if (coupon.getCouponBets()
                    .values()
                    .stream()
                    .allMatch(bet -> BetStatus.NOT_STARTED.equals(bet.getBetStatus()))) {
                coupon.setCouponStatus(IN_PLAY);
                couponRepository.sendCoupon(coupon);
            } else {
                throw new MatchInProgressException();
            }
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public void settleCoupon(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException());
        if (IN_PLAY == coupon.getCouponStatus()) {
            if (coupon.getCouponBets()
                    .values()
                    .stream()
                    .allMatch(bet -> BetStatus.WON.equals(bet.getBetStatus()))) {
                coupon.setCouponStatus(WON);
            } else {
                coupon.setCouponStatus(LOST);
            }
        }
    }

    public Optional<Coupon> findById(Long id) {
        return couponRepository.findById(id);
    }
}