package com.sbs.controllers;

import com.sbs.models.Coupon;
import com.sbs.services.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public Coupon addCoupon(Coupon coupon) {
        return couponService.addCoupon(coupon);
    }

    @GetMapping
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @PatchMapping(value = "/{couponId}/{matchId}/{betName}", params = "add")
    public Optional<Coupon> addBet(@PathVariable Long couponId, @PathVariable Long matchId, @PathVariable String betName) {
        return couponService.addBet(couponId, matchId, betName);
    }

    @PatchMapping(value = "/{couponId}/{matchId}/{betName}", params = "remove")
    public Optional<Coupon> removeBet(@PathVariable Long couponId, @PathVariable Long matchId, @PathVariable String betName) {
        return couponService.removeBet(couponId, matchId, betName);
    }

    @PatchMapping(value = "/{id}", params = "send")
    public Optional<Coupon> sendCoupon(@PathVariable Long id) {
        return couponService.sendCoupon(id);
    }
}