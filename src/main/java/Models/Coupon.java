package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class Coupon {
    private Map<Long, Bet> couponBets;
    private float totalCourse;
}
