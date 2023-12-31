package com.sbs.repositories;

import com.sbs.models.Bet;
import com.sbs.models.Coupon;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomCouponRepository implements CouponRepository {

    private HashMap<Long, Coupon> coupons = new HashMap<>();
    private Long id = 0L;

    @Override
    public Coupon addCoupon(Coupon coupon) {
        coupon.setId(id);
        coupons.put(id, coupon);
        id += 1;
        return coupon;
    }
    @Override
    public void removeCoupon(Long id) {
        coupons.remove(id);
    }

    public Coupon addBet(Coupon coupon, Bet bet, Long matchId) {
        coupon.getCouponBets().put(matchId, bet);
        return coupon;
    }

    public Coupon removeBet(Coupon coupon, Long matchId) {
        coupon.getCouponBets().remove(matchId);
        return coupon;
    }

    @Override
    public Coupon sendCoupon(Coupon coupon) {
        coupons.put(coupon.getId(), coupon);
        return coupon;
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return coupons.containsKey(id) ? Optional.of(coupons.get(id)) : Optional.empty();
    }

    @Override
    public List<Coupon> getCoupons() {
        return new LinkedList<>(coupons.values());
    }
}
