package com.SBS.Repositories;

import com.SBS.Models.Bet;
import com.SBS.Models.Coupon;
import com.SBS.Repositories.CouponRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomCouponRepository implements CouponRepository {

    private HashMap<Long, Coupon> coupons = new HashMap<>();
    private Coupon coupon;
    private Long id = 0L;

    public Coupon addBet(Bet bet) {
        coupon.getCouponBets().add(bet);
        return coupon;
    }

    public Coupon removeBet(Bet bet) {
        coupon.getCouponBets().remove(bet);
        return coupon;
    }

    public Coupon saveCoupon() {
        coupon.setId(id);
        coupons.put(id, coupon);
        id += 1;
        return coupon;
    }

    @Override
    public List<Coupon> getCoupons() {
        return new LinkedList<>(coupons.values());
    }
}
