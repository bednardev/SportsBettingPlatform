package Repositories.Impl;

import Models.Bet;
import Repositories.CouponRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

public class CustomCouponRepository implements CouponRepository {

    public Map<Long, Bet> coupon = new HashMap<>();
    public Long id = 0L;

    public void addBet(Bet bet) {
        coupon.put(id, bet);
        id += 1;
    }

    public void removeBet(Long id) {
        coupon.remove(id);
    }

    public float calculateCourse(Map<Long, Bet> coupon) {
        float course = 1F;
        float tax = 0.30F;
        List<Float> courses = coupon
                .values()
                .stream()
                .map(b -> b.getCourse())
                .toList();
        for (Float e : courses) {
            course = course * e;
        }
        return course*tax;
    }
}
