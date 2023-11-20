package com.sbs.services;

import com.sbs.models.Bet;
import com.sbs.models.Coupon;
import com.sbs.models.CouponStatus;
import com.sbs.models.Match;
import com.sbs.repositories.CouponRepository;
import com.sbs.repositories.MatchRepository;
import com.sbs.utils.Exceptions.CouponInPlayException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Match match = matchRepository.findById(matchId)
                    .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
            Float betCourse = match.getOdds()
                    .stream()
                    .filter(bet -> bet.getName().equals(betName))
                    .map(Bet::getCourse)
                    .findFirst()
                    .orElse(null);
            Bet bet = new Bet(matchRepository.findById(matchId)
                    .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
                    .getName(), betName, betCourse);
            couponRepository.addBet(coupon, bet);
            coupon.setTotalCourse(coupon.getTotalCourse() * betCourse);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> removeBet(Long couponId, Long matchId, String betName) throws CouponInPlayException {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            Float betCourse = matchRepository.findById(matchId)
                    .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
                    .getOdds()
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
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        if (IN_PROGRESS == coupon.getCouponStatus()) {
            coupon.setCouponStatus(IN_PLAY);
            couponRepository.sendCoupon(coupon);
            return Optional.of(coupon);
        }
        throw new CouponInPlayException();
    }

    public Optional<Coupon> findById(Long id){
        return couponRepository.findById(id);
    }
}
