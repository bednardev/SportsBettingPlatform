package Coupon;

import Coupon.Bet;
import Coupon.Coupon;

public interface CouponRepository {
    Coupon addBet(Bet bet);

    Coupon removeBet(Long matchId);

    Coupon saveCoupon();

}
