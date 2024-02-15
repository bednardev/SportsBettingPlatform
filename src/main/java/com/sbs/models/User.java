package com.sbs.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String login;
    private Float balance;
    private List<Coupon> coupons = new LinkedList<>();
    public User(String login){
        this.login = login;
        this.balance = 0F;
    }

    public Optional<Coupon> findUserCouponByCouponId(Long couponId){
        return getCoupons()
                .stream()
                .filter(c -> couponId.equals(c.getId()))
                .findFirst();
    }
}
