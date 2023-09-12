package Repositories;

import Models.Bet;
import Models.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponRepository {
    Coupon addBet(Bet bet);

    Coupon removeBet(Long matchId);

    Coupon saveCoupon();

}
