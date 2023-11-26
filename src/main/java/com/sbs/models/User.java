package com.sbs.models;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class User {
    private Long id;
    private String login;
    private Float balance;
    private List<Coupon> coupons = new LinkedList<>();
    public User(String login){
        this.login = login;
        this.balance = 0F;
    }
}
