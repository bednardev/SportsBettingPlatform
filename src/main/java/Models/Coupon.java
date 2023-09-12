package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class Coupon {
    private Long id;
    private List<Bet> couponBets;
    private float totalCourse;
}
