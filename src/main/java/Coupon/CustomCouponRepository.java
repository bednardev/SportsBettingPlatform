package Coupon;

import Coupon.Bet;
import Coupon.Coupon;
import Coupon.CouponRepository;


public class CustomCouponRepository implements CouponRepository {

    public Coupon coupon;
    public Long id = 0L;

    public Coupon addBet(Bet bet) {
        coupon.getCouponBets().add(bet);
        return coupon;
    }

    public Coupon removeBet(Long id) {
        coupon.getCouponBets().remove(id);
        return coupon;
    }

    public Coupon saveCoupon(){
        coupon.setId(id);
        id += 1;
        return coupon;
    }
}
