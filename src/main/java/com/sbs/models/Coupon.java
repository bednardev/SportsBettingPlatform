package com.sbs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Transient
    private Map<Long, Bet> couponBets = new LinkedHashMap<>();
    private Float totalCourse = 1F;
    private Float stake;
    private Float winning;
    private CouponStatus couponStatus;
    private Long userId;

    public boolean checkIfMatchNotStarted() {
        return getCouponBets()
                .values()
                .stream()
                .allMatch(bet -> BetStatus.NOT_STARTED.equals(bet.getBetStatus()));
    }

    public boolean checkIfWon() {
        return getCouponBets()
                .values()
                .stream()
                .allMatch(bet -> BetStatus.WON.equals(bet.getBetStatus()));
    }
}
