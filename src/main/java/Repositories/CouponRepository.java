package Repositories;

import Models.Bet;

import java.util.List;
import java.util.Map;

public interface CouponRepository {
    void addBet(Bet bet);

    void removeBet(Long matchId);

    float calculateCourse(Map<Long, Bet> coupon);
}
