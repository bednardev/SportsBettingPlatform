package Coupon;

import Coupon.Bet;
import Coupon.Coupon;

 interface CouponRepository {
    Coupon addBet(Bet bet);

    Coupon removeBet(Bet bet);

    Coupon saveCoupon();

}
