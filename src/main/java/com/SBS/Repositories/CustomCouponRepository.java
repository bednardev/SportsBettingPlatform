package com.SBS.Repositories;

import com.SBS.Models.Coupon;
import com.SBS.Models.CouponStatus;
import com.SBS.Models.Match;
import com.SBS.Repositories.CouponRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomCouponRepository implements CouponRepository {

    private HashMap<Long, Coupon> coupons = new HashMap<>();
    private Coupon coupon;
    private Long id = 0L;

    public Coupon addCoupon(Coupon coupon){
        coupon.setId(id);
        coupon.setCouponStatus(CouponStatus.IN_PROGRESS);
        coupons.put(id, coupon);
        id += 1;
        return coupon;
    }
    public Coupon addBet(Coupon coupon, String betName, Float betCourse) {
        coupon.getCouponBets().put(betName, betCourse);
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
    public Coupon findById(Long id) {
        return coupons.get(id);
    }

    @Override
    public List<Coupon> getCoupons() {
        return new LinkedList<>(coupons.values());
    }
}
