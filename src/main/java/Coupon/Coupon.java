package Coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
 class Coupon {
    private Long id;
    private List<Bet> couponBets;
    private float totalCourse;
}
