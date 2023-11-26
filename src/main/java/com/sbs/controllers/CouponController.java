package com.sbs.controllers;

import com.sbs.models.Coupon;
import com.sbs.services.CouponService;
import com.sbs.utils.Exceptions.CouponNotFoundException;
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

    @DeleteMapping("{id}")
    public void removeCoupon(@PathVariable Long id) {
        couponService.removeCoupon(id);
    }

    @GetMapping
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{id}")
    public Coupon findById(@PathVariable Long id) {
        return couponService.findById(id)
                .orElseThrow(CouponNotFoundException::new);
    }

    @PatchMapping(value = "/{couponId}/{matchId}/{betName}", params = "add")
    public Optional<Coupon> addBet
            (@PathVariable Long couponId, @PathVariable Long matchId, @PathVariable String betName) {
        return couponService.addBet(couponId, matchId, betName);
    }

    @PatchMapping(value = "/{couponId}/{matchId}", params = "remove")
    public Optional<Coupon> removeBet(@PathVariable Long couponId, @PathVariable Long matchId) {
        return couponService.removeBet(couponId, matchId);
    }

    @PatchMapping(value = {"/{id}/{stake}"}, params = "stake")
    public Optional<Coupon> setStake(@PathVariable Float stake, @PathVariable Long id) {
        return couponService.setStake(stake, id);
    }

    @PatchMapping(value = "/{id}", params = "send")
    public Optional<Coupon> sendCoupon(@PathVariable Long id) {
        return couponService.sendCoupon(id);
    }

    @PatchMapping(value = "/{id}", params = "settle")
    public void settleCoupon(@PathVariable Long id) {
        couponService.settleCoupon(id);
    }
}
