package Repositories.Impl;

import Models.Bet;
import Models.Coupon;
import Repositories.CouponRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomCouponRepository implements CouponRepository {

    public Coupon coupon;
    public Long id = 0L;

    public Coupon addBet(Bet bet) {
        coupon.getCouponBets().put(id, bet);
        id += 1;
        return coupon;
    }

    public Coupon removeBet(Long id) {
        coupon.getCouponBets().remove(id);
        return coupon;
    }
}
