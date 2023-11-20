package com.sbs.repositories;

import com.sbs.models.Bet;
import com.sbs.models.Coupon;
import com.sbs.models.CouponStatus;
import com.sbs.models.Match;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomCouponRepository implements CouponRepository {

    private HashMap<Long, Coupon> coupons = new HashMap<>();
    private Coupon coupon;
    private Long id = 0L;

    public Coupon addCoupon(Coupon coupon){
        coupon.setId(id);
        coupons.put(id, coupon);
        id += 1;
        return coupon;
    }
    public Coupon addBet(Coupon coupon, Bet bet) {
        coupon.getCouponBets().add(bet);
        return coupon;
    }

    public Coupon removeBet(String betName) {
        coupon.getCouponBets().remove(betName);
        return coupon;
    }

    @Override
    public Coupon sendCoupon(Coupon coupon) {
        coupons.put(coupon.getId(), coupon);
        return coupon;
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return Optional.of(coupons.get(id));
    }

    @Override
    public List<Coupon> getCoupons() {
        return new LinkedList<>(coupons.values());
    }
}
